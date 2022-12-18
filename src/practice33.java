import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.util.PriorityQueue;

public class practice33 {

    public static void main(String Args[])throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> myQueue = new PriorityQueue<>();
        for(int i = 0; i<N; i++){
            int temp = Integer.parseInt(bf.readLine());
            myQueue.add(temp);
        }
        int count = 0;
        while(myQueue.size()>1){
            int temp1 = myQueue.poll();
            int temp2 = myQueue.poll();
            int temp3 = temp1+temp2;
            count += temp3;
            myQueue.add(temp3);
        }

        System.out.println(count);
    }
}
