package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class practice68 {
    static List<Integer> parents[];
    static int delete;
    static int count = 0;
    static boolean visited[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        parents = new List[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            parents[i] = new ArrayList<>();
        }

        st = new StringTokenizer(bf.readLine());
        int startNode = 0;

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp != -1) {
                parents[temp].add(i);
            } else startNode = i;
        }

        delete = Integer.parseInt(bf.readLine());

        DFS(startNode);

        System.out.println(count);





    }

    static void DFS(int input) {
        visited[input] = true;

        if (input == delete) {
            return;
        }

        if (parents[input].size() == 0) {
            count++;
            return;
        } else if (parents[input].size() == 1 && parents[input].get(0) == delete) {
            count++;
            return;
        }

        for (int next : parents[input]) {
            if (!visited[next] && next != delete) {
                visited[next] = true;
                DFS(next);
            }
        }
    }
}
