package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class practice66 {
    static int unionArr[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int lanLine[][] = new int[N][N];
        unionArr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            char[] arr = st.nextToken().toCharArray();
            unionArr[i] = i;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == 48) {
                    lanLine[i][j] = 0;
                    continue;
                }
                int temp = arr[j];
                if (temp >= 97 && temp <= 122) {
                    lanLine[i][j] = temp - 96;
                } else if (temp >= 65 && temp <= 90) {
                    lanLine[i][j] = temp - 38;
                }
            }

        }

        PriorityQueue<Node> myQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lanLine[i][j] != 0) {
                    myQueue.add(new Node(i, j, lanLine[i][j]));
                }
            }
        }
        int count = 0;
        int sum = 0;

        while (!myQueue.isEmpty()) {
            Node now = myQueue.poll();

            if (Find(now.start) != Find(now.end)) {
                Union(now.start, now.end);
                count++;
            } else sum += now.weight;
        }
        if (count < N - 1) {
            System.out.println(-1);
        }else System.out.println(sum);



    }
    public static class Node implements Comparable<Node>{
        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.end = end;
            this.start = start;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node input) {
            return this.weight < input.weight ? -1 : 1;
        }
    }

    public static void Union(int a, int b) {
        a = Find(a);
        b = Find(b);
        if (a != b) {
            unionArr[b] = a;
        }
    }

    public static int Find(int input) {
        if (unionArr[input] == input) {
            return input;
        } else return unionArr[input] = Find(unionArr[input]);
    }


}
