import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemC {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Tile list[];
        List<Tile> arr[];
        int arr_Count[];
        Queue<Tile> myQueue = new LinkedList<>();

        int T = Integer.parseInt(bf.readLine());

        for (int repeat = 0; repeat < T; repeat++) {
            int count = Integer.parseInt(bf.readLine());
            list = new Tile[count];
            arr = new List[count];
            arr_Count = new int[count];

            for (int i = 0; i < count; i++) {
                arr[i] = new ArrayList<>();
            }


            for (int i = 0; i < count; i++) {

                st = new StringTokenizer(bf.readLine());

                int temp1 = Integer.parseInt(st.nextToken());
                int temp2 = Integer.parseInt(st.nextToken());

                list[i] = new Tile(i, Math.max(temp1, temp2), Math.min(temp1, temp2));
            }

            Arrays.sort(list, Collections.reverseOrder());

            for (int i = 0; i < count; i++) {
                list[i].index = i;
            }

            for (int i = 0; i < count; i++) {
                for (int j = i + 1; j < count; j++) {
                    if (list[i].small >= list[j].small) {
                        arr[i].add(list[j]);
                    }
                }
            }

            for (int i = 0; i < count; i++) {
                myQueue.add(new Tile(i,0,0));
                while (!myQueue.isEmpty()) {
                    int node = myQueue.poll().index;

                    for (Tile k : arr[node]) {
                        myQueue.add(k);
                        if (arr_Count[k.index] < arr_Count[node] + 1) {
                            arr_Count[k.index] = arr_Count[node] + 1;
                        }
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < count; i++) {
                if (max < arr_Count[i]) max = arr_Count[i];
            }

            System.out.println(max+1);


        }
    }

    public static class Tile implements Comparable<Tile> {
        int index;
        int big;
        int small;

        public Tile(int index, int big, int small) {
            this.index = index;
            this.big = big;
            this.small = small;
        }

        @Override
        public int compareTo(Tile input) {
            if (this.big > input.big) {
                return 1;
            } else if (this.big < input.big) {
                return -1;
            } else {
                if (this.small >= input.small) {
                    return 1;
                } else return -1;
            }
        }
    }
}

