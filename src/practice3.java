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



    }
}
