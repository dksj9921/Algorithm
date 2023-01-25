package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.StringTokenizer;


public class practice21 {
    //버블 솔트 2
    static int N = 0;
    static long count = 0;

    public static void main(String Args[]) throws NumberFormatException, IOException {
        //버블 솔트 2 인데 거의 Marge sort
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int arr[] = new int[N];
        int tempArr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        MargeSort(arr, 0, N - 1, tempArr);

        bw.write(String.valueOf(count));
        bf.close();
        bw.flush();


    }

    static void MargeSort(int[] arr, int start, int end, int[] tempArr) {
        int m = (start + end) / 2;

        if (end - start > 1) {
            MargeSort(arr, start, m, tempArr);
            MargeSort(arr, m + 1, end, tempArr);
        }


        for (int k = start; k <= end; k++) {
            tempArr[k] = arr[k];
        }


        int temp = m + 1;
        int i = start;
        while (i <= end) {
            if (m + 1 <= end && tempArr[start] > tempArr[m + 1]) {
                arr[i] = tempArr[m + 1];
                count += (m+1-i);
                m++;
            } else if (start < temp) {
                arr[i] = tempArr[start];
                start++;
            } else {
                arr[i] = tempArr[m + 1];
                m++;
            }
            i++;
        }

    }
}
