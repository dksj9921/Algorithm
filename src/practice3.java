import java.util.Scanner;

public class practice3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int dataSize, sumSize, sum = 0;
        dataSize = scanner.nextInt();
        sumSize = scanner.nextInt();

        int [] dataArray = new int[dataSize];
        int [] sumAarray = new int[dataSize];
        for(int i = 0; i<dataSize; i++){
            dataArray[i] = scanner.nextInt();
            sum += dataArray[i];
            sumAarray[i] = sum;
        }
        int [] intPutArray = new int[sumSize*2];
        for(int i = 0; i<sumSize*2-1; i++){
            intPutArray[i] = scanner.nextInt();
            if(i%2==1){
                System.out.println(sumAarray[intPutArray[i]]-sumAarray[intPutArray[i-1]]);
            }
        }



    }
}
