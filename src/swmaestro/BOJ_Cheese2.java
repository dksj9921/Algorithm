package swmaestro;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_Cheese2 {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            if (i != 0) {
                st = new StringTokenizer(bf.readLine());
            }
            for (int j = 0; j <= M; j++) {
                if (i == 0 || i == N || j == 0 || j == M) {
                    map[i][j] = 2;
                    continue;
                }
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answerCount = 0;
        while (true) {
            answerCount++;
            Queue<Point> cheeseQueue = new LinkedList<>();

            visited = new boolean[N + 1][M + 1];
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= M; j++) {
                    if (map[i][j] == 2 && !visited[i][j]) {
                        MakeAir(new Point(j, i));
                    }

                    if (map[i][j] == 1) {
                        cheeseQueue.add(new Point(j, i));
                    }
                }
            }
            if (cheeseQueue.isEmpty()) {
                break;
            }

//            for (int i = 0; i <= N; i++) {
//                for (int j = 0; j <= M; j++) {
//                    if (map[i][j] == 2) {
//                        System.out.print("2 ");
//                    }else {
//                        System.out.print(map[i][j] + " ");
//                    }
//                }
//                System.out.println();
//            }
//            System.out.println("time = " + answerCount);

            while (!cheeseQueue.isEmpty()) {
                Point nowPoint = cheeseQueue.poll();

                if (isMelt(nowPoint)) {
                    map[nowPoint.y][nowPoint.x] = 0;
                }
            }
        }

        System.out.println(answerCount - 1);
    }

    static void MakeAir(Point nowPoint) {
        for (int i = 0; i < 4; i++) {
            int x = nowPoint.x + dx[i];
            int y = nowPoint.y + dy[i];

            if (x >= 0 && x <= M && y >= 0 && y <= N && !visited[y][x] && map[y][x] == 0) {
                map[y][x] = 2;
                visited[y][x] = true;
                MakeAir(new Point(x, y));
            }
        }
    }

    static boolean isMelt(Point nowPoint) {
        boolean isMelt = false;
        boolean isFirst = false;

        for (int i = 0; i < 4; i++) {
            int x = nowPoint.x + dx[i];
            int y = nowPoint.y + dy[i];

            if (x >= 0 && x <= M && y >= 0 && y <= N) {
                if (map[y][x] == 2 && !isFirst) {
                    isFirst = true;
                } else if (map[y][x] == 2 && isFirst) {
                    isMelt = true;
                    break;
                }
            }
        }
        return isMelt;
    }
}
