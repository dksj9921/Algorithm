import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemB {
    static Node arr[][];

    static int columns, rows;
    static boolean isFinished;
    static boolean checkArr[][];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());


        for (int repeat = 0; repeat < T; repeat++) {
            st = new StringTokenizer(bf.readLine());

            columns = Integer.parseInt(st.nextToken());
            rows = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[rows][columns];
            arr = new Node[rows][columns];
            checkArr = new boolean[rows][columns];
            isFinished = false;

            for (int i = 0; i < rows; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < columns; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 1) {
                        checkArr[i][j] = true;
                    }
                    arr[i][j] = new Node(temp);
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if(arr[i][j].value == 1){
                        continue;
                    }else {
                        visited = new boolean[rows][columns];
                        DFS(i,j, visited);
                    }
                    if(isFinished) break;
                }
                if(isFinished) break;
            }

            if(isFinished){
                System.out.println("1");
            }else System.out.println("0");

        }

    }

    public static void DFS(int row, int column, boolean[][] visited) {
        visited[row][column] = true;
        boolean isHaveWay = false;
        if (((row + 1) < rows) && (arr[row + 1][column].value) != 1 && !arr[row][column].down) {
            isHaveWay = true;
            arr[row][column].down = true;
            arr[row+1][column].up = true;
            DFS(row + 1, column, visited);
        }
        if (((row - 1) > -1) && (arr[row - 1][column].value) != 1 && !arr[row][column].up) {
            isHaveWay = true;
            arr[row][column].up = true;
            arr[row-1][column].down = true;
            DFS(row - 1, column, visited);
        }
        if (((column + 1) < columns) && (arr[row][column + 1].value) != 1 && !arr[row][column].right) {
            isHaveWay = true;
            arr[row][column].right = true;
            arr[row][column+1].left = true;
            DFS(row, column + 1, visited);
        }
        if (((column - 1) > -1) && (arr[row][column - 1].value) != 1 && !arr[row][column].left) {
            isHaveWay = true;
            arr[row][column].left = true;
            arr[row][column-1].right = true;
            DFS(row, column - 1, visited);
        }

        if(!isHaveWay){
            boolean Finished = false;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if(!visited[i][j] && !checkArr[i][j]){
                        Finished = true;
                    }
                }
            }
            if(!Finished) isFinished = true;
        }
    }

    public static class Node {
        int value;
        boolean up, down, left, right;

        public Node(int value) {
            this.value = value;
        }
    }
}
