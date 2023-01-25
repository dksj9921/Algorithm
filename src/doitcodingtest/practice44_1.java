package doitcodingtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class practice44_1 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new FileReader("src/test.text"));
        StringTokenizer st = new StringTokenizer(bf.readLine(),",");
        List<String> arr = new ArrayList<>();

        Random rand = new Random();

        while(st.hasMoreTokens()){
            arr.add(st.nextToken());
        }
        String arr2[] = new String[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            int randNum = rand.nextInt(arr.size());
            if(arr2[randNum] != null){
                i--;
                continue;
            }
            arr2[randNum] = arr.get(i);
        }

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+", ");
        }

    }
}
