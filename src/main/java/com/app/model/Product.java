package com.app.model;



import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="prodtabs30")
public class Product {
	@Id
	@Column(name="pid")
	@GeneratedValue
	private Integer prodId;
	
	@Column(name="pname")
	private String prodName;
	@Column(name="pcode")
	private String prodCode;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="prodcattbls",joinColumns=@JoinColumn(name="pidFk"),inverseJoinColumns=@JoinColumn(name="cidFk"))
	private List<Categories> prodCategory;
	@Column(name="pdetail")
	private String prodDetail;
	@Column(name="pcost")
	private Double prodCost;
	@Column(name="gst")
	private Double gst;
	@Column(name="pselprice")
	private Double prodSelPrice;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="prodimgstab",joinColumns=@JoinColumn(name="prodid"))
	@OrderColumn(name="pos")
	@Column(name="imgs")
	private List<String> images;
	@Transient
	private List<MultipartFile> files;
	
	public Product() {
		super();
	}

	public Product(Integer prodId) {
		super();
		this.prodId = prodId;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public List<Categories> getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(List<Categories> prodCategory) {
		this.prodCategory = prodCategory;
	}

	public String getProdDetail() {
		return prodDetail;
	}

	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}

	public Double getProdCost() {
		return prodCost;
	}

	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Double getProdSelPrice() {
		return prodSelPrice;
	}

	public void setProdSelPrice(Double prodSelPrice) {
		this.prodSelPrice = prodSelPrice;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodCode=" + prodCode + ", prodCategory="
				+ prodCategory + ", prodDetail=" + prodDetail + ", prodCost=" + prodCost + ", gst=" + gst
				+ ", prodSelPrice=" + prodSelPrice + ", images=" + images + ", files=" + files + "]";
	}
	

	
}
