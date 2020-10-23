package com.hemebiotech.analytics.writer;

import java.io.IOException;
import java.util.Map;

/**
 * That will write symptom data to a file
 */
public interface ISymptomWriter {
	/**
	 * If no data is available, throw an  @exception
	 * @param symptomMap a map of symptom
	 */
	 void writeSymptoms(Map<String, Integer> symptomMap) throws IOException;
}
