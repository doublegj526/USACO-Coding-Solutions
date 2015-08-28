/*
ID: jgee1
LANG: JAVA
TASK: skidesign
*/
//package skidesign;

import java.io.*;
import java.util.*;
import java.math.*;
/*
class skidesign {
   public static PrintWriter out;
   public static class IntegerObject implements Comparable{
       int i;
       int dist;
       public IntegerObject(int i, int dist){
           this.i = i;
           this.dist = dist;
       }
        public int compareTo(Object o) {
            if(this.i <= ((IntegerObject)o).i){
                return -1;
            }
            else{
                return 1;
            }
        }
       
   }
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        ArrayList<IntegerObject> arr = new ArrayList<IntegerObject>();
        for(int i = 0; i < n; i++){
            nstr = new StringTokenizer(f.readLine());
            int j = Integer.parseInt(nstr.nextToken());
            arr.add(new IntegerObject(j,0));
        }
        Collections.sort(arr);
        //printArr(arr);
        while(arr.get(n-1).i - arr.get(0).i > 17){
            //printArr(arr);
            int bottomDist = 0;
            int topDist = 0;
            int frontChecker = arr.get(0).i;
            int backChecker = arr.get(n-1).i;
            int indexFront = 1;
            int indexBack = n-1;
            while(arr.get(indexFront).i == frontChecker){
                indexFront++;
            }
            while(arr.get(indexBack).i == backChecker){
                indexBack--;
            }
            for(int i = 0; i < indexFront; i++){
                bottomDist += arr.get(i).dist;
            }
            for(int i = indexBack; i < n; i++){
                topDist += arr.get(i).dist;
            }
            if(bottomDist >= topDist){
                int newdistsqrt = ((int)Math.sqrt(arr.get(n-1).dist) + 1);
                int newdist = newdistsqrt * newdistsqrt;
                int index = n - 1;
                arr.get(n-1).i = arr.get(n-1).i - 1;
                arr.get(n-1).dist = newdist;
                while(arr.get(index).i < arr.get(index - 1).i){
                    IntegerObject temp = arr.get(index - 1);
                    arr.set(index - 1, arr.get(index));
                    arr.set(index, temp);
                    index--;
                }
                while(arr.get(index).i == arr.get(index - 1).i && arr.get(index).dist < arr.get(index - 1).dist){
                    IntegerObject temp = arr.get(index - 1);
                    arr.set(index - 1, arr.get(index));
                    arr.set(index, temp);
                    index--;
                }
            }
            else{
                int newdistsqrt = ((int)Math.sqrt(arr.get(0).dist) + 1);
                int newdist = newdistsqrt * newdistsqrt;
                int index = 0;
                arr.get(index).i = arr.get(index).i + 1;
                arr.get(index).dist = newdist;
                while(arr.get(index).i > arr.get(index + 1).i){
                    IntegerObject temp = arr.get(index + 1);
                    arr.set(index + 1, arr.get(index));
                    arr.set(index, temp);
                    index++;
                }
                while(arr.get(index).i == arr.get(index + 1).i && arr.get(index).dist > arr.get(index + 1).dist){
                    IntegerObject temp = arr.get(index + 1);
                    arr.set(index + 1, arr.get(index));
                    arr.set(index, temp);
                    index++;
                }
                
            }
        }
        //printArr(arr);
        int total = 0;
        for(int i = 0; i < n; i++){
            total += arr.get(i).dist;
        }
        out.println(total);
        out.close();                                 
        System.exit(0);                            
    }
    public static void printArr(ArrayList<IntegerObject> arr){
        int n = arr.size();
        for(int i = 0; i < n; i++){
            out.print(arr.get(i).i + "," + arr.get(i).dist + "  ");
        }
        out.println();
    }
}*/
class skidesign {
   public static PrintWriter out;
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            nstr = new StringTokenizer(f.readLine());
            int j = Integer.parseInt(nstr.nextToken());
            arr.add(j);
        }
        int total = Integer.MAX_VALUE;
        int minindex = Integer.MAX_VALUE;
        for(int j = 0; j < 83; j++){
            int temptotal = 0;
            for(int i = 0; i < n; i++){
                if(arr.get(i) < j || arr.get(i) > (j+17)){
                    int sum1 = (arr.get(i) - j) * (arr.get(i) - j);
                    int sum2 = (arr.get(i) - (j+17)) * (arr.get(i) - (j+17));
                    temptotal += Math.min(sum1, sum2);
                }
            }
            if(temptotal < total){
                total = temptotal;
                minindex = j;
            }
        }
        out.println(total);
        //out.println(minindex);
        out.close();                                 
        System.exit(0);                            
    }
}