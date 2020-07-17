import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.*;

public class RandomCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 1;
        loop:
        while(n<=3){
            String s = input.nextLine();
            if(s.equals("Christmas")|| s.equals("New Year")){
                break;
            }
            n++;
        }
    }
}
