package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ProgramTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file path: ");
		String strFile = sc.nextLine();
		
		File algFile = new File(strFile);
		
		try (BufferedReader br = new BufferedReader(new FileReader(algFile))) {
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		sc.close();
	}

}
