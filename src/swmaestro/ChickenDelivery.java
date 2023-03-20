package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class ChickenDelivery {
    static int arr[][];
    static ArrayList<Point> house = new ArrayList<Point>();
    static boolean visited[];
    static int N, M;
    static int answer;
    static Point tempChickenShop[];
    static ArrayList<Point> chickenShop = new ArrayList<Point>();
    static Queue<Point> myQueue = new LinkedList<>();
    static int dx[] = {0, 1, -1, 0};
    static int dy[] = {1, 0, 0, -1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tempChickenShop = new Point[M];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) {
                    house.add(new Point(j, i));
                }
                if (k == 2) {
                    chickenShop.add(new Point(j, i));
                }
            }
        }

        Combination(0, 0);

        System.out.println(answer);
    }

    static void Combination(int depth, int start) {

        if (depth == M) {

//            for (int i = 0; i < depth; i++) {
//                System.out.print(tempChickenShop[i]+ " ");
//            }
//            System.out.println();

            int distanceSum = 0;

            myQueue = new LinkedList<>();
            for (int i = 0; i < house.size(); i++) {
                Point home = house.get(i);
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    Point chick = tempChickenShop[j];
                    int dist = Math.abs(home.x - chick.x) + Math.abs(home.y - chick.y);

                    min = Math.min(min, dist);
                }
                distanceSum += min;
            }

            answer = Math.min(distanceSum, answer);

            return;
        }

        for (int i = start; i < chickenShop.size(); i++) {
                tempChickenShop[depth] = new Point(chickenShop.get(i).x, chickenShop.get(i).y);
                Combination(depth + 1, i + 1);
        }
    }
}
