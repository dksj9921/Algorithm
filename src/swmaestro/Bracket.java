package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Bracket {
    static int result[];
    static ArrayList<Point> coupleArr;
    static char[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        arr = bf.readLine().toCharArray();

        Stack<Integer> stack = new Stack<Integer>();
        coupleArr = new ArrayList<>();


        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i] == ')') {
                coupleArr.add(new Point(stack.pop(), i));
                count++;
            }
        }

        for (int i = 1; i <= count; i++) {
            result = new int[i];
            Combination(0, 0, i);
        }
    }

    static void Combination(int depth, int start, int i) {
        if (depth == i) {
            boolean isPrint[] = new boolean[arr.length];

            for (int j = 0; j < result.length; j++) {
                isPrint[coupleArr.get(result[j]).x] = true;
                isPrint[coupleArr.get(result[j]).y] = true;
            }

            for (int j = 0; j < arr.length; j++) {
                if (!isPrint[j]) {
                    System.out.print(arr[j]);
                }
            }
            System.out.println("");

            return;
        }

        for (int j = start; j < coupleArr.size(); j++) {
            result[depth] = j;
            Combination(depth + 1, j + 1, i);
        }
    }
}
