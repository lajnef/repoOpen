package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.reader.SymptomReaderImp;
import com.hemebiotech.analytics.writer.SymptomWriterImp;

import java.util.*;

public class AnalyticsCounterService {
	private String fileNameIn;
	private String fileOutPath;
	Map<String, Integer> map = new TreeMap<>();

	public AnalyticsCounterService(String fileNameIn, String fileOutPath) {
		this.fileNameIn = fileNameIn;
		this.fileOutPath = fileOutPath;
	}

	/**
	 * Read symtom from file
	 * @return
	 * @throws Exception
	 */
	public  List<String> readSymptoms() throws Exception {
		SymptomReaderImp readSymptom = new SymptomReaderImp(this.fileNameIn);
		return readSymptom.GetSymptoms();
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
		SymptomWriterImp symptomWriter = new SymptomWriterImp(fileOutPath);
		symptomWriter.writeSymptoms(map);

	}
}
