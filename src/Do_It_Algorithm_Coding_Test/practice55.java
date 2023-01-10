package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.util.*;

public class practice55 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        int arrival_TimeArr[] = new int[N + 1];
        List<Node> route[] = new List[N + 1];
        int arrival_CountArr[] = new int[N + 1];

        Queue<Integer> myQueue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            route[i] = new ArrayList<>();
        }

        int count[] = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int temp_Arrival_Time = Integer.parseInt(st.nextToken());

            route[start].add(new Node(end, temp_Arrival_Time));
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

                if (arrival_TimeArr[next.index] == arrival_TimeArr[now] + next.arrival_Time) {
                    if(arrival_TimeArr[next.index] == temp){
                        arrival_CountArr[next.index] = arrival_CountArr[now] + arrival_CountArr[next.index] + 1;
                    }else arrival_CountArr[next.index] = arrival_CountArr[now] + 1;
                }
                count[next.index]--;
                if (count[next.index] == 0) {
                    myQueue.add(next.index);
                }
            }
        }

        System.out.println(arrival_TimeArr[end_node_index]);
        System.out.println(arrival_CountArr[end_node_index]);
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
