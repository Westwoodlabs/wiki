import java.io.FileOutputStream
import java.util.*
import java.util.regex.Pattern

val htmlFiles = tasks.register("htmlFiles") {}
val indexFiles = tasks.register("indexFiles") {}

fun indexName(dir: File) = dir.relativeTo(file("src")).toString().replace('/', '_')
fun indexTaskName(dir: File) = "indexFile_${indexName(dir)}"
fun indexFile(dir: File) = "build/tmp/${indexName(dir)}.idx"

val liveHtmlFiles = TreeSet<File>()

file("src").walkTopDown().filter{ it.isDirectory }.forEach {
    val indexName = indexName(it)
    val indexFile = tasks.register(indexTaskName(it)) {
        inputs.dir(it)
        val outFile = indexFile(it)
        outputs.files(outFile)
        doLast {
            file(outFile).printWriter(Charsets.UTF_8).use { wr ->
                data class NavItem(val order: Int, val html: String)
                val navItems = ArrayList<NavItem>()
                it.listFiles().filter { it.extension == "md" }.forEach {f ->
                    val headers = parseHeadersFromMdFile(f)
                    fun String.parseInt():Int = Integer.parseInt(this)
                    navItems.add(NavItem(
                            headers["index-order"]?.parseInt() ?: 0,
                            """<li class="nav-item" data-toggle="tooltip" data-placement="right" title="${headers["title"] ?: f.nameWithoutExtension}">
                              |   <a class="nav-link" href="${f.nameWithoutExtension}.html"><span class="nav-link-text">${headers["title"] ?: f.nameWithoutExtension}</span></a>
                              |</li>""".trimMargin()))
                }
                navItems.sortBy { it.order }
                navItems.forEach {
                    wr.print(it.html)
                }
            }
        }
    }
    indexFiles {
        dependsOn(indexFile)
    }
}

file("src").walkTopDown().filter { it.isFile && it.extension == "md" }.forEach {
    val htmlFile = tasks.register("htmlFile_${it.relativeTo(file("src")).toString().replace('/', '_')}") {
        inputs.files(it, indexFile(it.parentFile), file("template.html"))
        dependsOn(indexTaskName(it.parentFile))
        val outFile = "build/html/${it.relativeTo(file("src")).parent ?: ""}/${it.nameWithoutExtension}.html"
        outputs.files(outFile)
        liveHtmlFiles.add(file(outFile))
        doLast {
            exec {
                standardOutput = FileOutputStream(outFile)
                fun String.nameFilter(): String = this.replace(Regex("[\\\\'\"\\$`{}()><]"), "_")
                commandLine("sh", "-c", "pandoc --template template.html -B '${indexFile(it.parentFile).nameFilter()}' '${it.toString().nameFilter()}' | hxnormalize -l 1000 | hxpipe | " +
                        "sed -E -e '/\\(table/i\\\\Aclass CDATA table table-hover' " +
                        "    -e 's!(Ahref CDATA )\\{\\{webroot\\}\\}(.*)!\\1${(file("src").toRelativeString(it.parentFile).ifEmpty {"."}).nameFilter()}\\2!' " +
                        "  | hxunpipe")
            }
        }
    }
    htmlFiles {
        dependsOn(htmlFile)
    }
}

val pruneStaleFiles = tasks.register("pruneStaleFiles") {
    dependsOn(htmlFiles)
    doLast {
        file("build").walkTopDown().filter { it.isFile && it.extension == "html" && !liveHtmlFiles.contains(it) }.forEach { f-> f.delete() }
    }
}

val copyResources = tasks.register("copyResources") {
    inputs.dir(file("resources"))
    outputs.dir(file("build/html/resources"))
    doLast {
        copy {
            from("resources")
            into("build/html/resources")
        }
    }
}



tasks.register("build") {
    dependsOn(htmlFiles, indexFiles, pruneStaleFiles, copyResources)
}

tasks.register("clean") {
    doLast {
        file("build").deleteRecursively()
    }
}

fun parseHeadersFromMdFile(f: File): Map<String, String> {
    val fileLines = f.readLines()
    return if (fileLines[0] == "---") {
        val headers = HashMap<String, String>()
        for (i in 1..fileLines.size) {
            val line = fileLines[i]
            if (line == "---") break
            val parts = line.split(Pattern.compile(": *"), limit = 2)
            if (parts.size == 2) {
                headers[parts[0]] = parts[1]
            }
        }
        headers
    } else {
        emptyMap()
    }
}