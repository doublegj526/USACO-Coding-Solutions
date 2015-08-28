/*
ID: jgee1
LANG: JAVA
TASK: zerosum
*/
//package zerosum;

import java.io.*;
import java.util.*;
import java.math.*;

class zerosum{
    public static PrintWriter out;
    public static ArrayList<String> arrs;
    public static int n;
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        n = Integer.parseInt(nstr.nextToken());
        arrs = new ArrayList<String>();
        generateStrings("1",1,2,true,1);
        Collections.sort(arrs);
        for(int i = 0; i < arrs.size(); i++){
            out.println(arrs.get(i));
        }
        out.close();
        System.exit(0);
    }
    
    // sum is cumulative sum
    // index is the number you are on
    public static void generateStrings(String s, int sum, int index, boolean add,int added){
        if(index == (n+1)){
            //out.println(s);
            if(sum == 0){
                //out.println(s + " " + sum + " " + index);
                arrs.add(s);
            }
            else{
                return;
            }
        }
        else{
            String s1 = s + "+" + index;
            generateStrings(s1, sum + index, index + 1,true,index);
            String s2 = s + "-" + index;
            generateStrings(s2, sum - index, index + 1,false,index);
            String s3 = s + " " + index;
            if(add)
                generateStrings(s3, sum - added + (10*(added) + index), index + 1,add, (10*(added) + index));
            else
                generateStrings(s3, sum + added - (10*(added) + index), index + 1,add, (10*(added) + index));
        }
    }
}