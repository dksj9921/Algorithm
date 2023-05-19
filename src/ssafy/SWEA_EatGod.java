package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_EatGod {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());

            PriorityQueue<Integer> playerQueue = new PriorityQueue<>(Collections.reverseOrder());

            while (st.hasMoreTokens()) {
                playerQueue.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < K; j++) {
                int now = playerQueue.poll();
                if (now != 0) {
                    now--;
                }
                playerQueue.add(now);
            }

            st = new StringTokenizer(bf.readLine());
            PriorityQueue<Integer> foodQueue = new PriorityQueue<>();

            int Max = 0;
            while(st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                foodQueue.add(temp);
            }

            for (int j = 0; j < N; j++) {
                int nowFood = foodQueue.poll();
                int nowPlayer = playerQueue.poll();

                int tempNow = nowPlayer * nowFood;

                if (Max < tempNow) {
                    Max = tempNow;
                }
            }

            System.out.print("#" + i + " " + Max+"\n");



        }
    }
}
