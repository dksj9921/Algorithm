import java.util.Scanner;

import static java.lang.Boolean.TRUE;

public class practice6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        int startIndex = 1, endIndex = 1, sum = 1, count = 1;

        while (endIndex != input) {
            if (sum < input) {
                endIndex++;
                sum += endIndex;
            }
            if (sum > input) {
                sum -= startIndex;
                startIndex++;
            }
            if (sum == input) {
                endIndex ++;
                sum += endIndex;
                count++;
            }

        }

        System.out.println(count);


    }
}
