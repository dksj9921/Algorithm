import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class practice23 {
    static ArrayList<Integer>[] A;
    static boolean visitied[];

    public static void main(String args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visitied = new boolean[N + 1];

        int count = 0;

        for(int i = 1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }
        for (int i = 1; i < N + 1; i++) {
            if(!visitied[i]) {
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }


    public static void DFS(int index) {

        if(visitied[index]) return;

        visitied[index] = true;

        for(int i :A[index]){
            if(!visitied[i]){
                DFS(i);
            }
        }


    }
}
