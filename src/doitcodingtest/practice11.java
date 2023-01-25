package doitcodingtest;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class practice11 {

    public static void main(String Args[]) throws NumberFormatException, IOException {

        Scanner scanner = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer();


        int N = scanner.nextInt();


        Stack<Integer> stack = new Stack<>();
        int numArr[] = new int[N];
        int num = 1;
        boolean check = false;


        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = scanner.nextInt();
        }

        for (int i = 0; i < numArr.length; i++) {
            int su = numArr[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    stringBuffer.append("+\n");
                }
                stack.pop();
                stringBuffer.append("-\n");
            } else {
                int temp = stack.pop();
                if (temp > su) {
                    System.out.println("NO");
                    check = true;
                    break;
                } else stringBuffer.append("-\n");
            }
        }
        if (!check) System.out.println(stringBuffer);
    }
}
