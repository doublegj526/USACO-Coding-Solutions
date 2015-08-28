/*
ID: jgee1
LANG: JAVA
TASK: ride
*/
//package ride;

import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    StringTokenizer st1 = new StringTokenizer(f.readLine());
    StringTokenizer st2 = new StringTokenizer(f.readLine());
    String s1 = st1.nextToken();
    String s2 = st2.nextToken();
    int s1len = s1.length();
    int s2len = s2.length();
    int s1prod = 1;
    int s2prod = 1;
    for(int i = 0; i < s1len; i++){
        s1prod *= s1.charAt(i) - 64;
        s1prod %= 47;
    }
    for(int i = 0; i < s2len; i++){
        s2prod *= s2.charAt(i) - 64;
        s2prod %= 47;
    }
    if(s1prod == s2prod){
        out.println("GO");
    }
    else{
        out.println("STAY");
    }                       
    out.close();                                 
    System.exit(0);                            
  }
}
