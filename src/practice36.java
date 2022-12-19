import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice36 {

    public static void main(String Args[])throws NumberFormatException, IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(),"-");

        String firstString = st.nextToken();
        StringTokenizer first = new StringTokenizer(firstString,"+");

        int sum = 0;
        while(first.hasMoreTokens()){
            sum += Integer.parseInt(first.nextToken());
        }

        while(st.hasMoreTokens()){
            String tempString = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(tempString,"+");
            while(st2.hasMoreTokens()){
                sum-=Integer.parseInt(st2.nextToken());
            }
        }

        System.out.println(sum);;




    }
}
