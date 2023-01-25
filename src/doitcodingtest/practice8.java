package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice8 {
    //좋은 수 구하기
    public static void main(String Args[]) throws NumberFormatException, IOException {

//        Scanner scanner = new Scanner(System.in);
//
//        int arrNum = scanner.nextInt();
//


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int arrNum = Integer.parseInt(bf.readLine());
        int arr[] = new int[arrNum];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<arrNum; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        int endIndex = arrNum - 1, startIndex = 0, count = 0, i = 0;


        while (i != arrNum) {

                if (endIndex == startIndex) {
                    startIndex = 0;
                    endIndex = arrNum - 1;
                    i++;
                }
                else if (i==startIndex) startIndex++;
                else if (i==endIndex)endIndex--;
                else if (i < arrNum && arr[startIndex] + arr[endIndex] == arr[i]) {
                    count++;
                    i++;
                    startIndex = 0;
                    endIndex = arrNum - 1;
                } else if (i < arrNum && arr[startIndex] + arr[endIndex] > arr[i]) {
                    endIndex--;
                } else if (i < arrNum && arr[startIndex] + arr[endIndex] < arr[i]) {
                    startIndex++;
                }

        }
        System.out.println(count);
        bf.close();
    }
}

