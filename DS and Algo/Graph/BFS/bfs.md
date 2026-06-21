# Breadth-First Search (BFS) on Graphs

A complete beginner-to-interview guide. Read top to bottom — every section builds on the previous one.

---

## 1. What is BFS?

**Breadth-First Search** explores a graph **level by level**. Starting from a source node, it
visits all nodes at distance 1, then all nodes at distance 2, and so on — like ripples spreading
out when you drop a stone in water.

```
        (A)                 BFS order starting at A:
       /   \                Level 0:  A
     (B)   (C)              Level 1:  B, C
     / \      \             Level 2:  D, E, F
   (D) (E)    (F)
```

Contrast with **DFS (Depth-First Search)**, which goes as deep as possible down one path before
backtracking. BFS goes *wide* first; DFS goes *deep* first.

---

## 2. When should I reach for BFS?

| Use BFS when you need...                                   | Why BFS fits                                  |
| --------------------------------------------------------- | --------------------------------------------- |
| **Shortest path in an *unweighted* graph**                | The first time you reach a node is the fewest edges away |
| **Level-order traversal** (process nodes by distance)     | BFS naturally groups nodes by level           |
| **"Minimum number of steps/moves" problems**              | Each step = one BFS level                      |
| **Spreading / flood-fill** (e.g. rotting oranges, islands)| Simultaneous expansion from many sources       |

> ⚠️ For **weighted** shortest paths use Dijkstra / Bellman-Ford instead — plain BFS assumes every
> edge costs the same.

---

## 3. The core idea: a Queue + a Visited set

BFS relies on two data structures:

1. **Queue (FIFO)** — holds the nodes waiting to be explored, in the order they were discovered.
   FIFO ordering is what guarantees level-by-level processing.
2. **Visited set** — remembers which nodes we have already discovered, so we never enqueue the same
   node twice (this prevents infinite loops in cyclic graphs).

### The algorithm in 5 steps

```
1. Mark the start node as visited and put it in the queue.
2. While the queue is not empty:
3.     Remove (dequeue) the front node — call it `current`.
4.     Process `current` (print it, record its distance, etc.).
5.     For each neighbor of `current` that is NOT visited:
           mark it visited and enqueue it.
```

The golden rule: **mark a node visited the moment you enqueue it, NOT when you dequeue it.**
Marking on enqueue prevents the same node from being added to the queue multiple times.

---

## 4. Dry run (trace it by hand)

Graph (adjacency list):

```
0 -> 1, 2
1 -> 0, 3
2 -> 0, 3
3 -> 1, 2, 4
4 -> 3
```

BFS starting from node `0`:

| Step | Dequeued | Queue after  | Visited           | Notes                       |
| ---- | -------- | ------------ | ----------------- | --------------------------- |
| init | —        | [0]          | {0}               | start                       |
| 1    | 0        | [1, 2]       | {0,1,2}           | enqueue 1, 2                |
| 2    | 1        | [2, 3]       | {0,1,2,3}         | 0 already visited, add 3    |
| 3    | 2        | [3]          | {0,1,2,3}         | 0 and 3 already visited     |
| 4    | 3        | [4]          | {0,1,2,3,4}       | add 4                       |
| 5    | 4        | []           | {0,1,2,3,4}       | done                        |

**Visit order:** `0 → 1 → 2 → 3 → 4`

---

## 5. Java implementation

### 5a. Basic traversal

```java
// Standard BFS over a graph stored as an adjacency list.
public static List<Integer> bfs(List<List<Integer>> adj, int start) {
    List<Integer> order = new ArrayList<>();      // visit order (the result)
    boolean[] visited = new boolean[adj.size()];  // visited[i] == true once node i is discovered
    Queue<Integer> queue = new LinkedList<>();     // FIFO queue of nodes to explore

    // Step 1: seed the queue with the start node and mark it visited.
    visited[start] = true;
    queue.offer(start);

    // Step 2: keep going until there is nothing left to explore.
    while (!queue.isEmpty()) {
        int current = queue.poll();   // dequeue the front (oldest) node
        order.add(current);           // "process" it

        // Step 3: explore every neighbor we haven't seen yet.
        for (int next : adj.get(current)) {
            if (!visited[next]) {
                visited[next] = true; // mark on ENQUEUE (not on dequeue!)
                queue.offer(next);
            }
        }
    }
    return order;
}
```

### 5b. BFS that also computes shortest distance (in edges)

Because BFS reaches every node by the shortest number of edges, we can record distances for free:

```java
public static int[] shortestDistances(List<List<Integer>> adj, int start) {
    int[] dist = new int[adj.size()];
    Arrays.fill(dist, -1);            // -1 means "not reached yet"
    Queue<Integer> queue = new LinkedList<>();

    dist[start] = 0;                  // distance to itself is 0
    queue.offer(start);

    while (!queue.isEmpty()) {
        int current = queue.poll();
        for (int next : adj.get(current)) {
            if (dist[next] == -1) {           // unvisited == distance still -1
                dist[next] = dist[current] + 1; // one edge further than current
                queue.offer(next);
            }
        }
    }
    return dist; // dist[i] = fewest edges from start to i (-1 if unreachable)
}
```

### 5c. Level-by-level BFS (process one full level at a time)

This pattern is essential for "minimum number of steps" problems and grid problems.
The trick: capture `queue.size()` **before** the inner loop — that is exactly how many nodes
belong to the current level.

```java
public static void bfsByLevel(List<List<Integer>> adj, int start) {
    boolean[] visited = new boolean[adj.size()];
    Queue<Integer> queue = new LinkedList<>();
    visited[start] = true;
    queue.offer(start);

    int level = 0;
    while (!queue.isEmpty()) {
        int levelSize = queue.size();         // freeze the count for THIS level
        System.out.print("Level " + level + ": ");

        for (int i = 0; i < levelSize; i++) { // process exactly this level's nodes
            int current = queue.poll();
            System.out.print(current + " ");
            for (int next : adj.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        System.out.println();
        level++;
    }
}
```

---

## 6. BFS on a 2D grid (very common in interviews)

Many problems (number of islands, rotting oranges, shortest path in a maze) are grids where each
cell connects to its 4 neighbors. The graph is *implicit* — neighbors are computed, not stored.

```java
// Returns the shortest number of steps from (sr, sc) to any cell with value == target.
// 0 = open cell, 1 = wall. Movement is up/down/left/right.
public static int bfsGrid(int[][] grid, int sr, int sc) {
    int rows = grid.length, cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{sr, sc});
    visited[sr][sc] = true;

    int steps = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                // Skip out-of-bounds, walls, and already-visited cells.
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (visited[nr][nc] || grid[nr][nc] == 1) continue;
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
        steps++;
    }
    return steps;
}
```

> 💡 **Multi-source BFS:** to flood from several starting cells at once (e.g. all rotten oranges),
> just push *all* the sources into the queue before the loop starts. The level counter then measures
> time for the wave to reach everything.

---

## 7. Complexity

Let **V** = number of vertices (nodes), **E** = number of edges.

- **Time:** `O(V + E)` — each node is enqueued/dequeued once, and each edge is examined once.
- **Space:** `O(V)` — the queue and visited set can each hold up to all V nodes.

For a grid with `R` rows and `C` columns: `O(R * C)` time and space (each cell is a node, with up to
4 edges).

---

## 8. Common pitfalls

1. **Marking visited on dequeue instead of enqueue** → the same node gets added many times, blowing
   up memory and time. Always mark when you *offer* to the queue.
2. **Forgetting the visited set** on a cyclic graph → infinite loop.
3. **Using a `Stack` instead of a `Queue`** → that's DFS, not BFS. BFS needs **FIFO**.
4. **Recomputing `queue.size()` inside the level loop** → the size changes as you enqueue children;
   capture it once before the inner `for`.
5. **Disconnected graphs:** a single BFS only reaches one connected component. To touch every node,
   loop over all nodes and start a fresh BFS from each unvisited one.

---

## 9. Practice problems (LeetCode)

| # | Problem | Pattern |
| - | ------- | ------- |
| 200 | Number of Islands | Grid BFS / connected components |
| 994 | Rotting Oranges | Multi-source BFS + levels |
| 1091 | Shortest Path in Binary Matrix | Grid BFS shortest path |
| 127 | Word Ladder | BFS over implicit graph |
| 102 | Binary Tree Level Order Traversal | Level-by-level BFS |
| 542 | 01 Matrix | Multi-source BFS |
| 752 | Open the Lock | BFS state-space search |

Start with **102** and **200**, then move to the multi-source and state-space ones.

---

## TL;DR

- BFS = explore **level by level** using a **Queue (FIFO)** + **Visited set**.
- It finds the **shortest path in unweighted graphs**.
- **Mark visited on enqueue.**
- Capture `queue.size()` to process one level at a time.
- Complexity: **O(V + E)** time, **O(V)** space.
