import java.io.*;
import java.util.*;

public class pq {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int t = sc.nextInt();

        int c = sc.nextInt();

        // write your code here

        bfs(graph, t, c);
    }

    public static class Pair {
        int vtx;
        int psf;

        Pair(int vtx, int psf) {
            this.vtx = vtx;
            this.psf = psf;
        }
    }

    public static int bfs(ArrayList<Edge> graph[], int t, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 1));

        int dis[][] = new int[graph.length][2];

        dis[1][0] = 0;

        while (pq.isEmpty() == false) {
            Pair<Integer, String> node = pq.pop();

            int distance = node.first;

            int par = node.second;

            for (Edge child : par) {
                int updated = (distance + c) / t;
                int xxx = distance + c;

                if (updated % 2 == 1) {
                    xxx += t - ((distance + c) % t);
                }

                if (dis[child][1] > xxx) {
                    dis[child][1] = xxx;

                    Arrays.sort(dis[child]);

                    pq.add(new Pair(xxx, child));
                }
            }
        }

        System.out.println(dis[graph.length][0]);

    }
}