package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice63 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N + 1][N + 1];
        int answer[] = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

//        for (int j = 1; j < N + 1; j++) {
//            for (int k = 1; k < N + 1; k++) {
//                System.out.print(arr[j][k] + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");

        for (int i = 1; i < N + 1; i++) {
            for (int start = 1; start < N + 1; start++) {
                for (int end = 1; end < N + 1; end++) {
                    if (((arr[start][i] > 0) && (arr[i][end] > 0))) {
                        if (arr[start][end] == 0) arr[start][end] = arr[start][i] + arr[i][end];
                        else {
                            int temp = Math.min(arr[start][end], arr[start][i] + arr[i][end]);
                            arr[start][end] = temp;
                            arr[end][start] = temp;
                        }
                    }
                }
            }
//            for (int j = 1; j < N + 1; j++) {
//                for (int k = 1; k < N + 1; k++) {
//                    System.out.print(arr[j][k] + " ");
//                }
//                System.out.println("");
//            }
//            System.out.println("");
        }

        int min = Integer.MAX_VALUE;
        int print_Answer = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (arr[i][j] != 0) {
                    answer[i] += arr[i][j];
                }
            }
            if (answer[i] < min) {
                min = answer[i];
                print_Answer = i;
            }
        }

        System.out.println(print_Answer);


    }
}

