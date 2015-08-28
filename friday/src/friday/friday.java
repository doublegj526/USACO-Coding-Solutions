/*
ID: jgee1
LANG: JAVA
TASK: friday
*/
//package friday;

import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    StringTokenizer nstr = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(nstr.nextToken());
    int count = 0;
    /* 0 - Sunday
       1 - Monday
       2 - Tuesday
       3 - Wednesday
       4 - Thursday
       5 - Friday
       6 - Saturday
    */
    int day = 6;
    HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
    for(int i = 0; i < 7; i++){
        frequency.put(i,0);
    }
    for(int i = 1900; i < (1900 + n); i++){
        for(int j = 1; j < 13; j++){
            frequency.put(day, frequency.get(day) + 1);
            // Thirty days has September, April, June, and November, 30 % 7 = 2
            if(j == 4 || j == 6 || j==9||j==11){
                day = (day+2)%7;
            }
            // February, 28 % 7 = 0
            // leap year
            else if(j==2 && (i % 4 == 0)){
                if(i % 100 == 0 && i % 400 ==0)
                    day = (day + 1)%7;
                else if(i % 100 == 0)
                    day = day;
                else
                    day = (day + 1)%7;
            }
            // February, 28 % 7 = 0
            // non leap year
            else if(j==2){
                day = day;
            }
            // 31 days, 31 % 7 = 3
            else{
                day = (day+3)%7;
            }
        }
    }
    out.print(frequency.get(6) + " ");
    for(int i = 0; i < 5; i++){
        out.print(frequency.get(i)+ " ");
    }
    out.println(frequency.get(5));
    out.close();                                 
    System.exit(0);                            
  }
}

