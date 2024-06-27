package com.jg.poms.dto.review.response;

import com.jg.poms.domain.review.ReviewImage;
import lombok.Getter;

@Getter
public class ReviewImageResponse {
	private String filePath;

	public ReviewImageResponse(ReviewImage reviewImage) {
		this.filePath = reviewImage.getFilePath();
	}
}
