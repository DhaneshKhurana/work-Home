package serializable;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SavingStates implements Serializable {

	public int i=10;
	public String state="Saved";
	public boolean isSaved=true;
	
	public SavingStates(int a, String b, boolean c) {
		i=a;
		state = b;
		isSaved=c;
	}
	
	public String toString(){
		return (this.i+" "+ this.state +" "+ this.isSaved);
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SavingStates ss = new SavingStates(10, "Saved", true);
		SavingStates ee ;
		/*FileOutputStream fos = new FileOutputStream("D:\\javaspace\\resources\\file1.sr");
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(ss);
		*/
		System.out.println("hey");
		FileInputStream fis = null;
		try{
			fis = new FileInputStream("D:\\javaspace\\resources\\file1.sr");
			
		}catch(Exception e){
			FileOutputStream fos = new FileOutputStream("D:\\javaspace\\resources\\file1.sr");
			System.out.println("returning");
			return;
		}
		finally{
			
		}
		
		/*ObjectInputStream ois=new ObjectInputStream(fis);
		ee= (SavingStates) ois.readObject();
		
		
		System.out.println("ee :: " + ee);
		*/
		/*ee.i=20;
		ee.state="savingAgain";
		os.writeObject(ee);
		
		ss=(SavingStates) ois.readObject();
		
		System.out.println("after changing content ss :: " + ss);
		
		ss.i=100;
		ss.state="writing txt file";
		FileOutputStream fw = new FileOutputStream("D:\\javaspace\\resources\\file2.txt");
		ObjectOutputStream osw = new ObjectOutputStream(fos);
		osw.writeObject(ss);
		*/
	/*	
		FileInputStream fisw = new FileInputStream("D:\\javaspace\\resources\\file2.txt");
		ObjectInputStream oisw=new ObjectInputStream(fisw);
		ee= (SavingStates) oisw.readObject();
		
		System.out.println("ee :: " + ee);
		
		ee.i=200;
		ee.state="savingAgain in txt file";
		osw.writeObject(ee);
		
		ss=(SavingStates) oisw.readObject();
		
		System.out.println("after changing content ss :: " + ss);*/
		
	}

}
