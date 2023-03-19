package products.carvaan.details;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CarvaanExpectedValues {
	private String csvpath = "src/test/java/products/carvaan/details/snapshot_031823.csv";
	
	public CarvaanExpectedValues()
	{
		FileInputStream file;
		try {
			file = new FileInputStream(csvpath);
			InputStreamReader csvreader = new InputStreamReader(file);
			//csvreader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

