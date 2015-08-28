/*
ID: jgee1
LANG: JAVA
TASK: money
*/

//package money;

import java.io.*;
import java.util.*;
import java.math.*;

class money{
    public static PrintWriter out;
    public static ArrayList<Integer> arr;
    //public static long[] ways;
    public static HashMap<Integer,HashMap<Integer,Long>> lookup;
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("money.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int v = Integer.parseInt(nstr.nextToken());
        int n = Integer.parseInt(nstr.nextToken());
        nstr = new StringTokenizer(f.readLine());
        arr = new ArrayList<Integer>();
        HashSet<Integer> unique = new HashSet<Integer>();
        int temp;
        lookup = new HashMap<Integer,HashMap<Integer,Long>>();
        for(int i = 0; i < v; i++){
            try{
                temp = Integer.parseInt(nstr.nextToken());
            }
            catch(NoSuchElementException e){
                nstr = new StringTokenizer(f.readLine());
                temp = Integer.parseInt(nstr.nextToken());
            }
            //System.out.println(temp);
            if(!unique.contains(temp)){
                unique.add(temp);
                arr.add(temp);
            }
        }
        /*ways = new int[n+1];
        for(int i = 0 ; i < ways.length; i++){
            ways[i] = -1;
        }
        ways[1] = 0;*/
        Collections.sort(arr);
        //out.println(arr);
        out.println(findWays(n,arr.size()-1));
        /*for(int i = 0; i < ways.length; i++){
            out.println(ways[i]);
        }*/
        out.close();
        System.exit(0);
    }
    
    // num is the amount you want to get
    // indx is the largest denomination you can use
    public static long findWays(int num,int indx){
        //System.out.println(num + " " + indx);
        //System.out.println(num + " " + indx);
        /*if(ways[indx] != -1){
            return ways[indx];
        }
        else{*/
        //out.println(num + " " + indx);
        if(lookup.get(num) != null && lookup.get(num).get(indx) != null){
            return lookup.get(num).get(indx);
        }
        else if(num == 0 || (indx == 0 && (num % arr.get(0) == 0))){
            if(lookup.get(num) == null){
                lookup.put(num,new HashMap<Integer,Long>());
            }
            long s = 1;
            lookup.get(num).put(indx, s);
            return 1;
        }
        else{
            long total = 0;
            /*for(int i = 0; i < arr.size(); i++){
                int temp = indx - arr.get(i);
                if(temp >= 0){
                    total += findWays(temp);
                }
            }*/
            for(int i = indx; i >= 0; i--){
                int temp = num - arr.get(i);
                if(temp == 0 || (i == 0 && (temp % arr.get(0) == 0))){
                    if(lookup.get(temp) == null){
                        lookup.put(temp,new HashMap<Integer,Long>());
                    }
                    //long s = 1;
                    //lookup.get(num).put(i, s);
                    //return 1;
                    total += 1;
                }
                else if(i == 0){
                    continue;
                }
                else if(temp > 0){
                    if(lookup.get(temp) != null && lookup.get(temp).get(i) != null){
                        total += lookup.get(temp).get(i);
                    }
                    else{
                        total += findWays(temp,i);
                    }
                }
            }
            //ways[indx] = total;
            if(lookup.get(num) == null){
                lookup.put(num,new HashMap<Integer,Long>());
            }
            lookup.get(num).put(indx, total);
            return total;
        //}
        }
    }
}