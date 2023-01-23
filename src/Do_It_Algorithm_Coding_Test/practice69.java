package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice69 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node root = new Node();

        for (int i = 0; i < N; i++) {
            String temp = bf.readLine();
            Node now = root;

            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                int nowInt = c - 'a';

                if (now.next[nowInt] == null) {
                    now.next[nowInt] = new Node();
                }

                now = now.next[nowInt];

                if (j == temp.length() - 1) {
                    now.isFinish = true;
                }
            }
        }
        int count = 0;

        for (int i = 0; i < M; i++) {
            String temp = bf.readLine();
            Node now = root;

            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                int nowInt = c - 'a';
                if (now.next[nowInt] == null) {
                    break;
                }
                now = now.next[nowInt];

                if (j == temp.length() - 1) {
                    if (now.isFinish) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);


    }

    public static class Node{
        Node next[] = new Node[26];
        boolean isFinish = false;
    }
}
