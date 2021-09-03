package file_InputOutput;
import java.io.*;

public class FileIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// code for creating the file
		File f =new File("C:\\Users\\Mohan babar\\Desktop\\Industrial Training\\src\\file_InputOutput\\Java_programming.txt");
		try {
			
			boolean file= f.createNewFile();
			if(file) {
				System.out.println("File has been created successfully...");
			}
			else {
				System.out.println("File already present...");
			}
			
		}
		catch(IOException e) {
			System.out.println("Exception occured:");
			e.printStackTrace();
		}
		
		
		//code for writing content in java_programming file
		String content="Java is a programming language and a platform. Java is a high level, robust, object-oriented and secure programming language.";
		FileOutputStream fos=null;
		try {
			
			fos=new FileOutputStream(f);
			if(!f.exists()) {
				f.createNewFile();
			}
			byte [] bytesArr=content.getBytes();
			fos.write(bytesArr);
			fos.flush();
			System.out.println("File Written sucessfully....");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		//code for reading java_programming file
		BufferedInputStream bis=null;
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(f);
			bis=new BufferedInputStream(fis);
			while(bis.available()>0) {
				System.out.println((char)bis.read());
			}
		}
		
		catch(FileNotFoundException fe){
			System.out.println("FileNotFoundException occured:");
			fe.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	// code for append to java_programmong file
		try {
			String newContent="Java was developed by Sun Microsystems (which is now the subsidiary of Oracle) in the year 1995. James Gosling is known as the father of Java. Before Java, its name was Oak. Since Oak was already a registered company, so James Gosling and his team changed the name from Oak to Java.";
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw=new FileWriter(f,true);
			BufferedWriter Bw=new BufferedWriter(fw);
			Bw.write(newContent);
			Bw.close();
			System.out.println("Data successfully append....");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		//code for reading java_programming file after append 
		BufferedInputStream bs=null;
		FileInputStream fs=null;
		try {
			fs=new FileInputStream(f);
			bs=new BufferedInputStream(fs);
			while(bs.available()>0) {
				System.out.println((char)bs.read());
			}
		}
		
		catch(FileNotFoundException fe){
			System.out.println("FileNotFoundException occured:");
			fe.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}//end main 

}//end class
