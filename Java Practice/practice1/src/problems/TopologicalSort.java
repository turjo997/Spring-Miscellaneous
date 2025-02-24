package problems;

import java.util.*;

public class TopologicalSort {

    static final int MAX = 1000;
    static List<Integer>[] graph = new ArrayList[MAX];
    static boolean[] visited = new boolean[MAX];
    static List<Integer> res = new ArrayList<>();

    public static void dfs(int src){
        visited[src] = true;
        for(int nxt : graph[src]){
            if(!visited[nxt]){
                dfs(nxt);
            }
        }
        res.add(src);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nodes = sc.nextInt();
        int edges = sc.nextInt();

        for(int i = 0 ; i < MAX ; ++i){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
        }

        for(int i = 1; i <= nodes ; ++i){
            if(!visited[i]){
                dfs(i);
            }
        }

        Collections.reverse(res);

        for(int node : res){
            System.out.println(node + "");
        }

    }
}
