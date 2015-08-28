/*
ID: jgee1
LANG: JAVA
TASK: gift1
*/
//package gift1;

import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    StringTokenizer nstr = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(nstr.nextToken());
    ArrayList<String> names = new ArrayList<String>();
    HashMap<String, Integer> finalmoney = new HashMap<String, Integer>();
    HashMap<String, Integer> initialmoney = new HashMap<String, Integer>();
    for(int i = 0; i < n; i++){
        nstr = new StringTokenizer(f.readLine());
        String name = nstr.nextToken();
        names.add(name);
        finalmoney.put(name, 0);
    }
    for(int i = 0; i < n; i++){
        nstr = new StringTokenizer(f.readLine());
        String name = nstr.nextToken();
        nstr = new StringTokenizer(f.readLine());
        int initial = Integer.parseInt(nstr.nextToken());
        int divide = Integer.parseInt(nstr.nextToken());
        int gain = 0;
        if (divide != 0){
            gain = initial/divide;
        }
        initialmoney.put(name, initial);
        if (divide != 0){
            finalmoney.put(name, finalmoney.get(name) + (initial % divide));
        }
        else{
            finalmoney.put(name, finalmoney.get(name) + initial);
        }
        for(int j = 0; j < divide; j++){
            nstr = new StringTokenizer(f.readLine());
            String name2 = nstr.nextToken();
            finalmoney.put(name2, finalmoney.get(name2) + gain);
        }
    }
    for(int i = 0; i < n; i++){
        out.println(names.get(i) + " " + (finalmoney.get(names.get(i)) - initialmoney.get(names.get(i))));
    }
    out.close();                                 
    System.exit(0);                            
  }
}

