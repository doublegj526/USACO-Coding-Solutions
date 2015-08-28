/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nocows2;

/**
 *
 * @author johngee
 */
public class nocows2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N = 15;
   int K = 5;
			
   long[][] state = new long[K+1][N+1]; 
		
   /*
    * Initial condition.
    */		
   state[1][1] = 1;
	    
   for (int length = 2; length <= K; ++length) {
      for (int num = 3; num <= N; num += 2) {
	    			    	    		
         int rightLength = length - 1;
	    		
         for (int rightNum = num - 2; rightNum >= 1; rightNum -= 2) {
	    			
	    /*
	     * If there are no valid right subtrees with 
	     * this state then continue
	     */
	    if (state[rightLength][rightNum] == 0)
	       continue;
	    			
	    long rightState = state[rightLength][rightNum];
	    			
	    int leftNum = num - (rightNum + 1);
	    				
	    for (int leftLength = 1; leftLength <= rightLength; ++leftLength) {
	    				
	       long leftState = state[leftLength][leftNum];
	    					
	       /*
	    	* If there is no valid left hand state continue to next
	    	* left hand state.
	    	*/
	       if (leftState == 0)
	          continue;
	    				  					
               /*
                * If leftLength == rightLength our loop will consider
                * both mirror images of the state so only count it
                * once.
                *
                * If leftNum == rightNum then both sub trees
                * are identical. The loop only considers
                * this (symmetric) state once which is correct
                */  		
	       if (leftLength == rightLength) {			
	          state[length][num] += (leftState * rightState);
	       }
	       else {
	          state[length][num] += (leftState * rightState * 2);
	       }
	    				
	       state[length][num] %= 9901;
	    				
	    }
	 }
      }
   }
	    
	        
   System.out.println(state[K][N]);
    }
    
}
