package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice30 {

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        int sum = 0;
        int max = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (arr[i] > max) max = arr[i];
        }

        int start = max;
        int end = sum;
        int count = 0;
        int middle = 0;


        while (start <= end) {
            middle = (start + end) / 2;
            int arrSum = 0;
            count = 0;
            for (int i = 0; i < N; i++) {
                if (arrSum + arr[i] > middle) {
                    count++;
                    arrSum = 0;
                }
                arrSum = arrSum + arr[i];
            }
            if (arrSum != 0) count++;

            if (count > M) start = middle + 1;
            else end = middle - 1;
        }

        System.out.println(start);

    }

}
