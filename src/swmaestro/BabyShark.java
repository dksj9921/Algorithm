package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Queue;

public class BabyShark {
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int N, sharkSize, eatFish, nowTime;
    static Point startPoint;
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        arr = new int[N][N];

        StringTokenizer st;

        sharkSize = 2;
        eatFish = 0;
        nowTime = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    startPoint = new Point(j, i);
                    arr[i][j] = 0;
                }

            }
        }

        while (true) {
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("nowTime = " + nowTime + "  sharkSize = " + sharkSize);
//            System.out.println(" ");
            int temp = BFS(startPoint);
            if (temp != -1) {
                nowTime = temp;
            }else{
                break;
            }
        }

        System.out.println(nowTime);
    }

    static int BFS(Point point) {

        Point sharkLocation;
        Queue<Point> queue = new LinkedList<>();

        queue.add(point);

        PriorityQueue<Node> tempSave = new PriorityQueue<>();

        boolean[][] visited = new boolean[N][N];
        int[][] tempArr = new int[N][N];
        tempArr[point.y][point.x] = nowTime;
        visited[point.y][point.x] = true;
        int temp = -1;
        boolean isFinished = false;

        while (!queue.isEmpty()) {
            sharkLocation = queue.poll();

            if (temp != -1 && temp != tempArr[sharkLocation.y][sharkLocation.x]) {
                isFinished = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = sharkLocation.x + dx[i];
                int y = sharkLocation.y + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < N && !visited[y][x] && arr[y][x] <= sharkSize) {
                    tempArr[y][x] = tempArr[sharkLocation.y][sharkLocation.x] + 1;
                    visited[y][x] = true;
                    queue.add(new Point(x, y));
                    if (arr[y][x] != 0 && arr[y][x] < sharkSize) {
                        tempSave.add(new Node(x, y));
                        temp = tempArr[sharkLocation.y][sharkLocation.x];
                    }
                }
            }
        }

        if (isFinished || temp != -1) {
            eatFish++;
            if (eatFish == sharkSize) {
                eatFish = 0;
                sharkSize++;
            }
            Node tempNode = tempSave.poll();
            startPoint.x = tempNode.x;
            startPoint.y = tempNode.y;
            arr[startPoint.y][startPoint.x] = 0;
            return tempArr[startPoint.y][startPoint.x];
        }
        return -1;
    }

    static class Node implements Comparable<Node> {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node input) {
            if (this.y > input.y) {
                return 1;
            } else if (this.y == input.y) {
                if (this.x > input.x) {
                    return 1;
                }
            }
            return -1;
        }
    }


}
