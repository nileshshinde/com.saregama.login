package products.carvaan.details;

import java.util.List;
import java.util.ArrayList;

public class CarvaanExpectedDataRecord {
	private String Product;
	private String Title;
	private String Color;
	private String MRP;
	private String MOP;
	private boolean Notify;
	private String ID;
	private String Image;
	private String ZoomImage;
	
	public CarvaanExpectedDataRecord() {
		setProduct("");
		setTitle("");
		setColor("");
		setMRP("");
		setMOP("");
		setNotify(false);
		setID("");
		setImage("");
		setZoomImage("");
	}
	
	public CarvaanExpectedDataRecord(
			String ProductName,
			String ProductTitle,
			String ProductColor,
			String ProductMRP,
			String ProductMOP,
			boolean ProductNotify,
			String ProductID,
			String ProductImage,
			String ProductZoomImage) {
		setProduct(ProductName);
		setTitle(ProductTitle);
		setColor(ProductColor);
		setMOP(ProductMOP);
		setMRP(ProductMRP);
		setNotify(ProductNotify);
		setID(ProductID);
		setImage(ProductImage);
		setZoomImage(ProductZoomImage);
	}
	
	
	public void setProduct(String productName) { this.Product = productName; }
	public void setTitle(String productTitle) { this.Title = productTitle; }
	public void setColor(String productColor) { this.Color = productColor; }
	public void setMRP(String productMRP) { this.MRP = productMRP; }
	public void setMOP(String productMOP) { this.MOP = productMOP; }
	public void setNotify(boolean productNotify) { this.Notify = productNotify; }
	public void setID(String productID) { this.ID = productID; }
	public void setImage(String productImage) { this.Image = productImage; }
	public void setZoomImage(String productZoomImage) { this.ZoomImage = productZoomImage; }
	
	public String getProduct() { return Product; }
	public String getTitle() { return Title; }
	public String getColor() { return Color; }
	public String getMRP() { return MRP; }
	public String getMOP() { return MOP; }
	public boolean getNotify() { return Notify; }
	public String getID() { return ID; }
	public String getImage() { return Image; }
	public String getZoomImage() { return ZoomImage; }
}
