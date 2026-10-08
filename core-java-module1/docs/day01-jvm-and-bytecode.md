# Day 01 — JVM and bytecode

## What happens when a Java program runs

1. You write the source code, e.g. `Welcome.java`.
2. `javac Welcome.java` compiles it into `Welcome.class`. A `.class` file holds **bytecode**: instructions for the JVM, not for your CPU.
3. `java Welcome` starts the **JVM**. It loads the class, checks the bytecode and runs it. It interprets the bytecode at first and compiles frequently used code to native machine code (JIT).

Every operating system has its own JVM that understands the same bytecode, so a compiled program is portable: *write once, run anywhere*.

## JVM vs JRE vs JDK

- **JVM** – the virtual machine that executes bytecode.
- **JRE** – the JVM plus the core libraries needed to run programs.
- **JDK** – the JRE plus developer tools such as `javac`, `jar` and `javadoc`.

## Packages

- `package day01.mathops;` puts a class in a package, and the file must sit in `src/day01/mathops/`.
- `import day01.mathops.Calculator;` makes the class usable in another package. `import static` imports a single static method.
- Only `public` classes and members can be used from another package.
- Compile: `javac -d out -sourcepath src src/day01/launcher/CalculatorMain.java`
- Run: `java -cp out day01.launcher.CalculatorMain`
