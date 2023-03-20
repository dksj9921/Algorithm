package swmaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Laboratory3 {
    static int arr[][];
    static int N, M;
    static int tempArr[][];
    static ArrayList<Point> empty = new ArrayList<>();
    static boolean visited[];
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};
    static final int MAX_VALUE = 9999999;
    static int Max = MAX_VALUE;
    static boolean[][] tempVisited;
    static Point virus[];

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        virus = new Point[M];
        tempArr = new int[N][N];

        tempVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    empty.add(new Point(j, i));
                    arr[i][j] = 0;
                }

                if (arr[i][j] == 1) {
                    arr[i][j] = -2;
                }
            }
        }

        Combination(0, 0);

        if(Max == MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(Max + 1);
        }

        bf.close();
    }

    static void Combination(int depth,  int start) {
        if (depth == M) {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tempArr[i][j] = arr[i][j];
                    tempVisited[i][j] = false;
                }
            }

            for (int i = 0; i < virus.length; i++) {
                tempArr[virus[i].y][virus[i].x] = -1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tempArr[i][j] == -1) {
                        tempVisited[i][j] = true;
                        BFS(j, i);
                    }
                }
            }

            for (int i = 0; i < empty.size(); i++) {
                Point now = empty.get(i);
                tempArr[now.y][now.x] = -3;
            }

            int tempMax = -1;

            boolean isNotFinished = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!tempVisited[i][j] && tempArr[i][j] != -1 && tempArr[i][j] != -2 && tempArr[i][j] != -3){
                        isNotFinished = true;
                        break;
                    }
                    if (tempMax < tempArr[i][j]) {
                        tempMax = tempArr[i][j];
                    }
                }
            }

            if (tempMax < Max && !isNotFinished) {
                Max = tempMax;
            }
            return;
        }

        for (int i = start; i < empty.size(); i++) {
            virus[depth] = empty.get(i);
            Combination(depth + 1, i + 1);
        }
    }

    static void BFS(int nowX, int nowY) {
        Queue<Point> myQueue = new LinkedList<>();

        myQueue.add(new Point(nowX, nowY));

        while(!myQueue.isEmpty()){

            Point now = myQueue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < N) {
                    if (tempArr[y][x] != -1 && tempArr[y][x] != -2 && tempArr[y][x] != -3) {
                        if(!tempVisited[y][x]){
                            tempArr[y][x] = tempArr[now.y][now.x] + 1;
                            myQueue.add(new Point(x, y));
                            tempVisited[y][x] = true;
                        }else if(tempArr[y][x] > (tempArr[now.y][now.x] + 1)){
                            tempArr[y][x] = tempArr[now.y][now.x] + 1;
                            myQueue.add(new Point(x, y));
                            tempVisited[y][x] = true;
                        }
                    }
                }
            }
        }
    }
}
