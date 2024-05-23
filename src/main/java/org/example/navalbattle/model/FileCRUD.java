package org.example.navalbattle.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCRUD {

    private final String filePath;

    /**
     * Constructs a FileCRUD object with the specified file path.
     *
     * @param filePath the path of the file to perform CRUD operations on
     */
    public FileCRUD(String filePath) {
        this.filePath = filePath;
    }


    /**
     * Appends a line of content to the end of the file.
     *
     * @param content the content to be added to the file
     */
    public void create(String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            bufferedWriter.write(content);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads all lines from the file and returns them as a list of strings.
     *
     * @return a list of all lines in the file
     */
    public List<String> read() {

        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Updates a specific line in the file.
     *
     * @param lineNumber the line number to be updated (0-based index)
     * @param newContent the new content to replace the existing line
     */
    public void update(int lineNumber, String newContent) {
        List<String> lines = read();

        if (lineNumber >= 0 && lineNumber < lines.size()) {
            lines.set(lineNumber, newContent);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
                for (String line : lines) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid line number.");
        }
    }

    /**
     * Deletes a specific line from the file.
     *
     * @param lineNumber the line number to be deleted (0-based index)
     */
    public void delete(int lineNumber) {
        List<String> lines = read();
        if (lineNumber >= 0 && lineNumber < lines.size()) {
            lines.remove(lineNumber);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
                for (String line : lines) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid line number.");
        }
    }
}
