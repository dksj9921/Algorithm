package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotCleaner {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        st = new StringTokenizer(bf.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Point startPoint = new Point(x, y);

        int startDirection = Integer.parseInt(st.nextToken());

        if (startDirection == 1) {
            startDirection = 3;
        } else if (startDirection == 3) {
            startDirection = 1;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int countCleanRoom = 0;
        int direction = startDirection;
        Point robotLocation = startPoint;

        while (true) {

//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println("");
//            }
//            System.out.println();

            if (arr[robotLocation.y][robotLocation.x] == 0) {
                arr[robotLocation.y][robotLocation.x] = 2;
                countCleanRoom++;
            }

            boolean isDirtyRoom = false;
            for (int i = 0; i < 4; i++) {
                int nextX = robotLocation.x + dx[i];
                int nextY = robotLocation.y + dy[i];

                if (arr[nextY][nextX] == 0) {
                    isDirtyRoom = true;
                }
            }

            if (!isDirtyRoom) {
                int backX = robotLocation.x - dx[direction];
                int backY = robotLocation.y - dy[direction];

                if (arr[backY][backX] == 1) {
                    break;
                }else{
                    robotLocation.x = backX;
                    robotLocation.y = backY;
                }
            }else{
                direction++;
                if (direction == 4) {
                    direction = 0;
                }

                int frontX = robotLocation.x + dx[direction];
                int frontY = robotLocation.y + dy[direction];

                if(arr[frontY][frontX] == 0){
                    robotLocation.x = frontX;
                    robotLocation.y = frontY;
                }
            }
        }

        System.out.println(countCleanRoom);
    }
}
