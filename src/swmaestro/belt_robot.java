package swmaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class belt_robot {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Node arr[] = new Node[2 * N];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Node(Integer.parseInt(st.nextToken()));
        }

        int firstRobotLocation = 0;
        int leftCount = 0;
        int count = 0;
        boolean isFirst = false;
        while (true) {
            int tempInt = 0;
            boolean tempRobot = false;
            if(isFirst){
                firstRobotLocation++;
                if(firstRobotLocation == arr.length){
                    firstRobotLocation -= arr.length;
                }//첫번째 로봇 위치 변경
            }
            if (arr[N].isRobot) {
                arr[N].isRobot = false;
            }

            for (int i = arr.length - 1; i > 0; i--) {//컨베이어벨트 이동

                if (i == arr.length - 1) {
                    tempInt = arr[0].left;
                    tempRobot = arr[0].isRobot;
                    arr[0].left = arr[arr.length - 1].left;
                    arr[0].isRobot = arr[arr.length - 1].isRobot;
                }

                if (i == 1) {
                    arr[i].isRobot = tempRobot;
                    arr[i].left = tempInt;
                } else {
                    arr[i].isRobot = arr[i - 1].isRobot;
                    arr[i].left = arr[i - 1].left;
                }

            }

            if (arr[N].isRobot) {
                arr[N].isRobot = false;
            }

            for (int i = 0; i < arr.length; i++) {//로봇 한칸씩 앞으로 이동
                int nowLocation = firstRobotLocation + i; //첫번째 로봇부터
                if (nowLocation > arr.length - 1) {
                    nowLocation -= arr.length;
                }
                int nextLocation = nowLocation + 1;
                if (arr[nowLocation].isRobot) {
                    if (nextLocation >= arr.length) {
                        nextLocation -= arr.length;
                    }

                    if (!arr[nextLocation].isRobot && arr[nextLocation].left != 0) {
                        if (nowLocation == firstRobotLocation) {
                            firstRobotLocation++;
                            if(firstRobotLocation == arr.length){
                                firstRobotLocation -= arr.length;
                            }
                        }
                        arr[nextLocation].isRobot = arr[nowLocation].isRobot;
                        arr[nextLocation].left--;
                        arr[nowLocation].isRobot = false;
                        if (arr[nextLocation].left == 0) {
                            leftCount++;
                        }
                    }
                }
                if (nextLocation == N && arr[nextLocation].isRobot) {
                    arr[nextLocation].isRobot = false;
                }
            }

            if (arr[0].left != 0 && !arr[0].isRobot) {
                arr[0].left--;
                arr[0].isRobot = true;
                if (arr[0].left == 0) {
                    leftCount++;
                }
                if (!isFirst) {
                    firstRobotLocation = count;
                    isFirst = true;
                }
            }

            if (leftCount >= k) {
                break;
            }
            count++;

            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%7d", arr[i].left);
            }
            System.out.println();
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%7b", arr[i].isRobot);
            }
            System.out.println("");
        }

        System.out.println(count + 1);
    }

    static class Node {
        int left;
        boolean isRobot;

        public Node(int left) {
            this.left = left;
        }
    }
}
