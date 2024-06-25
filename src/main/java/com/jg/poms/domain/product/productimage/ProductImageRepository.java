package com.jg.poms.domain.product.productimage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
	List<ProductImage> findByProduct_ProductIdx(Long productIdx);
}
