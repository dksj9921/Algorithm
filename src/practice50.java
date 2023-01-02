import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice50 {

    static int arr2[];

    public static void main(String[] Args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr2 = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr2[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int isFind = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int start_Representative = Find(start);
            int end_Representative = Find(end);
            if (isFind == 0) {
                if (start_Representative != end_Representative) {
                    arr2[end_Representative] = arr2[start_Representative];
                }
            } else {
                if (start_Representative == end_Representative) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static int Find(int index) {
        if (arr2[index] == index) {
            return index;
        } else {
            return arr2[index] = Find(arr2[index]);
        }

    }

}
