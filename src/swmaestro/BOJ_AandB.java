package swmaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class BOJ_AandB {
    static String S, T;
    static boolean isCan = false;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        S = bf.readLine();
        T = bf.readLine();

        char tempCharS[] = S.toCharArray();
        char tempCharT[] = T.toCharArray();

        run(T);

        if (isCan) {
            System.out.println(1);
        } else {
            System.out.println(0);

        }


    }

    static void run(String T) {
        if (T.length() == S.toCharArray().length) {
            if (T.equals(S)) {
                isCan = true;
            } else {
                isCan = false;
            }
            return;
        }

        if (T.charAt(T.length() - 1) == 'B') {
            run(ReverseAndPlusB(T));
        } else {
            run(PlusA(T));
        }
    }

    static String ReverseAndPlusB(String nowString) {
        String tempString = new String();

        for (int i = nowString.length() - 2; i >= 0; i--) {
            tempString += nowString.charAt(i);
        }

        return tempString;
    }

    static String PlusA(String nowString) {
        return nowString.substring(0, nowString.length() - 1);
    }
}
