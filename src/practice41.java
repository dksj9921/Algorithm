import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class practice41 {

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(bf.readLine());

        //1조라...

        //시@발 숫자 크기로 장난질 하는거좀 그만해라 개새끼들아...
        long result = N;

        for (long i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                result = result - result / i;
                while (N % i == 0) {
                    N = N/i;
                }
            }
        }

        if(N>1){
            result = result - result/N;
        }

        System.out.println(result);
    }
}
