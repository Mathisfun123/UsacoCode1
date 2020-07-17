import static java.lang.System.*;
import static java.lang.Math.*;
import java.io.*;
import java.util.*;
public class WileTri2
{
    public static void main(String [] args) throws IOException
    {
        Scanner f = new Scanner(new File("wiletri.dat"));
        int n = f.nextInt();
        f.nextLine();
        while(n-- >0)
        {
            int[][]grid=new int[16][16];
            grid[1][1]=f.nextInt();
            grid[2][1]=f.nextInt();
            grid[2][2]=f.nextInt();
            int row = 3;
            int col = 1;
            for(int x=3;x<=15*14/2;x++)
            {
//				out.println(row+" "+col+" "+x);
                grid[row][col]=grid[row-1][col]+grid[row-1][col-1]+grid[row-2][col-1];
                col++;
                if(col>row)
                {
                    col=1;
                    row++;
                }
            }
//			for(int r=1;r<15;r++)
//			{
//				for(int c=1;c<=r;c++)
//					out.print(grid[r][c]+" ");
//				out.println();
//			}
            int p = f.nextInt();
            while(p-->0)
            {
                int r=f.nextInt();
                int c=f.nextInt();
                out.println("Element "+r+" "+c+" :"+grid[r][c]);
            }
            out.println();
        }
    }
}