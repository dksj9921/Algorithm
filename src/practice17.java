import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class practice17 {
    public static void main(String Args[]) throws NumberFormatException, IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        ArrayList<Integer> arr = new ArrayList<>();

        String tempSt = bf.readLine();

        for(int z =0; z<tempSt.length();z++){
            arr.add(Character.getNumericValue(tempSt.charAt(z)));
        }


        int i=0,j=0,Max=0,temp2=0,temp=0;
        while(i<arr.size()){
            Max = 0;
            while(j<arr.size()){

                if(arr.get(j)>Max) {
                    Max = arr.get(j);
                    temp2 = j;
                }
                if(Max ==0) temp2=i;
                j++;
            }
            temp = arr.get(i);
            arr.set(i,Max);
            arr.set(temp2,temp);
            i++;
            j = i;
        }
        for(int k =0; k<arr.size();k++){
            System.out.print(arr.get(k));
        }
        bf.close();
    }
}
