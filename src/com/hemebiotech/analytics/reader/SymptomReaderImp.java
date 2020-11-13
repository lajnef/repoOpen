package com.hemebiotech.analytics.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SymptomReaderImp implements ISymptomReader {

	private String filepath;
	

	public SymptomReaderImp(String filepath) {
		this.filepath = filepath;
	}

	/**
	 *
	 * @return list of symtoms in file
	 * @throws IOException
	 */
	@Override
	public List<String> GetSymptoms() throws IOException {
		ArrayList<String> result = new ArrayList<String>();
		BufferedReader reader = null;

		if (filepath != null) {
			try {
				reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				reader.close();
			}
		}
		
		return result;
	}

}
