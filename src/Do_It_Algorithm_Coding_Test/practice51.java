package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice51 {
    static int parents[];

    public static void main(String[] Args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 1; j < N + 1; j++) {
                int isConnected = Integer.parseInt(st.nextToken());
                if (isConnected == 1) {
                    Union(i,j);
                }
            }
        }

        st = new StringTokenizer(bf.readLine());
        boolean isYES = true;
        int representative = Find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            if (Find(Integer.parseInt(st.nextToken())) != representative) {
                isYES = false;
                break;
            }
        }

        if(isYES) System.out.println("YES");
        else System.out.println("NO");

    }

    public static void Union(int start, int end) {
        int a = Find(start);
        int b = Find(end);

        if (a != b) {
            parents[b] = parents[a];
        }
    }

    public static int Find(int index) {
        if (parents[index] == index) {
            return index;
        }else{
            return parents[index] = Find(parents[index]);
        }
    }
}
