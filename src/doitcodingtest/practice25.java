package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class practice25 {
    //친구 관계 파악하기
    static ArrayList<Integer> arr[];
    static boolean visited[];

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int k = 0; k < N; k++) {
                visited[k] = false;
            }
            DFS(i, count);
        }
        System.out.println(0);
    }

    static void DFS(int input, int count) {

        if (visited[input]) return;

        count++;

        if (count == 5) {
            System.out.println(1);
            System.exit(0);
        }

        visited[input] = true;

        if(arr[input].isEmpty()) count--;
        for (int i : arr[input]) {
            if (!visited[i]) {
                DFS(i, count);
            }
        }
        visited[input] = false;
    }
}
