package com.jg.poms.domain.review;

import com.jg.poms.domain.product.Product;
import com.jg.poms.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewIdx = null;

	private Long starRating;

	@Column(length = 1)
	private boolean deleteYn;

	private LocalDateTime registrationDate;

	private LocalDateTime modifyDate;

	//상품과 연관 관계 설정
	@ManyToOne
	@JoinColumn(name = "product_idx")
	private Product product;

	//리뷰 이미지와 연관 관계 설정
	@OneToMany(mappedBy = "reivew",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReviewImage> reviewImageList = new ArrayList<>();

	//유저와 연관 관계 설정
	@ManyToOne
	@JoinColumn(name = "user_idx")
	private User user;

	//JPA 사용을 위한 기본 생성자
	public Review() {
	}
}
