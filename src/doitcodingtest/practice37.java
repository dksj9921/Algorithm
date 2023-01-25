package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class practice37 {

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr2 = new ArrayList<>();

        boolean arr[] = new boolean[M + 1];

        arr[0] = arr[1] = true;

        for (int i = 2; i * i <= M; i++) {
            for (int k = i * i; k <= M; k += i) {
                arr[k] = true;
            }
        }

        for (int i = N; i <= M; i++) {
            if (!arr[i]) arr2.add(i);
        }

        for (int i = 0; i < arr2.size(); i++) {
            System.out.println(arr2.get(i));
        }
    }
}
