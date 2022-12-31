import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice48 {
    static List<Integer> arr[];
    static boolean visited[];
    static Queue<Integer> myQueue;
    static boolean divide[];
    static boolean isNO;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        String answer[] = new String[T];



        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr = new List[V + 1];
            visited = new boolean[V + 1];
            divide = new boolean[V + 1];

            for (int j = 1; j < V + 1; j++) {
                arr[j] = new ArrayList<>();
            }

            myQueue = new LinkedList<>();

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                arr[start].add(end);
                arr[end].add(start);
            }
            isNO = false;
            for (int j = 1; j < V + 1; j++) {
                if (!visited[j]) {
                    myQueue.add(j);
                    BFS();
                }
                if(isNO) break;
            }

            if(isNO){
                answer[i] = "NO";
            }else answer[i] = "YES";
        }

        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void BFS() {
        while (!myQueue.isEmpty()) {
            int nodeIndex = myQueue.poll();
            visited[nodeIndex] = true;

            for (int i : arr[nodeIndex]) {
                if (!visited[i]) {
                    myQueue.add(i);
                    visited[i] = true;
                    divide[i] = !divide[nodeIndex];
                }else {
                    if (divide[i] == divide[nodeIndex]) {
                        isNO = true;
                    }
                }
            }
        }
    }

}
