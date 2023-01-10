package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class practice52 {
    static int parents[];
    static int representative = 0;
    public static void main(String[] Args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        parents = new int[N + 1];
        int count = 0;


        List<Integer> party[] = new List[M];

        for (int i = 1; i < N+1; i++) {
            parents[i] = i;
        }

        int know_True = Integer.parseInt(st.nextToken());
        if (know_True != 0) {
            representative = Integer.parseInt(st.nextToken());
            for (int i = 1; i < know_True; i++) {
                parents[Integer.parseInt(st.nextToken())] = representative;
            }
        } else {
            System.out.println(M);
            System.exit(0);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int tempArr[] = new int[num];
            party[i] = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                tempArr[j] = Integer.parseInt(st.nextToken());
                party[i].add(tempArr[j]);
            }
            for (int j = 0; j < num; j++) {
                if (j + 1 < num){
                    Union(tempArr[j],tempArr[j+1]);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            boolean Can = false;
            for (int j = 0; j < party[i].size(); j++) {
                if(Find(party[i].get(j)) == representative){
                    Can = true;
                    break;
                }
            }
            if(!Can) count++;
        }


        System.out.println(count);
    }

    public static void Union(int start, int end) {
        int a = Find(start);
        int b = Find(end);

        if (a != b) {
            if(a == representative) parents[b] = a;
            else parents[a] = b;
        }
    }

    public static int Find(int index) {
        if (parents[index] == index) return index;
        else {
            return parents[index] = Find(parents[index]);
        }
    }

}
