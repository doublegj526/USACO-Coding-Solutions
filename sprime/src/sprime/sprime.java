/*
ID: jgee1
LANG: JAVA
TASK: sprime
*/
//package sprime;

import java.io.*;
import java.util.*;
import java.math.*;

class sprime{
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        ArrayList<Integer> arr = superprime(n);
        for(int i = 0; i < arr.size(); i++){
            out.println(arr.get(i));
        }
        out.close();
        System.exit(0);
    }
    public static ArrayList<Integer> superprime(int n){
        ArrayList<Integer> arr;
        if(n == 1){
            arr = new ArrayList<Integer>();
            arr.add(2);
            arr.add(3);
            arr.add(5);
            arr.add(7);
            return arr;
        }
        else{
            arr = superprime(n-1);
            ArrayList<Integer> result = new ArrayList<Integer>();
            for(int i = 0; i < arr.size(); i++){
                int temp = arr.get(i);
                for(int add = 1; add < 10; add += 2){
                    if(isPrime(10*temp+add)){
                        result.add(10*temp+add);
                    }
                }
            }
            return result;
        }
    }
    public static boolean isPrime(int k){
        int sqrt = (int)Math.sqrt(k);
        for(int i = 2; i <= sqrt; i++){
            if(k % i == 0){
                return false;
            }
        }
        return true;
    }
}