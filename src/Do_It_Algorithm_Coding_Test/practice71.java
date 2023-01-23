package Do_It_Algorithm_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice71 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int lenght = N;
        while (lenght != 0) {
            lenght /= 2;
            treeHeight++;
        }
//        System.out.println(treeHeight);
        int treeSize = (int)Math.pow(2, (treeHeight + 1));
//        System.out.println(treeSize);

        long tree[] = new long[treeSize];

        int startNode = treeSize / 2;

        for (int i = 0; i < N; i++) {
            tree[startNode + i] = Long.parseLong(bf.readLine());
        }

        for (int i = treeSize/2 - 1; i >= 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        int mCount = 0;
        int kCount = 0;
        while (mCount != M || kCount != K) {
            st = new StringTokenizer(bf.readLine());

            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (check == 1) {
                mCount ++;
                int startPoint = a + startNode - 1;
                long diff = tree[startPoint] - b;
                for (int i = 0; i < treeHeight; i++) {
                    int temp = (int)Math.pow(2,i);
                    tree[startPoint/temp] = tree[startPoint/temp] - diff;
                }
            }

            if (check == 2) {
                kCount++;
                int startPoint = a + startNode - 1;
                int endPoint = (int)b + startNode - 1;
                long sum = 0;

                while (startPoint <= endPoint) {
                    if (startPoint % 2 == 1) {
                        sum = sum + tree[startPoint];
                        startPoint++;
                    }
                    if (endPoint % 2 == 0) {
                        sum = sum + tree[endPoint];
                        endPoint--;
                    }

                    startPoint /= 2;
                    endPoint /= 2;
                }

                System.out.println(sum);
            }
        }



//        for (int i = 0; i < M + K; i++) {
//            st = new StringTokenizer(bf.readLine());
//        }
//
//        for (int i = 0; i < treeSize; i++) {
//            System.out.print(tree[i] + " ");
//        }

    }
}
