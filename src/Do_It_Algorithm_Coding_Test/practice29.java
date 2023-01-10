package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice29 {
    static int arr[];

    public static void main(String Args[]) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < M; i++) {
            BinarySearch(Integer.parseInt(st.nextToken()));
        }
    }

    public static void BinarySearch(int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean find = false;

        while (start <= end) {
            int m = (start + end) / 2;
            int M = arr[m];
            if (M > target) {
                end = m - 1;
            } else if (M < target) {
                start = m + 1;
            } else {
                find = true;
                break;
            }
        }

        if (find) System.out.println(1);
        else System.out.println(0);
    }
}
