package swmaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class LaserTower {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int arr[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N + 1];

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = N; i > 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                answer[stack.pop()] = i;
            }
            stack.push(i);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
