class Solution {

    class TrieNode {

        TrieNode[] children;
        int bestIndex;

        public TrieNode() {

            children = new TrieNode[26];
            bestIndex = -1;
        }
    }

    class Trie {

        private TrieNode root;
        private String[] wordsContainer;

        public Trie(String[] wordsContainer) {

            this.wordsContainer = wordsContainer;
            root = new TrieNode();
        }

        // Insert reversed word into Trie
        public void insert(String word, int index) {

            TrieNode current = root;

            // Update root best index
            updateBestIndex(current, index);

            String reversed =
                    new StringBuilder(word)
                            .reverse()
                            .toString();

            for (char ch : reversed.toCharArray()) {

                int idx = ch - 'a';

                if (current.children[idx] == null) {

                    current.children[idx] =
                            new TrieNode();
                }

                current = current.children[idx];

                updateBestIndex(current, index);
            }
        }

        // Search longest common suffix
        public int search(String word) {

            TrieNode current = root;

            String reversed =
                    new StringBuilder(word)
                            .reverse()
                            .toString();

            for (char ch : reversed.toCharArray()) {

                int idx = ch - 'a';

                if (current.children[idx] == null) {

                    break;
                }

                current = current.children[idx];
            }

            return current.bestIndex;
        }

        // Maintain shortest length word
        // If tie -> earlier index automatically remains
        private void updateBestIndex(
                TrieNode node,
                int index
        ) {

            if (node.bestIndex == -1) {

                node.bestIndex = index;
                return;
            }

            String existing =
                    wordsContainer[node.bestIndex];

            String newWord =
                    wordsContainer[index];

            if (newWord.length() < existing.length()) {

                node.bestIndex = index;
            }
        }
    }

    public int[] stringIndices(
            String[] wordsContainer,
            String[] wordsQuery
    ) {

        Trie trie = new Trie(wordsContainer);

        // Build Trie
        for (int i = 0;
             i < wordsContainer.length;
             i++) {

            trie.insert(wordsContainer[i], i);
        }

        int[] ans =
                new int[wordsQuery.length];

        // Process Queries
        for (int i = 0;
             i < wordsQuery.length;
             i++) {

            ans[i] =
                    trie.search(wordsQuery[i]);
        }

        return ans;
    }
}