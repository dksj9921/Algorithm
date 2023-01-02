import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.AlgorithmConstraints;
import java.sql.Array;
import java.util.*;

public class practice49 {
    static boolean visited[][] = new boolean[201][201];
    static int arr[];
    static Queue<Node> myQueue;
    static int sum;
    static HashSet<Integer> answer = new HashSet<>();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        sum = C;

        arr = new int[3];

        arr[0] = A;
        arr[1] = B;
        arr[2] = C;

        myQueue = new LinkedList<>();


        BFS(new Node(0, 0));

        for (Integer i : answer) {
            System.out.print(i+" ");
        }


    }

    public static void BFS(Node index) {
        myQueue.add(index);
        while (!myQueue.isEmpty()) {
            Node node = myQueue.poll();
            if(node.A == 0) answer.add(sum - (node.A + node.B));
            if (!visited[node.A][node.B]) {
                visited[node.A][node.B] = true;

                int A_Left = node.A;
                int B_Left = node.B;
                int C_Left = sum - (A_Left + B_Left);

                if (A_Left != 0) {
                    if (A_Left <= (arr[1] - B_Left)) {
                        myQueue.add(new Node(0, (B_Left + A_Left)));
                    } else {
                        myQueue.add(new Node(A_Left - (arr[1] - B_Left), arr[1]));
                    }

                    if (A_Left <= (arr[2] - C_Left)) {
                        myQueue.add(new Node(0, B_Left));
                    } else {
                        myQueue.add(new Node(A_Left - (arr[2] - C_Left), B_Left));
                    }

                } else answer.add(C_Left);

                if (B_Left != 0) {
                    if (B_Left <= (arr[0] - A_Left)) {
                        myQueue.add(new Node(A_Left + B_Left, 0));
                    } else {
                        myQueue.add(new Node(arr[0], B_Left - (arr[0] - A_Left)));
                    }

                    if (B_Left <= (arr[2] - C_Left)) {
                        myQueue.add(new Node(A_Left, 0));
                    } else {
                        myQueue.add(new Node(A_Left, B_Left - (arr[2] - C_Left)));
                    }
                }

                if (C_Left != 0) {
                    if (C_Left <= (arr[0] - A_Left)) {
                        myQueue.add(new Node(A_Left + C_Left, B_Left));
                    } else {
                        myQueue.add(new Node(arr[0], B_Left));
                    }

                    if (C_Left <= (arr[1] - B_Left)) {
                        myQueue.add(new Node(A_Left, B_Left + C_Left));
                    } else {
                        myQueue.add(new Node(A_Left, arr[1]));
                    }
                }
            }
        }

    }


    public static class Node {
        int A;
        int B;

        public Node(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}
