package doitcodingtest;

import java.util.*;

public class practice7 {
    //주몽의 명령
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        int ingredientsNum = scanner.nextInt();
        int sumNum = scanner.nextInt();

        int ingredients [] = new int[ingredientsNum];

        for(int i = 0; i < ingredientsNum; i++){
            ingredients[i] = scanner.nextInt();
        }

        Arrays.sort(ingredients);

        int startIndex = 0, endIndex = ingredientsNum-1, count = 0;

        while(true){

            if(startIndex >= endIndex) {
                System.out.println(count);
                break;
            }
            if(ingredients[startIndex]+ingredients[endIndex] == sumNum){
                count ++;
                startIndex ++;
                endIndex --;
            } else if (ingredients[startIndex]+ingredients[endIndex] > sumNum) {
                endIndex --;
            } else if (ingredients[startIndex]+ingredients[endIndex] < sumNum){
                startIndex ++;
            }
        }
    }
}
