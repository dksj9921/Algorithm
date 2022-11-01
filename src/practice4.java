import java.util.Scanner;

public class practice4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int arrSize = 0, askSize = 0, sumRow = 0, sumCol = 0;

        arrSize = scanner.nextInt();
        askSize = scanner.nextInt();

        int[][] arr = new int[arrSize][arrSize];
        int[][] ask = new int[askSize][4];
        int[][] arrSum = new int[arrSize+1][arrSize+1];

        for(int i = 0; i<arrSize; i++){
            for(int j = 0; j<arrSize; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i<askSize; i++){
            for(int j = 0; j<4; j++){
                ask[i][j] = scanner.nextInt();
            }
        }

        for(int i = 1; i<arrSize+1; i++){
            for(int j =1; j<arrSize+1; j++){
                arrSum[i][j] = arrSum[i-1][j] + arrSum[i][j-1] - arrSum[i-1][j-1] + arr[i-1][j-1];
            }
        }

        for(int i = 0; i<askSize; i++){
            int first = ask[i][0];
            int second = ask[i][1];
            int third = ask[i][2];
            int forth = ask[i][3];

            System.out.println(arrSum[third][forth] - arrSum[third][second-1] - arrSum[first-1][forth] + arrSum[first-1][second-1]);
        }
    }
}
