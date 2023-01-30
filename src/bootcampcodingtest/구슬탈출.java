package bootcampcodingtest;

import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구슬탈출 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Point R;
    static Point B;
    static boolean isRealFinishedR = false;
    static boolean isRealFinishedB = false;
    static char[][] arr;
    static Point target;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] temp = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp[j];
                if (arr[i][j] == 'R') {
                    R = new Point();
                    R.x = j;
                    R.y = i;
                    arr[i][j] = '.';
                }

                if (arr[i][j] == 'B') {
                    B = new Point();
                    B.x = j;
                    B.y = i;
                    arr[i][j] = '.';
                }

                if (arr[i][j] == 'O') {
                    target = new Point();
                    target.x = j;
                    target.y = i;
                }
            }
        }
        Point[] pointBox = new Point[2];
        pointBox[0] = R;
        pointBox[1] = B;
        int count = 0;
        Direction(pointBox, count, false, false);

        if (isRealFinishedR) {
            System.out.println("1");
        } else System.out.println("0");

    }

    private static void Direction(Point[] pointBox, int count, boolean isFinishedR, boolean isFinishedB) {
        count++;
        for (int i = 0; i < 4; i++) {
            Point[] box = Move(i, pointBox);

            if(isFinishedR && isFinishedB){
                continue;
            } else if(!isFinishedB && isFinishedR){
                isRealFinishedR = true;
                continue;
            } else if (isFinishedB) {
                continue;
            }

            Direction(box, count, isFinishedR, isFinishedB);
        }
    }

    private static Point[] Move(int direction, Point[] pointBox) {
        Point R = pointBox[0];
        Point B = pointBox[1];

        int directionX = dx[direction];
        int directionY = dy[direction];

        int i = 1;
        boolean isBreak = false;

        Point tempR;
        tempR = R;
        Point tempB;
        tempB = B;
        while (arr[tempR.y][tempR.x] != '#') {
            tempR.x += directionX;
            tempR.y += directionY;
            if (tempR.x == B.x && tempR.y == B.y) {
                isBreak = true;
            }

            if(tempR.x == target.x && tempR.y == target.y) {
                isRealFinishedR = true;
            }
        }

        tempR.x -= dx[direction];
        tempR.y -= dy[direction];

        if (isBreak) {
            tempR.x -= dx[direction];
            tempR.y -= dy[direction];
        }

        i = 1;

        isBreak = false;
        while (arr[tempB.y][tempB.x] != '#') {
            tempB.x += directionX;
            tempB.y += directionY;
            if (tempB.x == R.x && tempB.y == R.y) {
                isBreak = true;
            }

            if(tempB.x == target.x && tempB.y == target.y) {
                isRealFinishedB = true;
            }

            i++;
        }

        tempB.x -= dx[direction];
        tempB.y -= dy[direction];

        if (isBreak) {
            tempB.x -= dx[direction];
            tempB.y -= dy[direction];
        }

        pointBox[0] = tempR;
        pointBox[1] = tempB;

        return pointBox;
    }


}
