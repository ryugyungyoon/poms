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

	private String productImageType;

	private String filePath;

	private String displayOrder;

	private Boolean deleteYn;

	private LocalDateTime registrationDate;

	private LocalDateTime modifyDate;

	//상품과 연관 관계 설정
	@ManyToOne
	@JoinColumn(name="product_idx")
	@JsonIgnore
	private Product product;

	public ProductImage(){}
}
