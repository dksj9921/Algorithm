package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_CompetitiveContagion {
    static int N, K, S, X, Y;
    static int arr[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean visited[][];
    static ArrayList<Point> nextQueue = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        ArrayList<Point> myQueue = new ArrayList<Point>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp != 0) {
                    arr[i][j] = temp;
                    nextQueue.add(new Point(j, i));
                }
            }
        }

        st = new StringTokenizer(bf.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        int count = 0;
        while (true) {
            myQueue = nextQueue;

            Collections.sort(myQueue, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (arr[o1.y][o1.x] > arr[o2.y][o2.x]) {
                        return 1;
                    } else return -1;
                }
            });

            visited = new boolean[N][N];
            nextQueue = new ArrayList<>();

            count++;

            for (int i = 0; i < myQueue.size(); i++) {
                Point tempPoint = myQueue.get(i);
                visited[tempPoint.y][tempPoint.x] = true;
                Contagion(tempPoint);
            }

//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println("");
//            }

            if (count == S) {
                break;
            }
        }

        System.out.println(arr[X][Y]);
    }

    static void Contagion(Point nowPoint) {
        for (int i = 0; i < 4; i++) {
            int x = nowPoint.x + dx[i];
            int y = nowPoint.y + dy[i];

            if (x >= 0 && x < N && y >= 0 && y < N && !visited[y][x]) {
                if (arr[y][x] == 0) {
                    visited[y][x] = true;
                    arr[y][x] = arr[nowPoint.y][nowPoint.x];
                    nextQueue.add(new Point(x, y));
                }
            }
        }
    }
}
