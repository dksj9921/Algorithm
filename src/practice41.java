import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class practice41 {
    static ArrayList<Character> RightArr;
    static ArrayList<Character> unRightArr;

    public static void main(String Args[])throws NumberFormatException, IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for(int i = 0; i<N; i++){
            char[] Right = bf.readLine().toCharArray();
            char[] unRight = bf.readLine().toCharArray();


            int count = 1;

            int RightPointer = 0;
            int unRightPointer = 0;
            for(int k = 0; k< Right.length; k++){
                int temp = Right[k];
                if(temp==Right[k+1]) {
                    RightPointer++;
                    continue;
                }
                for(int j = unRightPointer; j<RightPointer; j++){
                }

            }

        }
    }


}
