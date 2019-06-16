FILES := $(shell (find src/ -iname '*.md'))

.PHONY: all clean

all: build build/resources $(subst src/,build/,$(FILES:.md=.html))

clean:
	-rm -rf build

build/%.html: src/%.md template.html| build
	find $$(dirname $<) -maxdepth 1 -iname '*.md' | sed 's!.*/!!' | sed -E 's!(.*).md!<li class="nav-item" data-toggle="tooltip" data-placement="right" title="\1"><a class="nav-link" href="\1.html"><span class="nav-link-text">\1</span></a></li>!' > $@.idx
	sed -i -E 's!(href="$(shell (basename $@))")!\1!' $@.idx
	pandoc --template template.html -B $@.idx -o $@ $<
	rm $@.idx

build:
	test -d $@ || mkdir -p $@

build/resources: resources/ | build
	test -L $@ || ln -s ../resources/ $@
