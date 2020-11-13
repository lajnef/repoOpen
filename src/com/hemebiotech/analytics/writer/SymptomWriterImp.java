package com.hemebiotech.analytics.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SymptomWriterImp implements ISymptomWriter {

	private String outputFilePath;
	public SymptomWriterImp(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	/**
	 * this method allows to read a map of symptoms
	 * @param symptomMap a map of symptom and write data to output file
	 * @throws IOException
	 *
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptomMap) throws IOException {
		FileWriter writer = new FileWriter (this.outputFilePath);
		for (String symptom : symptomMap.keySet()) {
			writer.write(symptom + ": " + symptomMap.get(symptom) + "\n");
		}
		writer.close();
	}
}
