package bootcampcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의개수 {

    static int arr[][];
    static boolean visited[][];
    static int dx[] = {1, 0, -1, 0 , 1, -1, 1, -1};
    static int dy[] = {0, 1, 0, -1, 1, -1 , -1, 1};
    static int w,h;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (w != 0 && h != 0) {
            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }



            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        BFS(i, j);
                        count++;
                    }
                }
            }



            sb.append(count + "\n");

            st = new StringTokenizer(bf.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

        }
        System.out.println(sb);
    }

    private static void BFS(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            if (tempX >= 0 && tempX < h && tempY >= 0 && tempY < w) {
                if (!visited[tempX][tempY] && arr[tempX][tempY] == 1) {
                    visited[tempX][tempY] = true;
                    BFS(tempX, tempY);
                }
            }
        }
    }
}
