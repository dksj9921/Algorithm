package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_ChessRook {
    static int[][] board;
    static boolean[] columVisited = new boolean[8];
    static boolean[] rowVisited = new boolean[8];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());

        for (int repeat = 1; repeat <= N; repeat++) {
            int count = 0;
            boolean isFinished = false;
            columVisited = new boolean[8];
            rowVisited = new boolean[8];
            sb.append("#"+repeat+" ");
            for (int i = 0; i < 8; i++) {
                char tempChar[] = bf.readLine().toCharArray();
                for (int j = 0; j < 8; j++) {
                    if (tempChar[j] == 'O') {
                        count++;
                        if (columVisited[j]) {
                            rowVisited[i] = true;
                            isFinished = true;
                        } else if (rowVisited[i]) {
                            columVisited[j] = true;
                            isFinished = true;
                        } else {
                            columVisited[j] = true;
                            rowVisited[i] = true;
                        }
                    }
                }
            }

            if (isFinished || count != 8) {
                sb.append("no\n");
            } else {
                sb.append("yes\n");
            }
        }
        System.out.print(sb.toString());
    }
}
