/*
ID: jgee1
LANG: JAVA
TASK: preface
*/
//package preface;

import java.io.*;
import java.util.*;
import java.math.*;

class preface{
    public static PrintWriter out;
    public static HashMap<String,Integer> map;
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("preface.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        map = new HashMap<String,Integer>();
        map.put("I",0);
        map.put("V",0);
        map.put("X",0);
        map.put("L",0);
        map.put("C",0);
        map.put("D",0);
        map.put("M",0);
        for(int i = 1; i <= n; i++){
            include(i);
        }
        if(map.get("I") != 0)
            out.println("I " + map.get("I"));
        if(map.get("V") != 0)
            out.println("V " + map.get("V"));
        if(map.get("X") != 0)
            out.println("X " + map.get("X"));
        if(map.get("L") != 0)
            out.println("L " + map.get("L"));
        if(map.get("C") != 0)
            out.println("C " + map.get("C"));
        if(map.get("D") != 0)
            out.println("D " + map.get("D"));
        if(map.get("M") != 0)
            out.println("M " + map.get("M"));
        out.close();
        System.exit(0);
    }
    public static void include(int i){
        if(i == 0){
            return;
        }
        else if(1 <= i && i <= 3){
            map.put("I", map.get("I") + i);
        }
        else if(i == 4){
            map.put("I",map.get("I") + 1);
            map.put("V",map.get("V") + 1);
        }
        else if(5 <= i && i <= 8){
            map.put("V",map.get("V") + 1);
            include(i - 5);
        }
        else if(i == 9){
            map.put("I",map.get("I") + 1);
            map.put("X",map.get("X") + 1);
        }
        else if(10 <= i && i <= 39){
            map.put("X",map.get("X") + 1);
            include(i - 10);
        }
        else if(40 <= i && i <= 49){
            map.put("X",map.get("X") + 1);
            map.put("L",map.get("L") + 1);
            include(i - 40);
        }
        else if(50 <= i && i <= 89){
            map.put("L",map.get("L") + 1);
            include(i - 50);
        }
        else if(90 <= i && i <= 99){
            map.put("X",map.get("X") + 1);
            map.put("C",map.get("C") + 1);
            include(i - 90);
        }
        else if(100 <= i && i <= 399){
            map.put("C",map.get("C") + 1);
            include(i - 100);
        }
        else if(400 <= i && i <= 499){
            map.put("C",map.get("C") + 1);
            map.put("D",map.get("D") + 1);
            include(i - 400);
        }
        else if(500 <= i && i <= 899){
            map.put("D", map.get("D") + 1);
            include(i - 500);
        }
        else if(900 <= i && i <= 999){
            map.put("C",map.get("C") + 1);
            map.put("M",map.get("M") + 1);
            include(i - 900);
        }
        else{
            map.put("M",map.get("M") + 1);
            include(i - 1000);
        }
    }
}