import java.util.Scanner;

public class practice1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String input;
        int sum=0,size=0;

        size = scanner.nextInt();
        input = scanner.next();



        for(int i =0; i<input.length();i++){
            sum+=input.charAt(i);
        }
    }
}
