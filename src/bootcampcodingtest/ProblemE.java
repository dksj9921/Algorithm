import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemE {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(bf.readLine());

        for (int i = 1; i < N + 1; i++) {
            sb.append(i+"\n");
            Hanoi(i, 1, 2, 3);
        }

        System.out.println(sb);
    }

    public static void Hanoi(int N, int start, int mid, int to) {

        if (N == 1) {
            sb.append(N+" "+start + " " + to + "\n");
            return;
        }

        Hanoi(N - 1, start, to, mid);


        sb.append(N+" "+start + " " + to + "\n");


        Hanoi(N - 1, mid, start, to);

    }
}

