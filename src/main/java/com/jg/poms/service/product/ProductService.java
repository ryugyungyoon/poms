package com.jg.poms.service.product;

import com.jg.poms.domain.product.Product;
import com.jg.poms.domain.product.ProductRepository;
import com.jg.poms.dto.product.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Transactional(readOnly = true)
	//전체 상품 조회(select)
	public List<ProductResponse> getProducts() {
		return productRepository.findAll().stream()
				.map(ProductResponse::new)
				.collect(Collectors.toList());
	}
}
