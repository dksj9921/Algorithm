package swmaestro;
//벽을 세워두고 한다? 조합으로 골라서?
//그렇다면 일단 모든 조합을 검사하는것을 4만번 해야함.
//하나하나 도는데 얼마나 걸릴지도 모르긴 함
//그리고 조합으로 표현하는데에 1 - 64까지가 아닌 x,y의 값으로 나타내야함
//그렇다면 x값 하나 y값 하나를 찾아서 한다?

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Laboratory {
    static int arr[][];
    static int tempArr[][];
    static ArrayList<Point> empty = new ArrayList<Point>();
    static Point wall[] = new Point[3];
    static boolean[] visited;
    static int N, M;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int answerCount = 0;
    static int print[][];


    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        tempArr = new int[N][M];
        print = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    empty.add(new Point(j, i));
                }
            }
        }

        visited = new boolean[empty.size()];
        Point walls[] = new Point[3];

        Combination(0, walls);

        System.out.println(answerCount);
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(print[i][j] + " ");
//            }
//            System.out.println();
//        }

    }



    static void Combination(int depth, Point[] walls) {

        if (depth == 3) {
            wall = walls;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tempArr[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < 3; i++) {
                tempArr[wall[i].y][walls[i].x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tempArr[i][j] == 2) {
                        DFS(j, i);
                    }
                }
            }

            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tempArr[i][j] == 0) {
                        count ++;
                    }
                }
            }

            if (answerCount < count) {
                answerCount = count;

//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < M; j++) {
//                        print[i][j] = tempArr[i][j];
//                    }
//                }
            }

            return;

        }

        for (int i = 0; i < empty.size(); i++) {
            if (!visited[i]) {
                walls[depth] = empty.get(i);
                visited[i] = true;
                Combination(depth + 1, walls);
                visited[i] = false;
            }
        }
    }

    static void DFS(int nowX, int nowY) {

        for (int k = 0; k < 4; k++) {
            int x = nowX + dx[k];
            int y = nowY + dy[k];

            if (x >= 0 && x < M && y >= 0 && y < N) {
                if (tempArr[y][x] == 0) {
                    tempArr[y][x] = 2;
                    DFS(x, y);
                }
            }
        }
    }
}
