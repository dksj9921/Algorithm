import com.sun.source.doctree.SummaryTree;

import java.io.*;
import java.nio.BufferOverflowException;
import java.time.temporal.Temporal;

public class practice20 {
    static int N = 0;

    public static void main(String Args[]) throws NumberFormatException, IOException {
        //Merge Sort
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bf.readLine());

        int arr[] = new int[N];
        int tempArr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        MargeSort(arr, 0, N - 1, tempArr);
        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(arr[i]));
            bw.write("\n");
        }

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


        int temp = m+1;
        int i = start;
        while (i <= end) {
            if (m + 1 <= end && tempArr[start] > tempArr[m + 1] ) {
                arr[i] = tempArr[m + 1];
                m++;
            } else if(start<temp){
                arr[i] = tempArr[start];
                start++;
            } else {
                arr[i] = tempArr[m+1];
                m++;
            }
            i++;
        }

    }
}
