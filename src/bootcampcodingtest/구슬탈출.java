package bootcampcodingtest;

import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구슬탈출 {
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static Point R;
    static Point B;
    static boolean isFinished = false;
    static char arr[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N + 2][M + 2];

        for (int i = 0; i < N + 2; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M + 2 ; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }


    }

    private static void Move(int arr[][], Point R, Point B, int count) {
        if(isFinished) return;

        for (int i = 0; i < 4; i++) {
            R.x = R.x + dx[i];
            R.y = R.y + dy[i];
            B.x = R.x + dx[i];
            B.y = B.y + dy[i];

            if (R.x != '#' && R.y != '#' && B.x != '#' && B.y != '#') {
                if(arr[R.x][R.y] == 'O'){
                    if (arr[B.x][B.y] == '0') {
                        return;
                    }
                    isFinished = true;
                    return;
                }
            }

        }

    }



}
