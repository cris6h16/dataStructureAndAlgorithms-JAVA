# Efficiency

## Contiguous Array

| Method          | Eff    |
|-----------------|--------|
| `prepend()`     | `O(n)` |
| `removeFirst()` | `O(n)` |
| `append()`      | `O(1)` |
| `removeLast()`  | `O(1)` |

### `prepend()` in `O(1)`

Instead of:

- `moveEachToItsNextPosition()` and later `arr[0] = <val>`

Do:

- `append(<val>)`, later `swap(arr, idxLast, idxFirst)`

**Problem**: You'll lose the order, other way to optimize it is to use a `Circular Array`.

## Circular Array

| Method          | Eff    |
|-----------------|--------|
| `prepend()`     | `O(1)` |
| `removeFirst()` | `O(1)` |
| `append()`      | `O(1)` |
| `removeLast()`  | `O(1)` |

```bash
constructor:
    arr = new int[fixedSize];
    head = fixedSize / 2;
    tail = fixedSize / 2;
    # |   |   |   |   |   |   |   |   |   |   |
    #                   ^
    #                   |
    #              head - tail
    
prepend(int val):
    head = goToLeft(head);
    arr[head] = val;
    
# prepend(1)
    # |   |   |   | 1 |   |   |   |   |   |   |
    #               ^   ^
    #               |   |
    #            head   tail
# prepend(2)
    # |   |   | 2 | 1 |   |   |   |   |   |   |
    #           ^       ^
    #           |       |
    #        head       tail
# prepend(1 to 5)
    # | 2 | 1 | 2 | 1 |   |   |   | 5 | 4 | 3 |
    #                   ^           ^
    #                   |           |
    #                 tail         head

# etc.

append(int val):
    arr[tail] = val;
    tail = goToRight(tail);
    
# append(1)
    # |   |   |   |   | 1 |   |   |   |   |   |
    #                   ^   ^
    #                   |   |
    #                 head  tail
# append(2)
    # |   |   |   |   | 1 | 2 |   |   |   |   |
    #                   ^       ^
    #                   |       |
    #                 head      tail
# append(1 to 5)
    # | 5 |   |   |   | 1 | 2 | 1 | 2 | 3 | 4 |
    #       ^           ^
    #       |           |
    #      tail        head
```

### Key Points

- `goToLeft(int idx)`:

```java
private int goLeft(int idx) {
    return (idx - 1 + arr.length) % arr.length;
}
```

- `goToRight(int idx)`:

```java
private int goRight(int idx) {
    return (idx + 1) % arr.length;
}
```