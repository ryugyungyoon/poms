package com.jg.poms.dto.product.response;

import com.jg.poms.domain.brand.Brand;
import com.jg.poms.domain.category.Category;
import com.jg.poms.domain.product.Product;
import com.jg.poms.domain.product.productimage.ProductImage;
import com.jg.poms.domain.review.Review;
import com.jg.poms.dto.review.response.ReviewResponse;
import lombok.Getter;

import java.util.ArrayList;
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
	private List<ReviewResponse> productReviewList;

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
									.toList();
		this.thumbnailImageFilePath = productImages.get(0).getFilePath();

		this.productReviewList = new ArrayList<>();
		List<Review> reviews = product.getProductReviewList().stream()
				.filter(review -> review.isDeleteYn() != true)
				.toList();
		if(product.getProductReviewList() != null){
			for(Review review : reviews) {
				this.productReviewList.add(new ReviewResponse(review));
			}
		}
	}

}
