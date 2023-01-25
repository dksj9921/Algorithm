package bootcampcodingtest;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class tomato {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int tray[][] = new int[N][M];
        boolean visited[][] = new boolean[N][M];
        int tomato_Count = 0;
        Queue<Point> myQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                tray[i][j] = temp;
                if (temp == 0) {
                    tomato_Count++;
                } else if (temp == 1) {
                    myQueue.add(new Point(i, j));
                }
            }
        }
//        for (int X = 0; X < N; X++) {
//            for (int Y = 0; Y < M; Y++) {
//                System.out.print(tray[X][Y] + " ");
//            }
//            System.out.println("");
//        }
        int check_Count = 0;
        while (!myQueue.isEmpty()) {
            Point now = myQueue.poll();
            visited[now.x][now.y] = true;
            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (tray[x][y] == 0 && !visited[x][y]) {
                        check_Count++;
                        myQueue.add(new Point(x, y));
                        visited[x][y] = true;
                        tray[x][y] = tray[now.x][now.y] + 1;

//                        for (int X = 0; X < N; X++) {
//                            for (int Y = 0; Y < M; Y++) {
//                                System.out.print(tray[X][Y] + " ");
//                            }
//                            System.out.println("");
//                        }
//                        System.out.println("");

                    }

                }
            }
        }


        int Max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tray[i][j] > Max) {
                    Max = tray[i][j];
                }
            }
        }

        if (tomato_Count > check_Count) {
            System.out.println(-1);
        } else System.out.println(Max - 1);
    }
}

