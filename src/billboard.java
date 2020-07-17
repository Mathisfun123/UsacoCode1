import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class billboard {
    public static void main(String[] args)throws IOException {
        Scanner sc= new Scanner(new File("billboard.in"));
        PrintWriter pw = new PrintWriter(new File("billboard.out"));
        int lx1 = sc.nextInt(); int ly1 = sc.nextInt(); int lx2 = sc.nextInt(); int ly2 = sc.nextInt();
        int cx1 = sc.nextInt(); int cy1 = sc.nextInt(); int cx2 = sc.nextInt(); int cy2 = sc.nextInt();
        pw.println(notCovered(lx1,ly1,lx2,ly2,cx1,cy1,cx2,cy2));
        pw.close();

    }
    public static int areaUnassuming(int x1, int y1, int x2, int y2){
        return (y2-y1) * (x2-x1);
    }
    public static int notCovered(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        int area= areaUnassuming(x1,y1,x2,y2);
        return  area;
    }

}
