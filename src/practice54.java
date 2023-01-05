import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class practice54 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        List<Node> building[] = new List[N + 1];
        int time[] = new int[N + 1];
        int answer[] = new int[N + 1];
        int count[] = new int[N + 1];
        boolean visited[] = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            building[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp != -1) {
                    building[temp].add(new Node(i, false));
                    count[i]++;
                } else break;
            }
        }

        boolean isFinished = false;
        while (true) {
            isFinished = false;
            for (int i = 1; i <= N; i++) {
                if (count[i] == 0 && !visited[i]) {
                    answer[i] += time[i];
                    isFinished = true;
                    for (Node k : building[i]) {
                        if (!visited[i] && !k.isCount) {
                            answer[k.index] = answer[i] + answer[k.index];
                            k.ChangeIsCount();
                        }
                        count[k.index]--;
                    }
                    visited[i] = true;
                }
            }
            if (!isFinished) {
                break;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.println(answer[i]);
        }
    }

    public static class Node {
        int index;
        boolean isCount;

        public Node(int index, boolean isCount) {
            this.index = index;
            this.isCount = false;
        }

        public void ChangeIsCount(){
            this.isCount = true;
        }
    }

}
