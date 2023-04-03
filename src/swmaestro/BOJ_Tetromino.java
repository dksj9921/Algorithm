package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Tetromino {
    static int[][] arr;
    static int N, M, answerSum;
    static boolean[][] visited;
    static boolean[][] resultVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
//                TDFSDirection(new Point(j, i), 0);
                visited[i][j] = true;
                DFS(j, i, 0, arr[i][j]);
                visited[i][j] = false;
            }
        }

        bf.close();

        System.out.println(answerSum);
    }

//    static void TDFSDirection(Point nowPoint, int sum) {
//
//        for (int i = 0; i < 4; i++) {
//            int x = nowPoint.x + dx[i];
//            int y = nowPoint.y + dy[i];
//
//            if (x >= 0 && x < M && y >= 0 && y < N) {
//                TDFS(new Point(x, y), 1, arr[nowPoint.y][nowPoint.x], i);
//            }
//        }
//    }

//    static void TDFS(Point nowPoint, int count, int sum, int direction) {
//        if (resultVisited[nowPoint.y][nowPoint.x]) {
//            return;
//        }
//
//        if (count == 3) {
//            if (answerSum < sum) {
//                answerSum = sum;
//            }
//            return;
//        }
//
//        int x = nowPoint.x + dx[direction];
//        int y = nowPoint.y + dy[direction];
//
//        if (count == 1) {
//            int tempX = 0;
//            int tempY = 0;
//            if (dx[direction] == 0) {
//                for (int i = 0; i < 2; i++) {
//                    tempX = nowPoint.x + dx[i];
//                    tempY = nowPoint.y + dy[i];
//
//                    if (tempX >= 0 && tempX < M && tempY >= 0 && tempY < N) {
//                        sum += arr[tempY][tempX] + arr[nowPoint.y][nowPoint.x];
//                        count++;
//
//                        if (x >= 0 && x < M && y >= 0 && y < N) {
//                            TDFS(new Point(x, y), count + 1, sum + arr[y][x], direction);
//                        }
//                    }
//                }
//            }else{
//                for (int i = 2; i < 4; i++) {
//                    tempX = nowPoint.x + dx[i];
//                    tempY = nowPoint.y + dy[i];
//
//                    if (tempX >= 0 && tempX < M && tempY >= 0 && tempY < N) {
//                        sum += arr[tempY][tempX] + arr[nowPoint.y][nowPoint.x];
//                        count++;
//
//                        if (x >= 0 && x < M && y >= 0 && y < N) {
//                            TDFS(new Point(x, y), count + 1, sum + arr[y][x], direction);
//                        }
//                    }
//                }
//            }
//        }else{
//            if (x >= 0 && x < M && y >= 0 && y < N) {
//                TDFS(new Point(x, y), count + 1, sum + arr[y][x], direction);
//            }
//        }
//
//    }
    static void DFS(int nowX, int nowY, int count, int sum) {

        visited[nowY][nowX] = true;

        if (count == 3) {
            if (answerSum < sum) {
                answerSum = sum;
            }
            return;
        }

        for (int k = 0; k < 4; k++) {
            int x = nowX + dx[k];
            int y = nowY + dy[k];

            if (x >= 0 && x < M && y >= 0 && y < N && !visited[y][x]) {
                if (count == 1) {
                    visited[y][x] = true;
                    DFS(nowX, nowY, count + 1, sum + arr[y][x]);
                    visited[y][x] = false;
                }
                visited[y][x] = true;
                DFS(x, y, count + 1, sum + arr[y][x]);
                visited[y][x] = false;
            }
        }
    }
}
