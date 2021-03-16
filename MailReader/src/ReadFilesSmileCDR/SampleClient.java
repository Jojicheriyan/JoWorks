package ReadFilesSmileCDR;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
 

public class SampleClient {
	String fileName = "src/Files/Names.txt";
	
	public boolean findNames(String lName) {
		
		boolean findStatus =false;
		
		try {
			System.out.println("Start");
			Stream<String> stream = Files.lines(Paths.get(fileName));
			findStatus = stream.map(String::toLowerCase)
					.filter(str -> str != null && str.length()>0 && str.contains(","))		
					.map(str -> str.split(","))					
					.anyMatch(str -> str[1].equals(lName.toLowerCase()));
			   //  .forEach(System.out::println);
			System.out.println("Name:"+findStatus);
			System.out.println("End");
		}catch(Exception e) {
			System.out.println("Exception Occurred: "+ e.getLocalizedMessage());
		}finally {
			
		}
		return findStatus;
	}
	
	public static void main(String args[]) {
		
		SampleClient client = new SampleClient();
		client.findNames("do");
	}

}
