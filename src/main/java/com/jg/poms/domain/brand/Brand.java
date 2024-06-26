package com.jg.poms.domain.brand;

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
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandIdx = null;

	private String name;

	private Boolean deleteYn;

	private LocalDateTime registrationDate;

	private LocalDateTime modifyDate;

	private String rogoFilePath;

	//상품과 연관 관계 설정 (읽기 전용)
	@OneToMany(mappedBy = "brand")
	private List<Product> product = new ArrayList<>();

	//JPA 사용을 위한 기본생성자
	public Brand() {
	}
}
