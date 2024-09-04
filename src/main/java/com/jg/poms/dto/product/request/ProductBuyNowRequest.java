package com.jg.poms.dto.product.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductBuyNowRequest {

	private Long productIdx;
	private List<String> price;
	private List<String> amount;
	private List<String> option;

}
