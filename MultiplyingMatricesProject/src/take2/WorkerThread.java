package take2;

import java.util.Arrays;

public class WorkerThread implements Runnable{
	private int rowStart;
    private int columnStart;
    private int sequencesPerThread;
    private int u;
    private int v;
    private int w;
    private int [][] A;
    private int [][] B;
    private int [][] C;
    
    public WorkerThread(int rowStart, int columnStart, int sequencesPerThread, int u, int v, int w, int[][] A,
      int[][] B, int[][] C) {
        this.rowStart = rowStart;
        this.columnStart = columnStart;
        this.sequencesPerThread = sequencesPerThread;
        this.u = u;
        this.v = v;
        this.w = w;
        this.A = A;
        this.B = B;
        this.C = C;
    }
    
    @Override
    public void run() {
    	int j = 0;
    	int sum = 0;
    	
    	
        //IF UNFINISHED
    	if (columnStart != 0) {
    		
    		//Unfinished row
    		for (int b = columnStart; b < w; b++) {
    			for (int c = 0; c < v; c++) {
    				sum += A[rowStart][c] * B[c][b];
    			}
        		C[rowStart][b] = sum;
        		sum = 0;
        		//System.out.println(Arrays.deepToString(C));
        		j++;
        		if (j == sequencesPerThread) {
        			return;
        		}
    		}
    		
    		//Rest of sequences
    		for (int a = rowStart + 1; a < u; a++) {
    			for (int b = 0; b < w; b++) {
    				for (int c = 0; c < v; c++) {
    					sum += A[a][c] * B[c][b];
    				}
    	    		C[a][b] = sum;
    	    		sum = 0;
    	    		//System.out.println(Arrays.deepToString(C));
    	    		j++;
    	    		if (j == sequencesPerThread) {
    	    			return;
    	    		}
    			}
    		}
    		
    		
    	}
        
    	
    	//IF FINISHED
    	if (columnStart == 0) {
    		for (int a = rowStart; a < u; a++) {
    			for (int b = 0; b < w; b++) {
    				for (int c = 0; c < v; c++) {
    					sum += A[a][c] * B[c][b];
    				}
    	    		C[a][b] = sum;
    	    		sum = 0;
    	    		//System.out.println(Arrays.deepToString(C));
    	    		j++;
    	    		if (j == sequencesPerThread) {
    	    			return;
    	    		}
    			}
    		}
    	}
    	
    	
    } 
}


 /*
Main - Divide (u * w) - total number of mathematical sequences - by number of threads with remainder
* Main - Store answer and remainder into 2 variables
* Thread - Do mathematical sequences based on answer variable
* 		Divide answer variable by w -> store answer and remainder into thread variables
* 		For loop (j) for number of sequences per thread (answer variable)
* 			Dot product multiplication - Start at A[thread answer var][col] x B[row][thread rem var]
* 			Continue with adding j + original numbers
* Main - Have for loop for these threads
* 		
* Thread - Make new thread for remainder variable
* Main - One extra line for this thread
*/