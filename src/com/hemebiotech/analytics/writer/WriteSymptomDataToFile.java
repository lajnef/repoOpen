package com.hemebiotech.analytics.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String outputFilePath;

	/**
	 *
	 * @param outputFilePath a full or partial path to outputfile with symptom data
	 */
	public WriteSymptomDataToFile(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptomMap) throws IOException {
		FileWriter writer = new FileWriter (this.outputFilePath);
		for (String symptom : symptomMap.keySet()) {
			writer.write(symptom + ": " + symptomMap.get(symptom) + "\n");
		}
		writer.close();
	}
}
