package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Base64;

public class Product {
    private String proId;
    private String proName;
    private Double proPrice;
    private String proBrand;
    private Date proMfgDate;
    private Date proExpDate;
    private String proMadeIn;
    private InputStream proImage;
    

  //additional methods
    public String getBase64ProductImage() {
        try {
            return Base64.getEncoder().encodeToString(proImage.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


	public String getProId() {
		return proId;
	}


	public void setProId(String proId) {
		this.proId = proId;
	}


	public String getProName() {
		return proName;
	}


	public void setProName(String proName) {
		this.proName = proName;
	}


	public Double getProPrice() {
		return proPrice;
	}


	public void setProPrice(Double proPrice) {
		this.proPrice = proPrice;
	}


	public String getProBrand() {
		return proBrand;
	}


	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}


	public Date getProMfgDate() {
		return proMfgDate;
	}


	public void setProMfgDate(Date proMfgDate) {
		this.proMfgDate = proMfgDate;
	}


	public Date getProExpDate() {
		return proExpDate;
	}


	public void setProExpDate(Date proExpDate) {
		this.proExpDate = proExpDate;
	}


	public String getProMadeIn() {
		return proMadeIn;
	}


	public void setProMadeIn(String proMadeIn) {
		this.proMadeIn = proMadeIn;
	}


	public InputStream getProImage() {
		return proImage;
	}


	public void setProImage(InputStream proImage) {
		this.proImage = proImage;
	}


	




	

    }
