/*
ID: jgee1
LANG: JAVA
TASK: castle
*/
//package castle;

import java.io.*;
import java.util.*;
import java.math.*;

class castle{
    public static class room{
        boolean north;
        boolean east;
        boolean south;
        boolean west;
        int size;
        int hqi;
        int hqj;
        public room(){
            this.north = true;
            this.east = true;
            this.south = true;
            this.west = true;
            this.size = 0;
            this.hqi = Integer.MIN_VALUE;
            this.hqj = Integer.MIN_VALUE;
        }
        public void toggleNorth(){
            this.north = false;
        }
        public void toggleEast(){
            this.east = false;
        }
        public void toggleSouth(){
            this.south = false;
        }
        public void toggleWest(){
            this.west = false;
        }
        public void setSize(int size){
            this.size = size;
        }
    }
    public static room[][] rooms;
    public static boolean[][] visited;
    public static int m;
    public static int n;
    public static int numrooms;
    public static int maxsize;
    public static PrintWriter out;
    public static int bestWallI;
    public static int bestWallJ;
    public static int finalWallI;
    public static int finalWallJ;
    public static int bestWallBreak;
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        StringTokenizer nstr = new StringTokenizer(f.readLine());
        n = Integer.parseInt(nstr.nextToken());
        m = Integer.parseInt(nstr.nextToken());
        rooms = new room[m][n];
        visited = new boolean[m][n];
        bestWallI = Integer.MIN_VALUE;
        bestWallJ = Integer.MIN_VALUE;
        bestWallBreak = Integer.MIN_VALUE;
        finalWallI = Integer.MIN_VALUE;
        finalWallJ = Integer.MAX_VALUE;
        numrooms = 0;
        maxsize = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                rooms[i][j] = new room();
            }
        }
        for(int i = 0; i < m; i++){
            nstr = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++){
                int temp = Integer.parseInt(nstr.nextToken());
                if(temp == 1){
                    rooms[i][j].toggleWest();
                }
                else if(temp == 2){
                    rooms[i][j].toggleNorth();
                }
                else if(temp == 3){
                    rooms[i][j].toggleWest();
                    rooms[i][j].toggleNorth();
                }
                else if(temp == 4){
                    rooms[i][j].toggleEast();
                }
                else if(temp == 5){
                    rooms[i][j].toggleWest();
                    rooms[i][j].toggleEast();
                }
                else if(temp == 6){
                    rooms[i][j].toggleNorth();
                    rooms[i][j].toggleEast();
                }
                else if(temp == 7){
                    rooms[i][j].toggleWest();
                    rooms[i][j].toggleNorth();
                    rooms[i][j].toggleEast();
                }
                else if(temp == 8){
                    rooms[i][j].toggleSouth();
                }
                else if(temp == 9){
                    rooms[i][j].toggleWest();
                    rooms[i][j].toggleSouth();
                }
                else if(temp == 10){
                    rooms[i][j].toggleNorth();
                    rooms[i][j].toggleSouth();
                }
                else if(temp == 11){
                    rooms[i][j].toggleWest();
                    rooms[i][j].toggleNorth();
                    rooms[i][j].toggleSouth();
                }
                else if(temp == 12){
                    rooms[i][j].toggleEast();
                    rooms[i][j].toggleSouth();
                }
                else if(temp == 13){
                    rooms[i][j].toggleWest();
                    rooms[i][j].toggleEast();
                    rooms[i][j].toggleSouth();
                }
                else if(temp == 14){
                    rooms[i][j].toggleNorth();
                    rooms[i][j].toggleEast();
                    rooms[i][j].toggleSouth();
                }
                else if(temp == 15){
                    rooms[i][j].toggleWest();
                    rooms[i][j].toggleNorth();
                    rooms[i][j].toggleEast();
                    rooms[i][j].toggleSouth();
                }
            }
        }
        /*for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                out.println(rooms[i][j].north + " " + rooms[i][j].south + " " + rooms[i][j].east + " " + rooms[i][j].west);
            }
        }*/
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    numrooms++;
                    explore(i,j,Integer.MIN_VALUE,Integer.MIN_VALUE);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ;j++){
                rooms[i][j].size = rooms[rooms[i][j].hqi][rooms[i][j].hqj].size;
            }
        }
        /*for(int i = 0; i < m; i++){
            for(int j = 0; j < n ;j++){
                out.print(rooms[i][j].size + " ");
            }
            out.println();
        }*/
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                goThroughWalls(i,j);
            }
        }
        out.println(numrooms);
        out.println(maxsize);
        out.println(bestWallBreak);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }
        findBestWall(bestWallI, bestWallJ);
        //out.println(finalWallI + " " + finalWallJ);
        if(finalWallI > 0 && !rooms[finalWallI][finalWallJ].north && (rooms[finalWallI][finalWallJ].size + rooms[finalWallI-1][finalWallJ].size == bestWallBreak))
            out.println(++finalWallI + " " + ++finalWallJ + " " + "N");
        else if(finalWallJ < (n-1) && !rooms[finalWallI][finalWallJ].east && (rooms[finalWallI][finalWallJ].size + rooms[finalWallI][finalWallJ+1].size == bestWallBreak))
        {
           out.println(++finalWallI + " " + ++finalWallJ + " " + "E");
        }
        out.close();
        System.exit(0);
    }
    public static void explore(int i, int j,int ceni, int cenj){
        //out.print(i + " " + j);
        visited[i][j] = true;
        //out.println(visited[i][j]);
        boolean spanNorth = false;
        boolean spanEast = false;
        boolean spanWest = false;
        boolean spanSouth = false;
        int val = 0;
        int newi; 
        int newj;
        if(ceni == Integer.MIN_VALUE){
            newi = i;
            newj = j;
            rooms[i][j].hqi = i;
            rooms[i][j].hqj = j;
        }
        else{
            newi = ceni;
            newj = cenj;
            rooms[i][j].hqi = ceni;
            rooms[i][j].hqj = cenj;
        }
        if(i > 0 && !visited[i-1][j] && rooms[i][j].north){
            explore(i-1,j,newi,newj);
            spanNorth = true;
            val += rooms[i-1][j].size;
        }
        if(j < (n-1) && !visited[i][j+1] && rooms[i][j].east){
            explore(i,j+1,newi,newj);
            spanEast = true;
            val += rooms[i][j+1].size;
        }
        if(j > 0 && !visited[i][j-1] && rooms[i][j].west){
            explore(i,j-1,newi,newj);
            spanWest = true;
            val += rooms[i][j-1].size;
        }
        if(i < (m-1) && !visited[i+1][j] && rooms[i][j].south){
            explore(i+1,j,newi,newj);
            spanSouth = true;
            val += rooms[i+1][j].size;
        }
        if(!spanNorth && !spanEast && !spanWest && !spanSouth){
            rooms[i][j].size = 1;
        }
        else{
            rooms[i][j].size = val + 1;
        }
        if(rooms[i][j].size > maxsize){
            maxsize = rooms[i][j].size;
        }
    }
    public static void goThroughWalls(int i, int j){
        visited[i][j] = true;
        int total = 0;
        if(i > 0 && !rooms[i][j].north && (rooms[i][j].hqi != rooms[i-1][j].hqi || rooms[i][j].hqj != rooms[i-1][j].hqj)){
            total = rooms[i][j].size + rooms[i-1][j].size;
            if(total > bestWallBreak){
                bestWallBreak = total;
                bestWallI = i;
                bestWallJ = j;
            }
        }
        if(j < (n-1) && !rooms[i][j].east && (rooms[i][j].hqi != rooms[i][j+1].hqi || rooms[i][j].hqj != rooms[i][j+1].hqj)){
            total = rooms[i][j].size + rooms[i][j+1].size;
            if(total > bestWallBreak){
                bestWallBreak = total;
                bestWallI = i;
                bestWallJ = j;
            }
        }
        if(j > 0 && !rooms[i][j].west && (rooms[i][j].hqi != rooms[i][j-1].hqi || rooms[i][j].hqj != rooms[i][j-1].hqj)){
            total = rooms[i][j].size + rooms[i][j-1].size;
            if(total > bestWallBreak){
                bestWallBreak = total;
                bestWallI = i;
                bestWallJ = j;
            }
        }
        if(i < (m-1) && !rooms[i][j].south && (rooms[i][j].hqi != rooms[i+1][j].hqi || rooms[i][j].hqj != rooms[i+1][j].hqj)){
            total = rooms[i][j].size + rooms[i+1][j].size;
            if(total > bestWallBreak){
                bestWallBreak = total;
                bestWallI = i;
                bestWallJ = j;
            }
        }
    }
    public static void findBestWall(int i, int j){
        if(visited[i][j]){
            return;
        }
        else{
            visited[i][j] = true;
            boolean temp = (i > 0 && !rooms[i][j].north && (rooms[i][j].size + rooms[i-1][j].size == bestWallBreak)) || (j < (n-1) && !rooms[i][j].east && (rooms[i][j].size + rooms[i][j+1].size == bestWallBreak));
            if(j < finalWallJ && temp){
                finalWallI = i;
                finalWallJ = j;
                //out.println("sup" + finalWallI + " " + finalWallJ);
            }
            else if(j == finalWallJ && i > finalWallI && temp){
                finalWallI = i;
                finalWallJ = j;
                //out.println("sup" + finalWallI + " " + finalWallJ);
            }
            if(i > 0 && (rooms[i][j].north || (!rooms[i][j].north && (rooms[i][j].size + rooms[i-1][j].size == bestWallBreak)))){
                findBestWall(i-1,j);
            }
            if(i < (m-1) && (rooms[i][j].south || (!rooms[i][j].south && (rooms[i][j].size + rooms[i+1][j].size == bestWallBreak)))){
                findBestWall(i+1,j);
            }
            if(j > 0 && (rooms[i][j].west || (!rooms[i][j].west && (rooms[i][j].size + rooms[i][j-1].size == bestWallBreak)))){
                findBestWall(i,j-1);
            }
            if(j < (n-1) && (rooms[i][j].east || (!rooms[i][j].east && (rooms[i][j].size + rooms[i][j+1].size == bestWallBreak)))){
                findBestWall(i,j+1);
            }
        }
    }
}