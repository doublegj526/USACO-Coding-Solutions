/*
ID: jgee1
LANG: JAVA
TASK: namenum
*/
//package namenum;

import java.io.*;
import java.util.*;

class namenum {
  public static HashMap<String, Boolean> dict;
  public static boolean printedOne;
  public static PrintWriter out;
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
    BufferedReader f2 = new BufferedReader(new FileReader("dict.txt"));
    out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
    printedOne = true;
    dict = new HashMap<String, Boolean>();
    for(int i = 0; i < 5000; i++){
        String s = f2.readLine();
        if(s != null)
            dict.put(s, true);
        else
            break;
    }
    StringTokenizer nstr = new StringTokenizer(f.readLine());
    printStrings("" + nstr.nextToken(), 0);
    if(printedOne){
        out.println("NONE");
    }
    out.close();                                 
    System.exit(0);                            
  }
  /*
  2: A,B,C
  3: D,E,F
  4: G,H,I 
  5: J,K,L
  6: M,N,O
  7: P,R,S
  8: T,U,V
  9: W,X,Y
  */
  public static void printStrings(String s, int index){
      if(index == s.length()){
          if(dict.containsKey(s)){
              out.println(s);
              printedOne = false;
          }
      }
      else{
          String s1 = "";
          String s2 = "";
          String s3 = "";
          char c = s.charAt(index);
          char[] sarr = s.toCharArray();
          if(c == '2'){
              sarr[index] = 'A';
              s1 = String.valueOf(sarr);
              sarr[index] = 'B';
              s2 = String.valueOf(sarr);
              sarr[index] = 'C';
              s3 = String.valueOf(sarr);
          }
          else if(c == '3'){
              sarr[index] = 'D';
              s1 = String.valueOf(sarr);
              sarr[index] = 'E';
              s2 = String.valueOf(sarr);
              sarr[index] = 'F';
              s3 = String.valueOf(sarr);
          }
          else if(c == '4'){
              sarr[index] = 'G';
              s1 = String.valueOf(sarr);
              sarr[index] = 'H';
              s2 = String.valueOf(sarr);
              sarr[index] = 'I';
              s3 = String.valueOf(sarr);
          }
          else if(c == '5'){
              sarr[index] = 'J';
              s1 = String.valueOf(sarr);
              sarr[index] = 'K';
              s2 = String.valueOf(sarr);
              sarr[index] = 'L';
              s3 = String.valueOf(sarr);
          }
          else if(c == '6'){
              sarr[index] = 'M';
              s1 = String.valueOf(sarr);
              sarr[index] = 'N';
              s2 = String.valueOf(sarr);
              sarr[index] = 'O';
              s3 = String.valueOf(sarr);
          }
          else if(c == '7'){
              sarr[index] = 'P';
              s1 = String.valueOf(sarr);
              sarr[index] = 'R';
              s2 = String.valueOf(sarr);
              sarr[index] = 'S';
              s3 = String.valueOf(sarr);
          }
          else if(c == '8'){
              sarr[index] = 'T';
              s1 = String.valueOf(sarr);
              sarr[index] = 'U';
              s2 = String.valueOf(sarr);
              sarr[index] = 'V';
              s3 = String.valueOf(sarr);
          }
          else if(c == '9'){
              sarr[index] = 'W';
              s1 = String.valueOf(sarr);
              sarr[index] = 'X';
              s2 = String.valueOf(sarr);
              sarr[index] = 'Y';
              s3 = String.valueOf(sarr);
          }
          printStrings(s1, index + 1);
          printStrings(s2, index + 1);
          printStrings(s3, index + 1);
      }
  }
}
/*
if(c == '2'){
              s1 = s.substring(0,index) + "A" + s.substring(index + 1, s.length());
              s2 = s.substring(0,index) + "B" + s.substring(index + 1, s.length());
              s3 = s.substring(0,index) + "C" + s.substring(index + 1, s.length());
          }
          else if(c == '3'){
              s1 = s.substring(0,index) + "D" + s.substring(index + 1, s.length());
              s2 = s.substring(0,index) + "E" + s.substring(index + 1, s.length());
              s3 = s.substring(0,index) + "F" + s.substring(index + 1, s.length());
          }
          else if(c == '4'){
              s1 = s.substring(0,index) + "G" + s.substring(index + 1, s.length());
              s2 = s.substring(0,index) + "H" + s.substring(index + 1, s.length());
              s3 = s.substring(0,index) + "I" + s.substring(index + 1, s.length());
          }
          else if(c == '5'){
              s1 = s.substring(0,index) + "J" + s.substring(index + 1, s.length());
              s2 = s.substring(0,index) + "K" + s.substring(index + 1, s.length());
              s3 = s.substring(0,index) + "L" + s.substring(index + 1, s.length());
          }
          else if(c == '6'){
              s1 = s.substring(0,index) + "M" + s.substring(index + 1, s.length());
              s2 = s.substring(0,index) + "N" + s.substring(index + 1, s.length());
              s3 = s.substring(0,index) + "O" + s.substring(index + 1, s.length());
          }
          else if(c == '7'){
              s1 = s.substring(0,index) + "P" + s.substring(index + 1, s.length());
              s2 = s.substring(0,index) + "R" + s.substring(index + 1, s.length());
              s3 = s.substring(0,index) + "S" + s.substring(index + 1, s.length());
          }
          else if(c == '8'){
              s1 = s.substring(0,index) + "T" + s.substring(index + 1, s.length());
              s2 = s.substring(0,index) + "U" + s.substring(index + 1, s.length());
              s3 = s.substring(0,index) + "V" + s.substring(index + 1, s.length());
          }
          else if(c == '9'){
              s1 = s.substring(0,index) + "W" + s.substring(index + 1, s.length());
              s2 = s.substring(0,index) + "X" + s.substring(index + 1, s.length());
              s3 = s.substring(0,index) + "Y" + s.substring(index + 1, s.length());
          }
*/