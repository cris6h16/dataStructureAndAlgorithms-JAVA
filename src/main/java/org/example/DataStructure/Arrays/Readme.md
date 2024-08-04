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
    head = (head - 1 + fixedSize) % fixedSize;
    arr[head] = val;
    
# prepend(1)
    # |   |   |   |   | 1  |   |   |   |   |   |
    #               ^   ^
    #               |   |
    #            head   tail
# prepend(2)
    # |   |   |   | 2 | 1  |   |   |   |   |   |
    #           ^       ^
    #           |       |
    #        head       tail
# prepend(1 to 5)
    # | 3 | 2 | 1 | 2 | 1  |   |   |   | 5 | 4 |
    #                   ^            ^
    #                   |            |
    #                 tail          head

# etc.
```

