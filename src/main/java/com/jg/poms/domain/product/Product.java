package com.jg.poms.domain.product;

import com.jg.poms.domain.brand.Brand;
import com.jg.poms.domain.category.Category;
import com.jg.poms.domain.product.productimage.ProductImage;
import com.jg.poms.domain.review.Review;
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

	private String name;

	private String code;

	private String price;

	private boolean deleteYn;

	private LocalDateTime registrationDate;

	private LocalDateTime modifyDate;

	//브랜드와 연관 관계 설정
	@ManyToOne
	@JoinColumn(name = "brand_idx")
	private Brand brand;

	//상품 이미지와 연관 관계 설정
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductImage> productImageList = new ArrayList<>();

	//카테고리와 연관 관계 설정
	@ManyToOne
	@JoinColumn(name = "category_idx")
	private Category category;

	//리뷰와 연관 관계 설정
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> productReviewList = new ArrayList<>();

	//JPA 사용을 위한 기본생성자
	public Product() {
    }

}
