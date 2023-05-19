package ssafy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_CardFlip {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= T; i++) {
            char input[] = bf.readLine().toCharArray();

            boolean isInOne = false;
            boolean isCan = false;
            boolean isHaveOne = false;
            int count = 0;
            for (int j = 0; j < input.length; j++) {
                if (input[j] == '1') {
                    isHaveOne = true;
                    count++;
                }
            }

            System.out.print("#" + i + " ");
            if ((count % 2) != 0) {
                System.out.print("yes\n");
            } else {
                System.out.print("no\n");
            }
        }
    }
}
