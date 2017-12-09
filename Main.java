import java.io.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

	public static void main(String[] args) throws IOException {
		/**
		 * Scans text file of words and adds all the words to an ArrayList dictionary
		 */
		File file = new File("src/words.txt");
		Scanner scan = new Scanner(file);
		
		ArrayList<String> dictionary = new ArrayList<String>();
		
		while (scan.hasNext()) {
			dictionary.add(scan.next());
		}
		
		scan.close();
		
		/**
		 * Gets user's letters and puts them into a string array 
		 */
		System.out.print("Enter your letters.");
		Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		
		String[] letters = input.split("");
		
		System.out.println(letters[0]);
		

	}

}
