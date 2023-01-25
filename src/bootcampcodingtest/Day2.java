package bootcampcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int arr[][] = new int[N][N];
        int wall[] = new int[4];

        int count = 1;
        int temp = 0;
        int wall_Control = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - wall[wall_Control]; j++) {
                int check = i % 4;
                if (check == 0) {
                    arr[i][j] = count;
                }
                else if (check == 1) {
                    arr[j][N - 1 - wall[wall_Control]] = count;
                }
                else if (check == 2){
                }


            }
        }
    }
}
