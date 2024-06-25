package com.jg.poms.dto.brand.response;

import com.jg.poms.domain.brand.Brand;
import com.jg.poms.domain.category.Category;
import com.jg.poms.domain.product.Product;
import com.jg.poms.domain.product.productimage.ProductImage;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class BrandResponse {

	private Long BrandIdx;
	private String name;
	private Boolean deleteYn;
	private LocalDateTime registrationDate;
	private LocalDateTime modifyDate;
	private String rogoFilePath;

	public BrandResponse(Brand brand) {
		this.BrandIdx = brand.getBrandIdx();
        this.name = brand.getName();
        this.deleteYn = brand.getDeleteYn();
        this.registrationDate = brand.getRegistrationDate();
        this.modifyDate = brand.getModifyDate();
        this.rogoFilePath = brand.getRogoFilePath();
	}

}
