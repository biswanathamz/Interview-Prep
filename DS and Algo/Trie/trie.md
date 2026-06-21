# Trie (Prefix Tree)

A complete beginner-to-interview guide. Read top to bottom — every section builds on the previous one.

---

## 1. What is a Trie?

A **Trie** (pronounced "try", from re**trie**val) is a tree where each node represents a single
**character**, and a path from the root down to a node spells out a **prefix**. Words that share a
prefix share the same path — that shared structure is the whole point.

```
Insert: "cat", "car", "card", "dog"

            (root)
           /      \
         c          d
         |          |
         a          o
        / \         |
       t*  r        g*
           |
           d*        '*' marks the end of a complete word
```

Notice `cat`, `car`, and `card` all share the `c → a` path, and `car`/`card` share `c → a → r`.
A Trie stores prefixes **once**, not once per word.

> A Trie is **not** a binary tree. Each node can have many children — one per possible next
> character (e.g. 26 for lowercase English letters).

---

## 2. When should I reach for a Trie?

| Use a Trie when you need...                                  | Why a Trie fits                                  |
| ------------------------------------------------------------ | ------------------------------------------------ |
| **Prefix search** — "does any word start with `app`?"        | Walk the prefix path; O(prefix length)           |
| **Autocomplete / typeahead**                                 | Find the prefix node, then collect everything below |
| **Dictionary / spell-check / word existence**                | Exact-word lookup is O(word length)              |
| **Many strings sharing prefixes**                            | Shared paths save memory vs. storing each string |
| **Word-search / board games (e.g. Boggle, LeetCode 212)**    | Prune dead branches early while exploring         |

> ⚠️ If you only need **exact** lookups and don't care about prefixes, a `HashSet`/`HashMap` is
> simpler and often faster. The Trie wins specifically when **prefixes** matter.

---

## 3. The core idea: nodes of children + an end-of-word flag

Every Trie node holds two things:

1. **`children`** — links to the next character's node. With a fixed alphabet (lowercase a–z) this
   is an array of size 26, where index `ch - 'a'` maps a character to a slot. A `null` slot means
   "no word continues with this character here." (For larger/unknown alphabets, use a
   `HashMap<Character, TrieNode>` instead.)
2. **`endOfWord`** — a boolean that marks "a complete word ends *at this node*." This is what lets
   the Trie tell apart `car` (a real word) from `car` being merely a prefix of `card`.

```java
class TrieNode {
    TrieNode[] children;   // one slot per letter a-z
    boolean endOfWord;     // true if a word ends exactly here

    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}
```

---

## 4. The three core operations

### 4a. Insert
Walk character by character. For each character, if the child link is missing, create it. Move down.
After the last character, mark `endOfWord = true`.

```
insert("car"):
  start at root
  'c' -> no child, create it, move down
  'a' -> no child, create it, move down
  'r' -> no child, create it, move down
  mark endOfWord = true on the 'r' node
```

### 4b. Search (exact word)
Walk the characters. If any link is missing, the word isn't there → return `false`. If you reach the
end, return the node's `endOfWord` flag (the path may exist only as a prefix of a longer word).

### 4c. startsWith (prefix check)
Identical to search, **except** at the end you return `true` regardless of `endOfWord` — you only
care that the path exists.

> 🔑 **Search vs startsWith** differ in exactly one line: search returns `endOfWord`, startsWith
> returns `true`. That single flag is the heart of a Trie.

---

## 5. Java implementation

The repo's [TrieNode.java](TrieNode.java) and [Trie.java](Trie.java) implement this. Here it is
fully commented (field spelled `children` for clarity):

```java
class TrieNode {
    TrieNode[] children;   // index 0..25 for 'a'..'z'
    boolean endOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();   // root represents the empty prefix ""
    }

    // Insert a word, creating nodes as needed.  O(L) where L = word length.
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';                       // map letter -> slot
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(); // create missing link
            }
            current = current.children[index];           // descend
        }
        current.endOfWord = true;                         // mark complete word
    }

    // Is `word` a complete stored word?  O(L).
    public boolean search(String word) {
        TrieNode node = walk(word);
        return node != null && node.endOfWord;            // path exists AND ends here
    }

    // Does any stored word start with `prefix`?  O(L).
    public boolean startsWith(String prefix) {
        return walk(prefix) != null;                      // path exists, flag irrelevant
    }

    // Shared helper: follow the path for `s`, return the final node or null if it breaks.
    private TrieNode walk(String s) {
        TrieNode current = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) return null; // dead end
            current = current.children[index];
        }
        return current;
    }
}
```

> 💡 Extracting the shared `walk` helper removes the near-duplicate loop that `search` and
> `startsWith` would otherwise both contain.

---

## 6. Dry run (trace it by hand)

Insert `"cat"`, `"car"`, `"card"`, then query:

| Operation            | Walk            | Result | Why                                            |
| -------------------- | --------------- | ------ | ---------------------------------------------- |
| `search("car")`      | c → a → r       | `true`  | path exists and `r` node has `endOfWord=true`  |
| `search("ca")`       | c → a           | `false` | path exists but `a` node has `endOfWord=false` |
| `search("care")`     | c → a → r → ✗   | `false` | no `e` child after `r`                         |
| `startsWith("ca")`   | c → a           | `true`  | path exists; flag doesn't matter               |
| `startsWith("dog")`  | d → ✗           | `false` | no `d` child at the root                       |

This table captures the entire behavioral contract of a Trie.

---

## 7. Bonus operations (often asked as follow-ups)

### 7a. Collect all words with a given prefix (autocomplete)
Find the prefix node, then DFS down, appending characters and recording every node where
`endOfWord` is true.

```java
public List<String> autocomplete(String prefix) {
    List<String> results = new ArrayList<>();
    TrieNode node = walk(prefix);
    if (node != null) dfs(node, new StringBuilder(prefix), results);
    return results;
}

private void dfs(TrieNode node, StringBuilder path, List<String> out) {
    if (node.endOfWord) out.add(path.toString());
    for (int i = 0; i < 26; i++) {
        if (node.children[i] != null) {
            path.append((char) ('a' + i));
            dfs(node.children[i], path, out);
            path.deleteCharAt(path.length() - 1);   // backtrack
        }
    }
}
```

### 7b. Wildcard search (LeetCode 211, "." matches any letter)
When you hit a `.`, branch into **every** non-null child instead of one specific index — a recursive
DFS over the Trie.

---

## 8. Complexity

Let **L** = length of the word/prefix, **N** = number of words, **A** = alphabet size (26 here).

| Operation     | Time   | Notes                                            |
| ------------- | ------ | ------------------------------------------------ |
| `insert`      | O(L)   | one node visit per character                     |
| `search`      | O(L)   | independent of how many words are stored         |
| `startsWith`  | O(L)   | same walk as search                              |

- **Space:** worst case `O(N · L · A)` — every node carries an array of size A. Using a
  `HashMap<Character, TrieNode>` per node trades a little speed for much less space when the tree is
  sparse.
- The big win: lookups depend only on **word length**, *not* on the number of stored words.

---

## 9. Common pitfalls

1. **Forgetting `endOfWord`** → you can't distinguish a stored word from a mere prefix; `search` and
   `startsWith` collapse into the same thing.
2. **Returning `true` from `search` just because the path exists** → must return `endOfWord`.
3. **Wrong index mapping** → `ch - 'a'` assumes lowercase a–z only. Uppercase, digits, or Unicode
   need a bigger array or a `HashMap`.
4. **Reusing one `TrieNode` array reference** instead of `new TrieNode()` → all nodes alias the same
   children. Always allocate a fresh node.
5. **Array vs HashMap trade-off ignored** → fixed 26-array is fast but memory-heavy for sparse data;
   `HashMap` is leaner for large/unknown alphabets.

---

## 10. Practice problems (LeetCode)

| #   | Problem                                   | Pattern                          |
| --- | ----------------------------------------- | -------------------------------- |
| 208 | Implement Trie (Prefix Tree)              | The canonical insert/search/startsWith |
| 211 | Design Add and Search Words Data Structure| Wildcard `.` search (DFS)        |
| 212 | Word Search II                            | Trie + grid DFS / backtracking   |
| 648 | Replace Words                             | Shortest-prefix lookup           |
| 1268| Search Suggestions System                 | Autocomplete (prefix + collect)  |
| 14  | Longest Common Prefix                     | Prefix intuition (Trie optional) |
| 421 | Maximum XOR of Two Numbers in an Array    | Binary Trie (bits instead of letters) |

Start with **208** (you've essentially built it already), then **211** and **212**.

---

## TL;DR

- A Trie is a **prefix tree**: each node = a character, each path = a prefix.
- Each node has **`children` links** + an **`endOfWord` flag**.
- `insert`, `search`, `startsWith` are all **O(word length)** — independent of how many words exist.
- `search` returns `endOfWord`; `startsWith` returns `true`. **That flag is the whole difference.**
- Shines for **prefix queries and autocomplete**; use a `HashSet` if you only need exact lookups.
