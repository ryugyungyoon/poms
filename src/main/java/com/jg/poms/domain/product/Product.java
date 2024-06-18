package com.jg.poms.domain.product;

import com.jg.poms.domain.product.productimage.ProductImage;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productIdx = null;

	private Long brandIdx;

	private Long categoryIdx;

	private String name;

	private String code;

	private boolean deleteYn;

	private LocalDateTime registrationDate;

	private LocalDateTime modifyDate;

	//상품 이미지와 연관 관계 설정
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductImage> productImages = new ArrayList<>();

	public void setProductImage(List<ProductImage> productImages) {
		this.productImages = productImages;
		for(ProductImage productImage : productImages){
            productImage.setProduct(this);
        }
	}

	public Product() {
    }

	public Product(Long productIdx, Long brandIdx, Long categoryIdx, String name, String code) {
		this.productIdx = productIdx;
		this.brandIdx = brandIdx;
		this.categoryIdx = categoryIdx;
		this.name = name;
		this.code = code;
	}
}
