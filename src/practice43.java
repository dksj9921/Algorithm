import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice43 {

    public static void main(String Args[])throws NumberFormatException, IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int big = 0;
        int small = 0;

        if(A>B) {
            big = A;
            small = B;
        }
        else if(B>A){
            big = B;
            small = A;
        }

        int minus = big - small;

    }

}
