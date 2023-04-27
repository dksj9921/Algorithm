package ssafy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_ScreenCapture {
    static int N;
    static int nowN;
    static List<PNG> PNGList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int repeat = 0; repeat < N; repeat++) {
            PNGList = new ArrayList<>();
            nowN = Integer.parseInt(bf.readLine());
            for (int i = 1; i <= nowN; i++) {
                String tempString = String.valueOf(i);
                char tempChar[] = tempString.toCharArray();
                PNGList.add(new PNG(tempChar));
            }
            Collections.sort(PNGList);

            int temp = PNGList.size();
            if (temp > 50) {
                temp = 50;
            }
            sb.append(repeat + 1 + "# ");
            for (int i = 0; i < temp; i++) {
                sb.append(PNGList.get(i).PlusPNG + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class PNG implements Comparable<PNG>{
        char[] number;
        String PlusPNG;

        @Override
        public int compareTo(PNG input) {
            int tempRepeat = Math.min(input.number.length, this.number.length);
            for (int i = 0; i < tempRepeat; i++) {
                if (this.number[i] > input.number[i]) {
                    return 1;
                } else if (this.number[i] < input.number[i]) {
                    return -1;
                }
            }
            if (tempRepeat == input.number.length) {
                return 1;
            } else return -1;
        }

        PNG(char[] number) {
            this.number = number;
            String tempString = new String();
            for (int i = 0; i < number.length; i++) {
                tempString += number[i];
            }
            this.PlusPNG = tempString + ".png";
        }
    }

}
