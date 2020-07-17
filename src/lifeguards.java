import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class lifeguards {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("lifeguards.in"));
        PrintWriter out = new PrintWriter( new File("lifeguards.out"));
        int n = sc.nextInt();
        int startelements [] = new int[n];
        TreeMap<Integer,Integer> getEndBasedOnStart  = new TreeMap<>();
        for(int i = 0; i< n; i++){
            startelements[i]= sc.nextInt();
            getEndBasedOnStart.put(startelements[i], sc.nextInt());
        }
        ArrayList<Integer> actualItems = new ArrayList<>();
        TreeSet<Integer> posValues = new TreeSet<>();
        for(int i = 0; i< n; i++){
            for(int j= 0; j< i; j++){
                actualItems.add(startelements[j]);
            }
            for(int j = n-1; j> i ; j--){
                actualItems.add(startelements[j]);
            }
            int val = 0;
            Collections.sort(actualItems);
            int [] startAndEnd= new int[2];
            startAndEnd[0] = Integer.MAX_VALUE;
            for (int j = 0; j < actualItems.size(); j++) {
                int startTime= actualItems.get(j);
                int end = getEndBasedOnStart.get(startTime);
                //System.out.println(end);
                val+=(end-startTime) - overlap(startTime,end, startAndEnd[0],startAndEnd[1]);
                startAndEnd[0] = Math.min(startAndEnd[0],startTime);
                startAndEnd[1]= Math.max(end, startAndEnd[1]);
               // System.out.println(startAndEnd[0]+ " "+ startAndEnd[1]);
            }
            posValues.add(val);
            actualItems.clear();
        }
       out.println(posValues.pollLast());
        out.close();

    }
    public static int overlap(int start1, int end1, int start2, int end2){
        if(start2 > start1 && end1< end2){
            return end2-end1;
        }
        if(start1<start2 && end1>start2){
            return end1-start2;
        }else if(start1>start2 && end2>start1){
            return  end2-start1;
        }
        return 0;
    }
}
