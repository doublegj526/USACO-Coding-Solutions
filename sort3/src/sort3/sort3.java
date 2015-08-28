/*
ID: jgee1
LANG: JAVA
TASK: sort3
*/
//package sort3;

import java.io.*;
import java.util.*;
import java.math.*;

class sort3{
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        int[] arr = new int[n];
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int i = 0; i < n; i++){
            nstr = new StringTokenizer(f.readLine());
            int temp = Integer.parseInt(nstr.nextToken());
            if(temp == 1){
                count1++;
            }
            else if(temp == 2){
                count2++;
            }
            else if(temp == 3){
                count3++;
            }
            arr[i] = temp;
        }
        int twosInOnes = 0;
        int threesInOnes = 0;
        int onesInTwos = 0;
        int threesInTwos = 0;
        int onesInThrees = 0;
        int twosInThrees = 0;
        for(int i = 0; i < count1; i++){
            if(arr[i] == 2)
            {
                twosInOnes++;
            }
            else if(arr[i] == 3){
                threesInOnes++;
            }
        }
        for(int i = count1; i < count1 + count2; i++){
            if(arr[i] == 1)
            {
                onesInTwos++;
            }
            else if(arr[i] == 3){
                threesInTwos++;
            }
        }
        for(int i = count1 + count2; i < n; i++){
            if(arr[i] == 1)
            {
                onesInThrees++;
            }
            else if(arr[i] == 2){
                twosInThrees++;
            }
        }
        int moves = 0;
        //out.println(twosInOnes + " " + threesInOnes + " " + onesInTwos + " " + threesInTwos + " " + onesInThrees + " " + twosInThrees);
        
        while(twosInOnes + threesInOnes + onesInTwos + threesInTwos + onesInThrees + twosInThrees != 0){
            //System.out.println(twosInOnes + " " + threesInOnes + " " + onesInTwos + " " + threesInTwos + " " + onesInThrees + " " + twosInThrees);
            if(onesInThrees > 0 && threesInOnes > 0){
                onesInThrees--;
                threesInOnes--;
            }
            else if(onesInTwos > 0 && twosInOnes > 0){
                onesInTwos--;
                twosInOnes--;
            }
            else if(twosInThrees > 0 && threesInTwos > 0){
                twosInThrees--;
                threesInTwos--;
            }
            else if(onesInThrees > 0 && threesInTwos > 0){
                onesInThrees--;
                threesInTwos--;
                onesInTwos++;
            }
            else if(twosInThrees > 0 && threesInOnes > 0){
                twosInThrees--;
                threesInOnes--;
                twosInOnes++;
            }
            else if(onesInTwos > 0 && twosInThrees > 0){
                onesInTwos--;
                twosInThrees--;
                onesInThrees++;
            }
            else if(threesInTwos > 0 && twosInOnes > 0){
                threesInTwos--;
                twosInOnes--;
                threesInOnes++;
            }
            else if(threesInOnes > 0 && onesInTwos > 0){
                threesInOnes--;
                onesInTwos--;
                threesInTwos++;
            }
            else if(twosInOnes > 0 && onesInThrees > 0){
                twosInOnes--;
                onesInThrees--;
                twosInThrees++;
            }
            moves++;
        }
        out.println(moves);
        out.close();
        System.exit(0);
    }
}