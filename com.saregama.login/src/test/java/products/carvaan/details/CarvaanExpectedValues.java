package products.carvaan.details;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

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

