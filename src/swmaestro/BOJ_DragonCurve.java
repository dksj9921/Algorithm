package swmaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_DragonCurve {
    static int N, count;
    static List<Integer> arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map = new int[101][101];
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            Paint(x, y, d, g);

        }
        Check();
        System.out.println(count);
    }

    static void Paint(int x, int y, int d, int g) {

        map[y][x] = 1;

        arr = new ArrayList<>();
        arr.add(d);

        for (int i = 0; i < g; i++) {
            int n = arr.size();

            for (int j = 0; j < n; j++) {
                d = arr.get(n - 1 - j) + 1;
                if (d == 4) {
                    d = 0;
                }
                arr.add(d);
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            x = x + dx[arr.get(i)];
            y = y + dy[arr.get(i)];

            map[y][x] = 1;
        }
    }

    static void Check() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1){
                    count++;
                }
            }
        }
    }



}
