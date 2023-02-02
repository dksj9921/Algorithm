package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;

public class practice78 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int repeat = 0; repeat < T; repeat++) {
            int k = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());

            int apart[][] = new int[k + 1][16];

            for (int i = 1; i <= 15; i++) {
                apart[0][i] = i;
            }

            for (int i = 1; i < k + 1; i++) {
                for (int j = 1; j <= 15; j++) {
                    apart[i][j] = apart[i - 1][j] + apart[i][j - 1];
                }
            }

            System.out.println(apart[k][n]);
        }
    }
}
