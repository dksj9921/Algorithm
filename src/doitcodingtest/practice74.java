package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice74 {
    static List<Integer> arr[];
    static boolean visited[];
    static Queue<Integer> myQueue = new LinkedList<>();
    static int depth[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        depth = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        myQueue.add(1);
        BFS();

        for (int i = 1; i <= N; i++) {
            System.out.print(depth[i]+" ");
        };





    }

    static void BFS() {
        while (!myQueue.isEmpty()) {
            int now = myQueue.poll();
            visited[now] = true;

            for (int next : arr[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[now] + 1;
                    myQueue.add(next);
                }
            }
        }
    }


}

