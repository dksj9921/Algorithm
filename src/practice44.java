import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice44 {

    static int mod, q, p;
    static ArrayList<Node> arr[];
    static boolean visited[];
    static int arr2[];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        arr = new ArrayList[N];
        visited = new boolean[N - 1];
        arr2 = new int[N];

        int least_Multiple = 0;


        int checkPoint = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
            arr2[i] = 1;
        }
        int small;
        int big;

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if (q < p) {
                small = q;
                big = p;
            } else {
                small = p;
                big = q;
            }

            LCM(big, small);
            q /= mod;
            p /= mod;

            arr[a].add(new Node(i, a, b, q, p));
            arr[b].add(new Node(i, a, b, q, p));
        }

        Queue<Integer> myQueue = new LinkedList<>();

        int temp = 0;
        for (int z = 0; z < N; z++) {
            int i = z;
            int tempArr[] = new int[arr[i].size() + 1];
            for (int j = 0; j < tempArr.length; j++) {
                tempArr[j] = 1;
            }
            temp = 0;

            for (Node k : arr[i]) {
                if (!visited[k.index]) {
                    visited[k.index] = true;
                    if (i == k.a) {
                        tempArr[temp] = k.q;
                    } else {
                        tempArr[temp] = k.p;
                    }
                    temp++;
                }
            }
            tempArr[temp] = arr2[i];
            int lowMulti = 0;
            for (int j = 0; j < tempArr.length; j++) {
                if (j + 1 < tempArr.length) {
                    if (tempArr[j] > tempArr[j + 1]) {
                        big = tempArr[j];
                        small = tempArr[j + 1];
                    } else {
                        big = tempArr[j + 1];
                        small = tempArr[j];
                    }
                    int multi = big * small;
                    LCM(big, small);
                    tempArr[j + 1] = multi / mod;
                }
            }
            int sum = tempArr[tempArr.length - 1];
            arr2[i] = sum;
            for (Node k : arr[i]) {
                int temp2 = 0;
                if (i == k.a) {
                    temp2 = sum / k.q;
                    arr2[k.b] *= (k.p * temp2);
                } else {
                    temp2 = sum / k.p;
                    arr2[k.a] *= (k.q * temp2);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr2[i] + " ");
        }
        ;


    }

    static void LCM(int big, int small) {
        mod = big % small;

        if (mod == 0) {
            mod = small;
            return;
        } else {
            LCM(small, mod);
        }
    }

    public static class Node {
        int index;
        int a;
        int b;
        int q;
        int p;

        public Node(int index, int a, int b, int q, int p) {
            this.index = index;
            this.a = a;
            this.b = b;
            this.q = q;
            this.p = p;
        }
    }
}
