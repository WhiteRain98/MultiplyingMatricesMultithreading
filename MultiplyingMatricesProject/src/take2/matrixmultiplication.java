package take2;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.io.*;


public class matrixmultiplication {
        
    
    public static void main(String[] args) throws FileNotFoundException, Exception {   
    	
    	//TEST

    	
    	//System.exit(0);
    	
		Scanner sc = new Scanner(System.in);

		//Get u, v, and w
    	int u;
    	int v;
    	int w;
            	
    	System.out.println("Enter u");
    	u = Integer.parseInt(sc.next());
    	System.out.println("Enter v");
    	v = Integer.parseInt(sc.next());
    	System.out.println("Enter w");
    	w = Integer.parseInt(sc.next());
    	
    	//Create final matrix with size u, w
    	int [][] C = new int [u][w];
    	
    	//Get first matrix file and store into array
     	System.out.println("First file name");
    	Scanner sc1 = new Scanner(new BufferedReader(new FileReader(sc.next())));
        int [][] myArray = new int[u][v];
    	for (int row = 0; row < u; row++) {
    		for (int column = 0; column < v; column++) {
    			myArray[row][column] = Integer.parseInt(sc1.next());
    			//System.out.println(myArray[row][column]);
    		}
    	}
        	
        		    	
    	//Get second matrix file and store into array
     	System.out.println("Second file name");
     	sc.reset();
    	Scanner sc2 = new Scanner(new BufferedReader(new FileReader(sc.next())));
        int [][] myArray2 = new int[v][w];
    	for (int row = 0; row < v; row++) {
    		for (int column = 0; column < w; column++) {
    			myArray2[row][column] = Integer.parseInt(sc2.next());
    			//System.out.println(myArray2[row][column]);
    		}
    	}
            	    	
        
    	//Print both matrices
    	//System.out.println(Arrays.deepToString(myArray));
    	//System.out.println(Arrays.deepToString(myArray2));

        
        //Get number of threads
        Scanner threadNumber = new Scanner(System.in);
        System.out.println("How many threads?");
        int numberOfThreads = Integer.parseInt(sc.next());
        
        ExecutorService pool = Executors.newFixedThreadPool(numberOfThreads);  
        
        
        //Thread variables
        int totalSequences = u * w;
        int sequencesPerThread = totalSequences/numberOfThreads;
        int remaindingSequences = totalSequences % numberOfThreads;
        
        //System.out.println(sequencesPerThread);
        //System.out.println(remaindingSequences);
        
        WorkerThread threadThing = null;
        
        //EXECUTE THREADS
        for (int i = 0; i < numberOfThreads; i++) {
        	int sequenceStart = sequencesPerThread * i;
        	int rowStart = sequenceStart/w;
        	int columnStart = sequenceStart % w;
        	threadThing = new WorkerThread(rowStart, columnStart, sequencesPerThread, u, v, w, myArray, myArray2, C);
        	Thread myThread = new Thread(threadThing);
        	//myThread.start();
        	pool.execute(myThread);
        	//System.out.println(i + "1");
//        	try {             
//            	   System.out.println(i + "2");
//        		   myThread.join();
//        	       System.out.println(i);
//            } catch (InterruptedException e) {
//               e.printStackTrace();
//            }
//        	Thread.sleep(1000);
//        	System.out.println(i);
        }
        //Thread.sleep(1000);
        //System.out.println(Arrays.deepToString(C));
    	//System.exit(0);
    	pool.shutdown();
    	try {
            if (!pool.awaitTermination(1000, TimeUnit.SECONDS)) {
            	pool.shutdownNow();
            }
        } catch (InterruptedException ex) {
        	pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
        
        //REMAINDER THREAD
        //System.out.println("REMAINDER");
        //Unfinished column
        int sum = 0;
        int rowStartRemainder = u - (remaindingSequences/w) - 1;
        for (int columnStartRemainder = w - (remaindingSequences % w); columnStartRemainder < w; columnStartRemainder++) {
    		for (int f = 0; f < v; f++) {
				sum += myArray[rowStartRemainder][f] * myArray2[f][columnStartRemainder];
			}
        	C[rowStartRemainder][columnStartRemainder] = sum;
        	sum = 0;
    	}
        
        //Rest of columns
    	sum = 0;
    	for (rowStartRemainder = u - (remaindingSequences/w); rowStartRemainder < u; rowStartRemainder++) {
    		for (int columnStart = 0; columnStart < w; columnStart++) {
	    		for (int f = 0; f < v; f++) {
					sum += myArray[rowStartRemainder][f] * myArray2[f][columnStart];
				}
	        	C[rowStartRemainder][columnStart] = sum;
	        	sum = 0;
	    	}
    	}
    	//Thread.sleep(1000);
    	System.out.println(Arrays.deepToString(C));

        /*
         * 
         * 
         * 
         * Main - Divide (u * w) - total number of mathematical sequences - by number of threads with remainder
         * Main - Store sequencePerThread and remaindingSequences vars
         * Thread - Do mathematical sequences based on answer variable
         * 		Divide answer variable by w -> store answer and remainder into thread variables
         * 		For loop (j) for number of sequences per thread (answer variable)
         * 			Dot product multiplication - Start at A[thread answer var][col] x B[row][thread rem var]
         * 			Continue with adding j + original numbers
         * Main - Have for loop for these threads
         * 		
         * Thread - Make new thread for remainder variable
         * Main - One extra line for this thread
         * 
         * 
         * 
		 */

    }
}