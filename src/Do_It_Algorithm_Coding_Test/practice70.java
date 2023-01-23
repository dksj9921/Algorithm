package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class practice70 {
    static Node tree[];
    static Queue<Integer> myQueue;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        tree = new Node[N];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(bf.readLine());

            int parent = st.nextToken().charAt(0);
            parent = parent - 'A';
            int a, b;
            char temp = st.nextToken().charAt(0);
            if (temp != '.') {
                a = temp - 'A';
            }else a = -1;
            temp = st.nextToken().charAt(0);
            if (temp != '.') {
                b = temp - 'A';
            }else b = -1;

            tree[i] = new Node(parent, a, b);
        }

        myQueue = new LinkedList<>();
        Preorder(0);

        for (int i = 0; i < N; i++) {
            int a = myQueue.poll();
            char b = (char)(a + 'A');
            System.out.println(b);
        }


    }

    private static void Preorder(int input) {
        myQueue.add(input);
        if (tree[input].left != -1) {
            Preorder(tree[input].left);
        }

        if (tree[input].right != -1) {
            Preorder(tree[input].right);
        }
    }



    public static class Node{
        int index, left, right;

        public Node(int index, int left, int right) {
            this.index = index;
            this.left = left;
            this.right = right;
        }
    }
}
