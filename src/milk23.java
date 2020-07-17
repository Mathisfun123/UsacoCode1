/*
ID: sairaja
LANG: JAVA
TASK: milk2
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class milk23 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("milk2.in"));
        PrintWriter out = new PrintWriter(new File("milk2.out"));
        int numfarmers = sc.nextInt();
        sc.nextLine();
        int starttimes[] = new int[numfarmers];
        int endtimes[] = new int[numfarmers];
        ArrayList<Integer> possCoonsecTimes = new ArrayList<>();
        if (numfarmers == 0) {
            out.print("0 0");
            out.close();
        }
        if (numfarmers == 1) {
            for (int i = 0; i < numfarmers; i++) {
                starttimes[i] = sc.nextInt();
                endtimes[i] = sc.nextInt();
            }
            out.println(endtimes[0] - starttimes[0] + " 0");
            out.close();
        } else {
            for (int i = 0; i < numfarmers; i++) {
                starttimes[i] = sc.nextInt();
                endtimes[i] = sc.nextInt();
            }
            //Start Comparing consecutive
            int [] copystart1  = Arrays.copyOf(starttimes,starttimes.length);
            Arrays.sort(copystart1); HashMap<Integer,ArrayList<Integer>> getAvail = new HashMap<>(); ArrayList<Integer> g = new ArrayList<>();
            for (int i = 0; i < endtimes.length; i++) {
                int n = numfarmers - 1;
                while (copystart1[n] > endtimes[i]) {
                    n--;
                    if(getAvail.containsKey(endtimes[n])){
                        g.add(copystart1[i]);
                        getAvail.put(endtimes[n], g);
                    }else{
                        getAvail.put(copystart1[i],g);
                    }
                }
                Collections.sort(getAvail.get(0));
                //System.out.println(endtimes[n]);
                int val = endtimes[n] - getAvail.get(0).get(0);
                System.out.println(endtimes[n]+ " "+getAvail.get(0));
                possCoonsecTimes.add(val);
            }
            Collections.sort(possCoonsecTimes);
            out.print(possCoonsecTimes.get(possCoonsecTimes.size() - 1) + " ");
            //Start Comparing Idle
            ArrayList<Integer> idles = new ArrayList<>();
            HashMap<Integer, Integer> getEndBasedOnStart = new HashMap<>();
            for (int i = 0; i < starttimes.length; i++) {
                getEndBasedOnStart.put(starttimes[i], endtimes[i]);
            }
            int[] copyOfStarts = Arrays.copyOf(starttimes, starttimes.length);
            Arrays.sort(copyOfStarts);
            int extrtime = 0;
            for (int i = 0; i < copyOfStarts.length; i++) {
                //System.out.println(copyOfStarts[i] + " " + getEndBasedOnStart.get(copyOfStarts[i]));
            }
            for (int i = 0; i < copyOfStarts.length; i++) {
                for (int p = i + 1; p < copyOfStarts.length; p++) {
                    if (copyOfStarts[p] > copyOfStarts[i] && copyOfStarts[p] < getEndBasedOnStart.get(copyOfStarts[i]) && getEndBasedOnStart.get(copyOfStarts[p]) > copyOfStarts[i]) {
                        int temp = copyOfStarts[p];
                        copyOfStarts[p] = copyOfStarts[i];
                        getEndBasedOnStart.put(copyOfStarts[p], Math.max(getEndBasedOnStart.get(temp), getEndBasedOnStart.get((copyOfStarts[p]))));
                        //System.out.println("HI " + copyOfStarts[i] + " " + getEndBasedOnStart.get(copyOfStarts[i]));
                        //System.out.println("ByE " + copyOfStarts[p] + " " + getEndBasedOnStart.get(copyOfStarts[p]));
                        i++;
                    } else if (copyOfStarts[p] > getEndBasedOnStart.get(copyOfStarts[i])) {
                        //System.out.println(copyOfStarts[p] + " "+ getEndBasedOnStart.get(copyOfStarts[i]));
                        idles.add( copyOfStarts[p] - getEndBasedOnStart.get(copyOfStarts[p-1]));
                    } else {
                    }
                }
            }
            for (int i = 0; i < idles.size(); i++) {
                //System.out.println(idles.get(i));
                if(idles.get(i)>extrtime){
                    extrtime= idles.get(i);
                }
            }
            out.println(extrtime);
        }

        out.close();
    }}