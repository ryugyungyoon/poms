package com.jg.poms.dto.product.response;

import com.jg.poms.domain.brand.Brand;
import com.jg.poms.domain.category.Category;
import com.jg.poms.domain.product.Product;
import com.jg.poms.domain.product.productimage.ProductImage;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProductResponse {

	private Long productIdx;
	private Brand brand;
	private Category category;
	private String name;
	private String code;
	private String price;
	private boolean deleteYn;
	private List<ProductImage> productImageList;
	private String thumbnailImageFilePath;

	public ProductResponse(Product product){
		this.productIdx = product.getProductIdx();
        this.brand = product.getBrand();
        this.category = product.getCategory();
        this.name = product.getName();
        this.code = product.getCode();
        this.price = product.getPrice();
		this.deleteYn = product.isDeleteYn();
        this.productImageList = product.getProductImageList();
		List<ProductImage> productImages = product.getProductImageList().stream()
									.filter(image -> image.getProductImageType().equals("thumbnailType"))
									.filter(image -> image.getDisplayOrder().equals("1"))
									.collect(Collectors.toList());
		this.thumbnailImageFilePath = productImages.get(0).getFilePath();
		/*
		System.out.println("size: "+productImages.size());
		System.out.println("========================================================================");
		if(productImages != null && productImages.size() !=0 ){
			System.out.println("타입: "+productImages.get(0).getProductImageType()+", 순서: "+productImages.get(0).getDisplayOrder());
			System.out.println(productImages.get(0).getFilePath());
		}
		else{
			System.out.println("얘가 0: " + product.getProductIdx());
		}
		System.out.println("끝========================================================================");
		 */
	}


}
