package com.jg.poms.dto.product.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public class ProductBuyNowRequest {

	private Long productIdx;
	private String[] prices;
	private String[] amounts;
	private String[] options;
	private String originalPrice;
	private String originalDiscountPrice;

	@Override
	public String toString() {
		return "ProductBuyNowRequest{" +
				"productIdx=" + productIdx +
				", prices=" + Arrays.toString(prices) +
				", amounts=" + Arrays.toString(amounts) +
				", options=" + Arrays.toString(options) +
				", originalPrice='" + originalPrice + '\'' +
				", originalDiscountPrice='" + originalDiscountPrice + '\'' +
				'}';
	}
}
