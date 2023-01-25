package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice58 {
    //k번째 최소거리 -> 현재 기량부족으로 코드를봐도 완벽하게 로직이 이해가 안됨. 나중에 풀어보기
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Node> arr[] = new List[n + 1];
        Queue<Node> myQueue = new LinkedList<>();
        int weight_Arr[] = new int[n + 1];


        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr[start].add(new Node(end, weight));
        }



        System.out.println(sb);
    }

    public static class Node {
        int index, value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
