package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PopulationMovement {
    static int arr[][];
    static int size, count, sum;
    static boolean[][] visited;
    static Queue<Point> union = new LinkedList<Point>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        size = N * 2 - 1;

        arr = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                st = new StringTokenizer(bf.readLine());
            }
            for (int j = 0; j < size; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int answerCount = 0;
        boolean isFinished = false;
        while (true) {
            isFinished = false;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if ((i == 0 && j % 2 == 1) || (j == 0 && i % 2 == 1) || (i % 2 == 0 && j % 2 == 1) || (j % 2 == 0 && i % 2 == 1)) {
                        int minus = 0;
                        if (j % 2 == 1) {
                            minus = arr[i][j - 1] - arr[i][j + 1];
                        } else {
                            minus = arr[i - 1][j] - arr[i + 1][j];
                        }
                        if (minus < 0) {
                            minus = -minus;
                        }
                        if (minus >= L && minus <= R) {
                            arr[i][j] = -1;
                            isFinished = true;
                        } else {
                            arr[i][j] = -2;
                        }
                    }
                }
            }

//            for (int i = 0; i < size; i++) {
//                for (int j = 0; j < size; j++) {
//                    System.out.printf("%3d",arr[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println( );


            if (!isFinished) {
                break;
            }
            sum = 0;
            count = 0;

            visited = new boolean[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i % 2 == 0 && j % 2 == 0 && !visited[i][j]) {
                        union = new LinkedList<>();
                        sum = 0;
                        count = 0;
                        DFS(new Point(j, i));

                        int avgPop = sum / count;
                        while (!union.isEmpty()) {
                            Point nowPoint = union.poll();
                            arr[nowPoint.y][nowPoint.x] = avgPop;
                        }
                    }
                }
            }
            answerCount++;
        }

        System.out.println(answerCount);
    }

    static void DFS(Point input) {
        union.add(input);
        sum += arr[input.y][input.x];
        count++;
        visited[input.y][input.x] = true;

        for (int i = 0; i < 4; i++) {
            int x = input.x + dx[i];
            int y = input.y + dy[i];

            if (x >= 0 && x < size && y >= 0 && y < size) {
                if (arr[y][x] == -1) {
                    Point nextPoint = new Point(x + dx[i], y + dy[i]);
                    if (!visited[nextPoint.y][nextPoint.x]) {
                        union.add(nextPoint);
                        visited[nextPoint.y][nextPoint.x] = true;
                        DFS(nextPoint);
                    }
                }
            }
        }
    }
}
