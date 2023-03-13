package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.util.StringTokenizer;

public class BoardGame {
    static int N, M;
    static int board[][];
    static Point location;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean visited[][];
    static int answerCount = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String tempString = st.nextToken();
            char tempChar[] = tempString.toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = tempChar[j] - 48;
            }
        }

        location = new Point(0, 0);

        DFS(location, 0, visited);

        if (answerCount == -1) {
            System.out.println(answerCount);
        }else {
            System.out.println(answerCount + 1);
        }

    }


    static void DFS(Point nowLocation, int count, boolean visited[][]) {

        int nowX = nowLocation.x;
        int nowY = nowLocation.y;

        if (answerCount == -1) {
            return;
        }

        if (answerCount < count && answerCount != -1) {
            answerCount = count;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = nowX + (dx[i] * board[nowY][nowX]);
            int nextY = nowY + (dy[i] * board[nowY][nowX]);

            if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                if (board[nextY][nextX] != 24) {
                    if (!visited[nextY][nextX]) {
                        Point tempPoint = new Point(nextX, nextY);
                        visited[nextY][nextX] = true;
                        DFS(tempPoint, count + 1, visited);
                    }else{
                        answerCount = -1;
                    }
                }
            }
        }
    }
}
