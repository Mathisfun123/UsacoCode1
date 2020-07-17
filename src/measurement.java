/*
ID: sairaja
LANG: JAVA
TASK: measurement
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class measurement {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(new File("measurement.in"));
        PrintWriter pw = new PrintWriter(new File("measurement.out"));
        int numchanges = 0;int max = 0;
        HashMap<String,Integer> accessAMtfromname= new HashMap<>(); String top = null;
        int n = sc.nextInt();sc.nextLine(); int [] days= new int[n];
        String rem[]= new String[n];
        HashSet<String > names = new HashSet<>();
        HashMap<Integer,String> accessnameandchangefromday = new HashMap<>();
        for(int p = 0; p< n; p++){
            int day = sc.nextInt();
            days[p]=day;
            String left = sc.nextLine();
            rem[p]= left;
            accessnameandchangefromday.put(day,left);
            //System.out.println(left);
            String name = left.split(" ")[1];

            boolean condition = true;
            for (int i = 0; i < names.size(); i++) {
                //System.out.println(names +name);
                if(names.contains(name)){
                    condition=false;// System.out.println(nameputsofar.get(i) + "MEME");
                }

            }names.add(name);
            if(condition){
            accessAMtfromname.put(name,7);}

        }
        Arrays.sort(days);
        for(int lmap = 0; lmap<days.length;lmap++){
            String full = accessnameandchangefromday.get(days[lmap]);
            String nameandchange [] = full.split(" ");
            //MUST BE 1 AND 2
            String nametoget= nameandchange[1];
            if(nameandchange[2].substring(0,1).equals("+")){
                int valtochange = Integer.parseInt(nameandchange[2].substring(1));
               // System.out.println(valtochange);
                accessAMtfromname.put(nametoget,accessAMtfromname.get(nametoget)+valtochange);
                //System.out.println(nametoget+ " MEME " + accessAMtfromname.get(nametoget));

                for (int i = 0; i < days.length; i++) {
                    String nametochecker = accessnameandchangefromday.get(days[i]).split(" ")[1];
                    if(top==null || !(nametochecker).equals(top)){
                        if(accessAMtfromname.get(nametochecker)>max){
                            //System.out.println(nametochecker+" "+accessAMtfromname.get(nametochecker));
                            max = accessAMtfromname.get(nametochecker);
                            top = nametochecker;
                            //System.out.println(max+ " "+ accessnameandchangefromday.get(days[i]));
                            numchanges++;
                        }

                    }
                }


            }else{
                int valtochange = Integer.parseInt(nameandchange[2].substring(1));
                valtochange*=-1;
                accessAMtfromname.put(nametoget,accessAMtfromname.get(nametoget)+valtochange);
               // System.out.println(nametoget+ " MEME " + accessAMtfromname.get(nametoget));
                HashMap<Integer,String> getNamefromVal = new HashMap<>();
                if(nametoget.equals(top)){
                    numchanges++;
                    max=0;
                    for (int i = 0; i < days.length; i++) {
                       String name = accessnameandchangefromday.get(days[i]).split(" ")[1];
                       int amt = accessAMtfromname.get(name);

                        if(amt>max && !(name.equals(top))){
                            getNamefromVal.put(amt,name);max=amt;}
                    }
                    top = getNamefromVal.get(max);
                }

            }
        }
        //System.out.println(names.size());
        pw.println(numchanges);
        pw.close();
        //Integer.parseInt(str.substring(1));
    }
}
