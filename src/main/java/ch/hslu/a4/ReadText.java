package ch.hslu.a4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {

	
	
	static public String readText(String file) {
		String line;
		String text = "";
		try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
 
            while ((line = bufferedReader.readLine()) != null) {
            	text += line;
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		return text; 
	}
}
