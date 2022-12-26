import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class practice43_1 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int arr[];
        int parents[];

        while (true) {
            st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (N == 0 && k == 0) {
                break;
            }

            arr = new int[N];
            parents = new int[N];
            int index = 0;

            st = new StringTokenizer(bf.readLine());

            if(N<=1){
                System.out.println(0);
                continue;
            }

            arr[0] = Integer.parseInt(st.nextToken());
            parents[0] = -1;
            arr[1] = Integer.parseInt(st.nextToken());
            parents[1] = 0;


            int save = 0;

            for (int i = 2; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i] = temp;
                if (arr[i] - 1 != arr[i - 1]) {
                    parents[i] = index + 1;
                    index++;
                } else {
                    parents[i] = index;
                }
                if (arr[i] == k) save = parents[i];
            }
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (parents[save] == parents[i]) {
                    for (int j = i; j < N; j++) {
                        if (i == parents[j] && parents[j] != save) {
                            count++;
                        }
                    }
                }
            }

            System.out.println(count);


        }


    }

}
