package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class practice38 {

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        boolean arr[] = new boolean[10000001];

        arr[0] = arr[1] = true;

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i]) continue;
            for (int k = i + i; k < arr.length; k += i) {
                arr[k] = true;
            }
        }

        int count = 0;
        for (int i = 2; i < arr.length; i++) {
            long temp = i;
            if (!arr[i]) {
                while ((double)temp<=(double) M/(double) i) {
                   if((double)temp>=(double) N/(double) i) {
                       count++;
                   }
                   temp = temp*i;
                }
            }


        }
        System.out.println(count);
        bf.close();
    }
}
