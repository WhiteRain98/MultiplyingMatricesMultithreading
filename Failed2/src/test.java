import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test extends Thread{
	public void run(int x, int y, int commonNumber, int firstArr[][], int secondArr[][]) {
//		int sum = 0;
//		for(int i = 0; i < commonNumber; i++) {
//			sum += firstArr[x][i] * secondArr[i][y];
//		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
			
		test thread = new test();
		thread.start();
		Scanner sc = new Scanner(System.in);
		
		String fileOne="";
		String fileTwo="";
		int u;
		int v;
		int w;
		
		System.out.println("Enter first file name");
		fileOne = sc.nextLine();
		System.out.println("Enter second file name");
		fileTwo = sc.nextLine();
	
		File firstFile = new File(fileOne);
		Scanner firstInput = new Scanner(firstFile);
		
		File secondFile = new File(fileTwo);
		Scanner secondInput = new Scanner(secondFile);
		
		System.out.println("Enter u");
		u = Integer.parseInt(sc.next());
		System.out.println("Enter v");
		v = Integer.parseInt(sc.next());
		System.out.println("Enter w");
		w = Integer.parseInt(sc.next());
		
		int commonNumber = u*w;
		
//		test t = new test();
//		for (int a = 0; a < threadNumber; a++) {
//			t.start();
//		}
		
		//int sum = 0;
		for(int i = 0; i < commonNumber; i++) {
			TestThread thread2 = new TestThread(2, 2, (int result) -> {
				System.out.println("Result is " + result);
			});
			//sum += firstArr[x][i] * secondArr[i][y];
		}
		
		TestThread thread2 = new TestThread(2, 2, (int result) -> {
			System.out.println("Result is " + result);
		});
		
		thread2.start();
		
//		TestThread thread3 = new TestThread(3, 3, new TestThread.ThreadCallback() {
//			@Override
//			public void onResult(final int result) {
//				int y = result + x;
//			}
//		});

		
		//BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		//Get u, v, w
		/*
		System.out.println("Enter in thhree numbers u, v and w, where the first matrix is of size u×v and the second of size v×w.");
		int u,v,w;
		StringTokenizer st = new StringTokenizer(input.readLine());
		u = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		while (u < 0) {
			System.out.println("'U' must be positive");
			st = new StringTokenizer(input.readLine());
			u = Integer.parseInt(st.nextToken());
		}
		while (v < 0) {
			System.out.println("'U' must be positive");
			st = new StringTokenizer(input.readLine());
			u = Integer.parseInt(st.nextToken());
		}
		while (w < 0) {
			System.out.println("'U' must be positive");
			st = new StringTokenizer(input.readLine());
			u = Integer.parseInt(st.nextToken());
		}
		System.out.println(u + " " + v + " " + w);
		
		*/
		//Get name of first file
		
		/* 
		System.out.println("Enter in the name of the first matrix file.");
		String m1 = input.readLine();
		boolean fileFound = false;
		while (!fileFound) {
			try {
				BufferedReader changeName = new BufferedReader(new FileReader(m1));
				fileFound = true;
			}
			catch (Exception e) {
				System.out.println("Enter in the name of the first matrix file.");
				m1 = input.readLine();
			};
		}
		//Get name of second file
	
		System.out.println("Enter in the name of the second matrix file.");
		String m2 = input.readLine();
		fileFound = false;
		while (!fileFound) {
			try {
				BufferedReader changeName = new BufferedReader(new FileReader(m2));
				fileFound = true;
			}
			catch (Exception e) {
				System.out.println("Enter in the name of the second matrix file.");
				m2 = input.readLine();
			};
		}
		//Get name of final file
	
		System.out.println("Enter in the name of the final matrix file.");
		String finalM = input.readLine();
		fileFound = false;
		while (!fileFound) {
			try {
				BufferedReader changeName = new BufferedReader(new FileReader(finalM));
				fileFound = true;
			}
			catch (Exception e) {
				System.out.println("Enter in the name of the final matrix file.");
				finalM = input.readLine();
			};
		}
		
		System.out.println(m1 + " " + m2 + " " + finalM);
	
		
		//System.out.println(m1 + " " + m2 + " " + finalMatrix);
		//BufferedReader matrix1 = new BufferedReader(new FileReader("Matrix1.rtf"));
		 
	     //while ((z = br.nextDouble()) != -1)
	     //System.out.print((char)z);
		
		MyTask task = new MyTask();
		//task.executeTask();
		task.start();
		
		*/
			
	}
}
