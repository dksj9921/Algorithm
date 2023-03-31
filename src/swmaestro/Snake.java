package swmaestro;

import java.awt.*;
import java.awt.font.TextLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Snake {
    static Point appleArr[];
    static int arr[][];
    static HashMap<Integer, Character> map = new HashMap<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());

        arr = new int[N][N];

        appleArr = new Point[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x - 1][y - 1] = 2;

            appleArr[i] = new Point(x, y);
        }

        int X = Integer.parseInt(bf.readLine());

        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(st.nextToken());

            char directionChange = st.nextToken().charAt(0);

            map.put(time, directionChange);
        }

        int time = 0;
        arr[0][0] = 1;
        Point head = new Point(0, 0);
        Point tail = new Point(0, 0);
        int[] direction = {1, 0};
        Queue<Point> myQueue = new LinkedList<>();

        while (true) {
            time++;
//            System.out.println();
//            System.out.println("time = " + time);

            int moveHeadX = head.x + direction[0];
            int moveHeadY = head.y + direction[1];

            if (moveHeadY >= 0 && moveHeadY < N && moveHeadX >= 0 && moveHeadX < N && arr[moveHeadY][moveHeadX] != 1) {
                Point movePoint = new Point(moveHeadX, moveHeadY);
                myQueue.add(movePoint);

                boolean isApple = false;

                if (arr[moveHeadY][moveHeadX] == 2) {
                    isApple = true;
                }

                arr[moveHeadY][moveHeadX] = 1;

                head.x = moveHeadX;
                head.y = moveHeadY;

                if(!isApple){
                    Point tailPoint = myQueue.poll();
                    arr[tail.y][tail.x] = 0;
                    tail.x = tailPoint.x;
                    tail.y = tailPoint.y;
                }

            }else{
                break;
            }

            if (map.get(time) != null) {
                direction = directionChange(direction, map.get(time));
            }

//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.printf("%3d", arr[i][j]);
//                }
//                System.out.println(" ");
//            }
        }

        System.out.println(time);
    }

    static int[] directionChange(int[] direction, char directionChange) {
        int changedDirection[] = new int[2];

        if(directionChange == 'D'){
            if (direction[0] == 0) {
                if (direction[1] == 1) {
                    changedDirection[0] = -1;
                }else{
                    changedDirection[0] = 1;
                }
                changedDirection[1] = 0;
            }else{
                if(direction[0] == 1){
                    changedDirection[1] = 1;
                }else{
                    changedDirection[1] = -1;
                }
                changedDirection[0] = 0;
            }
        }else{
            if (direction[0] == 0) {
                if(direction[1] == 1){
                    changedDirection[0] = 1;
                }else{
                    changedDirection[0] = -1;
                }
                changedDirection[1] = 0;
            }else{
                if (direction[0] == 1) {
                    changedDirection[1] = -1;
                }else{
                    changedDirection[1] = 1;
                }
                changedDirection[0] = 0;
            }
        }

        return changedDirection;
    }
}
