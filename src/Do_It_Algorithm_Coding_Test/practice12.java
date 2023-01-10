package Do_It_Algorithm_Coding_Test;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.util.Stack;
import java.util.StringTokenizer;

public class practice12 {
    //오큰수 구하기
    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        int top = 0;
        int temp = 0;

        int arr[] = new int[N];
        int NGE[] = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                top = arr[i];
            } else if (arr[i] >= top) {
                while (!stack.isEmpty()) {
                    temp = stack.pop();
                    NGE[temp] = arr[i];
                    if (arr[temp] >= arr[i]) {
                        stack.push(temp);
                        break;
                    }
                }
                stack.push(i);
            } else if (arr[i] < top) {
                stack.push(i);
                top = arr[i];
            }
        }
        int temp2 = stack.size();
        for(int i = 0; i<temp2; i++){
            int temp3 = stack.pop();
            NGE[temp3] = -1;
        }
        for(int i = 0; i<NGE.length; i++){
            bw.write(NGE[i]+" ");
        }
        bf.close();
        bw.flush();
    }
}
