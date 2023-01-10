package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice32 {

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        int tempI = 0;
        boolean isFirst = false;
        int count = 0;

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(bf.readLine());
            arr[i] = temp;
            if (temp > K && !isFirst) {
                tempI = i-1;
                isFirst = true;
            }
        }

        if(!isFirst) tempI = N-1;

        for (int i = tempI; i >= 0; i--) {
            if (K == 0) {
                break;
            }

            if (K >= arr[i]) {
                count += K / arr[i];
                K = K % arr[i];
            }
        }

        System.out.println(count);
    }
}
