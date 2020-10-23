package com.hemebiotech.analytics;

import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.writer.WriteSymptomDataToFile;

import java.util.*;

public class AnalyticsCounter {
	private String fileNameIn;
	private String fileOutPath;
	Map<String, Integer> map = new TreeMap<>();

	public AnalyticsCounter(String fileNameIn, String fileOutPath) {
		this.fileNameIn = fileNameIn;
		this.fileOutPath = fileOutPath;
	}

	//Read symtom from file
	public  List<String> readSymptoms() throws Exception {
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(this.fileNameIn);
		return readSymptomDataFromFile.GetSymptoms();
	}
	public  void calculateNbreOfSymptoms(List<String> symptoms) throws Exception {
		for (String symtom : symptoms) {
			if (map.containsKey(symtom)) {
				map.put(symtom, map.get(symtom)+1);
			} else {
				map.put(symtom, 1);
			}
		}
	}
	//write nombre of symptoms into file
	public  void writeSymptomsOut() throws Exception {
		WriteSymptomDataToFile writeSymptomDataToFile = new WriteSymptomDataToFile(fileOutPath);
		writeSymptomDataToFile.writeSymptoms(map);

	}
}
