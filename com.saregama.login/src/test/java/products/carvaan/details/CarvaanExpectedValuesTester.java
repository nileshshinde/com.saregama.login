package products.carvaan.details;

public class CarvaanExpectedValuesTester {
	
	private static String ProductName = "Hindi"; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printProductDetails("Porcelain White");
		printProductDetails("Cherrywood Red");
		printProductDetails("Charcoal Grey");
		printProductDetails("Camouflage Green");
	}
	
	public static void printProductDetails(String ProductColor) {
		CarvaanExpectedValues CEV = new CarvaanExpectedValues();
		
		CarvaanExpectedDataRecord record = CEV.getRecordByColor(ProductName, ProductColor);
		
		String Color = CEV.getProductColorByColor(ProductName, ProductColor);
		String Title = CEV.getProductTitleByColor(ProductName, ProductColor);
		String MRP = CEV.getProductMRPByColor(ProductName, ProductColor);
		String MOP = CEV.getProductMOPByColor(ProductName, ProductColor);
		boolean Notify = CEV.getProductNotifyByColor(ProductName, ProductColor);
		String ID = CEV.getProductIDByColor(ProductName, ProductColor);
		String Image = CEV.getProductImageByColor(ProductName, ProductColor);
		String ZoomImage = CEV.getProductZoomImageByColor(ProductName, ProductColor);
		
		System.out.println("--------------------------Carvaan: " + ProductColor + ", Using Variable--------------------------");
		System.out.println("Title: " + Title);
		System.out.println("Color: " + Color);
		System.out.println("MRP: " + MRP);
		System.out.println("MOP: " + MOP);
		System.out.println("Notify: " + (Notify?"True":"False"));
		System.out.println("ID: " + ID);
		System.out.println("Image: " + Image);
		System.out.println("Zoom Image: " + ZoomImage);

		System.out.println("--------------------------Carvaan: " + ProductColor + ", Using Record--------------------------");
		System.out.println("Title: " + record.getTitle());
		System.out.println("Color: " + record.getColor());
		System.out.println("MRP: " + record.getMRP());
		System.out.println("MOP: " + record.getMOP());
		System.out.println("Notify: " + (record.getNotify()?"True":"False"));
		System.out.println("ID: " + record.getID());
		System.out.println("Image: " + record.getImage());
		System.out.println("Zoom Image: " + record.getZoomImage());
}

}
