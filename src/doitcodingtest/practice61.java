package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice61 {
    static long arr[][];
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        arr = new long[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j) arr[i][j] = 0;
                else {
                    arr[i][j] = MAX;
                }
            }

        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (arr[a][b] > weight) {
                arr[a][b] = weight;
            }
        }
//        for (int i = 1; i < N + 1; i++) {
//            for (int j = 1; j < N + 1; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println("");
//        }


        for (int i = 1; i < N + 1; i++) {
            for (int start = 1; start < N + 1; start++) {
                for (int end = 1; end < N + 1; end++) {
                    if ((arr[start][i] != MAX) && (arr[i][end] != MAX) && (start != i) && (end != i)) {
                        arr[start][end] = Math.min(arr[start][end], (arr[start][i] + arr[i][end]));
                    }
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (arr[i][j] == MAX) {
                    System.out.print(0 + " ");
                } else System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

    }


}
