package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class practice59 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int MAX = 9999999;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long least_Weight[] = new long[N + 1];
        Edge edge_List[] = new Edge[M];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edge_List[i] = new Edge(start, end, weight);
        }

        for (int i = 0; i < N + 1; i++) {
            least_Weight[i] = MAX;
        }

        least_Weight[1] = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                Edge now = edge_List[j];
                if ((least_Weight[now.end] > (least_Weight[now.start] + now.weight)) && least_Weight[now.start] != MAX) {
                    least_Weight[now.end] = (least_Weight[now.start] + now.weight);
                }
            }
        }
        boolean isMinus = false;

        for (int i = 0; i < M; i++) {
            Edge now = edge_List[i];
            if ((least_Weight[now.end] > (least_Weight[now.start] + now.weight)) && least_Weight[now.start] != MAX) {
                isMinus = true;
                break;
            }
        }

        if (isMinus) {
            System.out.println("-1");
            System.exit(0);
        }


        for (int i = 2; i < N+1; i++) {
            if (least_Weight[i] == MAX) System.out.println("-1");
            else System.out.println(least_Weight[i]);
        }


    }

    public static class Edge {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
