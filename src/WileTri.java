import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WileTri {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("wiletri.dat"));
        int n = scan.nextInt();
        while(n-->0){
       // System.out.println("Enter intial 3 numbers of a triangle");
        int first=scan.nextInt();
        int second=scan.nextInt();
        int third=scan.nextInt();
        int tri[][] = new int[16][31];
        tri[1][15] = first;
        tri[2][14] = second;
        tri[2][16] = third;
        for(int i=3;i<=15;i++)
        {
            int count = i;
            for(int j=15-(count-1);j<30;j++)
            {
                tri[i][j] = tri[i-1][j-1]+tri[i-1][j+1]+tri[i-2][j];
                j++;
            }
            count++;
        }
        //Uncomment to Print triangle values
		/*for(int i = 1; i<=15;i++)
		{
			for(int j = 1; j<=30;j++)
				System.out.print(tri[i][j]+",");
			System.out.println();
		}*/

       // System.out.println("Enter no. of pairs");
        int pairs = scan.nextInt();
        int a[][] = new int[pairs+1][pairs+1];
        for(int i=1;i<=pairs;i++)
        {
           // System.out.println("Enter pairs "+i);
            a[i][0] = scan.nextInt();
            a[i][1] = scan.nextInt();

        }
       // System.out.println("Output for each pair");
        for(int i=1;i<=pairs;i++)
        {
            System.out.print("Element "+a[i][0]+" "+a[i][1]+":"  );
            int row = a[i][0];
            int column = 15-(a[i][0]-1)+((a[i][1]*2)-2);
            System.out.println(tri[row][column]);
        }
    }}

}
