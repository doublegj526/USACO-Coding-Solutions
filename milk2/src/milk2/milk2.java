/*
ID: jgee1
LANG: JAVA
TASK: milk2
*/
//package milk2;

import java.io.*;
import java.util.*;

class milk2 {
   public static class interval implements Comparable{
       int start;
       int end;
       public interval(int start, int end){
           this.start = start;
           this.end = end;
        }
        public int compareTo(Object o) {
            if(this.start < ((interval)o).start){
                return -1;
            }
            else{
                return 1;
            }
        }
    }
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = Integer.parseInt(nstr.nextToken());
        interval[] intervals = new interval[n];
        for(int i = 0; i < n; i++){
            nstr = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(nstr.nextToken());
            int end = Integer.parseInt(nstr.nextToken());
            intervals[i] = new interval(start,end);
        }
        Arrays.sort(intervals);
        int low = intervals[0].start;
        int high = intervals[0].end;
        int milked = high - low;
        int notmilked = 0;
        for(int i = 1; i < n; i++){
            if(intervals[i].start > high){
                if(high - low > milked){
                    milked = high - low;
                }
                if(intervals[i].start - high > notmilked){
                    notmilked = intervals[i].start - high;
                }
                low = intervals[i].start;
                high = intervals[i].end;
            }
            else{
                if(intervals[i].end > high){
                    high = intervals[i].end;
                }
            }
        }
        out.println(milked + " " + notmilked);
        out.close();                                 
        System.exit(0);                            
    }
}