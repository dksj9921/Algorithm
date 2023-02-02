package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice79 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());

        for (int repeat = 0; repeat < T; repeat++) {
            st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int arr[][] = new int[M + 1][M + 1];

            for (int i = 0; i < M + 1; i++) {
                arr[i][i] = 1;
                arr[i][1] = i;
                arr[i][0] = 1;
            }

            for (int i = 1; i < M + 1; i++) {
                for (int j = 1; j < M + 1; j++) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }

            System.out.println(arr[M][N]);
        }
    }
}
