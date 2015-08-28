/*
ID: jgee1
LANG: JAVA
TASK: milk
*/
//package milk;

import java.io.*;
import java.util.*;

class milk {
   public static ArrayList<ArrayList<Integer>> occupied;
   public static PrintWriter out;
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        int m = Integer.parseInt(nstr.nextToken());
        ArrayList<Integer> prices = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < m; i++){
            nstr = new StringTokenizer(f.readLine());
            int price = Integer.parseInt(nstr.nextToken());
            prices.add(price);
            int amount = Integer.parseInt(nstr.nextToken());
            if(!map.containsKey(price))
            {
                 map.put(price,amount);
            }
            else{
                map.put(price,map.get(price) + amount);
            }
        }
        Collections.sort(prices);
        int index = 0;
        int total = 0;
        while(n > 0)
        {
            if(map.get(prices.get(index)) == 0){
                index++;
            }
            else{
                n--;
                map.put(prices.get(index), map.get(prices.get(index)) - 1);
                total += prices.get(index);
            }
        }
        out.println(total);
        out.close();                                 
        System.exit(0);                            
    }
}