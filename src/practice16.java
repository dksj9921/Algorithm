import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class practice16 {
    //버블소트1
    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        mData arr[] = new mData[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new mData(i,Integer.parseInt(bf.readLine()));
        }

        Arrays.sort(arr);

        int MAX = 0;
        for(int i = 0; i < N; i++){
            if(MAX<arr[i].index-i) MAX = arr[i].index-i;
        }
        System.out.println(MAX+1);
    }
}


class mData implements Comparable<mData> {
    int index;
    int value;

    public mData(int index, int value){
        super();
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(mData inputIndex){
        return this.value - inputIndex.value;
    }

}


