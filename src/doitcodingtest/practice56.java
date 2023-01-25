package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice56 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int MAX_SIZE = 99999999;

        List<Node> arr[] = new List[V + 1];
        int weight_arr[] = new int[V + 1];
        boolean visited[] = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < V + 1; i++) {
            weight_arr[i] = Integer.MAX_VALUE;
        }

        int start_Node = Integer.parseInt(bf.readLine());
        weight_arr[start_Node] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int weight = Integer.parseInt(st.nextToken());

            arr[start].add(new Node(end, weight));
        }

        PriorityQueue<Node> myQueue = new PriorityQueue<>();

        myQueue.add(new Node(start_Node, 0));

        while (!myQueue.isEmpty()) {
            Node now = myQueue.poll();
            if(visited[now.index]) continue;
            visited[now.index] = true;
            for (Node next : arr[now.index]) {
                if (weight_arr[next.index] > (weight_arr[now.index] + next.value)) {
                    weight_arr[next.index] = (weight_arr[now.index] + next.value);
                    myQueue.add(new Node(next.index, weight_arr[next.index]));
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (!visited[i]) {
                System.out.println("INF");
            } else System.out.println(weight_arr[i]);
        }
    }

    public static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node input) {
            if (this.value > input.value) return 1;
            else return -1;
        }
    }
}
