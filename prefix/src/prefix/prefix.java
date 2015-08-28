/*
ID: jgee1
LANG: JAVA
TASK: prefix
*/

//package prefix;

import java.io.*;
import java.util.*;
import java.math.*;

class prefix{
    public static PrintWriter out;
    public static HashMap<Integer, HashMap<String, Boolean>> lookup;
    public static HashMap<Integer, Boolean> map;
    public static HashMap<String, Boolean> dict;
    public static ArrayList<Integer> lengths;
    public static String s;
    public static int maxdiclen;
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
        StringTokenizer nstr; 
        lookup = new HashMap<Integer,HashMap<String,Boolean>>();
        dict = new HashMap<String, Boolean>();
        lengths = new ArrayList<Integer>();
        map = new HashMap<Integer, Boolean>();
        maxdiclen = Integer.MIN_VALUE;
        StringBuilder br = new StringBuilder();
        s = "";
        boolean ab = true;
        while(ab){
            nstr = new StringTokenizer(f.readLine());
            while(nstr.hasMoreTokens()){
                String s2 = nstr.nextToken();
                //out.println(s2);
                if(s2.equals(".")){
                    ab = false;
                    break;
                }
                dict.put(s2,true);
                int n = s2.length();
                if(n > maxdiclen){
                    maxdiclen = n;
                }
                if(lookup.get(n) == null)
                {
                    lookup.put(n,new HashMap<String,Boolean>());
                    lengths.add(n);
                }
                lookup.get(n).put(s2, true);
            }
        }
        Collections.sort(lengths);
        //out.println(lengths);
        while(true){
            try{
                nstr = new StringTokenizer(f.readLine());
                br.append(nstr.nextToken());
            }
            catch(NullPointerException e){
                break;
            }
        }
        //out.println(s);
        s = br.toString();
        for(int i = 0; i <= s.length(); i++){
            map.put(i,false);
        }
        for(int i = 1; i <= s.length(); i++){
            compute(i);
        }
        /*for(int i = 1; i <= s.length(); i++){
            out.println(map.get(i));
        }*/
        boolean printedSomething = true;
        for(int i = s.length(); i >= 0; i--)
        {
            if(map.get(i)){
                out.println(i);
                printedSomething = false;
                break;
            }
        }
        if(printedSomething)
        {
            out.println(0);
        }
        out.close();
        System.exit(0);
    
    }
    public static void compute(int indx){
        if(indx <= maxdiclen && dict.get(s.substring(0,indx)) != null){
            map.put(indx,true);
        }
        else{
            for(int i = 0; i < lengths.size(); i++){
                HashMap<String,Boolean> dic2 = lookup.get(lengths.get(i));
                /*Iterator<String> iter = dic2.iterator();
                while(iter.hasNext()){
                    out.println(iter.next());
                }*/
                //String s1 = s.substring(0,indx - lengths.get(i));
                try{
                    String s2 = s.substring(indx - lengths.get(i),indx);
                    //out.println(s1 + " " + s2);
                    //out.println(indx - lengths.get(i) + 1);
                    if(map.get(indx - lengths.get(i)) && dic2.get(s2) != null){
                         map.put(indx,true);
                    return;}}
                catch(StringIndexOutOfBoundsException e){
                }
            }
        }
    }
}