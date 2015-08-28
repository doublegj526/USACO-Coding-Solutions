/*
ID: jgee1
LANG: JAVA
TASK: hamming
*/
//package hamming;

import java.io.*;
import java.util.*;
import java.math.*;

class hamming{
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        int b = Integer.parseInt(nstr.nextToken());
        int d = Integer.parseInt(nstr.nextToken());
        ArrayList<Integer> a = new ArrayList<Integer>();
        int count = n;
        a.add(0);
        count--;
        int num = 0;
        //System.out.println(7 ^ 25);
        while(count > 0){
            //System.out.println(a);
            num++;
            boolean addToList = true;
            for(int i = 0; i < a.size(); i++){
                int temp = a.get(i);
                if(hammingDistance(temp,num) < d){
                    addToList = false;
                    break;
                }
            }
            if(addToList){
                a.add(num);
                count--;
            }
        }
        int times = n / 10;
        for(int i = 0; i < times; i++){
            for(int j = 0; j < 9; j++){
                out.print(a.get(10*i + j)+ " ");
            }
            out.println(a.get(10*i + 9));
        }
        for(int i = 10*times; i < (n-1); i++){
            out.print(a.get(i)+" ");
        }
        if(n % 10 != 0)
            out.println(a.get(n-1));
        out.close();
        System.exit(0);
    }
    public static int hammingDistance(int x, int y){
        int temp = x ^ y;
        String s = Integer.toString(temp,2);
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1')
                count++;
        }
        return count;
    }
}