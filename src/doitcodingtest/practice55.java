package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice55 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        int arrival_TimeArr[] = new int[N + 1];
        List<Node> route[] = new List[N + 1];
        List<Node> route_Reverse[] = new List[N + 1];
        Queue<Integer> myQueue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            route[i] = new ArrayList<>();
            route_Reverse[i] = new ArrayList<>();
        }

        int count[] = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int temp_Arrival_Time = Integer.parseInt(st.nextToken());

            route[start].add(new Node(end, temp_Arrival_Time));
            route_Reverse[end].add(new Node(start, temp_Arrival_Time));
            count[end]++;
        }
        st = new StringTokenizer(bf.readLine());
        int start_node_index = Integer.parseInt(st.nextToken());
        int end_node_index = Integer.parseInt(st.nextToken());


        myQueue.add(start_node_index);

        while (!myQueue.isEmpty()) {
            int now = myQueue.poll();

            for (Node next : route[now]) {
                int temp = arrival_TimeArr[next.index];
                arrival_TimeArr[next.index] = Math.max(arrival_TimeArr[next.index], arrival_TimeArr[now] + next.arrival_Time);

                count[next.index]--;
                if (count[next.index] == 0) {
                    myQueue.add(next.index);
                }
            }
        }

        myQueue = new LinkedList<>();

        myQueue.add(end_node_index);
        int reverse_Count = 0;

        boolean visited[] = new boolean[N + 1];

        while (!myQueue.isEmpty()) {
            int now = myQueue.poll();

            for (Node next : route_Reverse[now]) {
                if (((arrival_TimeArr[next.index] + next.arrival_Time) == arrival_TimeArr[now])) {
                    reverse_Count++;
                    if (!visited[next.index]) {
                        visited[next.index] = true;
                        myQueue.add(next.index);
                    }
                }
            }
        }


        System.out.println(arrival_TimeArr[end_node_index]);
        System.out.println(reverse_Count);
    }

    public static class Node {
        int index;
        int arrival_Time;


        public Node(int index, int arrival_Time) {
            this.index = index;
            this.arrival_Time = arrival_Time;
        }


    }
}
