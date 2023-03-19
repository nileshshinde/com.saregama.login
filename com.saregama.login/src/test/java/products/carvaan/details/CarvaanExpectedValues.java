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
	private String jsonpath = "src/test/java/products/carvaan/details/snapshot_031823.json";
	private List<CarvaanExpectedDataRecord> records;

	public CarvaanExpectedValues() {
		records = new ArrayList<CarvaanExpectedDataRecord>();
		readDataFromJson();
	}

	public void readDataFromJson() {
		JSONParser jsonparser = new JSONParser();
		try (FileReader reader = new FileReader(jsonpath)) {

			Object obj = jsonparser.parse(reader);
			JSONObject products = (JSONObject) obj;
			JSONArray productlist = (JSONArray) products.get("products");
			for (int i = 0; i < productlist.size(); i++) {
				JSONObject product = (JSONObject) productlist.get(i);
				String productName = (String) product.get("Product");
				String productTitle = (String) product.get("Title");
				String productColor = (String) product.get("Color");
				String productMRP = (String) product.get("MRP");
				String productMOP = (String) product.get("MOP");
				boolean productNotify = (boolean) product.get("Notify");
				String productID = (String) product.get("ID");
				String productImage = (String) product.get("Image");
				String productZoomImage = (String) product.get("ZoomImage");
				
				records.add(new CarvaanExpectedDataRecord(productName, productTitle, productColor, productMRP, productMOP, productNotify, productID, productImage, productZoomImage));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} catch (ParseException e) {
		e.printStackTrace();
		}
	}
	
	public List<CarvaanExpectedDataRecord> getAllRecords() { return records; }
	
	public CarvaanExpectedDataRecord getRecordByColor(String ProductColor)
	{
		for (int i=0; i<records.size(); i++) {
			try {
				if (records.get(i).getColor().equals(ProductColor))
					return records.get(i);
			} catch (Exception ex) {
				continue;
			}
		}
		return null;
	}
	
	public String getProdutTitleByColor(String ProductColor) {
		for (int i=0; i<records.size(); i++) {
			try {
				if (records.get(i).getColor().equals(ProductColor))
					return records.get(i).getTitle();
			} catch (Exception ex) {
				continue;
			}
		}
		return null;
	}

	public String getProdutColorByColor(String ProductColor) {
		for (int i=0; i<records.size(); i++) {
			try {
				if (records.get(i).getColor().equals(ProductColor))
					return records.get(i).getColor();
			} catch (Exception ex) {
				continue;
			}
		}
		return null;
	}

	public String getProdutMRPByColor(String ProductColor) {
		for (int i=0; i<records.size(); i++) {
			try {
				if (records.get(i).getColor().equals(ProductColor))
					return records.get(i).getMRP();
			} catch (Exception ex) {
				continue;
			}
		}
		return null;
	}

	public String getProdutMOPByColor(String ProductColor) {
		for (int i=0; i<records.size(); i++) {
			try {
				if (records.get(i).getColor().equals(ProductColor))
					return records.get(i).getMOP();
			} catch (Exception ex) {
				continue;
			}
		}
		return null;
	}

	public boolean getProdutNotifyByColor(String ProductColor) {
		for (int i=0; i<records.size(); i++) {
			try {
				if (records.get(i).getColor().equals(ProductColor))
					return records.get(i).getNotify();
			} catch (Exception ex) {
				continue;
			}
		}
		return false;
	}

	public String getProdutIDByColor(String ProductColor) {
		for (int i=0; i<records.size(); i++) {
			try {
				if (records.get(i).getColor().equals(ProductColor))
					return records.get(i).getID();
			} catch (Exception ex) {
				continue;
			}
		}
		return null;
	}

	public String getProdutImageByColor(String ProductColor) {
		for (int i=0; i<records.size(); i++) {
			try {
				if (records.get(i).getColor().equals(ProductColor))
					return records.get(i).getImage();
			} catch (Exception ex) {
				continue;
			}
		}
		return null;
	}

	public String getProdutZoomImageByColor(String ProductColor) {
		for (int i=0; i<records.size(); i++) {
			try {
				if (records.get(i).getColor().equals(ProductColor))
					return records.get(i).getZoomImage();
			} catch (Exception ex) {
				continue;
			}
		}
		return null;
	}
}
