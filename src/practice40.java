import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class practice40 {
    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size = (int) (max - min + 1);

        long arr[] = new long[1000001];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = min + i - 1;
        }

        for (int i = 2, j = 0; i < Math.sqrt(max); i++) {
            int square = i * i;
            for (int k = square; k < max; k = k + square) {
                if(square>=arr[i]){
                    arr[i] = 0;
                }
            }
        }
        long count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) count++;
        }

        System.out.println(count);


    }


}
