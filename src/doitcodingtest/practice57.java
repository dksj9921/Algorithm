package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice57 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        List<Node> arr[] = new ArrayList[N + 1];
        PriorityQueue<Node> myQueue = new PriorityQueue<>();
        boolean visited[] = new boolean[N + 1];
        int weight_Arr[] = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < N + 1; i++) {
            weight_Arr[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int weight = Integer.parseInt(st.nextToken());

            arr[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(bf.readLine());

        int start_Node = Integer.parseInt(st.nextToken());
        int end_Node = Integer.parseInt(st.nextToken());

        weight_Arr[start_Node] = 0;
        myQueue.add(new Node(start_Node, 0));

        while (!myQueue.isEmpty()) {
            Node now = myQueue.poll();
            if (visited[now.index]) continue;
            visited[now.index] = true;

            for (Node next : arr[now.index]) {
                if (weight_Arr[next.index] > (weight_Arr[now.index] + next.value)) {
                    weight_Arr[next.index] = (weight_Arr[now.index] + next.value);
                    myQueue.add(new Node(next.index, weight_Arr[next.index]));
                }
            }
        }

        System.out.println(weight_Arr[end_Node]);
    }


    public static class Node implements Comparable<Node> {
        int index, value;

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
