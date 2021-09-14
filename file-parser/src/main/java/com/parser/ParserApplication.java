package com.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ParserApplication {

	public static void main(String[] args) throws Exception {

		Scanner myObj = new Scanner(System.in);
		System.out.println("please provide log file location:");
		String filepath = myObj.nextLine();
		File files = new File(filepath);
		File[] filearray = files.listFiles();
		System.out.println("Number of Log files:" + filearray.length);
		System.out.println("please provide file Extension: ");
		String fileExtension = myObj.nextLine();
		for (File file : filearray) {
			if (file.isFile() && getFileExtension(file).contains(fileExtension)) {
				try (BufferedReader fileContent = new BufferedReader(new FileReader(file))) {
					String line;
					List<String> listOfValue = new ArrayList<>();
					while ((line = fileContent.readLine()) != null) {
						listOfValue.add(getFormatedName(line));
						writeToFile(getFormatedName(line), filepath, "WithOutAscendingOder");
					}
					System.out.println(listOfValue);
					Collections.sort(listOfValue);
					System.out.println(listOfValue);
					listOfValue.forEach(content -> {
						try {
							writeToFile(getFormatedName(content), filepath, "WithAscendingOder");
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
				}
			}
		}
	}

	public static void writeToFile(String encryptedKey, String dirPath, String fileNmae) throws Exception {
		String paresedDirPath = dirPath.replace("\\", "/") + "/parsedFile/";
		try {
			File newFile = new File(paresedDirPath);
			if (!newFile.exists()) {
				newFile.mkdir();
			}
			FileWriter myWriter = new FileWriter(paresedDirPath + fileNmae, true);
			myWriter.write(encryptedKey + "\n");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static String getFormatedName(String line) {
		String[] split = line.split("\\|");
		return split[0];
	}
	
	public static String getFileExtension(File file) {
		String extension = null;
		String fileName = file.toString();
		int index = fileName.lastIndexOf('.');
		if (index > 0) {
			extension = fileName.substring(index + 1);
			System.out.println("File extension is " + extension);
		}

		return extension;

	}

}
