/*
ID: jgee1
LANG: JAVA
TASK: ariprog
*/
//package ariprog;

import java.io.*;
import java.util.*;
import java.math.*;

class ariprog{
    public static PrintWriter out;
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
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
                if(o1[1] < o2[1])
                    return -1;
                if(o1[1] > o2[1])
                    return 1;
                if(o1[0] < o2[0])
                    return -1;
                if(o1[0] > o2[0])
                    return 1;
                return 0;
            }});
        for(int i = 0; i < result.size(); i++){
            int[] cur = result.get(i);
            out.println(cur[0] + " " + cur[1]);
        }
        if(result.size() == 0){
            out.println("NONE");
        }
        out.close();
        System.exit(0);
    }
}

/*class ariprog {
   public static PrintWriter out;
   public static boolean printedSomething;
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        nstr = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(nstr.nextToken());
        HashMap<Integer,Boolean> bisquares = new HashMap<Integer,Boolean>();
        ArrayList<Integer> biarr = new ArrayList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        int max = 2 * m * m;
        for(int i = 0; i <= max; i++){
            bisquares.put(i,false);
        }
        for(int i = 0; i <= m; i++){
            int temp = i * i;
            for(int j = 0; j <= m; j++){
                int blah = temp + j*j;
                bisquares.put(blah,true);
                if(!visited.contains(blah)){
                    visited.add(blah);
                    biarr.add(blah);
                }
            }
        }
        printedSomething = false;
        //biarr.remove(0);
        Collections.sort(biarr);
        //System.out.println(biarr);
        if(n == 3)
        {
            // can go up to 2
            if(m >= 1){
                out.println("0 1");
            }
            // can go up to 8
            if(m >= 2){
                out.println("0 2");
                out.println("2 3");
            }
            printedSomething = true;
        }
        int diff = 4;
        int tops = max;
        for(int i = diff; i <= tops; i += 4){
            //System.out.println(i);
            HashMap<Integer,Integer> next = new HashMap<Integer,Integer>();
            for(int j = 0; j < biarr.size(); j++){
                int temp = biarr.get(j);
                //System.out.println(temp);
                if(bisquares.get(temp + i) != null && bisquares.get(temp+i)){
                    next.put(temp, temp + i);
                }
            }
            //visited2 = new HashMap<Integer, Boolean>();
            for(int j = 0; j < biarr.size() - n + 1; j++){
                //System.out.println(j);
                DFS(biarr.get(j),i,biarr.get(j),bisquares,1,n);
            }
        }
        if(!printedSomething){
            out.println("NONE");
        }
        out.close();                                 
        System.exit(0);                            
    }
   //public static HashMap<Integer, Boolean> visited2;
    public static void DFS(int start, int diff, int current, HashMap<Integer, Boolean> bisquares, int index,int n){
        //System.out.println(start + " " + diff+ " " + current+ " " + index + " " + n);
        //System.out.println(index);
        if(index >= n){
            printedSomething = true;
            out.println(start + " " + diff);
            return;
        }
        else{
            if(bisquares.get(current + diff) != null && bisquares.get(current+diff)){
                DFS(start,diff,current+diff,bisquares,index+1,n);
            }
        }
        return;
    }
}*/