package doitcodingtest;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice75 {
    //다시해야함
    static List<Integer> arr[];
    static boolean visited[];
    static Queue<Integer> myQueue = new LinkedList<>();
    static int depth[];
    static int parents[][];
    static int tempParents[];
    static int MaxDepth = 0;
    static int K = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        tempParents = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        myQueue.add(1);
        BFS();

        int length = MaxDepth;
        K = 0;

        while (length > 0) {
            length /= 2;
            K++;
        }

        parents = new int[K][N+1];

        for (int i = 0; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 0) {
                    parents[i][j] = tempParents[j];
                } else parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }
        System.out.println("");
        for (int i = 0; i < K; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(parents[i][j] + " ");
            }
            System.out.println("");
        }


        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int answer = LCA(a, b);

            System.out.println(answer);
        }


    }

    static void BFS() {
        while (!myQueue.isEmpty()) {
            int now = myQueue.poll();
            visited[now] = true;

            for (int next : arr[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[now] + 1;
                    tempParents[next] = now;
                    if (MaxDepth < depth[next]) {
                        MaxDepth = depth[next];
                    }
                    myQueue.add(next);
                }
            }
        }
    }

    static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int minus = depth[a] - depth[b];
        System.out.println(minus);

        for (int i = K - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= minus) {
                if (depth[b] <= depth[parents[i][a]]) {
                    b = parents[i][b];
                }
            }
        }
        System.out.println(b);

        System.out.println(depth[a] + " " + depth[b]);

        while (a != b) {
            a = tempParents[a];
            b = tempParents[b];
        }

        return a;

    }


}

