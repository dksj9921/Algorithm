import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class practice28 {

    static ArrayList<Point> arr[];
    static boolean visited[];

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        int arrWeight[] = new int[N + 1];
        Queue<Integer> myQueue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            int trash = Integer.parseInt(st.nextToken());
            while (true) {
                int V = Integer.parseInt(st.nextToken());
                if (V == -1) break;
                int S = Integer.parseInt(st.nextToken());

                arr[trash].add(new Point(V, S));
            }
        }

        myQueue.add(1);

        while (!myQueue.isEmpty()) {
            int index = myQueue.poll();

            visited[index] = true;

            for (Point i : arr[index]) {
                if (!visited[i.x]) {
                    myQueue.add(i.x);
                    visited[i.x] = true;
                    arrWeight[i.x] = i.y + arrWeight[index];
                }
            }
        }

        int Max = 0;
        for (int i = 1; i <= N; i++) {
            if (arrWeight[i] > arrWeight[Max]) Max = i;
        }


        myQueue = new LinkedList<>();
        myQueue.add(Max);
        visited = new boolean[N+1];
        arrWeight = new int[N+1];

        while (!myQueue.isEmpty()) {
            int index = myQueue.poll();

            visited[index] = true;

            for (Point i : arr[index]) {
                if (!visited[i.x]) {
                    myQueue.add(i.x);
                    visited[i.x] = true;
                    arrWeight[i.x] = i.y + arrWeight[index];
                }
            }
        }

        Max = 0;
        for (int i = 1; i <= N; i++) {
            if (arrWeight[i] > Max) Max = arrWeight[i];
        }
        System.out.println(Max);

    }
}
