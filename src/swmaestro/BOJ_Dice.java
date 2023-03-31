package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_Dice {
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        Point point = new Point(startX, startY);

        int K = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        Dice dice = new Dice(0,0,0,0,0,0);
        for (int i = 0; i < K; i++) {
            int direction = Integer.parseInt(st.nextToken());
            direction--;

            int nextX = point.x + dx[direction];
            int nextY = point.y + dy[direction];

            if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
                if (direction == 0) {
                    dice.East();
                } else if (direction == 1) {
                    dice.West();
                } else if (direction == 2) {
                    dice.North();
                }else{
                    dice.South();
                }

                if (board[nextY][nextX] == 0) {
                    board[nextY][nextX] = dice.ground;
                }else{
                    dice.ground = board[nextY][nextX];
                    board[nextY][nextX] = 0;
                }

                System.out.println(dice.ceil);

                point = new Point(nextX, nextY);
            }
        }


    }

    static class Dice {
        int ceil, ground, front, back, left, right;

        Dice(int ground, int ceil, int front, int back, int left, int right) {
            this.ceil = ceil;
            this.back = back;
            this.right = right;
            this.front = front;
            this.left = left;
            this.ground = ground;
        }

        void East() {
            int temp = this.ground;
            this.ground = this.right;
            this.right = this.ceil;
            this.ceil = this.left;
            this.left = temp;
        }

        void West() {
            int temp = this.ground;
            this.ground = this.left;
            this.left = ceil;
            this.ceil = this.right;
            this.right = temp;
        }

        void North() {
            int temp = this.ground;
            this.ground = this.back;
            this.back = this.ceil;
            this.ceil = this.front;
            this.front = temp;
        }

        void South() {
            int temp = this.ground;
            this.ground = this.front;
            this.front = this.ceil;
            this.ceil = this.back;
            this.back = temp;
        }
    }
}


