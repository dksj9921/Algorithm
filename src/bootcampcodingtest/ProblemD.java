import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemD {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int m = Integer.parseInt(bf.readLine());
        List<Integer> arr = new ArrayList<>();


        for (int repeat = 0; repeat < m; repeat++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());

            int arr1[] = new int[a+1];

            for (int i = 0; i < a; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(bf.readLine());

            int b = Integer.parseInt(st.nextToken());
            int arr2[] = new int[b+1];

            for (int i = 0; i < b; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int first_pointer = 0;
            int second_pointer = 0;
            int start_pointer = 0;

            int Max = 0;

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    if(arr1[i] == arr2[j]){
                        arr.add(j);
                    }
                }
            }




            System.out.println(Max);
        }
    }
}
