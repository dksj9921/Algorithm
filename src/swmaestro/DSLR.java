package swmaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 9019 백준 DSLR
public class DSLR {

    static int start;
    static int end;
    static String anw;
    static Queue<Word> q = new LinkedList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tcase = Integer.parseInt(br.readLine());

        while (tcase-- > 0) {

            // 값 입력 및 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            anw = "";
            visit = new boolean[10000];
            q.clear();

            //BFS
            BFS(start, "");
            sb.append(anw + "\n");
        }

        System.out.print(sb.toString());
    }

    static void BFS(int s, String make) {

        Word w1 = new Word();
        w1.n = s;
        w1.make = make;
        q.add(w1);

        while (!q.isEmpty()) {

            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Word word = q.poll();


                // 같으면 정지
                if (word.n == end) {
                    q.clear();
                    anw = word.make;
                    break;
                }

                Word tempWord = new Word();
                tempWord.n = D(word.n);
                tempWord.make = word.make + "D";
                if(!visit[tempWord.n]) q.add(tempWord);
                visit[tempWord.n] = true;

                tempWord = new Word();
                tempWord.n = S(word.n);
                tempWord.make = word.make + "S";
                if(!visit[tempWord.n]) q.add(tempWord);
                visit[tempWord.n] = true;

                tempWord = new Word();
                tempWord.n = L(word.n);
                tempWord.make = word.make + "L";
                if(!visit[tempWord.n]) q.add(tempWord);
                visit[tempWord.n] = true;

                tempWord = new Word();
                tempWord.n = R(word.n);
                tempWord.make = word.make + "R";
                if(!visit[tempWord.n]) q.add(tempWord);
                visit[tempWord.n] = true;
            }
        }
    }

    static int D(int num) {
        int n = num;
        n = (n * 2) % 10000;
        return n;
    }

    static int S(int num) {
        int n = num;
        if(--n < 0) n = 9999;
        return n;
    }

    static int L(int num) {
        num = (num * 10) % 10000 + (num / 1000);
        return num;

    }

    static int R(int num) {
        num = (num / 10) + (num % 10) * 1000;
        return num;
    }

    static class Word {
        int n;
        String make;

        Word(int n, String make) {
            this.n = n;
            this.make = make;
        }

        public Word() {

        }
    }
}
