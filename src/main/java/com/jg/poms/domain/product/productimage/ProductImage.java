package com.jg.poms.domain.product.productimage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jg.poms.domain.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productImageIdx = null;

	//상품과 연관 관계 설정
	@ManyToOne
	@JoinColumn(name="product_idx")
	@JsonIgnore
	private Product product;

	private String productImageType;

	private String filePath;

	private String displayOrder;

	private Boolean deleteYn;

	private LocalDateTime registrationDate;

	private LocalDateTime modifyDate;

	public ProductImage(){}

	public ProductImage(Long productImageIdx, Product product, String productImageType, String filePath, String displayOrder, Boolean deleteYn, LocalDateTime registrationDate, LocalDateTime modifyDate) {
		this.productImageIdx = productImageIdx;
		this.product = product;
		this.productImageType = productImageType;
		this.filePath = filePath;
		this.displayOrder = displayOrder;
		this.deleteYn = deleteYn;
		this.registrationDate = registrationDate;
		this.modifyDate = modifyDate;
	}
}
