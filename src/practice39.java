import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class practice39 {

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        boolean arr[] = new boolean[1004001];

        arr[0] = arr[1] = true;
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i]) continue;
            for (int k = i + i; k < arr.length; k += i) {
                arr[k] = true;
            }
        }
        int answer = 0;
        for (int i = N; i < arr.length; i++) {
            if (!arr[i]) {
                if (!isPelindrom(i)) {
                    answer = i;
                    break;
                }
            }
        }
        if (answer != 0) System.out.print(answer);
    }

    public static boolean isPelindrom(int input) {
        boolean isPelindrom = false;

        char[] chars = ("" + input).toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            } else {
                isPelindrom = true;
                break;
            }
        }

        return isPelindrom;
    }
}
