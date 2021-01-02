# brainfuck-interpreter

This program is a [Brainfuck](https://esolangs.org/wiki/Brainfuck) interpreter  written in Java. I use GraalVM to be able to build an executable so non-java 
users can run it without installing the JVM.

There is still a lot of work left until it is finished but it is already capable of executing code that is provided as a parameter.

## Prerequisites

All you need to build an executable is java and maven.

## Build it

Invoke the following maven goal:

```bash
    mvn package
```

This will generate an executable called "com.seniorglez.brainfuck.brainfuckinterpreter" under the target directory.

## Run it

You can pass code as an argument:

```bash
    ./com.seniorglez.brainfuck.brainfuckinterpreter ">+++++++++[<++++++++>-]<.>+++++++[<++++>-]<+.+++++++..+++.[-]>++++++++[<++++>-] <.>+++++++++++[<++++++++>-]<-.--------.+++.------.--------.[-]>++++++++[<++++>- ]<+.[-]++++++++++."
```

This will return: Hello world!

Or read .bf and .b files:

```bash
    ./com.seniorglez.brainfuck.brainfuckinterpreter helloworld.bf
```

## Contributing

Feel free to fork it and made pull request if something can be improved.

## Built With

* [Maven](https://maven.apache.org/) - The build automation tool
* [GraalVM](https://www.graalvm.org/) - The poliglot JVM

## Contributing

## Authors

* **Diego Dominguez**   <a href="https://twitter.com/DGlez1111" target="_blank">
    <img alt="Twitter: DGlez1111" src="https://img.shields.io/twitter/follow/DGlez1111.svg?style=social" />
  </a>

## License

Brainfuck-Interpreter is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or any later version.

Brainfuck-Interpreter is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the [GNU General Public License](LICENSE)
along with Brainfuck-Interpreter. If not, see [https://www.gnu.org/licenses/](https://www.gnu.org/licenses/)

![GPL3 or later](https://www.gnu.org/graphics/gplv3-or-later.png)
