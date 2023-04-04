package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Cheese {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> myQueue = new LinkedList<>();
    static Queue<Point> cheeseQueue = new LinkedList<>();

    static boolean[][] visited;
    static boolean isAirCheck;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
                    arr[i][j] = 2;
                }
            }
        }

        int time = 0;
        int lastCount = 0;
        int nowCount = 0;
        while (true) {
            boolean isFinished = false;
            nowCount = 0;
            time++;

            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1) {
                        isFinished = true;
                        cheeseQueue.add(new Point(j, i));
                        nowCount++;
                    } else if (arr[i][j] == 2) {
                        MakeAirZone(new Point(j, i));
                    }
                }
            }

            while (!cheeseQueue.isEmpty()) {
                Point nowPoint = cheeseQueue.poll();
                if (LookAround(nowPoint)) {
                    myQueue.add(nowPoint);
                }
            }

            while (!myQueue.isEmpty()) {
                Point nowPoint = myQueue.poll();
                arr[nowPoint.y][nowPoint.x] = 0;
            }


            if (!isFinished) {
                break;
            } else {
                lastCount = nowCount;
            }

//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("time = " + time);

        }

        System.out.println(time - 1);
        System.out.println(lastCount);
    }

    static boolean LookAround(Point nowPoint) {
        boolean isMelt = false;

        for (int i = 0; i < 4; i++) {
            int x = nowPoint.x + dx[i];
            int y = nowPoint.y + dy[i];

            if (arr[y][x] == 2) {
                isMelt = true;
                break;
            }
        }

        return isMelt;
    }

//    static void isAirChecked(Point nowPoint) {
//        if (isAirCheck) {
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int x = nowPoint.x + dx[i];
//            int y = nowPoint.y + dy[i];
//
//            if ((x == 0 || y == 0 || x > M - 1 || y > N - 1) || arr[y][x] == 2) {
//                isAirCheck = true;
//                return;
//            } else if (arr[y][x] == 0 && !visited[y][x]) {
//                visited[y][x] = true;
//                isAirChecked(new Point(x, y));
//                visited[y][x] = false;
//            }
//        }
//}

    static void MakeAirZone(Point nowPoint) {
        visited[nowPoint.y][nowPoint.x] = true;

        for (int i = 0; i < 4; i++) {
            int x = nowPoint.x + dx[i];
            int y = nowPoint.y + dy[i];

            if (x >= 0 && x < M && y >= 0 && y < N && !visited[y][x] && arr[y][x] == 0) {
                visited[y][x] = true;
                arr[y][x] = 2;
                MakeAirZone(new Point(x, y));
            }
        }
    }
}
