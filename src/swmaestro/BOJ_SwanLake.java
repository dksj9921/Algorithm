package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

public class BOJ_SwanLake {
    static int N, M;
    static char lake[][];
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};
    static Point first, second;
    static boolean iceVisited[][];
    static boolean isFinished = false;
    static Deque<Node> nextMeltQueue = new LinkedList<Node>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lake = new char[N][M];

        boolean isFirst = false;
        for (int i = 0; i < N; i++) {
            char temp[] = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                lake[i][j] = temp[j];
                if (temp[j] == 'L' && !isFirst) {
                    first = new Point(j, i);
                    lake[i][j] = '1';
                    isFirst = true;
                } else if (temp[j] == 'L' && isFirst) {
                    second = new Point(j, i);
                    lake[i][j] = '2';
                }
            }
        }

        iceVisited = new boolean[N][M];
        MakeIsland(first, '1');
        MakeIsland(second, '2');
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lake[i][j] == '.') {
                    MakeIsland(new Point(j, i), '.');
                }
            }
        }


//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(lake[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(" ");

        if (isFinished) {
            System.out.println(0);
            System.exit(0);
        }

        int count = 0;

        while (true) {
            count++;

            int tempSize = nextMeltQueue.size();
            for (int i = 0; i < tempSize; i++) {
                Node nowNode = nextMeltQueue.poll();
                Point nowPoint = nowNode.nodePoint;

                lake[nowPoint.y][nowPoint.x] = nowNode.nodeChar;

                MakeNextMelt(nowPoint, nowNode.nodeChar);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(lake[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(" ");

            if (isFinished) {
                break;
            }

        }

        System.out.println(count);
    }


    static void MakeIsland(Point nowPoint, char count) {
        boolean[][] visited = new boolean[N][M];
        Queue<Point> myQueue = new LinkedList<>();
        visited[nowPoint.y][nowPoint.x] = true;
        myQueue.add(nowPoint);
        lake[nowPoint.y][nowPoint.x] = count;

        while (!myQueue.isEmpty()) {
            if (isFinished) {
                break;
            }
            Point now = myQueue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if (x >= 0 && x < M && y >= 0 && y < N && !visited[y][x]) {
                    if ((count == '1' && lake[y][x] == '2') || (count == '2' && lake[y][x] == '1')) {
                        isFinished = true;
                        break;
                    }
                    if (lake[y][x] != 'X') {
                        visited[y][x] = true;
                        lake[y][x] = count;
                        myQueue.add(new Point(x, y));
                    } else if (!iceVisited[y][x]) {
                        iceVisited[y][x] = true;
                        nextMeltQueue.add(new Node(count, new Point(x, y)));
                    }
                }
            }
        }
    }

    static void MakeNextMelt(Point nowPoint, char count) {
        for (int i = 0; i < 4; i++) {
            int x = nowPoint.x + dx[i];
            int y = nowPoint.y + dy[i];

            if (x >= 0 && x < M && y >= 0 && y < N) {
                if (!iceVisited[y][x] && lake[y][x] == 'X') {
                    if (count != '.') {
                        iceVisited[y][x] = true;
                    }
                    nextMeltQueue.add(new Node(count, new Point(x, y)));
                } else if (lake[y][x] == '.' && count != '.') {
                    MakeIsland(new Point(x, y), count);
                } else if (lake[y][x] != '.' && lake[y][x] != 'X' && count == '.') {
                    MakeIsland(new Point(x,y), lake[y][x]);
                } else if (lake[y][x] != '.' && lake[y][x] != 'X' && lake[y][x] != count && count != '.') {
                    isFinished = true;
                    return;
                }
            }
        }
    }

    static class Node {
        char nodeChar;
        Point nodePoint;

        Node(char nodeChar, Point now) {
            this.nodeChar = nodeChar;
            this.nodePoint = now;
        }

        char getNodeChar() {
            return this.nodeChar;
        }
    }


}
