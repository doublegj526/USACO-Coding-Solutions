/*
ID: jgee1
LANG: JAVA
TASK: palsquare
*/
//package palsquare;

import java.io.*;
import java.util.*;

class palsquare {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
    StringTokenizer nstr = new StringTokenizer(f.readLine());
    int b = Integer.parseInt(nstr.nextToken());
    for(int i = 1; i <= 300; i++){
        String s = Integer.toString(Integer.parseInt(""+(i*i), 10), b).toUpperCase();
        if(isPalindrome(s)){
            out.println(Integer.toString(Integer.parseInt(""+i),b).toUpperCase()+ " " + s);
        }
    }
    out.close();                                 
    System.exit(0);                            
  }
  public static boolean isPalindrome(String s){
      int len = s.length();
      for(int i = 0; i < len/2; i++){
          if(s.charAt(i) != s.charAt(len - 1 - i))
              return false;
      }
      return true;
  }
}