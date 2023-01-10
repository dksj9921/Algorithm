import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemA {
    static List<Integer> arr[];
    static boolean visited[];
    static int Max = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());

        for (int repeat = 0; repeat < T; repeat++) {
            Max = 0;
            st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            arr = new List[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i < N + 1; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                arr[start].add(end);
                arr[end].add(start);
            }
            int all_Max = 0;
            for (int i = 1; i < N + 1; i++) {
                Max = 0;
                if (!visited[i]) {
                    DFS(i);
                }
                if(all_Max<Max) all_Max = Max;
            }

            bw.write(all_Max+"\n");
        }
        bw.flush();
        bw.close();
        bf.close();
    }

    public static void DFS(int index) {
        visited[index] = true;
        Max++;

        for (int i : arr[index]) {
            if (!visited[i]) {
                DFS(i);
                visited[i] = true;
            }
        }
    }
}