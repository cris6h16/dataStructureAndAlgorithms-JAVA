# Efficiency
## Contiguous Array
|Method|Eff|
|-----------------|--------|
|`addFirst()`     | `O(n)` |
|`removeFirst()`  | `O(n)` |
|`addLast()`      | `O(1)` |
|`removeLast()`   | `O(1)` |

### `addFirst()` in `O(1)`

Instead of:   
- `moveEachToItsNextPosition()` and later `arr[0] = <val>`   
Do:   
- `addLast(<val>)`, later `swap(arr, idxLast, idxFirst)`

**Problem**: You'll lost the order

