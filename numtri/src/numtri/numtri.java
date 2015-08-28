/*
ID: jgee1
LANG: JAVA
TASK: numtri
*/
//package numtri;

import java.io.*;
import java.util.*;
import java.math.*;

class numtri{
    public static class Node{
        int i; 
        int max;
        public Node(int i){
            this.i = i;
            this.max = Integer.MIN_VALUE;
        }
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        ArrayList<Node> prev = new ArrayList<Node>();
        ArrayList<Node> curr = new ArrayList<Node>();
        Node first = null;
        int index = 1;
        for(int i = 0; i < n; i++){
            nstr = new StringTokenizer(f.readLine());
            prev = curr;
            curr = new ArrayList<Node>();
            for(int j = 0; j < index; j++){
                int temp = Integer.parseInt(nstr.nextToken());
                curr.add(new Node(temp));
            }
            if(index != 1){
                for(int j = 0; j < index; j++){
                    if(j==0){
                        curr.get(j).max = prev.get(j).max + curr.get(j).i;
                    }
                    else if(j == index - 1){
                        curr.get(j).max = prev.get(j-1).max + curr.get(j).i;
                    }
                    else{
                        curr.get(j).max = Math.max(prev.get(j).max, prev.get(j-1).max) + curr.get(j).i;
                    }
                }
            }
            else{
                first = curr.get(0);
                first.max = first.i;
            }
            index++;
        }
        int totalMax = Integer.MIN_VALUE;
        for(int i = 0; i < curr.size(); i++){
            totalMax = Math.max(totalMax, curr.get(i).max);
        }
        out.println(totalMax);
        out.close();
        System.exit(0);
    }
}