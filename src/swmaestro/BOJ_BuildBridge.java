package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.Queue;

public class BOJ_BuildBridge {
    static int N = 0, count = 2;
    static int arr[][];
    static boolean visited[][];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int shortestBridge = Integer.MAX_VALUE;
    static int arr2[][];
    static boolean mainVisited[][];
    static int[][] tempArr;
    static boolean isFinished = false;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    arr[i][j] = count;
                    Union(new Point(j, i));
                    count++;
                }
            }
        }

        visited = new boolean[N][N];
        mainVisited = new boolean[N][N];
        tempArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) {
                    tempArr[i][j] = arr[i][j];
                    for (int k = 0; k < 4; k++) {
                        int x = j + dx[k];
                        int y = i + dy[k];

                        if (x >= 0 && x < N && y >= 0 && y < N && arr[y][x] == 0) {
                            mainVisited[y][x] = true;
                            arr2 = new int[N][N];
                            visited = new boolean[N][N];
                            isFinished = false;
                            int temp = MakeBridge(new Point(x, y), arr[i][j]);
                            if (isFinished) {
                                if (tempArr[y][x] != 0 && tempArr[y][x] > temp) {
                                    tempArr[y][x] = temp;
                                } else if (tempArr[y][x] == 0) {
                                    tempArr[y][x] = temp;
                                }
                                if (temp < shortestBridge) {
                                    shortestBridge = temp;
                                }
                            }
                        }
                    }
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(tempArr[i][j]+ " ");
//            }
//            System.out.println();
//        };

        System.out.println(shortestBridge);
    }

    static void Union(Point nowPoint) {
        for (int i = 0; i < 4; i++) {
            int x = nowPoint.x + dx[i];
            int y = nowPoint.y + dy[i];

            if (x >= 0 && x < N && y >= 0 && y < N && !visited[y][x]) {
                if (arr[y][x] == 1) {
                    arr[y][x] = count;
                    visited[y][x] = true;
                    Union(new Point(x, y));
                }
            }
        }
    }

    static int MakeBridge(Point nowPoint, int islandNumber) {

        Queue<Point> myQueue = new ArrayDeque<>();
        visited[nowPoint.y][nowPoint.x] = true;

        myQueue.add(nowPoint);

        while (!myQueue.isEmpty()) {
            Point tempPoint = myQueue.poll();
            for (int i = 0; i < 4; i++) {
                int x = tempPoint.x + dx[i];
                int y = tempPoint.y + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < N && !visited[y][x]) {
                    if (arr[y][x] == 0) {
                        visited[y][x] = true;
                        arr2[y][x] = arr2[tempPoint.y][tempPoint.x] + 1;
                        myQueue.add(new Point(x, y));
                    } else if (arr[y][x] != islandNumber) {
                        isFinished = true;
                        return arr2[tempPoint.y][tempPoint.x] + 1;
                    }
                }
            }
        }

        return 0;
    }
}
