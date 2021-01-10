# brainfuck-interpreter

This program is a [Brainfuck](https://esolangs.org/wiki/Brainfuck) interpreter  written in Java. I use GraalVM to be able to build an executable so non-java 
users can run it without installing the JVM.

There is still a lot of work left until it is finished.

The language have the following commands:

<table class="wikitable">
<tbody><tr>
<th style="text-align:center;">Character
</th>
<th align="left">Meaning
</th></tr>
<tr>
<td style="text-align:center"><code>&gt;</code>
</td>
<td>Increment the data pointer(to point to the next cell to the right). It the cell is pointing at the last cell will point to the frist one instead.
</td></tr>
<tr>
<td style="text-align:center"><code>&lt;</code>
</td>
<td>Decrement the data pointer (to point to the next cell to the left).It the cell is pointing at the first cell will point to the last one one instead.
</td></tr>
<tr>
<td style="text-align:center"><code>+</code>
</td>
<td>Increment (increase by one) the byte at the data pointer. If the byte value is 255 instead of increment it sets it to 0.
</td></tr>
<tr>
<td style="text-align:center"><code>-</code>
</td>
<td>Decrement (decrease by one) the byte at the data pointer.If the byte value is 0 instead of decrement it sets it to 255.
</td></tr>
<tr>
<td style="text-align:center"><code>.</code>
</td>
<td>Output the byte at the data pointer(as a char). 
</td></tr>
<tr>
<td style="text-align:center"><code>,</code>
</td>
<td>Accept one byte of input, storing its value in the byte at the data pointer. <hard>NOT IMPLEMENTED YET</hard>
</td></tr>
<tr>
<td style="text-align:center"><code>[</code>
</td>
<td>If the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next command, jump it <i>forward</i> to the command after the <i>matching</i> <code>]</code> command.
</table>

Any other character will be considered as a comment.

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
