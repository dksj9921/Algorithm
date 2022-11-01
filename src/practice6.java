import java.util.Scanner;

import static java.lang.Boolean.TRUE;

public class practice6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int size = 10000000;
        int arr[] = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = i+1;
        }

        int input = scanner.nextInt();

        int startIndex = 1, endIndex = 1, sum = 0, count=0;

        while(0 == 0){
            sum = 0;
            for(int i = startIndex ; i <= endIndex; i ++){
                sum += arr[i-1];
            }
            if(sum < input){
                endIndex++;
            }
            if(sum > input){
                startIndex++;
            }
            if(sum == input){
                startIndex++;
                count ++;
                endIndex = startIndex;
            }
            if(startIndex==input) {
                count ++;
                break;
            }
        }

        System.out.println(count);



    }
}
