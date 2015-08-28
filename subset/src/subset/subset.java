/*
ID: jgee1
LANG: JAVA
TASK: subset
*/
//package subset;

import java.io.*;
import java.util.*;
import java.math.*;

class subset{
    public static HashMap<Integer, Integer> numOfWays;
    public static int n;
    public static PrintWriter out;
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        n = Integer.parseInt(nstr.nextToken());
        numOfWays = new HashMap<Integer,Integer>();
        numOfWays.put(1,1);
        for(int i = 2; i <= n; i++){
            include(i);
        }
        if(numOfWays.get(0) != null)
            out.println(numOfWays.get(0));
        else{
            out.println(0);
        }
        out.close();
        System.exit(0);
    }
    public static void include(int i){
        Set<Integer> set = numOfWays.keySet();
        Iterator<Integer> it = set.iterator();
        HashMap<Integer,Integer> numOfWays2 = new HashMap<Integer,Integer>();
        while(it.hasNext()){
            int temp = it.next();
            if(numOfWays2.get(temp + i) == null){
                numOfWays2.put(temp + i, numOfWays.get(temp));
            }
            else{
                numOfWays2.put(temp + i, numOfWays.get(temp) + numOfWays2.get(temp + i));
            }
            //out.println(numOfWays2.get(temp+i));
            if(numOfWays2.get(temp - i) == null){
                numOfWays2.put(temp - i, numOfWays.get(temp));
            }
            else{
                numOfWays2.put(temp - i, numOfWays.get(temp) + numOfWays2.get(temp - i));
            }
            //out.println(numOfWays2.get(temp-i));
        }
        numOfWays = numOfWays2;
    }
}