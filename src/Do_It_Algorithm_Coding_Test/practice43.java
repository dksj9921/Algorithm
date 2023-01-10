package Do_It_Algorithm_Coding_Test;

import java.io.*;
import java.util.StringTokenizer;

public class practice43 {

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long big = 0;
        long small = 0;

        if (A > B) {
            big = A;
            small = B;
        } else {
            big = B;
            small = A;
        }

        long mod = 1;

        while(mod!=0){
            mod = big % small;
            big = small;
            if(mod!=0) small = mod;
        }

        for (long i = 0; i < small; i++) {
            String s = "1";
            bw.write(s);
        }

        bw.flush();
        bw.close();
        bf.close();//스트림을 닫음

    }
}
