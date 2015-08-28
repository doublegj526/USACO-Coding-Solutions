/*
ID: jgee1
LANG: JAVA
TASK: crypt1
*/
//package crypt1;

import java.io.*;
import java.util.*;

class crypt1 {
   public static int count;
   public static ArrayList<Character> arr;
   public static PrintWriter out;
   public static HashMap<Character, Boolean> dict;
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        dict = new HashMap<Character, Boolean>();
        int n = Integer.parseInt(nstr.nextToken());
        arr = new ArrayList<Character>();
        nstr = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            String s = nstr.nextToken();
            arr.add(s.charAt(0));
            dict.put(s.charAt(0),true);
        }
        count = 0;
        buildInts("     ",0);
        out.println(count);
        out.close();                                 
        System.exit(0);                            
    }
    public static void buildInts(String s, int index){
        if(index == 5){
            checkInts(s);
        }
        else{
            char[] c = s.toCharArray();
            for(int i = 0; i < arr.size(); i++){
                c[index] = arr.get(i);
                buildInts(String.valueOf(c), index + 1);
            }
        }
    }
    public static void checkInts(String s){
        char[] sarr = s.toCharArray();
        int a = Integer.parseInt("" + sarr[0] + sarr[1] + sarr[2]);
        int b = Integer.parseInt("" + sarr[3] + sarr[4]);
        int prod1 = a * (sarr[3] - 48);
        int prod2 = a * (sarr[4] - 48);
        int prod = a * b;
        if(prod1 < 100 || prod1 > 999 || prod2 < 100 || prod2 > 999 || prod < 1000 || prod > 9999){
            
        }
        else{
            String prod1str = "" + prod1;
            String prod2str = "" + prod2;
            String prodstr = "" + prod;
            if(dict.containsKey(prod1str.charAt(0)) && dict.containsKey(prod1str.charAt(1)) && dict.containsKey(prod1str.charAt(2)) && dict.containsKey(prod2str.charAt(0)) && dict.containsKey(prod2str.charAt(1)) && dict.containsKey(prod2str.charAt(2)) && dict.containsKey(prodstr.charAt(0)) && dict.containsKey(prodstr.charAt(1)) && dict.containsKey(prodstr.charAt(2)) && dict.containsKey(prodstr.charAt(3))){
                count++;
            }
        }
    }
}