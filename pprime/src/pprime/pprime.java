/*
ID: jgee1
LANG: JAVA
TASK: pprime
*/
//package pprime;

import java.io.*;
import java.util.*;
import java.math.*;

class pprime{
    public static ArrayList<Integer> palindromes;
    public static void palindrome1(){
        palindromes.add(5);
        palindromes.add(7);
    }
    public static void palindrome2(){
        palindromes.add(11);
    }
    public static void palindrome3(){
        for(int i = 1; i <= 9; i+= 2){
            for(int j = 0; j < 10; j++){
                palindromes.add(100 *i + 10 *j +i);
            }
        }
    }
    public static void palindrome4(){
        for(int i = 1; i <= 9; i+= 2){
            for(int j = 0; j < 10; j++){
                palindromes.add(1000 *i + 100 *j + 10*j +i);
            }
        }
    }
    public static void palindrome5(){
        for(int i = 1; i <= 9; i+= 2){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    palindromes.add(10000 * i + 1000*j+100*k+10*j +i);
                }
            }
        }
    }
    public static void palindrome6(){
        for(int i = 1; i <= 9; i+= 2){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    palindromes.add(100000 * i + 10000*j+1000*k+100*k +10*j+i);
                }
            }
        }
    }
    public static void palindrome7(){
        for(int i = 1; i <= 9; i+= 2){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    for(int l = 0; l < 10; l++){
                        palindromes.add(1000000 * i + 100000*j+10000*k+1000*l+100*k +10*j+i);
                    }
                }
            }
        }
    }
    public static void palindrome8(){
        for(int i = 1; i <= 9; i+= 2){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    for(int l = 0; l < 10; l++){
                        palindromes.add(10000000 * i + 1000000*j+100000*k+10000*l+1000*l+100*k +10*j+i);
                    }
                }
            }
        }
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(nstr.nextToken());
        int b = Integer.parseInt(nstr.nextToken());
        palindromes = new ArrayList<Integer>();
        palindrome1();
        palindrome2();
        palindrome3();
        palindrome4();
        palindrome5();
        palindrome6();
        palindrome7();
        palindrome8();
        int n = palindromes.size();
        //out.println(palindromes);
        for(int i = 0; i < n; i++){
            int temp = palindromes.get(i);
            //out.println(temp + " " + isPrime(temp) + " " + (temp >= a) + " " + (temp <= b));
            if((isPrime(temp)) && (temp >= a) && (temp <= b)){
                out.println(temp);
            }
        }
        out.close();
        System.exit(0);
    }
    public static boolean isPrime(int k){
        if(k % 2 == 0)
            return false;
        int sqrt = (int)Math.sqrt(k);
        for(int i = 3; i <= sqrt; i++){
            if(k % i == 0){
                return false;
            }
        }
        return true;
    }
}