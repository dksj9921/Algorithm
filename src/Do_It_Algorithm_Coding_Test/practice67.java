package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class practice67 {
    static List<Integer> arr[];
    static boolean visited[];
    static int parents[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());

        arr = new List[N + 1];
        visited = new boolean[N + 1];
        parents = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start].add(end);
            arr[end].add(start);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void DFS(int input) {
        visited[input] = true;

        for(int next : arr[input]) {
            if (!visited[next]) {
                parents[next] = input;
                visited[next] = true;
                DFS(next);
            }
        }
    }
}
