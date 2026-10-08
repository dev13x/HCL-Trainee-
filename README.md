# HCL Java Training

Daily practice code from the HCL Java training, organised by module and day.

## Module 1 — Core Java & Foundations

| Day | Covered | Code |
| --- | --- | --- |
| 01 | JVM and bytecode (notes only), packages and imports | [day01](core-java-module1/src/day01) · [notes](core-java-module1/docs/day01-jvm-and-bytecode.md) |
| 02 | OOP: constructors, inheritance, overloading, overriding, encapsulation, access modifiers | [day02](core-java-module1/src/day02) |
| 03 | Abstraction, interfaces, collections (LinkedList, ArrayList, Stack) | [day03](core-java-module1/src/day03) |
| 04 | Queue, Deque, Stack with ArrayDeque, HashMap, Comparable and toString | [day04](core-java-module1/src/day04) |

## Structure

```
core-java-module1/
├── docs/              notes without code
└── src/
    └── dayNN/         one package per day
        └── <topic>/   one sub-package per topic (constructors, inheritance, sorting, ...)
```

A class whose name ends in `Example` or `Main` has a `main` method you can run.

## Running a program

From inside `core-java-module1`:

```
javac -d out -sourcepath src src/day04/sorting/StudentSortExample.java
java -cp out day04.sorting.StudentSortExample
```

In IntelliJ: right-click `src` → Mark Directory as → Sources Root, then run any class that has a `main` method.
