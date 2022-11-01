import java.util.Scanner;

public class practice5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int sum = 0, count = 0;
        int arrSize = scanner.nextInt();
        int target = scanner.nextInt();
        int arr[] = new int[arrSize];
        int sumArr[] = new int[arrSize];
        int tempCountArr[] = new int [target];

        for(int i = 0; i<arrSize; i++){
            arr[i] = scanner.nextInt();
            sum += arr[i];
            sumArr[i] = sum%target;
            if(sumArr[i]==0){
                count ++;
            }
        }

        for(int i = 0; i<target; i++){
            int tempCount = 0;
            int temp=0, temp2=1;
            for(int j = 0; j<arrSize; j++){
                if(sumArr[j]==i){
                    tempCount++;
                }
            }
            if(tempCount>1){
                for(int k=1; k<=tempCount; k++){
                    temp2 *= k;
                }
                count = count+(temp2/2);
            }
        }
        System.out.println(count);
    }
}
