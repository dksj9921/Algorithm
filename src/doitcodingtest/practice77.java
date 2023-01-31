package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice77 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long arr[][] = new long[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i][i] = 1;
            arr[i][1] = i;
            arr[i][0] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % 10007;
            }
        }

        System.out.println(arr[N][K]);
    }
}

