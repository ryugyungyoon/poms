package com.jg.poms.service.brand;

import com.jg.poms.domain.brand.BrandRepository;
import com.jg.poms.dto.brand.response.BrandResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BrandService {

	private final BrandRepository brandRepository;

	public BrandService(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Transactional(readOnly = true)
	//브랜드 순번에 해당하는 브랜드 조회(select)
	public List<BrandResponse> getBrand(Long brandIdx) {
		return brandRepository.findById(brandIdx).stream()
				.map(BrandResponse::new)
				.collect(Collectors.toList());
	}
}
