import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.lang.Math;

import static java.lang.Math.abs;

public class practice14 {
    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(bf.readLine());

        PriorityQueue<absInteger> priorityQueueLowest = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(bf.readLine());
            System.out.println(now);

            if (now != 0) {
                priorityQueueLowest.add(new absInteger(now));
            } else if (now == 0 && !priorityQueueLowest.isEmpty()) {
                System.out.println(priorityQueueLowest.poll());
            } else System.out.println("0");
        }
    }

    static class absInteger implements Comparable<absInteger> {
        int input;

        public absInteger(int input) {
            this.input = input;
        }

        @Override
        public int compareTo(absInteger target) {
            if (abs(this.input) > abs(target.input)) return 1;
            else if (abs(this.input) < abs(target.input)) return -1;
            return this.input > target.input ? 1 : -1;
        }

        @Override
        public String toString() {
            return input + "";
        }
    }
}


