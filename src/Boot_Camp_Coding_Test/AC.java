package Boot_Camp_Coding_Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AC {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int N = Integer.parseInt(bf.readLine());

        for (int repeat = 0; repeat < N; repeat++) {
            sb = new StringBuilder();
            Deque<Integer> myQueue = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());

            char charArr[] = st.nextToken().toCharArray();

            st = new StringTokenizer(bf.readLine());
            int arr = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine(), "[ , ]");

            for (int i = 0; i < arr; i++) {
                myQueue.add(Integer.parseInt(st.nextToken()));
            }

            boolean isCheck = false;
            int reverseCheck = 1;
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] == 'R') {
                    reverseCheck *= -1;
                    if ((i == charArr.length - 1) && (arr == 0)) {
                        sb.append("[]");
                        System.out.println(sb);
                        isCheck = true;
                        break;
                    }
                } else {
                    Integer temp = 0;
                    if (reverseCheck == 1) {
                        temp = myQueue.pollFirst();
                    } else {
                        temp = myQueue.pollLast();
                    }

                    if (temp == null) {
                        isCheck = true;
                        sb.append("error");
                        System.out.println(sb);
                        break;
                    }
                }
            }

            if (myQueue.isEmpty() && !isCheck) {
                sb.append("[]");
                isCheck = true;
                System.out.println(sb);
            }

            if (reverseCheck == -1) {
                myQueue = Reverse(myQueue);
            }

            if (myQueue.size() == 1) {
                int temp = myQueue.poll();
                sb.append("[" + temp + "]");
                System.out.println(sb);
                isCheck = true;
            }

            if(isCheck) continue;
            else {
                int count = 0;
                int size = myQueue.size();
                while (!myQueue.isEmpty()) {
                    int temp = myQueue.poll();
                    if(count == 0){
                        sb.append("[" +temp+",");
                    } else if (count == size-1) {
                        sb.append(temp + "]");
                    } else {
                        sb.append(temp + ",");
                    }
                    count++;
                }

            }

            System.out.println(sb);
        }
        bf.close();
    }

    static public Deque Reverse(Deque myQueue) {
        Stack<Integer> tempStack = new Stack<>();
        while (!myQueue.isEmpty()) {
            tempStack.add((int) myQueue.poll());
        }

        while (!tempStack.isEmpty()) {
            myQueue.add(tempStack.pop());
        }

        return myQueue;
    }
}
