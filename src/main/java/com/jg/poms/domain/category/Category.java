package com.jg.poms.domain.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jg.poms.domain.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryIdx = null;

	private int depth;

	private String depthName;

	private String categoryName;

	//카테고리 연관 관계 설정
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_idx")
	private Category parentCategory;

	//상품과 연관 관계 설정 (읽기 전용)
	@OneToMany(mappedBy = "category")
	private List<Product> product = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
	private List<Category> childCategoryList = new ArrayList<>();

	public void setChildCategory(List<Category> childCategoryList) {
		this.childCategoryList = childCategoryList;
		for(Category childCategory : childCategoryList){
            childCategory.setParentCategory(this);
        }
	}

	private String displayOrder;

	private Boolean useYn;

	private LocalDateTime registrationDate;

	private LocalDateTime modifyDate;

	//JPA 사용을 위한 기본생성자
	public Category(){}


}
