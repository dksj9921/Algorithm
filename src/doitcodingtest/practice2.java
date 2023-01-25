package doitcodingtest;

import java.util.Scanner;

public class practice2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int scoreSize = scanner.nextInt();
        float [] score = new float[scoreSize];
        float Max=0;

        for(int i=0; i<score.length; i++){
            score[i] = scanner.nextInt();
            if(score[i]>Max) Max = score[i];
        }

        float sum =0;
        float average;
        for(int i =0; i<score.length; i++){
            score[i]=score[i]/Max*100;
            sum += score[i];
        }
        average = sum/scoreSize;

        System.out.println(average);
        //위에서 score 배열 차체의 값을 바꾸는 것이 아닌 print 할 때 만 바꿔줘도 됨. 그러면 전부 int로 해결 가능.



    }
}
