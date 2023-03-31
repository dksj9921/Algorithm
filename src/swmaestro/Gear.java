package swmaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gear {
    static int arr[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[4][8];

        for (int i = 0; i < 4; i++) {
            char[] tempChar = bf.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = tempChar[j] - 48;
            }
        }

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int target = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            target--;

            ArrayList<Integer> tempArr[] = new ArrayList[4];
            Queue<Node> myQueue = new LinkedList<>();
            boolean visited[] = new boolean[4];

            myQueue.add(new Node(target, direction));

            for (int j = 0; j < 4; j++) {
                tempArr[j] = new ArrayList<Integer>();
            }

            if (arr[0][2] != arr[1][6]) {
                tempArr[0].add(1);
                tempArr[1].add(0);
            }

            if (arr[1][2] != arr[2][6]) {
                tempArr[1].add(2);
                tempArr[2].add(1);
            }

            if (arr[2][2] != arr[3][6]) {
                tempArr[2].add(3);
                tempArr[3].add(2);
            }

            while (!myQueue.isEmpty()) {
                Node nowNode = myQueue.poll();
                int nowTarget = nowNode.target;
                int nowDirection = nowNode.direction;
                visited[nowTarget] = true;

                if (nowDirection == -1) {
                    leftShift(nowTarget);
                }else{
                    rightShift(nowTarget);
                }

                for (int nextTarget : tempArr[nowTarget]) {
                    if (!visited[nextTarget]) {
                        myQueue.add(new Node(nextTarget, -nowDirection));
                        visited[nextTarget] = true;
                    }
                }
            }
        }

        int answer = 0;
        int temp = 1;

        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                answer += temp;
            }
            temp *= 2;
        }


        System.out.println(answer);
    }

    static void rightShift(int target) {
        int tempLast = arr[target][7];
        for (int i = 7; i > 0; i--) {
            arr[target][i] = arr[target][i - 1];
        }
        arr[target][0] = tempLast;
    }

    static void leftShift(int target) {
        int tempFirst = arr[target][0];
        for (int i = 0; i < 7; i++) {
            arr[target][i] = arr[target][i + 1];
        }
        arr[target][7] = tempFirst;
    }

    static class Node {
        int target, direction;

        Node(int target, int direction) {
            this.target = target;
            this.direction = direction;
        }
    }
}
