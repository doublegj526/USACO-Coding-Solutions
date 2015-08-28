/*
ID: jgee1
LANG: JAVA
TASK: dualpal
*/
//package dualpal;

import java.io.*;
import java.util.*;

class dualpal {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
    StringTokenizer nstr = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(nstr.nextToken());
    int s = Integer.parseInt(nstr.nextToken());
    s = s + 1;
    int count = 0;
    while(count < n){
        int indiv = 0;
        for(int i = 2; i <= 10; i++){
            boolean val = isPalindrome(Integer.toString(Integer.parseInt(""+s, 10), i));
            if(val && indiv == 1){
                out.println(s);
                //out.println(s + " ");
                //out.println(i + " "+ Integer.toString(Integer.parseInt(""+s, 10),i));
                count++;
                break;
            }
            else if(val){
            {
                indiv++;
            }
        }
        }
        s = s+1;
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