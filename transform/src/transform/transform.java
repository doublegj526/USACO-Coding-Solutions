/*
ID: jgee1
LANG: JAVA
TASK: transform
*/
//package transform;

import java.io.*;
import java.util.*;

class transform {
  public static PrintWriter out;
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("transform.in"));
    out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
    StringTokenizer nstr = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(nstr.nextToken());
    char[][] matrix1 = new char[n][n];
    char[][] matrix2 = new char[n][n];
    for(int i = 0; i < n; i++){
        nstr = new StringTokenizer(f.readLine());
        String s = nstr.nextToken();
        matrix1[i] = s.toCharArray();
    }
    for(int i = 0; i < n; i++){
        nstr = new StringTokenizer(f.readLine());
        matrix2[i] = (nstr.nextToken()).toCharArray();
    }
    char[][] rotateOnce = rotate90(matrix1);
    if(equalMatrices(rotateOnce,matrix2)){
        out.println(1);
    }
    else{
        char[][] rotateTwice = rotate90(rotateOnce);
        if(equalMatrices(rotateTwice,matrix2)){
            out.println(2);
        }
        else{
            char[][] rotateThrice = rotate90(rotateTwice);
            if(equalMatrices(rotateThrice,matrix2)){
                out.println(3);
            }
            else{
                char[][] reflect = reflect(matrix1);
                if(equalMatrices(reflect,matrix2)){
                    out.println(4);
                }
                else{
                    char[][] reflect1 = rotate90(reflect);
                    if(equalMatrices(reflect1,matrix2)){
                        out.println(5);
                    }
                    else{
                        char[][] reflect2 = rotate90(reflect1);
                        if(equalMatrices(reflect2,matrix2)){
                            out.println(5);
                        }
                        else{
                            char[][] reflect3 = rotate90(reflect2);
                            if(equalMatrices(reflect3,matrix2)){
                                out.println(5);
                            }
                            else{
                                if(equalMatrices(matrix1,matrix2)){
                                    out.println(6);
                                }
                                else{
                                    out.println(7);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    out.close();                                 
    System.exit(0);                            
  }
  public static char[][] reflect(char[][] matrix){
      int n = matrix.length;
      char[][] matrix2 = new char[n][n];
      for(int i = 0; i < n; i++){
          for(int j = 0; j < n/2 + 1; j++){
              matrix2[i][n-j-1] = matrix[i][j];
              matrix2[i][j] = matrix[i][n-j-1];
          }
      }
      return matrix2;
  }
  public static void printMatrix(char[][] matrix){
      int n = matrix.length;
      for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
              out.print(matrix[i][j]);
          }
          out.println();
      }
  }
  public static char[][] rotate90(char[][] matrix){
      int n = matrix.length;
      char[][] matrix2 = new char[n][n];
      for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
              matrix2[i][j] = matrix[n-j-1][i];
          }
      }
      return matrix2;
  }
  public static boolean equalMatrices(char[][] matrix1, char[][] matrix2){
      int n = matrix1.length;
      for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
              if(matrix1[i][j] != matrix2[i][j]){
                  return false;
              }
          }
      }
      return true;
  }
}
