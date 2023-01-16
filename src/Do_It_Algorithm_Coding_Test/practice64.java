package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class practice64 {
    static int arr[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> myQueue = new PriorityQueue<>();
        arr = new int[N + 1];
        int sum_Weight = 0;

        for (int i = 0; i < N + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            myQueue.add(new Node(start, end, weight));
        }

        int used_Edge = 0;
        while (used_Edge<N-1) {
            Node now_Node = myQueue.poll();
            int temp_start = Find(now_Node.start);
            int temp_end = Find(now_Node.end);
            if (temp_start != temp_end) {
                Union(now_Node.start, now_Node.end);
                sum_Weight += now_Node.weight;
                used_Edge++;
            }
//            for (int i = 0; i < N + 1; i++) {
//                System.out.print(arr[i]+" ");
//            }
//            System.out.println(sum_Weight);
        }

        System.out.println(sum_Weight);
    }

    public static class Node implements Comparable<Node>{
        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node input) {
            return this.weight > input.weight ? 1 : -1;
        }
    }

    public static void Union(int a, int b) {
        int temp_A = Find(a);
        int temp_B = Find(b);
        arr[temp_B] = temp_A;
    }

    public static int Find(int input) {
        if (arr[input] == input) {
            return input;
        } else return arr[input] = Find(arr[input]);
    }
}
