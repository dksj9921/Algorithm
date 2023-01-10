package Do_It_Algorithm_Coding_Test;

import java.util.Scanner;

public class practice5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        long sum = 0, count = 0;
        int arrSize = scanner.nextInt();
        int target = scanner.nextInt();
        long arr[] = new long[arrSize];
        long sumArr[] = new long[arrSize];

        for(int i = 0; i<arrSize; i++){
            arr[i] = scanner.nextInt();
            sum += arr[i];
            sumArr[i] = sum%target;
            if(sumArr[i]==0){
                count ++;
            }
        }

        for(int i = 0; i<target; i++){
            long tempCount = 0;
            for(int j = 0; j<arrSize; j++){
                if(sumArr[j]==i){
                    tempCount++;
                }
            }
            if(tempCount>1){
                count = count+((tempCount*(tempCount-1))/2);
            }
        }
        System.out.println(count);
    }
}
