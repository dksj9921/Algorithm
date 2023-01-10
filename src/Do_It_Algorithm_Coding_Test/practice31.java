package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class practice31 {

    public static void main(String Args[])throws NumberFormatException, IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());

        int start = 1;
        int end = K;

        int m = 0;

        while(start<=end){
            m = (start+end)/2;
            int count = 0;
            for(int i=1;i<=N;i++){
                count += Math.min(N,m/i);
            }
            if(count<K)start=m+1;
            else end = m-1;
        }

        System.out.println(start);
    }
}
