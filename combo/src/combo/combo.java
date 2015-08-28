/*
ID: jgee1
LANG: JAVA
TASK: combo
*/
//package combo;

import java.io.*;
import java.util.*;

class combo {
   public static HashSet<ArrayList<Integer>> combos;
   public static int mod; 
   public static PrintWriter out;
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        ArrayList<Integer> combo1 = new ArrayList<Integer>();
        ArrayList<Integer> combo2 = new ArrayList<Integer>();
        nstr = new StringTokenizer(f.readLine());
        for(int i = 0; i < 3; i++){
            combo1.add(Integer.parseInt(nstr.nextToken()));
        }
        nstr = new StringTokenizer(f.readLine());
        for(int i = 0; i < 3; i++){
            combo2.add(Integer.parseInt(nstr.nextToken()));
        }
        int max = 5;
        if(n < 5){
            max = n;
        }
        //out.println(2*max*max*max);
        //out.println(findIntersection(combo1, combo2, n));
        out.println(2*max*max*max - findIntersection(combo1, combo2, n));
        //out.println(2 % 1);
        out.close();                                 
        System.exit(0);                            
    }
    public static int findIntersection(ArrayList<Integer> combo1, ArrayList<Integer> combo2, int n){
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        HashSet<Integer> firstcombo1 = new HashSet<Integer>();
        HashSet<Integer> firstcombo2 = new HashSet<Integer>();
        HashSet<Integer> secondcombo1 = new HashSet<Integer>();
        HashSet<Integer> secondcombo2 = new HashSet<Integer>();
        HashSet<Integer> thirdcombo1 = new HashSet<Integer>();
        HashSet<Integer> thirdcombo2 = new HashSet<Integer>();
        for(int i = -2; i <= 2; i++){
            firstcombo1.add(properMod(combo1.get(0)+i,n));
            firstcombo2.add(properMod(combo2.get(0)+i,n));
            secondcombo1.add(properMod(combo1.get(1)+i,n));
            secondcombo2.add(properMod(combo2.get(1)+i,n));
            thirdcombo1.add(properMod(combo1.get(2)+i,n));
            thirdcombo2.add(properMod(combo2.get(2)+i,n));
        }
        firstcombo1.retainAll(firstcombo2);
        secondcombo1.retainAll(secondcombo2);
        thirdcombo1.retainAll(thirdcombo2);
        return firstcombo1.size() * secondcombo1.size() * thirdcombo1.size();
    }
    public static int properMod(int i, int mod){
        if(i >= 0){
            if(i % mod == 0){
                return mod;
            }
            else{
                return i % mod;
            }
        }
        else{
            while(i <= 0){
                i = i + mod;
            }
            return i;
        }
    }
}

/*
class combo {
   public static HashSet<ArrayList<Integer>> combos;
   public static int mod; 
   public static PrintWriter out;
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("combo2.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        mod = Integer.parseInt(nstr.nextToken());
        ArrayList<Integer> combo1 = new ArrayList<Integer>();
        ArrayList<Integer> combo2 = new ArrayList<Integer>();
        combos = new HashSet<ArrayList<Integer>>();
        nstr = new StringTokenizer(f.readLine());
        for(int j = 0 ; j < 3; j++){
            int x = Integer.parseInt(nstr.nextToken());
            combo1.add(x);
        }
        nstr = new StringTokenizer(f.readLine());
        for(int j = 0 ; j < 3; j++){
            combo2.add(Integer.parseInt(nstr.nextToken()));
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(Integer.MAX_VALUE);
        temp.add(Integer.MAX_VALUE);
        temp.add(Integer.MAX_VALUE);
        addCombos(temp,combo1, 0);
        addCombos(temp,combo2, 0);
        out.println(combos.size());
        out.close();                                 
        System.exit(0);                            
    }
   public static ArrayList<Integer> zero(ArrayList<Integer> a){
       ArrayList<Integer> b = new ArrayList<Integer>();
       b.add(0);
       b.add(properMod(a.get(1) - a.get(0),mod));
       b.add(properMod(a.get(2) - a.get(1),mod));
       return b;
   }
   //219, 250
   public static void addCombos(ArrayList<Integer> build, ArrayList<Integer> combo, int index){
        if(index == 3){
            ArrayList<Integer> first = new ArrayList<Integer>();
            ArrayList<Integer> second = new ArrayList<Integer>();
            ArrayList<Integer> third = new ArrayList<Integer>();
            ArrayList<Integer> fourth = new ArrayList<Integer>();
            ArrayList<Integer> fifth = new ArrayList<Integer>();
            ArrayList<Integer> sixth = new ArrayList<Integer>();
            ArrayList<Integer> seventh = new ArrayList<Integer>();
            ArrayList<Integer> eighth = new ArrayList<Integer>();
            first.add(2);
            first.add(3);
            first.add(4);
            second.add(2);
            second.add(4);
            second.add(7);
            third.add(2);
            third.add(5);
            third.add(7);
            fourth.add(2);
            fourth.add(6);
            fourth.add(7);
            fifth.add(4);
            fifth.add(6);
            fifth.add(4);
            sixth.add(4);
            sixth.add(7);
            sixth.add(4);
            seventh.add(5);
            seventh.add(6);
            seventh.add(4);
            eighth.add(5);
            eighth.add(7);
            eighth.add(4);
            if(build.equals(first) || build.equals(second) || build.equals(third)|| build.equals(fourth)|| build.equals(fifth)|| build.equals(sixth)|| build.equals(seventh)|| build.equals(eighth)){
                out.println(combo + " " + build + " " + combos.contains(build));
            }
            combos.add(build);
            int[] a = new int[1];
            a[0] = 2;
            int[] b = new int[1];
            b[0] = 2;
            out.println(a.equals(b));
            return;
        }
        else{
            int fix = combo.get(index);
            for(int i = -2; i <= 2; i++){
                //out.println(build);
                int add = properMod(fix+i, mod);
                    build.set(index, add);
                    addCombos(build,combo,index+1);
                
            }
        }
   }
   public static int properMod(int i, int mod){
       if(i >= 0){
           if(i % mod == 0){
               return mod;
           }
           else{
               return i % mod;
           }
       }
       else{
           return i + mod;
       }
   }
}
*/