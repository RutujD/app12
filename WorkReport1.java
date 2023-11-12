package app12.com.test;

public class WorkReport1 {
	 public static void main(String[] args) {
	        String readFile = "D:\\report.txt";
	        String writeFile = "D:\\report3.txt";

	        ReadWriteThread1 readWriteThread = new ReadWriteThread1(readFile, writeFile);
	        Thread thread = new Thread(readWriteThread);

	        thread.start();
	    }
}
