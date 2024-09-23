package com.jg.poms.dto.product.response;

import com.jg.poms.dto.product.request.ProductBuyNowRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ProductBuyNowResponse {

	private Long productIdx;
	@NonNull //createCombinedData 함수를 사용하기위한 어노테이션, 해당 필드는 null이 아니여야함
	private int price;
	@NonNull
	private int amount;
	@NonNull
	private String option;
	private int originalPrice;
	private int originalDiscountPrice;
	private List<ProductBuyNowResponse> combinedData;

	//상품을 여러개 추가 했을 때 리스트로 반환하는 함수를 호출하는 생성자
	public ProductBuyNowResponse(ProductBuyNowRequest request){
		this.productIdx = request.getProductIdx();
		this.originalPrice = Integer.parseInt(request.getOriginalPrice());
		this.originalDiscountPrice = Integer.parseInt(request.getOriginalDiscountPrice());
		this.combinedData = createCombinedData(request);
	}

	//상품을 여러개 추가 했을 때 리스트로 반환하기 위한 함수
	private List<ProductBuyNowResponse> createCombinedData(ProductBuyNowRequest request){
		List<ProductBuyNowResponse> combinedList = new ArrayList<>();
		int size = Math.min(request.getOptions().length, Math.min(request.getAmounts().length, request.getPrices().length));
		for (int i = 0; i < size; i++) {
			combinedList.add(new ProductBuyNowResponse(Integer.parseInt(request.getPrices()[i]), Integer.parseInt(request.getAmounts()[i]), request.getOptions()[i]));
		}
		return combinedList;
	}
}
