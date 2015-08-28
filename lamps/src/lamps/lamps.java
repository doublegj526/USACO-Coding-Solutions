/*
ID: jgee1
LANG: JAVA
TASK: lamps
*/
//package lamps;

import java.io.*;
import java.util.*;
import java.math.*;

class lamps{
    public static PrintWriter out;
    public static HashMap<Integer,Boolean> on;
    public static HashMap<Integer,Boolean> off;
    public static ArrayList<String> configs;
    public static int n;
    public static String goodString;
    public static HashMap<Integer,HashMap<String,Boolean>> alreadyLooked;
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        n = Integer.parseInt(nstr.nextToken());
        configs = new ArrayList<String>();
        nstr = new StringTokenizer(f.readLine());
        int c = Integer.parseInt(nstr.nextToken());
        c %= 16;
        nstr = new StringTokenizer(f.readLine());
        on = new HashMap<Integer,Boolean>();
        off = new HashMap<Integer,Boolean>();
        alreadyLooked = new HashMap<Integer,HashMap<String,Boolean>>();
        for(int i = 0; i < (c+1); i++){
            alreadyLooked.put(i,new HashMap<String,Boolean>());
        }
        for(int i = 0; i < n; i++){
            on.put(i,false);
            off.put(i,false);
        }
        while(nstr.hasMoreTokens()){
            int temp = Integer.parseInt(nstr.nextToken());
            if(temp == -1){
                break;
            }
            else{
                //out.println(temp - 1);
                on.put(temp - 1, true);
            }
        }
        nstr = new StringTokenizer(f.readLine());
        while(nstr.hasMoreTokens()){
            int temp = Integer.parseInt(nstr.nextToken());
            if(temp == -1){
                break;
            }
            else{
                //out.println(temp - 1);
                off.put(temp - 1, true);
            }
        }
        //generateConfigs("",0);
        goodString = "";
        for(int i = 0; i < n; i++){
            goodString += "1";
        }
        //out.println(goodString);
        //int count = 0;
        /*boolean printOne = true;
        for(int i = 0; i < configs.size(); i++){
            //out.println(goodConfiguration(configs.get(i),c));
            if(goodConfiguration(configs.get(i),c)){
                out.println(configs.get(i));
                printOne = false;
            }
        }
        if(printOne){
            out.println("IMPOSSIBLE");
        }*/
        goodConfiguration(goodString,c);
        //out.println(alreadyLooked.get(0).keySet().size());
        //out.println(alreadyLooked.get(1).keySet().size());
        //out.println(count);
        Collections.sort(configs);
        for(int i = 0; i < configs.size(); i++){
            out.println(configs.get(i));
        }
        if(configs.size() == 0){
            out.println("IMPOSSIBLE");
        }
        out.close();
        System.exit(0);
    }
    public static String button1(String s){
        char[] sarr = s.toCharArray();
        for(int i = 0; i < n; i++){
            if(sarr[i] == '0'){
                sarr[i] = '1';
            }
            else{
                sarr[i] = '0';
            }
        }
        return String.valueOf(sarr);
    }
    public static String button2(String s){
        char[] sarr = s.toCharArray();
        for(int i = 0; i < n; i+=2){
            if(sarr[i] == '0'){
                sarr[i] = '1';
            }
            else{
                sarr[i] = '0';
            }
        }
        return String.valueOf(sarr);
    }
    public static String button3(String s){
        char[] sarr = s.toCharArray();
        for(int i = 1; i < n; i+=2){
            if(sarr[i] == '0'){
                sarr[i] = '1';
            }
            else{
                sarr[i] = '0';
            }
        }
        return String.valueOf(sarr);
    }
    public static String button4(String s){
        char[] sarr = s.toCharArray();
        for(int i = 0; i < n; i+=3){
            if(sarr[i] == '0'){
                sarr[i] = '1';
            }
            else{
                sarr[i] = '0';
            }
        }
        return String.valueOf(sarr);
    }
    /*public static void generateConfigs(String s,int index){
        if(index == n){
            configs.add(s);
        }
        else{
            if(on.get(index)){
                generateConfigs(s+"1",index+1);
            }
            else if(off.get(index)){
                generateConfigs(s+"0",index+1);
            }
            else{
                generateConfigs(s+"0",index+1);
                generateConfigs(s+"1",index+1);
            }
        }
    }*/
    public static void goodConfiguration(String s, int moves){
        //System.out.println(s + " " + moves);
        if(alreadyLooked.get(moves).get(s) != null){
            return;
        }
        else{
            alreadyLooked.get(moves).put(s,true);
            //System.out.println(moves);
            //System.out.println(alreadyLooked.get(moves).keySet().size());
            if(moves == 0){
                for(int i = 0; i < n; i++){
                    if(on.get(i)){
                        //out.println(i);
                        if(s.charAt(i) == '0'){
                            return;
                        }
                    }
                    if(off.get(i)){
                        //out.println(i + " " + s.charAt(i));
                        if(s.charAt(i) == '1'){
                            return;
                        }
                    }
                }
                configs.add(s);
            }
            else{
                String s1 = button1(s);
                String s2 = button2(s);
                String s3 = button3(s);
                String s4 = button4(s);
                if(alreadyLooked.get(moves-1).get(s1) == null)
                    goodConfiguration(s1,moves-1);
                if(alreadyLooked.get(moves-1).get(s2) == null)
                    goodConfiguration(s2,moves-1);
                if(alreadyLooked.get(moves-1).get(s3) == null)
                    goodConfiguration(s3,moves-1);
                if(alreadyLooked.get(moves-1).get(s4) == null)
                    goodConfiguration(s4,moves-1);
            }
        }
    }
}