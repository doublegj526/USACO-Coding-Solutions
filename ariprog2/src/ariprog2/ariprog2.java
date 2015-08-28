/*
ID: jgee1
LANG: JAVA
TASK: ariprog2
*/
package ariprog2;

import java.io.*;
import java.util.*;
import java.math.*;

class ariprog2 {
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        nstr = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(nstr.nextToken());
        int max = 2 * m * m;
        boolean[] bisquares = new boolean[max + 1];
        for(int i = 0; i <= m; i++){
            for(int j = i; j <= m; j++){
                bisquares[i*i + j*j] = true;
            }
        }
        /*for(int i = 0; i <= max; i++){
            if(bisquares[i])
                System.out.println(i);
        }*/
        //System.out.println("hi");
        ArrayList<int[]> result = new ArrayList<int[]>();
        for(int i = 0; i < max; i++){
            if(!bisquares[i])
                continue;
            else{
                for(int j = 1; j <= (max-i)/(n-1); j++){
                    int temp = i + j;
                    int count = 1;
                    while(count < n){
                        //System.out.println(i + " " + j + " " + temp + " " + count);
                        if(temp <= max && bisquares[temp]){
                            temp = temp+j;
                            count++;
                        }
                        else{
                            break;
                        }
                    }
                    if(count == n)
                        result.add(new int[]{i,j});
                }
            }
        }
        Collections.sort(result, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[1] < o2[1]){
                    return -1;
                }
                if(o1[0] < o2[0]){
                    return -1;
                }
                return 1;
            }});
        for(int i = 0; i < result.size(); i++){
            int[] cur = result.get(i);
            out.println(cur[0] + " " + cur[1]);
        }
    }
    
}