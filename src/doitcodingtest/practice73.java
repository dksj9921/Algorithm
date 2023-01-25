package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice73 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int Height = 0;
        int tempLength = N;
        int Mod = 1000000007;

        while (tempLength > 0) {
            tempLength /= 2;
            Height++;
        }

        int size = (int) Math.pow(2, Height + 1);

        long arr[] = new long[size];
        int startNode = size / 2;

        for (int i = 0; i < N; i++) {
            arr[startNode + i] = Long.parseLong(bf.readLine());
        }

        for (int i = startNode + N; i < size; i++) {
            arr[i] = 1;
        }

        for (int i = startNode - 1; i > 0; i--) {
            arr[i] = arr[i * 2] * arr[i * 2 + 1] % Mod;
        }


        while (M != 0 || K != 0) {
            st = new StringTokenizer(bf.readLine());
            int check = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            start = startNode + start - 1;


            if (check == 1) {
                arr[start] = end;

                while (start > 1) {
                    start = start / 2;
                    arr[start] = arr[start * 2] * arr[start * 2 + 1] % Mod;
                }

                M--;
            }

            if (check == 2) {
                long sum = 1;
                end = startNode + end - 1;
                while (start <= end) {
                    if (start % 2 == 1) {
                        sum = sum % Mod * arr[start] % Mod;
                        start++;
                    }

                    if (end % 2 == 0) {
                        sum = sum % Mod * arr[end] % Mod;
                        end--;
                    }
                    start /= 2;
                    end /= 2;
                }
                K--;
                System.out.println(sum);
            }

        }
    }
}
