import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class practice43_1 {
    static List<Node> arr[];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (N == 0 && k == 0) {
                break;
            }

            for(int i = 0; i< N; i++){
                int temp = Integer.parseInt(st.nextToken());

            }




        }


    }

    public static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
