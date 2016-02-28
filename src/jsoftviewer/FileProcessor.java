/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoftviewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roger
 */
public class FileProcessor {

    private  BufferedReader reader;
    private  List<String> fileLines;

    public FileProcessor(File file) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(file));
        this.fileLines = new ArrayList<>();
    }

    public List<String> process() {
        String temp = null;
        String thisLine = null;

        try {

            while ((thisLine = reader.readLine()) != null) {
                if (thisLine.charAt(thisLine.length() - 1) == '#') {
                    this.fileLines.add(thisLine);
                } else {
                    thisLine += reader.readLine();
                }
            }

            if (fileLines.size() >= 2) {
                fileLines.remove(0);
                fileLines.remove(fileLines.size() - 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileLines;
    }

}
