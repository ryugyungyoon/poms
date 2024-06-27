package com.jg.poms.domain.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class ReviewImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewImageIdx = null;

	private String filePath;

	private int displayOrder;

	@Column(length = 1)
	private boolean deleteYn;

	private LocalDateTime registrationDate;

	private LocalDateTime modifyDate;

	//리뷰와 연관 관계 설정
	@ManyToOne
	@JoinColumn(name="review_idx")
	@JsonIgnore
	private Review review;

	//JPA 사용을 위한 기본생성자
	public ReviewImage() {
	}
}
