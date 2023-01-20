package Boot_Camp_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인사고과 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Solution Solution = new Solution();
        System.out.println(Solution.solution(arr));
    }

    static class Solution {
        public int solution(int[][] scores) {
            int answer = 0;
            PriorityQueue<Node> myQueue = new PriorityQueue<>();
            List<Node> arr = new ArrayList<>();


            for (int i = 0; i < scores.length; i++) {
                int tempA = scores[i][0];
                int tempB = scores[i][1];

                arr.add(new Node(i, tempA, tempB, tempA + tempB));
            }

            Collections.sort(arr, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.big > o2.big) return -1;
                    else if (o1.big == o2.big) {
                        return o1.small > o2.small ? 1 : -1;
                    } else return 1;
                }
            });

            int Max_small = arr.get(0).small;
            int Max_big = arr.get(0).big;
            for (int i = 0; i < arr.size(); i++) {
                int temp = arr.get(i).small;
                if (temp < Max_small) {
                    arr.get(i).changeNo();
                } else {
                    Max_small = temp;
                }
                if (!arr.get(i).isNo) myQueue.add(arr.get(i));
            }
//
//            while (!myQueue.isEmpty()) {
//                System.out.println(myQueue.poll().sum);
//            }


            int count = 1;
            int tempSize = myQueue.size();
            int tempSum = myQueue.peek().sum;
            int tempArr[] = new int[arr.size()];

            for (int i = 0; i < tempSize; i++) {
                Node now = myQueue.poll();
                if (now.sum == tempSum) {
                    tempArr[now.index] = count;
                } else {
                    tempArr[now.index] = i + 1;
                    tempSum = now.sum;
                    count = i + 1;
                }
            }

            if (tempArr[0] == 0) {
                answer = -1;
            } else answer = tempArr[0];

            return answer;
        }

        class Node implements Comparable<Node> {
            int index, big, small;
            boolean isNo = false;
            int sum;

            public Node(int index, int big, int small, int sum) {
                this.index = index;
                this.big = big;
                this.small = small;
                this.sum = sum;
            }

            public void changeNo() {
                this.isNo = true;
            }

            @Override
            public int compareTo(Node input) {
                return this.sum < input.sum ? 1 : -1;
            }
        }
    }
}
