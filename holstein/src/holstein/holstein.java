/*
ID: jgee1
LANG: JAVA
TASK: holstein
*/
//package holstein;

import java.io.*;
import java.util.*;
import java.math.*;

class holstein{
    public static ArrayList<ArrayList<Integer>> arr;
    public static PrintWriter out;
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int v = Integer.parseInt(nstr.nextToken());
        //arr = new ArrayList<int[]>();
        nstr = new StringTokenizer(f.readLine());
        int[] req = new int[v];
        for(int i = 0; i < v; i++){
            req[i] = Integer.parseInt(nstr.nextToken());
        }
        nstr = new StringTokenizer(f.readLine());
        int g = Integer.parseInt(nstr.nextToken());
        int[][] mat = new int[g][v];
        for(int i = 0; i < g; i++){
            nstr = new StringTokenizer(f.readLine());
            for(int j = 0; j < v; j++){
                mat[i][j] = Integer.parseInt(nstr.nextToken());
            }
        }
        for(int i = 1; i <= g; i++){
            arr = new ArrayList<ArrayList<Integer>>();
            fillArr(new ArrayList<Integer>(),0,i,g);
            int indx = Integer.MIN_VALUE;
            for(int j = 0; j < arr.size(); j++){
                int[] fill = new int[v];
                ArrayList<Integer> arg = arr.get(j);
                for(int k = 0; k < arg.size(); k++){
                    int index = arg.get(k);
                    for(int l = 0; l < v; l++){
                        fill[l] += mat[index][l];
                    }
                }
                boolean passes = true;
                for(int k = 0; k < fill.length; k++){
                    if(fill[k] < req[k]){
                        passes = false;
                        break;
                    }
                }
                if(passes){
                    indx = j;
                }
            }
            if(indx >= 0){
                out.print(i + " ");
                ArrayList<Integer> tem = arr.get(indx);
                for(int j = 0; j < (tem.size() - 1); j++){
                    out.print((tem.get(j) + 1)+ " ");
                }
                out.println(tem.get(tem.size() - 1) + 1);
                break;
            }
        }
        out.close();
        System.exit(0);
    }
    public static void fillArr(ArrayList<Integer> a,int index, int filled, int arraylength){
        if(filled == 0){
            /*for(int i = 0; i < array.length; i++){
                out.print(array[i] + ", ");
            }*/
            arr.add(a);
        }
        else{
            if((arraylength - index) > filled){
                fillArr(a,index + 1, filled, arraylength);
            }
            ArrayList<Integer> b = new ArrayList<Integer>(a);
            b.add(index);
            fillArr(b,index+1, filled - 1, arraylength);
        }
    }
}