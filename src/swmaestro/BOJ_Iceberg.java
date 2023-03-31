package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_Iceberg {
    static int arr[][];
    static int N, M;
    static ArrayList<Ice> iceArr = new ArrayList<Ice>();
    static ArrayList<Point> meltIce = new ArrayList<>();
    static boolean visited[][];
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    iceArr.add(new Ice(arr[i][j], new Point(j, i)));
                }
            }
        }

        int year = 0;
        boolean isRealBreak = false;
        while (true) {
            year++;

            boolean isBreak = false;
            meltIce = new ArrayList<>();
            for (int i = 0; i < iceArr.size(); i++) {
                if (iceArr.get(i).leftYear != 0) {
                    isBreak = true;
                    Ice nowIce = iceArr.get(i);
                    boolean isMelt = false;
                    int count = 0;
                    for (int j = 0; j < 4; j++) {
                        int x = nowIce.location.x + dx[j];
                        int y = nowIce.location.y + dy[j];

                        if (x >= 0 && x < M && y >= 0 && y < N) {
                            if (arr[y][x] == 0) {
                                isMelt = true;
                                count++;
                            }
                        }
                    }

                    if (isMelt) {
                        nowIce.leftYear -= count;
                        if (nowIce.leftYear < 0) {
                            nowIce.leftYear = 0;
                        }
                        if (nowIce.leftYear == 0) {
                            meltIce.add(new Point(nowIce.location.x, nowIce.location.y));
//                            System.out.println("hello");
                        }else{
                            arr[nowIce.location.y][nowIce.location.x] = nowIce.leftYear;
                        }
                    }

                }
            }

            for (int j = 0; j < meltIce.size(); j++) {
                Point meltPoint = meltIce.get(j);
                arr[meltPoint.y][meltPoint.x] = 0;
            }

            if (!isBreak) {
                isRealBreak = true;
                break;
            }

            boolean isFirst = false;
            boolean isFinished = false;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
//                    System.out.print(arr[i][j] + " ");
                    if (arr[i][j] != 0 && !visited[i][j]) {
                        if (isFirst) {
                            isFinished = true;
                            break;
                        }
                        isFirst = true;
                        DFS(new Point(j, i));
                    }
                }
//                System.out.println();
            }
//            System.out.println();

            if (isFinished) {
                break;
            }
        }

        if (isRealBreak) {
            System.out.println(0);
        }else{
            System.out.println(year);
        }
    }

    static void DFS(Point iceLocation) {
        for (int j = 0; j < 4; j++) {
            int x = iceLocation.x + dx[j];
            int y = iceLocation.y + dy[j];

            if (x >= 0 && x < M && y >= 0 && y < N) {
                if (!visited[y][x] && arr[y][x] != 0) {
                    visited[y][x] = true;
                    DFS(new Point(x, y));
                }
            }
        }
    }

    static class Ice {
        int leftYear;
        Point location;

        Ice(int leftYear, Point location) {
            this.leftYear = leftYear;
            this.location = location;
        }
    }
}


