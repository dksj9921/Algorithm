package Do_It_Algorithm_Coding_Test;//import javax.swing.plaf.IconUIResource;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Do_It_Algorithm_Coding_Test.practice44 {
//
//    static int mod, q, p;
//    static ArrayList<Node> arr[];
//    static boolean visited[];
//    static int arr2[];
//
//    public static void main(String[] args) throws NumberFormatException, IOException {
//
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(bf.readLine());
//        StringTokenizer st;
//
//        arr = new ArrayList[N];
//        visited = new boolean[N - 1];
//        arr2 = new int[N];
//
//        int least_Multiple = 0;
//
//
//        int checkPoint = 0;
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = new ArrayList<>();
//            arr2[i] = 1;
//        }
//        int small;
//        int big;
//
//        for (int i = 0; i < N - 1; i++) {
//            st = new StringTokenizer(bf.readLine());
//
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int q = Integer.parseInt(st.nextToken());
//            int p = Integer.parseInt(st.nextToken());
//
//            if (q < p) {
//                small = q;
//                big = p;
//            } else {
//                small = p;
//                big = q;
//            }
//
//            LCM(big, small);
//            q /= mod;
//            p /= mod;
//
//            arr[a].add(new Node(i, a, b, q, p));
//            arr[b].add(new Node(i, a, b, q, p));
//        }
//
//        Queue<Integer> myQueue = new LinkedList<>();
//        boolean check_Input[] = new boolean[N];
//        boolean check_First = false;
//        int temp = 0;
//        for (int z = 0; z < N; z++) {
//            int i = z;
//            int tempArr[] = new int[arr[i].size() + 1];
//            if (arr[i].size() > 1) {
//
//                for (int j = 0; j < tempArr.length; j++) {
//                    tempArr[j] = 1;
//                }
//                temp = 0;
//                boolean check = false;
//                for (Node k : arr[i]) {
//                    if (!visited[k.index]) {
//                        check = true;
//                        if (i == k.a) {
//                            tempArr[temp] = k.q;
//                        } else {
//                            tempArr[temp] = k.p;
//                        }
//                        temp++;
//                    }
//                }
//                if (check) {
//                    tempArr[temp] = arr2[i];
//                    int lowMulti = 0;
//                    for (int j = 0; j < tempArr.length; j++) {
//                        if (j + 1 < tempArr.length) {
//                            if (tempArr[j] > tempArr[j + 1]) {
//                                big = tempArr[j];
//                                small = tempArr[j + 1];
//                            } else {
//                                big = tempArr[j + 1];
//                                small = tempArr[j];
//                            }
//                            int multi = big * small;
//                            LCM(big, small);
//                            tempArr[j + 1] = multi / mod;
//                        }
//                    }
//                    int sum = tempArr[tempArr.length - 1];
//
//                    for (Node k : arr[i]) {
//                        int temp2 = 0;
//                        if (!visited[k.index]) {
//                            visited[k.index] = true;
//                            if (i == k.a) {
//                                temp2 = sum / k.q;
//                                arr2[k.b] *= (k.p * temp2);
//                                check_Input[k.b] = true;
//                                if (check_First) {
//                                    for (int j = 0; j < N; j++) {
//                                        if ((check_Input[j]) && j != k.b)
//                                            arr2[j] *= (sum / arr2[i]);
//                                    }
//                                }
//                            } else {
//                                temp2 = sum / k.p;
//                                arr2[k.a] *= (k.q * temp2);
//                                check_Input[k.a] = true;
//                                if (check_First) {
//                                    for (int j = 0; j < N; j++) {
//                                        if ((check_Input[j]) && j != k.a)
//                                            arr2[j] *= (sum / arr2[i]);
//                                    }
//                                }
//
//                            }
//                        }
//                    }
//                    arr2[i] = sum;
//                    check_Input[i] = true;
//                }
//                check_First = true;
//            }
//        }
//        for (int i = 0; i < N; i++) {
//            System.out.print(arr2[i] + " ");
//        }
//
//
//
//    }
//
//    static void LCM(int big, int small) {
//        mod = big % small;
//
//        if (mod == 0) {
//            mod = small;
//            return;
//        } else {
//            LCM(small, mod);
//        }
//    }
//
//    public static class Node {
//        int index;
//        int a;
//        int b;
//        int q;
//        int p;
//
//        public Node(int index, int a, int b, int q, int p) {
//            this.index = index;
//            this.a = a;
//            this.b = b;
//            this.q = q;
//            this.p = p;
//        }
//    }
//}

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class practice44 {
    static ArrayList<cNode>[] A;
    static long lcm;
    static boolean visited[];
    static long D[];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<cNode>();
        }
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        for (int i = 0; i < N; i++) {
            System.out.print(D[i] / mgcd + " ");
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void DFS(int node) {
        visited[node] = true;
        for (cNode i : A[node]) {
            int next = i.getB();
            if (!visited[next]) {
                D[next] = D[node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }
}

class cNode {
    int b;
    int p;
    int q;

    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}
