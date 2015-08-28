/*
ID: jgee1
LANG: JAVA
TASK: frac1
*/
//package frac1;

import java.io.*;
import java.util.*;
import java.math.*;

class frac1{
    public static class Fraction implements Comparable{
        int num;
        int den;
        public Fraction(int num, int den){
            this.num = num;
            this.den = den;
        }
        public int compareTo(Object o) {
            int frac1 = this.num * ((Fraction)o).den;
            int frac2 = this.den * ((Fraction)o).num;
            if(frac1 < frac2){
                return -1;
            }
            else if(frac1 > frac2){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        ArrayList<Fraction> fracs = new ArrayList<Fraction>();
        fracs.add(new Fraction(0,1));
        fracs.add(new Fraction(1,1));
        for(int i = 2; i <= n; i++){
            fracs.add(new Fraction(1,i));
            for(int j = 2; j < i; j++){
                if(gcd(j,i) == 1){
                    fracs.add(new Fraction(j,i));
                }
            }
        }
        Collections.sort(fracs);
        for(int i = 0; i < fracs.size(); i++){
            Fraction temp = fracs.get(i);
            out.println(temp.num + "/" + temp.den);
        }
        out.close();
        System.exit(0);
    }
    
    // Eucledian Algorithm
    // second number is always the larger one
    public static int gcd(int i, int j){
        //System.out.println(i+ " " + j);
        if(i == 0 || i == j){
            return j;
        }
        else{
            int new1 = i;
            int new2 = j - i;
            if(new1 < new2){
                return gcd(new1, new2);
            }
            else{
                return gcd(new2, new1);
            }
        }
    }
}