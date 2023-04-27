package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_RainWater {
    static int N, M;
    static int map[][];
    static boolean visited[][];
    static int answerSum = 0, tempSum = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < temp; j++) {
                map[N - 1 - j][i] = 1;
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        boolean isWall = false;
        for (int i = 0; i < N; i++) {
            isWall = false;
            for (int j = 0; j < M - 1; j++) {
                if (map[i][j] == 1 && !isWall) {
                    isWall = true;
                } else if (map[i][j] == 0 && isWall && !visited[i][j]) {
                    answerSum += FindWall(new Point(j, i));
                    isWall = false;
                }
            }
        }
        System.out.println(answerSum);
    }

    static int FindWall(Point nowPoint) {
        int x = nowPoint.x;
        int y = nowPoint.y;
        int tempSum = 0;
        visited[y][x] = true;

        while (true) {
            x += 1;
            if (x < M - 1) {
                visited[y][x] = true;
                if (map[y][x] == 1) {
                    tempSum++;
                    break;
                } else {
                    tempSum++;
                }
            } else if (x == M - 1) {
                if (map[y][x] == 0) {
                    tempSum = 0;
                    break;
                } else {
                    tempSum++;
                    break;
                }
            }
        }

        return tempSum;
    }
}
