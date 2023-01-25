package bootcampcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class FailPercent {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Solution Solution = new Solution();

        int N = Integer.parseInt(st.nextToken());
        int arr[];
        ArrayList<Integer> temp_arr = new ArrayList<>();

        st = new StringTokenizer(bf.readLine());

        while (st.hasMoreTokens()) {
            temp_arr.add(Integer.parseInt(st.nextToken()));
        }

        arr = new int[temp_arr.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp_arr.get(i);

        }

        arr = Solution.solution(N, arr);

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i] + " ");
        }


    }

}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float arr2[] = new float[N + 1];
        float arr3[] = new float[N + 1];
        Node arr4[] = new Node[N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i) {
                    arr2[i] = arr2[i] + 1;
                }
                if (stages[j] == i) {
                    arr3[i] = arr3[i] + 1;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            float temp = arr3[i] / arr2[i];
            arr4[i] = new Node(i, temp);
        }

        arr4[0] = new Node(0, 2);
        Arrays.sort(arr4, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.value < o2.value) return 1;
                else if (o1.value == o2.value) {
                    if (o1.index < o2.index) {
                        return 1;
                    } else return -1;
                } else return -1;
            }
        });

        for (int i = 0; i < N; i++) {
            answer[i] = arr4[i + 1].index;
        }

        return answer;
    }

    public class Node {
        int index;
        float value;

        public Node(int index, float value) {
            this.index = index;
            this.value = value;
        }
    }
}
