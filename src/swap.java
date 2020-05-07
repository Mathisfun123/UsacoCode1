import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class swap {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("swap.in"));
        int n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i< n; i++){
            arr[i] = i;
        }
        //try out one manipulation
        int m = sc.nextInt(); int k = sc.nextInt();
        for(int i = 0; i< m; i++){
            int a = sc.nextInt()-1; int b = sc.nextInt()-1;
            for(int j = a; j<= (b-a)/2 + a ; j++){
                int temp = arr[j];
                arr[j] = arr[b-(j-a)];
                arr[b-(j-a)] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
