package doitcodingtest;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice80 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M = Integer.parseInt(bf.readLine());


        int arr[] = new int[M];
        int sum = 0;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int K = Integer.parseInt(bf.readLine());

        if (sum < K) {
            System.out.println("0.0");
            System.exit(0);
        }

//        int percent[][] = new int[sum + 1][sum + 1];
//
//        for (int i = 0; i < sum + 1; i++) {
//            percent[i][i] = 1;
//            percent[i][0] = 1;
//            percent[i][1] = i;
//        }
//
//        for (int i = 1; i < sum + 1; i++) {
//            for (int j = 1; j < sum + 1; j++) {
//                percent[i][j] = percent[i - 1][j] + percent[i][j - 1];
//            }
//        }

//        for (int i = 1; i < sum + 1; i++) {
//            for (int j = 1; j < sum + 1; j++) {
//                System.out.print(percent[i][j]+" ");
//            }
//            System.out.println("");
//        }

        double answer = 0;
        for (int i = 0; i < M; i++) {
            if(arr[i] < K){
                continue;
            }

            double tempSum = 1;
            double temp = 1;
            for (int j = 0; j < K; j++) {
//                System.out.println(sum);
                tempSum *= arr[i];
                arr[i]--;
                temp *= (sum - j);
//                System.out.println(tempSum + " " + temp);
            }
            answer = answer + (tempSum / temp);
        }

        System.out.println(answer);

    }

}
