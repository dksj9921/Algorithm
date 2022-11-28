import java.util.Arrays;
import java.util.Scanner;

public class practice8 {
    //좋은 수 구하기
    public static void main(String Args[]){

        Scanner scanner = new Scanner(System.in);

        int arrNum = scanner.nextInt();

        int arr[] = new int[arrNum];

        for(int i = 0;i<arrNum;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        int targetNum = arrNum - 1;
        int endIndex = targetNum - 1, startIndex = 0, count = 0;

        while(true){
           if(targetNum == 1){

               System.out.println(count);
               break;
           }

           if(endIndex<startIndex) {
               targetNum --;
               startIndex = 0;
               endIndex =targetNum -1;
               continue;
           }
           if(arr[endIndex] + arr[startIndex] == arr[targetNum]){
               targetNum --;
               count ++;
               startIndex = 0;
               endIndex = targetNum-1;
           } else if (arr[endIndex] + arr[startIndex] > arr[targetNum]) {
               endIndex --;
           } else if (arr[startIndex] + arr[endIndex] < arr[targetNum]) {
               startIndex ++;
           }

        }

    }
}
