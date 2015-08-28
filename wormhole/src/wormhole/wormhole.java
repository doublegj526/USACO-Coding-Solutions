/*
ID: jgee1
LANG: JAVA
TASK: wormhole
*/
//package wormhole;

import java.io.*;
import java.util.*;

class wormhole {
   public static int count;
   public static class Coordinate{
       int x;
       int y;
       Coordinate partner;
       public Coordinate(int x, int y){
           this.x = x;
           this.y = y;
           this.partner = null;
       }
   }
   public static PrintWriter out;
   public static HashMap<Coordinate, Coordinate> minnewguyx;
   public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(nstr.nextToken());
        //totalCount = 0;
        ArrayList<Coordinate> coord = new ArrayList<Coordinate>();
        HashSet<Coordinate> toIterOver = new HashSet<Coordinate>();
        for(int i = 0; i < n; i++){
            nstr = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(nstr.nextToken());
            int y = Integer.parseInt(nstr.nextToken());
            Coordinate c = new Coordinate(x,y);
            coord.add(c);
            toIterOver.add(c);
        }
        count = 0;
        minnewguyx = new HashMap<Coordinate, Coordinate>();
        for(int i = 0; i < coord.size(); i++){
            Coordinate tempcoord = coord.get(i);
            int tempx = tempcoord.x;
            int tempy = tempcoord.y;
            Coordinate nextGuy = null;
            int minnewguyxtemp = Integer.MAX_VALUE;
            for(int j = 0; j< coord.size(); j++){
                Coordinate traveler = coord.get(j);
                int travelerx = traveler.x;
                int travelery = traveler.y;
                if(travelery == tempy && travelerx < minnewguyxtemp && traveler.x > tempx){
                    minnewguyxtemp = traveler.x;
                    nextGuy = traveler;
                }
            }
            minnewguyx.put(tempcoord, nextGuy);
        }
        /*for(int i = 0; i < coord.size(); i++){
            out.print(coord.get(i).x + "," + coord.get(i).y + " : ");
            if(minnewguyx.get(coord.get(i)) != null)
                out.println(minnewguyx.get(coord.get(i)).x + "," + minnewguyx.get(coord.get(i)).y);
            else
                out.println("null");
        }*/
        out.println(pairingAssignment(coord, 0, n));
        //out.println(count);
        out.close();                                 
        System.exit(0);                            
    }
    public static int pairingAssignment(ArrayList<Coordinate> coord, int index, int n){
        if(index >= n){
            /*for(int i = 0; i < coord.size(); i++){
                System.out.println(coord.get(i).x + ","+ coord.get(i).y + " : " + coord.get(i).partner.x + "," + coord.get(i).partner.y);
            }
            System.out.println();*/
            HashMap<Coordinate, Coordinate> map = new HashMap<Coordinate, Coordinate>();
            for(int i = 0; i < coord.size(); i++){
                map.put(coord.get(i), coord.get(i).partner);
            }
            return checkNoCycles(map, coord);
        }
        else{
            int total = 0;
            int siz = coord.size();
            for(int i = index + 1; i < siz; i++){
                if(coord.get(i).partner == null){
                    //System.out.println(index + " " + i);
                    coord.get(index).partner = coord.get(i);
                    coord.get(i).partner = coord.get(index);
                    int indexTick = index + 1;
                    while(indexTick < n && coord.get(indexTick).partner != null){
                        indexTick++;
                    }
                    total += pairingAssignment(coord, indexTick, n);
                    //System.out.println(indexTick);
                    coord.get(index).partner = null;
                    coord.get(i).partner = null;
                }
            }
            return total;
        }
    }
    public static int checkNoCycles(HashMap<Coordinate,Coordinate> build, ArrayList<Coordinate> coord){
        //Iterator<Coordinate> newit = build.keySet().iterator();
        /*while(newit.hasNext()){
            Coordinate mapkey = newit.next();
            out.println(mapkey.x + "," + mapkey.y + " : " + build.get(mapkey).x + "," + build.get(mapkey).y);
        }*/
        for(int i = 0; i < coord.size(); i++){
            Coordinate iternext = coord.get(i);
            Coordinate traveler = iternext;
            HashMap<Coordinate, Integer> visited= new HashMap<Coordinate,Integer>();
            
            for(int j = 0; j < coord.size(); j++){
                visited.put(coord.get(j),0);
            }
            visited.put(iternext,1);
            while(true){
                //out.println(traveler.x + " " + traveler.y);
                Coordinate nextGuy = minnewguyx.get(traveler);
                if(nextGuy == null){
                    break;
                }
                else{
                    traveler = build.get(nextGuy);
                    if((visited.get(nextGuy) > 1) || (visited.get(traveler) > 1)){
                        //out.println("this one you should check");
                        // count++;
                        return 1;
                    }
                    visited.put(nextGuy, visited.get(nextGuy) + 1);
                    visited.put(traveler, visited.get(traveler) + 1);
                }
            }
        }
        return 0;
    }
}