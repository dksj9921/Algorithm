package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BOJ_OntheBeltRobot {
    static int N, K;
    static Node arr[];
    static int upLocation, downLocation, beltSize;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        beltSize = 2 * N;
        arr = new Node[beltSize];

        for (int i = 0; i < beltSize; i++) {
            arr[i] = new Node(Integer.parseInt(st.nextToken()), false);
        }

        upLocation = 0;
        downLocation = N - 1;


        int answerCount = 0;
        int robotCount = 0;
        while (true) {
            answerCount++;

            Node tempNode = arr[beltSize - 1];
            for (int i = beltSize - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = tempNode;

            if (arr[downLocation].isRobot) {
                arr[downLocation].isRobot = false;
                arr[downLocation].upTime = 0;
            }

            PriorityQueue<Integer> upQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (arr[o1].upTime > arr[o2].upTime) {
                        return 1;
                    }else return -1;
                }
            });

            for (int i = 0; i < beltSize; i++) {
                if (arr[i].isRobot) {
                    upQueue.add(i);
                }
            }

            while (!upQueue.isEmpty()) {
                int temp = upQueue.poll();
                int tempNext = temp + 1;
                if (tempNext == beltSize) {
                    tempNext = 0;
                }

                if (!arr[tempNext].isRobot && arr[tempNext].leftDurability > 0) {
                    arr[tempNext].isRobot = true;
                    arr[tempNext].upTime = arr[temp].upTime;
                    arr[tempNext].leftDurability--;
                    arr[temp].isRobot = false;
                    arr[temp].upTime = 0;
                }
            }

            if (arr[downLocation].isRobot) {
                arr[downLocation].isRobot = false;
                arr[downLocation].upTime = 0;
            }

            if (arr[upLocation].leftDurability > 0) {
                arr[upLocation].leftDurability--;
                arr[upLocation].upTime = ++robotCount;
                arr[upLocation].isRobot = true;
            }

            int count = 0;
            for (int i = 0; i < beltSize; i++) {
                if (arr[i].leftDurability < 1) {
                    count++;
                }
            }
            if (count >= K) {
                break;
            }

        }
        System.out.println(answerCount);
    }

    static class Node implements Comparable<Node> {
        int leftDurability;
        boolean isRobot;
        int upTime;

        Node(int leftDurability, boolean isRobot) {
            this.leftDurability = leftDurability;
            this.isRobot = isRobot;
        }

        @Override
        public int compareTo(Node input) {
            if (this.upTime > input.upTime) {
                return -1;
            } else return 1;
        }
    }


}
