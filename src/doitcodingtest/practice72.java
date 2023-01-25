package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice72 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int length = N;
        int treeHeight = 0;

        while (length > 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);

        int tree[] = new int[treeSize];
        int startNode = treeSize / 2;

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(bf.readLine());
            tree[startNode + i] = temp;
        }

        for (int i = startNode + N; i < treeSize; i++) {
            tree[i] = Integer.MAX_VALUE;
        }

        for (int i = startNode - 1; i > 0; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            start = startNode + start - 1;
            end = startNode + end - 1;

            int min = Integer.MAX_VALUE;
            while (start <= end) {
                if (start % 2 == 1) {
                    if(min > tree[start]){
                        min = tree[start];
                    }
                    start++;
                }

                if (end % 2 == 0) {
                    if (min > tree[end]) {
                        min = tree[end];
                    }
                    end --;
                }
                start /= 2;
                end /= 2;
            }

            System.out.println(min);
        }
    }
}
