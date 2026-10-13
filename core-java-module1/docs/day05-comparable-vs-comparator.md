# Day 05 — Comparable vs Comparator & Functional Interfaces

## Comparable vs Comparator

Both interfaces decide how two objects are ordered when sorting, but they differ in **where** the sorting rule is defined:

- **Comparable (`java.lang.Comparable`)**: Implemented **inside** the class being sorted. Defines a single default (*natural*) order via `compareTo(T other)`.
- **Comparator (`java.util.Comparator`)**: Implemented **outside** the class. Allows defining multiple custom sort orders via `compare(T a, T b)` without modifying the original class.

| Feature | `Comparable<T>` | `Comparator<T>` |
| --- | --- | --- |
| Package | `java.lang` | `java.util` |
| Abstract method | `int compareTo(T other)` | `int compare(T a, T b)` |
| Defined in | The model class itself | Separate class, anonymous class, or lambda |
| Number of sort orders | One (natural order) | Multiple (by name, marks, age, etc.) |
| Requires modifying class? | Yes | No |
| Common usage | `Collections.sort(list)` | `Collections.sort(list, cmp)`, `list.sort(cmp)` |

### Return value contract

Both `compareTo` and `compare` return an `int`:
- **Negative (`< 0`)**: First object comes **before** the second.
- **Zero (`0`)**: Both objects are equal in sort order.
- **Positive (`> 0`)**: First object comes **after** the second.

> Prefer `Integer.compare(x, y)` or `Double.compare(x, y)` over subtraction (`x - y`) to avoid integer overflow. To sort in descending order, either swap the arguments (`Integer.compare(b, a)`) or call `.reversed()`.

---

## Functional Interfaces & Lambda Expressions

A **functional interface** has **exactly one abstract method** (it may still contain `default` and `static` methods). Adding `@FunctionalInterface` asks the compiler to enforce this rule.

Because a functional interface has only one abstract method, you can provide its implementation directly using a **lambda expression**:

```text
(parameters) -> expression
(parameters) -> { statements; }
```

### Four ways to pass a `Comparator<Student>`

1. **Separate class**: `Collections.sort(list, new NameComparator())`
2. **Anonymous class**: `Collections.sort(list, new Comparator<Student>() { ... })`
3. **Lambda expression**: `list.sort((s1, s2) -> s1.getName().compareTo(s2.getName()))`
4. **Key extractor (`Comparator.comparing`)**: `list.sort(Comparator.comparing(Student::getName))`

### Built-in Functional Interfaces (`java.util.function`)

| Interface | Method | Signature | Typical use |
| --- | --- | --- | --- |
| `Predicate<T>` | `test(T)` | `T -> boolean` | Filtering (`removeIf`, conditions) |
| `Function<T, R>` | `apply(T)` | `T -> R` | Transforming a value |
| `Consumer<T>` | `accept(T)` | `T -> void` | Performing an action (`forEach`) |
| `Supplier<T>` | `get()` | `() -> T` | Producing a value on demand |
| `BiFunction<T, U, R>` | `apply(T, U)` | `(T, U) -> R` | Combining two inputs into a result |
