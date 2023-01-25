package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class practice65 {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int unionFindArr[];
    static int N, M, count_Node = 1;
    static int arr[][];
    static boolean visited[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];


        count_Node = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    arr[i][j] = count_Node;
                    BFS(i, j);
                    count_Node++;
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println("");
//        }


        PriorityQueue<Node> myQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (x >= 0 && x < N && y >= 0 && y < M) {
                            int temp_Count2 = 1;
                            while (arr[x][y] == 0) {
                                x += dx[k];
                                y += dy[k];

                                if ((x >= 0 && x < N && y >= 0 && y < M)) {
                                    if ((arr[x][y] != 0) && temp_Count2 != 1) {
//                                        System.out.println(arr[i][j] + " " + arr[x][y] + " " + temp_Count2);
                                        myQueue.add(new Node(arr[i][j], arr[x][y], temp_Count2));
                                        break;
                                    }
                                } else break;

                                temp_Count2++;
                            }
                        }
                    }
                }
            }
        }

        count_Node--;

        int check_Count = 0;
        int sum = 0;
        unionFindArr = new int[count_Node + 1];
        for (int i = 0; i <= count_Node; i++) {
            unionFindArr[i] = i;
        }

        while (check_Count < count_Node - 1) {

            Node temp = myQueue.poll();
            if (temp == null) {
                System.out.println("-1");
                System.exit(0);
            }

            if (Find(temp.start) != Find(temp.end)) {
                Union(temp.start, temp.end);
                sum += temp.weight;
//                System.out.println(" ");
//                for (int i = 0; i < unionFindArr.length; i++) {
//                    System.out.print(unionFindArr[i] + " ");
//                }
//                System.out.println(" ");
//                System.out.println(temp.start + " " + temp.end);
//                System.out.println(unionFindArr[temp.start] + " " + unionFindArr[temp.end] + " " + temp.weight);
                check_Count++;
            }
        }

        System.out.println(sum);
    }


    public static class Node implements Comparable<Node> {
        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node input) {
            return this.weight > input.weight ? 1 : -1;
        }
    }

    public static void Union(int a, int b) {
        a = Find(a);
        b = Find(b);

        unionFindArr[b] = a;
    }

    public static int Find(int input) {
        if (unionFindArr[input] == input) {
            return input;
        } else return unionFindArr[input] = Find(unionFindArr[input]);
    }

    public static void BFS(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (tempX >= 0 && tempX < N && tempY >= 0 && tempY < M){
                if(arr[tempX][tempY] == 1){
                    if(!visited[tempX][tempY]){
                    arr[tempX][tempY] = count_Node;
                    visited[tempX][tempY] = true;
                    BFS(tempX, tempY);}
                }
            }
        }
    }
}
