package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Laboratory2 {
    static int arr[][];
    static int N, M;
    static int tempArr[][];
    static ArrayList<Point> empty = new ArrayList<>();
    static boolean visited[];
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};
    static int Max = Integer.MAX_VALUE;
    static int print[][];
    static boolean[][] tempVisited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        Point virus[] = new Point[M];

        print = new int[N][N];
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
        visited = new boolean[empty.size()];

        Combination(0, virus);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (print[i][j] == -2) {
                    char temp = '벽';
                    System.out.printf("%3c", temp);
                }else{
                    System.out.printf("%3d ", print[i][j]);
                }
            }
            System.out.println("");
        }

        System.out.println(Max + 1);


    }

    static void Combination(int depth, Point[] virus) {


        if (depth == M) {
            tempArr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tempArr[i][j] = arr[i][j];
                    if (arr[i][j] == 2) {
                        tempArr[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < virus.length; i++) {
                tempArr[virus[i].y][virus[i].x] = -1;
            }
            tempVisited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tempArr[i][j] == -1) {
                        tempVisited[i][j] = true;
                        BFS(j, i);
                    }
                }
            }

            int tempMax = 0;

//            for (int i = 0; i < virus.length; i++) {
//                System.out.printf("%2d %2d", virus[i].x, virus[i].y);
//            }

//            System.out.println("");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
//                    System.out.printf("%3d", tempArr[i][j]);
                    if(tempVisited[]
                    if (tempMax < tempArr[i][j]) {
                        tempMax = tempArr[i][j];
                    }
                }
//                System.out.println(" ");
            }
//            System.out.println(" ");

            if (tempMax < Max) {
                Max = tempMax;


                for (int fori = 0; fori < N; fori++) {
                    for (int i = 0; i < N; i++) {
                        print[fori][i] = tempArr[fori][i];
                    }

                }
            }

            return;
        }

        for (int i = 0; i < empty.size(); i++) {
            if (!visited[i]) {
                virus[depth] = empty.get(i);
                visited[i] = true;
                Combination(depth + 1, virus);
                visited[i] = false;
            }
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
                    if (tempArr[y][x] != -1 && tempArr[y][x] != -2) {
                        if(!tempVisited[y][x]){
                            tempArr[y][x] = tempArr[now.y][now.x] + 1;
                            myQueue.add(new Point(x, y));
                            tempVisited[y][x] = true;
                        }else if(tempArr[y][x] >= (tempArr[now.y][now.x] + 1)){
                            tempArr[y][x] = tempArr[now.y][now.x] + 1;
                            myQueue.add(new Point(x, y));
                        }
                    }
                }
            }
        }
    }
}
