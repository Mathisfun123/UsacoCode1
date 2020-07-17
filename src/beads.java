/*
ID: sairaja
LANG: JAVA
TASK: beads
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class beads {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("beads.in"));
        PrintWriter out = new PrintWriter(new File("beads.out"));
        int n = sc.nextInt();
        sc.nextLine();
        String bead = sc.nextLine();
        bead+=bead;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> sg = new ArrayList<>();
        boolean checknotallw = true;
        for (int i = 0; i < bead.length(); i++) {
           if(bead.charAt(i)!='w'){
               checknotallw =false;
           }
        }
        if(!checknotallw){
        for(int p =1; p< bead.length();p++){
            String beg = bead.substring(0,p);
            String end = bead.substring(p);
            //System.out.println(beg + " "+ end);
            //STart beg part
            String check = beg.substring(beg.length()-1);
            int beglength =0;


            if(check.equals("w")){
                beglength++;
                int lmoa = 1;
                while(beg.length()-lmoa>0 &&beg.substring(beg.length()-lmoa,(beg.length()-lmoa)+1).equals("w")){ beglength++;
                    lmoa++;
                }
                //System.out.println("MEME " + beg.substring(beg.length()-lmoa,(beg.length()-lmoa)+1) + " HELLO DARK "+ beglength);
                if(!(beg.substring(beg.length()-lmoa,(beg.length()-lmoa)+1)).equals("w")){
                    check = beg.substring(beg.length()-lmoa,beg.length()-lmoa+1);
                  //  System.out.println(beg+ " hi "+ end);
                   // System.out.println(beg.substring(beg.length()-lmoa,(beg.length()-lmoa)+1) + " "+ beglength);
                  //  System.out.println((beg.length()-lmoa) + " "+check);
                    int magik = (beg.length()-lmoa -1 );
                    while(magik>=0 && (beg.substring(magik,magik+1).equals(check)||beg.substring(magik,magik+1).equals("w") )){
                        magik--;
                        beglength++;
                    }


                }
            }else{
                beglength++;
                int lmoa= beg.length()-1;
                while(lmoa>0&&(beg.substring(lmoa-1,lmoa).equals("w")||beg.substring(lmoa-1,lmoa).equals(check))){
                    lmoa--; beglength++;
                }
            }
            //System.out.println(beg+ " hi "+ end);
           // System.out.println(beglength);
            //end beg start end part
            int endlength =1;
            String firstletter = end.substring(0,1);
            int attempt= 0; anirudh:
            if(firstletter.equals("w")){
                while(attempt<end.length() && end.substring(attempt,attempt+1).equals("w")){
                    endlength++;
                    attempt++;
                }
                boolean conditionallwagain = true;
                for(int counter = 0; counter<end.length();counter++){
                    if(end.charAt(counter)!='w'){
                        conditionallwagain =false;
                    }
                }
                if(!conditionallwagain) {
                    firstletter = end.substring(attempt, attempt + 1);
                    attempt++;

                    while (attempt < end.length() && (end.substring(attempt, attempt + 1).equals("w") || end.substring(attempt, attempt + 1).equals(firstletter))) {
                        attempt++;
                        endlength++;
                    }
                    //System.out.println(firstletter+ " "+ endlength+ " MEME "+ attempt);
                }
            }else{
                endlength=0;
                while(attempt<end.length()&&(end.substring(attempt,attempt+1).equals("w")||end.substring(attempt,attempt+1).equals(firstletter))){
                    attempt++; endlength++;
                }
               // System.out.println(attempt + " NICE TRY"+ endlength);

            }
            int lengthtotal = beglength+endlength;
            sg.add(lengthtotal);
        }
        Collections.sort(sg);
        out.println(Math.min(sg.get(sg.size()-1),(bead.length()/2)));
        out.close();
    }else{
            out.println(n);
            out.close();
        }
    }
}
