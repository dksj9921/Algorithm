package swmaestro;

import com.sun.source.tree.CompilationUnitTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RemoteController {
    static int N, M;
    static HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    static boolean isMinus = false;
    static boolean isShake = false;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        String tempString = String.valueOf(N);
        char[] tempChar = tempString.toCharArray();
        M = Integer.parseInt(bf.readLine());
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < M; i++) {
                int temp = Integer.parseInt(st.nextToken());
                map.put(temp, true);
            }
        }

        int length = 100000;
        while (true) {
            if (N / length != 0) {
                break;
            }
            length /= 10;
        }

        int answer = 0;
        int result = 0;
        int temp = N;
        for (int i = length; i > 0; i /= 10) {
            int temptemp = temp / i;
            if (isShake && isMinus) {
                temptemp = 9;
            } else if (isShake && !isMinus) {
                temptemp = 0;
            }
            result = CheckNumber(temptemp);
            if (map.containsKey(temptemp) && !isShake) {
                isShake = true;
            }
            temp = temp % i;
            answer += (temptemp + result) * i;
//            System.out.println(answer + " " + result);
        }

        answer = N - answer;

        if (answer < 0) {
            answer = -answer;
        }

        answer += tempChar.length;

        int tempAnswer = N - 100;

        if (tempAnswer < 0) {
            tempAnswer = -tempAnswer;
        }

        if (tempAnswer < answer) {
            answer = tempAnswer;
        }

        System.out.println(answer);
    }

    static int CheckNumber(int index) {
        int result = 0;
        int upCheck = 0;
        int downCheck = 0;
        boolean isUpCheck = false;
        boolean isDownCheck = false;


        for (int i = index; i < 10; i++) {
            if (map.containsKey(i)) {
                upCheck++;
            } else {
                isUpCheck = true;
                break;
            }
        }

        for (int i = index; i >= 0; i--) {
            if (map.containsKey(i)) {
                downCheck++;
            } else {
                isDownCheck = true;
                break;
            }
        }

        if (!isShake) {
            if (isUpCheck && isDownCheck) {
                if (downCheck < upCheck) {
                    result = -downCheck;
                    isMinus = true;
                } else {
                    result = upCheck;
                    isMinus = false;
                }
            } else if (isUpCheck) {
                result = upCheck;
                isMinus = false;
            } else if (isDownCheck) {
                result = -downCheck;
                isMinus = true;
            }
        } else {
            if (isUpCheck && isDownCheck) {
                if (downCheck < upCheck) {
                    result = -downCheck;
                } else {
                    result = upCheck;
                }
            } else if (isUpCheck) {
                result = upCheck;
            } else if (isDownCheck) {
                result = -downCheck;
            }
        }


        return result;
    }
}
