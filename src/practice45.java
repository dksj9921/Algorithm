import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice45 {
    static int mod, X, Y;

    public static void main(String[] Args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        LCM(A, B);

        if (C % mod != 0) {
            System.out.println("-1");
            System.exit(0);
        } else {
            X = X * (C / mod);
            Y = Y * (C / mod);
        }

        System.out.println(X + " " + Y);
    }

    public static void LCM(int big, int small) {
        int moke = 0;

        mod = big % small;
        moke = big / small;

        if (mod == 0) {
            X = 1;
            Y = 0;
            mod = small;
        }else LCM(small, mod);

        int last_X = X;
        int last_Y = Y;
        X = last_Y;
        Y = last_X - (last_Y * moke);
    }
}
