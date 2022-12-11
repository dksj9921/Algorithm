import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class practice26 {
    //DFS와 BFS
    static ArrayList<Integer> arr[];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static Queue<Integer> myQueue = new LinkedList<>();

    public static void main(String Args[]) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        ;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());


        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        for (int i = 1; i < N + 1; i++) {
            if (!arr[i].isEmpty()) Collections.sort(arr[i]);
        }

        DFS(start);

        visited = new boolean[N + 1];

        if (!visited[start]) {
            myQueue.add(start);

            while (!myQueue.isEmpty()) {
                int poll = myQueue.poll();
                sb2.append(poll).append(" ");
                visited[poll] = true;
                for (int k : arr[poll]) {
                    if (!visited[k]) {
                        myQueue.add(k);
                        visited[k] = true;
                    }
                }
            }
        }


        System.out.println(sb);
        System.out.print(sb2);

    }

    public static void DFS(int index) {
        if (visited[index]) return;
        sb.append(index).append(" ");
        visited[index] = true;

        for (int i : arr[index]) {
            if (!visited[i]) DFS(i);
        }
    }
}
