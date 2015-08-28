/*
ID: jgee1
LANG: JAVA
TASK: barn1
*/
//package barn1;

import java.io.*;
import java.util.*;

class barn1 {
   public static ArrayList<ArrayList<Integer>> occupied;
   public static PrintWriter out;
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(nstr.nextToken());
        int s = Integer.parseInt(nstr.nextToken());
        occupied = new ArrayList<ArrayList<Integer>>();
        occupied.add(new ArrayList<Integer>());
        for(int i = 0; i < s; i++){
            try{
                nstr = new StringTokenizer(f.readLine());
                occupied.get(0).add(Integer.parseInt(nstr.nextToken()));
            }
            catch(NullPointerException e){
                break;
            }
        }
        Collections.sort(occupied.get(0));
        int bound = m - 1;
        if(occupied.get(0).size() - 1< bound){
            bound = occupied.get(0).size() - 1;
        }
        for(int i = 0; i < bound; i++){
            findMaxCut();
        }
        int total = 0;
        int len = occupied.size();
        for(int i = 0; i < len; i++){
            ArrayList<Integer> arr = occupied.get(i);
            int len2 = arr.size();
            total += arr.get(len2 - 1) - arr.get(0) + 1;
        }
        out.println(total);
        out.close();                                 
        System.exit(0);                            
    }
    public static void findMaxCut(){
        int arrayCut = Integer.MAX_VALUE;
        int indexCut = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int numArrays = occupied.size();
        for(int i = 0; i < numArrays; i++){
            ArrayList<Integer> arr = occupied.get(i);
            int len = arr.size();
            for(int j = 0; j < len - 1; j++){
                if(arr.get(j+1) - arr.get(j) > max){
                    max = arr.get(j+1) - arr.get(j);
                    indexCut = j;
                    arrayCut = i;
                }
            }
        }
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        ArrayList<Integer> arr = occupied.get(arrayCut);
        for(int i = 0; i <= indexCut; i++){
            arr1.add(arr.get(i));
        }
        for(int i = indexCut + 1; i < arr.size(); i++){
            arr2.add(arr.get(i));
        }
        occupied.remove(arrayCut);
        occupied.add(arr1);
        occupied.add(arr2);
    }
}