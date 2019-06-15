FILES := $(shell (find src/ -iname '*.md'))

.PHONY: all clean

all: build build/resources $(subst src/,build/,$(FILES:.md=.html))

clean:
	-rm -rf build

build/%.html: src/%.md | build
	find $$(dirname $<) -maxdepth 1 -iname '*.md' | sed 's!.*/!!' | sed -E 's!(.*).md!<li class="list-group-item"><a href="\1.html">\1</a></li>!' > $@.idx
	sed -i -E 's!(href="$(shell (basename $@))")!\1 class="font-weight-bold"!' $@.idx
	pandoc --template template.html -B $@.idx -o $@ $<
	rm $@.idx

build:
	test -d $@ || mkdir -p $@

build/resources: resources/ | build
	test -L $@ || ln -s ../resources/ $@
