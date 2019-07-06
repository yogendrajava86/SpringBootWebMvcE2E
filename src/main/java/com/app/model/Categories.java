package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="prodcate30")
public class Categories {
	@Id
	@Column(name="cid")
	@GeneratedValue
	private Integer catId;
	@Column(name="cname")
	private String catName;
	
	
	public Categories() {
		super();
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Override
	public String toString() {
		return "Categories [catId=" + catId + ", catName=" + catName + "]";
	}


	/*
	 * @ManyToMany(mappedBy="prodCategory") private List<Product> prods;
	 * 
	 * public List<Product> getProds() { return prods; }
	 * 
	 * public void setProds(List<Product> prods) { this.prods = prods; }
	 */

	
	/*
	 * @Override public String toString() { return "Categories [catId=" + catId +
	 * ", catName=" + catName + ", prods=" + prods + "]"; }
	 */
	

}
