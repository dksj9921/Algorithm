package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice58 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Node> arr[] = new List[n + 1];
        Queue<Node> myQueue = new LinkedList<>();
        HashSet<Integer> answer[] = new HashSet[n + 1];
        int weight_Arr[] = new int[n + 1];


        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
            answer[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr[start].add(new Node(end, weight));
        }

        myQueue.add(new Node(1, 0));

        while (!myQueue.isEmpty()) {
            Node now = myQueue.poll();
            int now_value = now.value;

            for (Node next : arr[now.index]) {
                if (weight_Arr[next.index] != (now_value + next.value)) {
                    answer[next.index].add(now_value + next.value);
                    if (answer[next.index].size() <= k + 2) {
                        myQueue.add(new Node(next.index, now_value + next.value));
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if(answer[i].size()<k){
                sb.append(-1 + "\n");
            } else {
                answer[i].stream().sorted();z
                Iterator<Integer> iter = answer[i].iterator();
                for (int j = 0; j < k; j++) {
                    int temp = iter.next();
                    if (j == k - 1) {
                        sb.append(temp + "\n");
                    }
                }
            }


        }

        System.out.println(sb);
    }

    public static class Node {
        int index, value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
