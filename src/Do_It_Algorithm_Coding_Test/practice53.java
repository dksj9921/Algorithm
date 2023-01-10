package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class practice53 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> arr[] = new List[N + 1];
        int arr2[] = new int[N + 1];
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        boolean visited[] = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start].add(end);
            arr2[end]++;
        }

        while (true) {
            boolean isFinished = false;
            for (int i = 1; i < arr2.length; i++) {
                if (arr2[i] == 0 && !visited[i]) {
                    visited[i] = true;
                    answer.add(i);
                    for (int k : arr[i]) {
                        isFinished = true;
                        arr2[k]--;
                    }
                }
            }
            if (!isFinished) break;
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i)+" ");
        }
    }
}

