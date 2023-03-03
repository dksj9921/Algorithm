package swmaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class chopstick {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        String[] chopstick = new String[n];

        for (int i = 0; i < n; i++) {
            chopstick[i] = st.nextToken();
        }


        solution sl = new solution();
        int answer = sl.solution(chopstick, n);

        System.out.println(answer);

    }
}

class solution {
    public int count;
    public HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    public ArrayList<Integer> List[];
    public Queue<String> myQueue;
    char arr[][];
    int nCount;
    String answerString = new String();

    public int solution(String[] chopstick, int n) {
        int answer = 0;

        arr= new char[n][2];
        List = new ArrayList[n];
        nCount = n;

        for (int i = 0; i < n; i++) {
            char temp[] = chopstick[i].toCharArray();
            arr[i][0] = temp[0];
            arr[i][1] = temp[1];

            List[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            List[i].add(i + 1);
        }

        myQueue = new LinkedList<>();
        BFS();
        answer = hashMap.get(answerString);
        return answer;
    }

    public void BFS() {
        int count = 0;
        String temp = new String();
        for (int i = 0; i < nCount; i++) {
            temp += arr[i][0];
            temp += arr[i][1];
        }
        myQueue.add(temp);

        hashMap.put(temp, count);

        while (!myQueue.isEmpty()) {
            String now = myQueue.poll();

            char tempChar[] = now.toCharArray();
            char target[][] = new char[nCount][2];
            for (int i = 0; i < temp.length(); i++) {
                target[i/2][i%2] = tempChar[i];
            }

            int tempCount = 0;
            for (int i = 0; i < nCount; i++) {
                if (target[i][0] == target[i][1]) {
                    tempCount++;
                }
            }

            if (tempCount == nCount) {
                answerString = now;
                return;
            }

//            for (int i = 0; i < nCount; i++) {
//                System.out.print(target[i][0]+ "" + target[i][1]);
//            }
//            System.out.println("");

            for (int i = 0; i < nCount; i++) {
                for(int k : List[i]){
                    for (int j = 0; j < 2; j++) {
                        for (int l = 0; l < 2; l++) {
                            char nowChar[][] = new char[nCount][2];
                            for (int m = 0; m < nCount; m++) {
                                nowChar[m][0] = target[m][0];
                                nowChar[m][1] = target[m][1];
                            }

                            char temptemp = nowChar[i][j];
                            nowChar[i][j] = nowChar[k][l];
                            nowChar[k][l] = temptemp;

                            String nowString = new String();

                            for (int m = 0; m < nCount; m++) {
                                nowString += nowChar[m][0];
                                nowString += nowChar[m][1];
                            }

                            if (hashMap.get(nowString) == null) {
                                System.out.println(now + " " + nowString);
                                hashMap.put(nowString, hashMap.get(now) + 1);
                                myQueue.add(nowString);
                            }
                        }
                    }
                }
            }
        }




    }
}
