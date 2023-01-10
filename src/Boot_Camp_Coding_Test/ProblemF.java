import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemF {
    static List<Integer> member[];
    static Queue<Integer> myQueue;
    static boolean visited[];
    static int distance[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for (int repeat = 0; repeat < T; repeat++) {
            int member_Count = Integer.parseInt(bf.readLine());

            member = new List[member_Count + 1];
            visited = new boolean[member_Count + 1];
            myQueue = new LinkedList<>();
            distance = new int[member_Count + 1];

            for (int i = 1; i < member_Count + 1; i++) {
                member[i] = new ArrayList<>();
                st = new StringTokenizer(bf.readLine());
                int trash = Integer.parseInt(st.nextToken());
                while (st.hasMoreTokens()) {
                    member[trash].add(Integer.parseInt(st.nextToken()));
                }
            }

            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            myQueue.add(start);

            while (!myQueue.isEmpty()) {
                int node = myQueue.poll();
                visited[node] = true;
                if (node == end) {
                    break;
                }

                for (int i : member[node]) {
                    if (!visited[i]) {
                        myQueue.add(i);
                        visited[i] = true;
                        distance[i] = distance[node] + 1;
                    }
                }
            }
            if (distance[end] != 0) {
                sb.append(distance[end] + "\n");
            } else sb.append("No\n");
        }
        System.out.println(sb);

        bf.close();
    }
}
