package swmaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_PuyoPuyo {
    static char[][] field = new char[12][6];
    static boolean[][] visited = new boolean[12][6];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int xSize = field[0].length;
        int ySize = field.length;

        for (int i = 0; i < ySize; i++) {
            char tempCharArr[] = bf.readLine().toCharArray();
            for (int j = 0; j < xSize; j++) {
                field[i][j] = tempCharArr[j];
            }
        }


        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {

            }
        }
    }
}
