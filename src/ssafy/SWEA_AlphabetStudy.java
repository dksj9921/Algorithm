package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_AlphabetStudy {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= N; i++) {
            char[] alphabet = bf.readLine().toCharArray();

            char start = 'a';
            int startInt = start;

            int count = 0;
            for (int j = 0; j < alphabet.length; j++) {
                int nowInt = alphabet[j];
                if (startInt == nowInt) {
                    count++;
                    startInt++;
                } else {
                    break;
                }
            }

            System.out.println("#"+i+" "+count);
        }
    }
}
