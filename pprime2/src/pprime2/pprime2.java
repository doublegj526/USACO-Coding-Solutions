/*
ID: jgee1
LANG: JAVA
TASK: pprime
*/
package pprime;

import java.io.*;
import java.util.*;
import java.math.*;

class pprime{
    public static HashMap<Integer,ArrayList<Integer>> mem;
    //public static HashMap<Integer,ArrayList<Integer>> memWithEvens;
    public static PrintWriter out;
    public static int maxdigits;
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(nstr.nextToken());
        int b = Integer.parseInt(nstr.nextToken());
        int adigits = (int)Math.log10(a) + 1;
        int bdigits = (int)Math.log10(b) + 1;
        maxdigits = bdigits;
        //memWithEvens = new HashMap<Integer,ArrayList<Integer>>();
        mem = new HashMap<Integer,ArrayList<Integer>>();
        generatePalindromes(bdigits);
        if(adigits != bdigits){
            generatePalindromes(bdigits - 1);
        }
        
        /*for(int i = 0 ; i < arrTotal.size(); i++){
            temparr = arrTotal.get(i);
            for(int j = 0 ; j < temparr.size(); j++){
                int temp = temparr.get(j);
                out.println(temp);
            }
        }*/
        
        int ntemp;
        //ArrayList<Integer> fin = new ArrayList<Integer>();
        ArrayList<Integer> temparr = mem.get(adigits);
        if(adigits != bdigits){
            ntemp = temparr.size();
            for(int j = 0; j < ntemp; j++){
                int temp = temparr.get(j);
                if(isPrime(temp) && temp >= a){
                    //fin.add(temp);
                    out.println(temp);
                }
            }
            int mtemp = bdigits - 1;
            for(int i = adigits + 1; i <= mtemp; i++){
                temparr = mem.get(i);
                ntemp = temparr.size();
                for(int j = 0; j < ntemp; j++){
                    int temp = temparr.get(j);
                    if(isPrime(temp)){
                        //fin.add(temp);
                        out.println(temp);
                    }
                }
            }
            if(adigits != bdigits){
                temparr = mem.get(bdigits);
                ntemp = temparr.size();
                for(int j = 0; j < ntemp; j++){
                    int temp = temparr.get(j);
                    if(isPrime(temp) && temp <= b){
                        //fin.add(temp);
                        out.println(temp);
                    }
                }
            }
        }
        else{
            for(int j = 0; j < temparr.size(); j++){
                int temp = temparr.get(j);
                if(isPrime(temp) && temp >= a && temp <= b){
                    //fin.add(temp);
                    out.println(temp);
                }
            }
        }
        //ntemp = fin.size();
        //Collections.sort(fin);
        /*for(int i = 0; i < ntemp; i++){
            out.println(fin.get(i));
        }*/
        out.close();
        System.exit(0);
    }
    public static boolean isPrime(int k){
        int sqrt = (int)Math.sqrt(k);
        for(int i = 3; i <= sqrt; i++){
            if(k % i == 0){
                return false;
            }
        }
        return true;
        
    }
    public static void generatePalindromes(int digits){
        if(digits == 1){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            //arr.add(0);
            arr.add(1);
            //arr.add(2);
            arr.add(3);
            //arr.add(4);
            arr.add(5);
            //arr.add(6);
            arr.add(7);
            //arr.add(8);
            arr.add(9);
            mem.put(digits,arr);
            //memWithEvens.put(digits,arr);
        }
        else if(digits == 2){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            //arr.add(0);
            arr.add(11);
            //arr.add(22);
            arr.add(33);
            //arr.add(44);
            arr.add(55);
            //arr.add(66);
            arr.add(77);
            //arr.add(88);
            arr.add(99);
            mem.put(digits,arr);
            //memWithEvens.put(digits,arr);
        }
        else{
            if(mem.get(digits - 2) == null){
                generatePalindromes(digits - 2);
            }
            ArrayList<Integer> arr = mem.get(digits - 2);
            out.println(arr);
            int tempdigits = digits - 2;
            int temploseZeros = (int)Math.pow(10,tempdigits - 1);
            int addZeros = (int)Math.pow(10,tempdigits + 1);
            ArrayList<Integer> result = new ArrayList<Integer>();
            int ntemp = arr.size();
            for(int i = 1; i <= 9; i+=2){
                int iAdded = addZeros*i + i;
                for(int j = 0; j < ntemp; j++){
                    int temp = arr.get(j);
                    if(tempdigits != 1){
                        result.add( 10 * (temp - 1 - temploseZeros) + iAdded);
                    }
                    else{
                        result.add( 10 * (temp - 1) + iAdded);
                    }
                }
                for(int j = 0; j < ntemp; j++){
                    int temp = arr.get(j);
                    result.add( 10 * temp + iAdded);
                }
            }
            out.println(result);
            mem.put(digits,result);
            //out.println(memNoEvens.get(digits));
            /*ArrayList<Integer> result2 = new ArrayList<Integer>(result);
            for(int i = 0; i <= 8; i += 2){
                int iAdded = addZeros*i + i;
                for(int j = 0; j < ntemp; j++){
                    int temp = arr.get(j);
                    result2.add(10 * temp + iAdded);
                }
            }*/
            //memWithEvens.put(digits,result2);
            //out.println(memWithEvens.get(digits));
        }
    }
}