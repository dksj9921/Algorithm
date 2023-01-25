package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice40 {
    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size = (int) (max - min + 1);


        boolean arr[] = new boolean[size];

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start_Index = min / square;
            if (min % square != 0) start_Index++;
            for (long k = start_Index; k * square <= max; k++) {
                arr[(int) ((k * square) - min)] = true;

            }
        }

        long count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!arr[i]) count++;
        }

        System.out.println(count);


    }


}
