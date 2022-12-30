import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class practice46 {
    public static void main(String[] Args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer> arr[] = new ArrayList[N+1];
        int arr2[] = new int[N+1];
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> myQueue = new LinkedList<>();
        boolean visited[] = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
        }

        myQueue.add(X);

        while(!myQueue.isEmpty()){
            int node = myQueue.poll();
            visited[node] = true;

            for(int i : arr[node]){
                if(!visited[i]){
                    myQueue.add(i);
                    visited[i] = true;
                    arr2[i] = arr2[node]+1;
                }
            }
        }
        boolean isTrue = false;
        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i]==K){
                isTrue = true;
                answer.add(i);
            }
        }

        if (!isTrue) {
            System.out.println("-1");
            System.exit(0);
        }

        Collections.sort(answer);

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }

    }
}
