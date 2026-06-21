# Depth-First Search (DFS) on Graphs

A complete beginner-to-interview guide. Read top to bottom — every section builds on the previous one.

---

## 1. What is DFS?

**Depth-First Search** explores a graph by going **as deep as possible down one path**, and only
backtracks when it hits a dead end (a node with no unvisited neighbors). Think of walking a maze:
you follow one corridor to its end, and when stuck, you walk back to the last junction and try a
different corridor.

```
        (0)                  DFS order starting at 0 (going to first child first):
       /   \                 0 -> 1 -> 3 -> 7 -> 4 -> 2 -> 5 -> 6
     (1)   (2)
     / \   / \               It dives all the way down 0->1->3->7 BEFORE
   (3) (4)(5) (6)            ever touching 2. That "go deep first" is the essence.
    |
   (7)
```

Contrast with **BFS (Breadth-First Search)**, which explores *level by level* (all neighbors first).
BFS goes **wide**; DFS goes **deep**.

---

## 2. When should I reach for DFS?

| Use DFS when you need...                                      | Why DFS fits                                     |
| ------------------------------------------------------------- | ------------------------------------------------ |
| **Does a path exist? / connectivity**                         | Dive until you find the target or exhaust paths  |
| **Count / explore connected components**                      | One DFS floods one whole component               |
| **Cycle detection**                                           | A back-edge to an in-progress node = a cycle     |
| **Topological sort** (task ordering, build order)             | DFS finish-order gives a valid topological order |
| **Backtracking** (permutations, word search, maze solving)    | DFS naturally tries → undoes → tries another      |
| **Tree/grid problems** (flood fill, area, path sums)          | Recursion mirrors the structure cleanly          |

> ⚠️ DFS does **not** give the shortest path in an unweighted graph — that's BFS's job. DFS finds
> *a* path, not necessarily the shortest one.

---

## 3. The core idea: recursion (or an explicit Stack) + a Visited set

DFS needs two things:

1. **A Stack (LIFO)** — explore the most recently discovered node next. This is what makes it go
   *deep*. With recursion, the **call stack** *is* your stack, so you often don't write one
   explicitly.
2. **A Visited set** — remember which nodes are already explored so you never revisit them. Without
   it, a cycle would loop forever.

### The recursive algorithm in 4 steps

```
dfs(node):
1.   mark node as visited
2.   process node (print it, count it, etc.)
3.   for each neighbor of node:
4.       if neighbor is NOT visited: dfs(neighbor)   <- recurse deeper
```

The golden rule: **mark a node visited the moment you enter it**, before recursing into neighbors.

---

## 4. Dry run (trace it by hand)

Graph (adjacency list):

```
0 -> 1, 2
1 -> 0, 3, 4
2 -> 0, 5, 6
3 -> 1, 7
4 -> 1
5 -> 2
6 -> 2
7 -> 3
```

Recursive DFS from `0` (neighbors visited left-to-right):

| Call           | Action                    | Visited (in order)        |
| -------------- | ------------------------- | ------------------------- |
| dfs(0)         | visit 0, go to 1          | 0                         |
| dfs(1)         | visit 1, go to 3          | 0,1                       |
| dfs(3)         | visit 3, go to 7          | 0,1,3                     |
| dfs(7)         | visit 7, dead end, back   | 0,1,3,7                   |
| back in dfs(1) | next neighbor 4           | 0,1,3,7                   |
| dfs(4)         | visit 4, dead end, back   | 0,1,3,7,4                 |
| back in dfs(0) | next neighbor 2           | 0,1,3,7,4                 |
| dfs(2)         | visit 2, go to 5          | 0,1,3,7,4,2               |
| dfs(5)         | visit 5, dead end, back   | 0,1,3,7,4,2,5             |
| dfs(6)         | visit 6, dead end, back   | 0,1,3,7,4,2,5,6           |

**Visit order:** `0 → 1 → 3 → 7 → 4 → 2 → 5 → 6`

---

## 5. Java implementation

### 5a. Recursive DFS (the most common form)

```java
// Recursive DFS over a graph stored as an adjacency list.
public static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
    visited[node] = true;        // mark on ENTRY, before recursing
    System.out.print(node + " "); // process the node

    for (int neighbour : adj.get(node)) {
        if (!visited[neighbour]) {
            dfs(neighbour, adj, visited); // dive deeper
        }
    }
    // when the loop ends, we backtrack automatically (return to caller)
}

// Kick it off:
boolean[] visited = new boolean[adj.size()];
dfs(0, adj, visited);
```

### 5b. Iterative DFS (using an explicit Stack)

Useful when recursion depth could overflow the call stack (very large/deep graphs).

```java
public static void dfsIterative(int start, List<List<Integer>> adj) {
    boolean[] visited = new boolean[adj.size()];
    Deque<Integer> stack = new ArrayDeque<>();

    stack.push(start);

    while (!stack.isEmpty()) {
        int node = stack.pop();          // take the most recent (LIFO)

        if (visited[node]) continue;     // may be pushed more than once
        visited[node] = true;
        System.out.print(node + " ");

        // push neighbors; they'll be explored before nodes pushed earlier
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                stack.push(neighbour);
            }
        }
    }
}
```

> 📝 **Recursive vs iterative:** the recursive version is cleaner and is what you'll write 90% of
> the time. Reach for the iterative version only when stack-overflow is a real risk. Note the visit
> *order* can differ slightly between the two because of push order — both are valid DFS.

### 5c. Handling disconnected graphs (DFS over ALL components)

A single DFS only reaches one connected component. To touch every node, start a fresh DFS from each
unvisited node:

```java
public static int countComponents(List<List<Integer>> adj) {
    boolean[] visited = new boolean[adj.size()];
    int components = 0;
    for (int i = 0; i < adj.size(); i++) {
        if (!visited[i]) {
            dfs(i, adj, visited); // flood the whole component
            components++;          // each new DFS = one new component
        }
    }
    return components;
}
```

---

## 6. DFS on a 2D grid (flood fill / connected cells)

Grids are implicit graphs: each cell connects to its 4 neighbors. DFS is perfect for "fill this
region" or "measure this blob" problems.

```java
// Counts the size of the region of 1s connected to (r, c). Marks visited by sinking to 0.
public static int floodFill(int[][] grid, int r, int c) {
    int rows = grid.length, cols = grid[0].length;
    // out of bounds, or water/visited -> stop
    if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) return 0;

    grid[r][c] = 0;     // "visit" by marking it so we never revisit

    return 1
        + floodFill(grid, r - 1, c)   // up
        + floodFill(grid, r + 1, c)   // down
        + floodFill(grid, r, c - 1)   // left
        + floodFill(grid, r, c + 1);  // right
}
```

> 💡 This is exactly the engine behind LeetCode 200 (Number of Islands) and 695 (Max Area of Island).

---

## 7. Complexity

Let **V** = number of vertices (nodes), **E** = number of edges.

- **Time:** `O(V + E)` — each node is visited once, and each edge is examined once.
- **Space:** `O(V)` — the visited set, plus the recursion/explicit stack (up to V deep in the worst
  case, e.g. a long chain).

For a grid with `R` rows and `C` columns: `O(R * C)` time and space.

---

## 8. BFS vs DFS — quick comparison

| Aspect              | BFS                              | DFS                                    |
| ------------------- | -------------------------------- | -------------------------------------- |
| Data structure      | **Queue** (FIFO)                 | **Stack** / recursion (LIFO)           |
| Explores            | Level by level (wide)            | One path to the end (deep)             |
| Shortest path?      | ✅ Yes (unweighted)              | ❌ Not guaranteed                      |
| Typical uses        | Min steps, level order, flood    | Cycles, topo sort, backtracking, components |
| Memory shape        | Wide graphs use lots of memory   | Deep graphs use lots of stack          |

---

## 9. Common pitfalls

1. **Forgetting the visited set** on a cyclic graph → infinite recursion / loop.
2. **Marking visited too late** (after the loop instead of on entry) → a node can be entered
   multiple times before it's marked.
3. **Stack overflow on huge/deep graphs** with recursion → switch to the iterative version.
4. **Assuming DFS gives the shortest path** → it doesn't; use BFS for that.
5. **Disconnected graphs:** one DFS won't cover everything — loop over all nodes (Section 5c).

---

## 10. Practice problems (LeetCode)

| #   | Problem                          | Pattern                          |
| --- | -------------------------------- | -------------------------------- |
| 200 | Number of Islands                | Grid DFS / flood fill            |
| 695 | Max Area of Island               | Grid DFS returning a count       |
| 547 | Number of Provinces              | Connected components             |
| 207 | Course Schedule                  | Cycle detection (DFS)            |
| 210 | Course Schedule II               | Topological sort (DFS)          |
| 417 | Pacific Atlantic Water Flow      | Multi-start DFS                  |
| 79  | Word Search                      | DFS + backtracking               |

Start with **200** and **695**, then move to cycle detection (**207**) and topo sort (**210**).

---

## TL;DR

- DFS = go **deep first**, backtrack at dead ends, using **recursion / a Stack (LIFO)** + a
  **Visited set**.
- **Mark visited on entry.**
- Great for **connectivity, components, cycle detection, topological sort, and backtracking**.
- It does **NOT** give shortest paths — that's BFS.
- Complexity: **O(V + E)** time, **O(V)** space.
