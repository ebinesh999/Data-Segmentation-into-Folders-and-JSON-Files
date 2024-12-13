package Task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FolderJsonTask {
		private static void createFolderAndFile(String folderName, String fileName, ArrayList<String> data) throws IOException {
	        File folder = new File(folderName);
	        if (!folder.exists() && !folder.mkdirs()) {
	            throw new IOException("Failed to create directory: " + folderName);
	        }

	        File file = new File(folder, fileName);
	        try (FileWriter writer = new FileWriter(file)) {
	            writer.write(data.toString());
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Map<String, String>> entries = new ArrayList<>();

	        System.out.println("Enter 10 entries (s.no, name, ph_no):");
	        for (int i = 0; i < 10; i++) {
	            Map<String, String> entry = new HashMap<>();

	            System.out.print("Enter s.no for entry " + (i + 1) + ": ");
	            String sNo = scanner.nextLine().trim();
	            while (sNo.isEmpty()) {
	                System.out.print("s.no cannot be empty. Please enter again: ");
	                sNo = scanner.nextLine().trim();
	            }
	            entry.put("s_no", sNo);

	            System.out.print("Enter name for entry " + (i + 1) + ": ");
	            String name = scanner.nextLine().trim();
	            while (name.isEmpty()) {
	                System.out.print("Name cannot be empty. Please enter again: ");
	                name = scanner.nextLine().trim();
	            }
	            entry.put("name", name);

	            System.out.print("Enter ph_no for entry " + (i + 1) + ": ");
	            String phNo = scanner.nextLine().trim();
	            while (phNo.isEmpty()) {
	                System.out.print("Phone number cannot be empty. Please enter again: ");
	                phNo = scanner.nextLine().trim();
	            }
	            entry.put("ph_no", phNo);

	            entries.add(entry);
	        }

	        ArrayList<String> sNoData = new ArrayList<>();
	        ArrayList<String> nameData = new ArrayList<>();
	        ArrayList<String> phNoData = new ArrayList<>();

	        for (Map<String, String> entry : entries) {
	            sNoData.add(entry.get("s_no"));
	            nameData.add(entry.get("name"));
	            phNoData.add(entry.get("ph_no"));
	        }

	        try {
	            createFolderAndFile("s_no", "s_no.json", sNoData);
	            createFolderAndFile("name", "name.json", nameData);
	            createFolderAndFile("ph_no", "ph_no.json", phNoData);
	            System.out.println("Folders and files created successfully!");
	        } catch (IOException e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        } finally {
	            scanner.close();
	        }
	    

	}

}
