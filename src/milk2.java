/*
ID: sairaja
LANG: JAVA
TASK: milk2
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.*;

public class milk2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner( new File("milk2.in"));
        PrintWriter out = new PrintWriter( new File("milk2.out"));
        int numtests = sc.nextInt();
        sc.nextLine();
        int [] starttimes = new int[numtests];
        TreeMap<Integer,Integer> getEndtimeBasedOnStart = new TreeMap<>();
        for(int p = 0; p< numtests; p++){
            starttimes[p]= sc.nextInt();
            getEndtimeBasedOnStart.put(starttimes[p], sc.nextInt());
        }
        Arrays.sort(starttimes);
        HashMap <Integer,Integer> getExtraMax = new HashMap<>();
        ArrayList <Integer> IdleTimes = new ArrayList<>();
        ArrayList <Integer> POsstimes = new ArrayList<>();
        for(int p = 1; p< starttimes.length;p++){
            if(starttimes[p]< getEndtimeBasedOnStart.get(starttimes[p-1])){
                int maxTime = Math.max(getEndtimeBasedOnStart.get(starttimes[p]),getEndtimeBasedOnStart.get(starttimes[p-1]));
                int startMin = Math.min(starttimes[p],starttimes[p-1]);
                starttimes[p]= startMin; starttimes[p-1] = startMin;
                getEndtimeBasedOnStart.put(startMin,maxTime);
                /*System.out.println(starttimes[p-1]+ " "+ getEndtimeBasedOnStart.get(starttimes[p-1]));
                System.out.println("Hello " + starttimes[p]+ " "+ getEndtimeBasedOnStart.get(starttimes[p]));*/
            }else if(starttimes[p]> getEndtimeBasedOnStart.get(starttimes[p-1])){
                //System.out.println(starttimes[p]+ " " + getEndtimeBasedOnStart.get(starttimes[p-1]));
               // System.out.println("1: "+ (getEndtimeBasedOnStart.get(starttimes[p])-starttimes[p]));
                //System.out.println(starttimes[p-1]);
                //System.out.println("2: "+ (getEndtimeBasedOnStart.get(starttimes[p-1])-starttimes[p-1]));
                IdleTimes.add(starttimes[p]- getEndtimeBasedOnStart.get(starttimes[p-1]));
                POsstimes.add(getEndtimeBasedOnStart.get(starttimes[p])-starttimes[p]); //POsstimes.add(getEndtimeBasedOnStart.get(starttimes[p-1])-starttimes[p-1]);
                int endTime = Math.max(getEndtimeBasedOnStart.get(starttimes[p]),getEndtimeBasedOnStart.get(starttimes[p-1]));

                starttimes[p]= Math.min(starttimes[p],starttimes[p-1]);
                //System.out.println(getEndtimeBasedOnStart.get(starttimes[p])+" "+getEndtimeBasedOnStart.get(starttimes[p-1]));
                getEndtimeBasedOnStart.put(starttimes[p], endTime);
            }else if(starttimes[p]==getEndtimeBasedOnStart.get(starttimes[p-1])){
                //System.out.println(starttimes[p-1] +" "+ getEndtimeBasedOnStart.get(starttimes[p-1])+" "+  starttimes[p] + " " + getEndtimeBasedOnStart.get(starttimes[p]));
                getExtraMax.put(starttimes[p],Integer.MAX_VALUE);
                if(getExtraMax.containsKey(starttimes[p-1])){
                    getExtraMax.put( starttimes[p], Math.min(getExtraMax.get(starttimes[p]),starttimes[p-1]));
                }else{
                    getExtraMax.put(starttimes[p],starttimes[p-1]);
                }
                 int amt = starttimes[p];
                while(getExtraMax.containsKey(amt)){
                    amt= getExtraMax.get(amt);
                }
                //System.out.println(getEndtimeBasedOnStart.get(starttimes[p]));
                POsstimes.add(getEndtimeBasedOnStart.get(starttimes[p])-amt);
            }
        }
        if(!POsstimes.isEmpty()){
            Collections.sort(POsstimes);
            out.print(POsstimes.get(POsstimes.size()-1)+" ");
        }else{
            out.print(getEndtimeBasedOnStart.get(starttimes[starttimes.length-1])-starttimes[starttimes.length-1] + " ");
        }
        if(!IdleTimes.isEmpty()){
            Collections.sort(IdleTimes);
            out.println(IdleTimes.get(IdleTimes.size()-1));
        }else{
            out.println(0);
        }
        out.close();
    }

}
