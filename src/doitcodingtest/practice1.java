package doitcodingtest;

import java.util.Scanner;

public class practice1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String input;
        int sum=0,size=0;

        size = scanner.nextInt();
        input = scanner.next();
        char[] cNum = input.toCharArray();

        for(int i =0; i<cNum.length;i++){
            sum+=cNum[i]-'0';
        }

        System.out.println(sum);
    }
}
