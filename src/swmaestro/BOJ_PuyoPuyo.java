package swmaestro;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_PuyoPuyo {
    static char[][] field = new char[12][6];
    static boolean[][] visited = new boolean[12][6];
    static HashMap<Character, Boolean> hashMap = new HashMap<>();
    static int popArr[] = new int[6];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int xSize, ySize, count;
    static char nowChar;
    static List<Point> popList = new ArrayList<>();
    static int tempArr[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        xSize = field[0].length;
        ySize = field.length;

        for (int i = 0; i < ySize; i++) {
            char tempCharArr[] = bf.readLine().toCharArray();
            for (int j = 0; j < xSize; j++) {
                field[i][j] = tempCharArr[j];
                if (field[i][j] != '.') {
                    hashMap.put(field[i][j], true);
                }
            }
        }

        int time = 0;
        while (true) {
            time++;

            boolean isFinished = false;
            visited = new boolean[ySize][xSize];
            for (int i = 0; i < ySize; i++) {
                for (int j = 0; j < xSize; j++) {
                    if (field[i][j] != '.' && !visited[i][j]) {
                        popList = new ArrayList<>();
                        count = 0;
                        nowChar = field[i][j];
                        FindPop(new Point(j, i));
                        if (count >= 4) {
                            isFinished = true;
                            DeletePop();
                        }
                    }
                }
            }

            tempArr = new int[ySize][xSize];
            for (int i = 0; i < xSize; i++) {
                for (int j = 0; j < ySize; j++) {
                    if (field[j][i] != '.') {
                        int tempCount = 0;
                        for (int k = j; k < ySize; k++) {
                            if (field[k][i] == '.') {
                                tempCount++;
                            }
                        }
                        tempArr[j][i] = tempCount;
                    }
                }
            }

            if (!isFinished) {
                break;
            }

            DropDown();

//            for (int i = 0; i < ySize; i++) {
//                for (int j = 0; j < xSize; j++) {
//                    System.out.print(field[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        System.out.println(time - 1);

    }

    static void FindPop(Point nowPoint) {

        for (int i = 0; i < 4; i++) {
            int x = nowPoint.x + dx[i];
            int y = nowPoint.y + dy[i];

            if (x >= 0 && x < xSize && y >= 0 && y < ySize && !visited[y][x]) {
                if (field[y][x] == nowChar) {
                    visited[y][x] = true;
                    popList.add(new Point(x, y));
                    count++;
                    FindPop(new Point(x, y));
                }
            }
        }
    }

    static void DeletePop() {
        for (int i = 0; i < popList.size(); i++) {
            Point nowPop = popList.get(i);
            popArr[nowPop.x]++;
            field[nowPop.y][nowPop.x] = '.';
        }
    }

    static void DropDown() {
        for (int i = 0; i < xSize; i++) {
            for (int j = ySize - 1; j >= 0; j--) {
                if (tempArr[j][i] != 0) {
                    int dropCount = tempArr[j][i];
                    field[j + dropCount][i] = field[j][i];
                    field[j][i] = '.';
                }
            }
        }
    }
}
