package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice60 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int V = Integer.parseInt(st.nextToken());
        int start_Node = Integer.parseInt(st.nextToken());
        int end_Node = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Edge edge_List[] = new Edge[E];
        int money[] = new int[V];
        long least_weight[] = new long[V];
        List<Edge> check_Arr[] = new List[V];

        for (int i = 0; i < V; i++) {
            check_Arr[i] = new ArrayList<>();
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edge_List[i] = new Edge(start, end, weight);
            check_Arr[start].add(new Edge(start, end, weight));

        }
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < V; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            least_weight[i] = Integer.MAX_VALUE;
        }
        least_weight[start_Node] = (0 - money[start_Node]);

        for (int i = 0; i < E; i++) {
            edge_List[i].weight -= money[edge_List[i].end];
        }


        for (int i = 0; i < V; i++) {
            for (int j = 0; j < E; j++) {
                Edge now = edge_List[j];
                if ((least_weight[now.end] > (least_weight[now.start] + now.weight)) && (least_weight[now.start] != Integer.MAX_VALUE)) {
                    least_weight[now.end] = (least_weight[now.start] + now.weight);
                }
//                for (int k = 0; k < V; k++) {
//                    System.out.print(least_weight[k] + " ");
//                }
//                System.out.println("");
            }
        }

        boolean isCheck = false;
        HashSet<Integer> change_Node = new HashSet<>();
        for (int i = 0; i < E; i++) {
            Edge now = edge_List[i];
            if ((least_weight[now.end] > (least_weight[now.start] + now.weight)) && (least_weight[now.start] != Integer.MAX_VALUE)) {
                isCheck = true;
                change_Node.add(now.start);
                change_Node.add(now.end);
            }
        }

        Queue<Integer> check_Q = new LinkedList<>();
        Iterator iter = change_Node.iterator();
        boolean isGee = false;
        boolean visited[];
        if (isCheck) {
            while (iter.hasNext() && !isGee) {
                int check = (int) (iter.next());


                check_Q.add(check);
                visited = new boolean[V];

                while (!check_Q.isEmpty() && !isGee) {

                    int now = check_Q.poll();
                    visited[now] = true;

                    for (Edge k : check_Arr[now]) {
                        if (k.end == end_Node) {
                            isGee = true;
                            break;
                        }
                        if (!visited[k.end]) {
                            check_Q.add(k.end);
                        }
                    }
                }
            }
        }


        if (least_weight[end_Node] == Integer.MAX_VALUE) {
            System.out.println("gg");
        } else if (isCheck && isGee) {
            System.out.println("Gee");
        } else System.out.println(-least_weight[end_Node]);

    }

    public static class Edge {
        int weight, start, end;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
