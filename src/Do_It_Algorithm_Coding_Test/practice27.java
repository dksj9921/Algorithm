package Do_It_Algorithm_Coding_Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class practice27 {

    static int arr[][];
    static boolean visited[][];

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Point> myQueue = new LinkedList<Point>();

        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for (int k = 0; k < M; k++) {
                arr[i][k] = Character.getNumericValue(str.charAt(k));
            }
        }

        myQueue.add(new Point(0, 0));

        int count = 0;
        while (!myQueue.isEmpty()) {
            Point index = myQueue.poll();
            visited[index.x][index.y] = true;
            count++;
            if (index.x == N-1 && index.y == M-1) break;

            for (int i = 0; i < 4; i++) {
                int x = index.x - dx[i];
                int y = index.y - dy[i];

                if (x > -1 && y > -1 && x < N && y < M && !visited[x][y] && arr[x][y] == 1) {
                    myQueue.add(new Point(x, y));
                    visited[x][y] = true;
                    arr[x][y] = arr[index.x][index.y]+1;
                }
            }
        }

        System.out.println(arr[N-1][M-1]);


    }
}

