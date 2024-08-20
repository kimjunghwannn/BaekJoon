package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class bak_24479 {
    
    static class Node {
        int data;
        LinkedList<Integer> adjacentNodes;

        public Node(int data) {
            this.data = data;
            this.adjacentNodes = new LinkedList<>();
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int lines = Integer.parseInt(input[1]);
        int starting = Integer.parseInt(input[2]);
        int rage[]=new int[n+1];
        int count=0;
        Node[] graph = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new Node(i);
        }

        for (int i = 0; i < lines; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            graph[start].adjacentNodes.add(end);
            graph[end].adjacentNodes.add(start);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i].adjacentNodes);
        }
        int[] visited = new int[n + 1];
        dodfs(starting, visited, graph,rage,count);

        for (int i = 1; i <= n; i++) {
            if (visited[i]!=0) {
               System.out.println(rage[i]);
            }
            else
            	System.out.println(-1);
        }

        
    }

    public static void dodfs(int v, int[] visited, Node[] graph,int[] rage,int count) {
        visited[v] = 1;
       rage[v]=count++;
        for (int w : graph[v].adjacentNodes) {
            if (visited[w]==0) {
                dodfs(w, visited, graph,rage,count);
            }
        }
        
    }
}