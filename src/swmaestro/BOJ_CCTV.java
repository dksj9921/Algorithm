package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_CCTV {
    static int N, M, sum, camSum;
    static int arr[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static PriorityQueue<Integer> camQueue = new PriorityQueue<Integer>();
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
                if (arr[i][j] == 0) {
                    sum++;
                } else if (arr[i][j] != 6) {
                    camQueue.add(arr[i][j]);
                    camSum++;
                }
            }
        }
    }



//    static class Cam{
//        Point location;
//        int direction[];
//
//        public void ChangeDirection() {
//            direction[0]++;
//            if (direction[0] == 4) {
//                direction[0] = 0;
//            }
//        }
//    }
//
//    static class FirstCam extends Cam{
//
//        FirstCam(Point location, int direction) {
//            this.location = location;
//            this.direction = new int[1];
//            this.direction[0] = direction;
//        }
//    }
//
//    static class SecondCam extends Cam {
//        SecondCam(Point location, int direction) {
//            this.location = location;
//            this.direction = new int[2];
//            this.direction[0] = direction;
//            this.direction[1] = direction;
//        }
//
//        @Override
//        public void ChangeDirection()
//
//    }

}
