package doitcodingtest;

import java.io.*;
import java.util.*;

public class practice47 {

    static List<Integer> arr[];
    static int MAX = 0;
    static int Hole_Max = 0;
    static boolean visited[];
    static int arr2[];

    public static void main(String[] Args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new List[N + 1];
        visited = new boolean[N + 1];
        arr2 = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
        }

        Hole_Max = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            DFS(i);
        }

        MAX = 0;
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] > MAX) {
                MAX = arr2[i];
            }
        }
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] == MAX) {
                bw.write(i+" ");
            }
        }
        bw.flush();
        bw.close();
        bf.close();
    }

    public static void DFS(int node) {
        visited[node] = true;
        arr2[node]++;
        MAX++;
        for (int i : arr[node]) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i);
            }
        }
    }
}
