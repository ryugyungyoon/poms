package com.jg.poms.dto.product.response;

import com.jg.poms.domain.brand.Brand;
import com.jg.poms.domain.category.Category;
import com.jg.poms.domain.product.Product;
import com.jg.poms.domain.product.productimage.ProductImage;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductResponse {

	private Long productIdx;
	private Brand brand;
	private Category category;
	private String name;
	private String code;
	private String price;
	private List<ProductImage> productImageList;

	public ProductResponse(Long productIdx, Brand brand, Category category, String name, String code, List<ProductImage> productImageList) {
		this.productIdx = productIdx;
		this.brand = brand;
		this.category = category;
		this.name = name;
		this.code = code;
		this.productImageList = productImageList;
	}

	public ProductResponse(Product product){
		this.productIdx = product.getProductIdx();
        this.brand = product.getBrand();
        this.category = product.getCategory();
        this.name = product.getName();
        this.code = product.getCode();
        this.price = product.getPrice();
        this.productImageList = product.getProductImageList();
	}
}
