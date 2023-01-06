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
        List<Integer> building[] = new List[N + 1];
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
                    building[temp].add(i);
                    count[i]++;
                } else break;
            }
        }

        boolean isFinished = false;
        while (true) {
            isFinished = false;
            for (int i = 1; i <= N; i++) {
                if (count[i] == 0 && !visited[i]) {
                    for (int k : building[i]) {
                        answer[k] = Math.max(answer[k], time[i] + answer[i]);
                        count[k]--;
                    }
                    visited[i] = true;
                    isFinished = true;
                }
            }
            if (!isFinished) break;
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.println(answer[i]+time[i]);

        }

    }
}
