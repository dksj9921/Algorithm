package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.StringTokenizer;

public class practice9 {
    //DNA 비밀번호
    static int countArr[] = new int[4];

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int dnaSize = Integer.parseInt(st.nextToken());
        int passwordSize = Integer.parseInt(st.nextToken());
        int mustArr[] = new int[4];


        char dnaArr[] = new char[dnaSize];
        String tempDna= bf.readLine();

        for(int i=0; i<dnaSize; i++){
            dnaArr[i] = tempDna.charAt(i);
        }
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<4; i++){
            mustArr[i] = Integer.parseInt(st.nextToken(" "));
        }

        for(int i = 0; i<dnaSize; i++){
            if(dnaArr[i]=='A'||dnaArr[i]=='C'||dnaArr[i]=='G'||dnaArr[i]=='T'){
                continue;
            }else {
                System.out.println("Dna 문자열이 아닙니다.");
                break;}
        }

        int startIndex = 0, endIndex = passwordSize, countAll=0;
        for(int i = startIndex; i<endIndex; i++){
            switch (dnaArr[i]){
                case 'A':
                    countArr[0]++;
                    break;
                case 'C':
                    countArr[1]++;
                    break;
                case 'G':
                    countArr[2]++;
                    break;
                default:
                    countArr[3]++;
                    break;
            }
        }
        if(countArr[0]>=mustArr[0]&&countArr[1]>=mustArr[1]&&countArr[2]>=mustArr[2]&&countArr[3]>=mustArr[3]) countAll ++;

        while(passwordSize!=dnaSize){//이거 같으면 바로 아래 endIndex가 outBoundIndex가 나버리므로 런타임 에러가 뜬다 이거 주의 하도록.
            char startArr = dnaArr[startIndex];
            char endArr = dnaArr[endIndex];
            startIndex++;
            endIndex++;
            if(endIndex == 0) break;
            arrReturn(startArr,endArr);
            if(countArr[0]>=mustArr[0]&&countArr[1]>=mustArr[1]&&countArr[2]>=mustArr[2]&&countArr[3]>=mustArr[3]) countAll ++;
            if(endIndex==dnaSize) break;
        }
        System.out.println(countAll);
        bf.close();
    }

    public static void arrReturn(char startIndex, char endIndex){

        switch (startIndex){
            case 'A':
                countArr[0]--;
                break;
            case 'C':
                countArr[1]--;
                break;
            case 'G':
                countArr[2]--;
                break;
            default:
                countArr[3]--;
                break;
        }

        switch (endIndex){
            case 'A':
                countArr[0]++;
                break;
            case 'C':
                countArr[1]++;
                break;
            case 'G':
                countArr[2]++;
                break;
            default:
                countArr[3]++;
                break;
        }
    }
}
