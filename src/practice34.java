import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class practice34 {

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(bf.readLine());
            if (temp <= 0) {
                negativeQueue.add(-temp);
            } else positiveQueue.add(temp);
        }

        int Max = 0;

        while (positiveQueue.size() > 1) {
            int temp1 = positiveQueue.poll();
            int temp2 = positiveQueue.poll();
            if (temp1 != 1 && temp2 != 1) Max += (temp1 * temp2);
            else Max += (temp1 + temp2);
        }
        if (positiveQueue.size() == 1) {
            Max += positiveQueue.poll();
        }

        while (negativeQueue.size() > 1) {
            int temp1 = negativeQueue.poll();
            int temp2 = negativeQueue.poll();
            Max += (temp1*temp2);
        }
        if(negativeQueue.size()==1){
            Max -= negativeQueue.poll();
        }

        System.out.println(Max);
    }
}
