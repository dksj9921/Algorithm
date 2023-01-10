package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice42 {

    public static void main(String Args[])throws NumberFormatException, IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int multiplication = A*B;

            int big = 0;
            int small = 0;

            if(A>B) {
                big = A;
                small = B;
            }
            else{
                big = B;
                small = A;
            }

            int mod = 1;

            while(mod!=0){
                mod = big % small;
                big = small;
                if(mod!=0) small = mod;
            }

            System.out.println(multiplication/small);
        }


    }
}
