/*
ID: jgee1
LANG: JAVA
TASK: milk3
*/
//package milk3;

import java.io.*;
import java.util.*;
import java.math.*;

class milk3 {
   public static HashSet<Integer> possibleCValues;
   public static int amax;
   public static int bmax;
   public static int cmax;
   public static HashMap<Integer, Boolean> map;
   public static PrintWriter out;
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        amax = Integer.parseInt(nstr.nextToken());
        bmax = Integer.parseInt(nstr.nextToken());
        cmax = Integer.parseInt(nstr.nextToken());
        map = new HashMap<Integer, Boolean>();
        possibleCValues = new HashSet<Integer>();
        for(int i = 0; i <= amax; i++){
            for(int j = 0; j <= bmax; j++){
                for(int k = 0; k <= cmax; k++){
                    int temp = 10000 * i + 100 * j + k;
                    //out.println(temp);
                    map.put(temp,false);
                }
            }
        }
        HashMap<Integer,Boolean> printedValues = new HashMap<Integer,Boolean>();
        //possibleCValues.add(cmax);
       // map.put(cmax,true);
        //out.println(amax);
        //out.println(bmax);
        //out.println(cmax);
        for(int i = 0; i <= cmax; i++){
            printedValues.put(i, false);
        }
        map.put(cmax,true);
        DFS(cmax);
        Iterator<Integer> iter = possibleCValues.iterator();
        while(iter.hasNext()){
            printedValues.put(iter.next(),true);
        }
        for(int i = 0; i < cmax; i++){
            if (printedValues.get(i))
                out.print(i + " ");
        }
        out.println(cmax);
        out.close();                                 
        System.exit(0);                            
    }
   public static void DFS(int k){
       
        ArrayList<Integer> arr = retrieveValues(k);
        //out.println(arr);
        int a = arr.get(0);
        int b = arr.get(1);
        int c = arr.get(2);
        if(a == 0 ){
            possibleCValues.add(c);
        }
        int aleft = amax - a;
        int bleft = bmax - b;
        int cleft = cmax - c;
        //out.println(aleft + " " + bleft + " " + cleft);
        // pour from A into B
        if(a > 0){
            int gain = Math.min(a,bleft);
            int tempa = a - gain;
            int tempb = b + gain;
            int tempc = c;
            /*if(a==0)
                possibleCValues.add(tempc);*/
            int val = 10000*tempa + 100*tempb + tempc;
            if(!map.get(val)){
                map.put(val,true);
                DFS(val);
            }
        }
        // pour from B into A
        if(b > 0){
            int gain = Math.min(b,aleft);
            int tempa = a + gain;
            int tempb = b - gain;
            int tempc = c;
            int val = 10000*tempa + 100*tempb + tempc;
            if(!map.get(val)){
                map.put(val,true);
                DFS(val);
            }
        }
        // pour from A into C
        if(a > 0){
            int gain = Math.min(a,cleft);
            int tempa = a - gain;
            int tempb = b;
            int tempc = c + gain;
            /*if(a==0)
                possibleCValues.add(tempc);*/
            int val = 10000*tempa + 100*tempb + tempc;
            if(!map.get(val)){
                map.put(val,true);
                DFS(val);
            }
        }
        // pour from C into A
        if(c > 0){
            int gain = Math.min(c,aleft);
            int tempa = a + gain;
            int tempb = b;
            int tempc = c - gain;
            //possibleCValues.add(tempc);
            int val = 10000*tempa + 100*tempb + tempc;
            if(!map.get(val)){
                map.put(val,true);
                DFS(val);
            }
        }
        // pour from B into C
        if(b > 0){
            int gain = Math.min(b, cleft);
            int tempa = a;
            int tempb = b - gain;
            int tempc = c + gain;
            //possibleCValues.add(tempc);
            int val = 10000*tempa + 100*tempb + tempc;
            if(!map.get(val)){
                map.put(val,true);
                DFS(val);
            }
        }
        // pour from C into B
        if(c > 0){
            int gain = Math.min(c, bleft);
            int tempa = a;
            int tempb = b + gain;
            int tempc = c - gain;
            //possibleCValues.add(tempc);
            int val = 10000*tempa + 100*tempb + tempc;
            if(!map.get(val)){
                map.put(val,true);
                DFS(val);
            }
        }
        map.put(k,true);
        return;
   }
   public static ArrayList<Integer> retrieveValues(int k){
       ArrayList<Integer> arr = new ArrayList<Integer>();
       int a = k / 10000;
       int b = (k / 100) % 100;
       int c = k % 100;
       arr.add(a);
       arr.add(b);
       arr.add(c);
       return arr;
   }
}