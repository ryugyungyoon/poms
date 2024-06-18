package com.jg.poms.dto.product.response;

import com.jg.poms.domain.product.Product;
import com.jg.poms.domain.product.productimage.ProductImage;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductResponse {
	private Long productIdx;
	private Long brandIdx;
	private Long categoryIdx;
	private String name;
	private String code;
	private List<ProductImage> productImages;

	public ProductResponse(Long productIdx, Long brand_idx, Long categoryIdx, String name, String code, List<ProductImage> productImages) {
		this.productIdx = productIdx;
		this.brandIdx = brand_idx;
		this.categoryIdx = categoryIdx;
		this.name = name;
		this.code = code;
		this.productImages = productImages;
	}

	public ProductResponse(Product product){
		this.productIdx = product.getProductIdx();
        this.brandIdx = product.getBrandIdx();
        this.categoryIdx = product.getCategoryIdx();
        this.name = product.getName();
        this.code = product.getCode();
        this.productImages = product.getProductImages();
	}
}
