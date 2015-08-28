/*
ID: jgee1
LANG: JAVA
TASK: beads
*/
//package beads;

import java.io.*;
import java.util.*;

class beads {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    StringTokenizer nstr = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(nstr.nextToken());
    int maxcount = 0;
    nstr = new StringTokenizer(f.readLine());
    String str = nstr.nextToken();
    char[] s = str.toCharArray();
    for(int i = 0; i < n; i++){
        boolean rchain = false;
        boolean bchain = false;
        // going forwards
        int count = 0;
        int gotthisfar = 0;
        for(int j = 0; j < n; j++){
            char c = s[getIndex(i+j,n)];
            if(c == 'w')
                count++;
            else if(c == 'b' && !rchain){
                count++;
                bchain = true;
            }
            else if(c == 'r' && !bchain){
                count++;
                rchain = true;
            }
            else{
                gotthisfar = j;
                break;
            }
            if(j == n-1){
                gotthisfar = n;
            }
        }
        //out.println(gotthisfar + " " + count);
        if(bchain){
            bchain = false;
            rchain = true;
        }
        else if(rchain){
            bchain = true;
            rchain = false;
        }
        // going backwards
        for(int j = 1; j < n - gotthisfar + 1; j++){
            char c = s[getIndex(i-j,n)];
            if(c == 'w')
                count++;
            else if(c == 'b' && !rchain){
                count++;
                bchain = true;
            }
            else if(c == 'r' && !bchain){
                count++;
                rchain = true;
            }
            else{
                break;
            }
        }
        if(count > maxcount){
            maxcount = count;
        }
    }
    out.println(maxcount);
    out.close();                                 
    System.exit(0);                            
  }
  public static int getIndex(int i, int j){
      if(i >= 0){
          return i%j;
      }
      else{
          return i+j;
      }
  }
}

