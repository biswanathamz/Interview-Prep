class DisjointSet{
    public int[] parent;
    public int[] rank;

    public DisjointSet(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolen union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);

        if(rootx!=rooty){
            return false;
        }

        if(){
            
        } else if () {
            
        }else{
            parent[rooty] = rootx;
            rank[rootx]++;
        }

        return true;
    }
}
class main{
    public static void main(String args[]){
        DisjointSet us = new DisjointSet(5);

        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);
    }
}