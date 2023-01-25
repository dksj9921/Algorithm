package doitcodingtest;

import java.util.Scanner;

public class practice3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int dataNum = 0;
        int askNum = 0;
        int tempSum = 0;
        int[] dataList;
        int[][] askList;
        int[] sumList;

        dataNum = scanner.nextInt();
        askNum = scanner.nextInt();

        dataList = new int[dataNum];
        sumList = new int[dataNum+1];
        askList = new int[askNum][2];

        for (int i =0; i<dataList.length; i++){
            dataList[i] = scanner.nextInt();
            tempSum += dataList[i];
            sumList[i+1] = tempSum;
        }

        for (int i = 0; i<askNum; i++){
            askList[i][0] = scanner.nextInt()-1;
            askList[i][1] = scanner.nextInt();
        }



        for (int i =0; i<askNum; i++){
            int first = askList[i][0];
            int second = askList[i][1];

            System.out.println(sumList[second]-sumList[first]);
        }










    }
}
