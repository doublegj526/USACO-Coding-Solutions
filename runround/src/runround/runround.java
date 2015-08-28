/*
ID: jgee1
LANG: JAVA
TASK: runround
*/
//package runround;

import java.io.*;
import java.util.*;
import java.math.*;

class runround{
    public static PrintWriter out;
    public static HashMap<String,Integer> map;
    public static HashMap<Integer,Boolean> filled;
    public static HashMap<Integer,Boolean> used;
    public static int digits;
    public static int[] arr;
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        filled = new HashMap<Integer,Boolean>();
        used = new HashMap<Integer,Boolean>();
        String str = "" + n;
        digits = (int)Math.log10(n) + 1;
        for(int i = 0; i < digits; i++){
            filled.put(i,false);
        }
        arr = new int[digits];
        for(int i = 0; i < digits; i++){
            arr[i] = str.charAt(i);
        }
        int num = n + 1;
        while(true){
            //System.out.println(num);
            str = "" + num;
            digits = (int)Math.log10(num) + 1;
            arr = new int[digits];
            for(int i = 0; i < digits; i++){
                arr[i] = str.charAt(i);
            }
            for(int i = 0; i < digits; i++){
                filled.put(i, false);
            }
            for(int i = 0; i < 10; i++){
                used.put(i, false);
            }
            filled.put(0,true);
            if(checkZeros(num) && checkUnique(num) && runRound(0,digits-1))
            {
                out.println(num);
                break;
            }
            num++;
        }
        //out.println(num);
        out.close();
        System.exit(0);
    }
    public static boolean checkZeros(int num){
        int temp = num;
        while(temp >= 10){
            if(temp % 10 == 0){
                return false;
            }
            temp = temp / 10;
        }
        if(temp == 0){
            return false;
        }
        else{
            return true;
        }
    }
    public static boolean checkUnique(int num){
        for(int i = 0; i < arr.length; i++){
            //System.out.println(arr[i]);
            if(!used.get(arr[i] - 48)){
                used.put(arr[i] - 48,true);
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static boolean runRound(int index,int dig){
        //System.out.println(dig);
        if(dig == 0){
            int temp = arr[index] - 48;
            int newindx = (index + temp) % digits;
            if(newindx == 0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            int temp = arr[index] - 48;
            //System.out.println(temp);
            int newindx = (index + temp) % digits;
            if(filled.get(newindx)){
                return false;
            }
            else{
                filled.put(newindx,true);
                return runRound(newindx,dig -1);
            }
        }
    }
}