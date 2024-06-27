package com.jg.poms.dto.review.response;

import com.jg.poms.domain.review.Review;
import com.jg.poms.domain.review.ReviewImage;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ReviewResponse {

	private Long reviewIdx;
	private String userId;
	private String content;
	private int starRating;
	private boolean deleteYn;
	private LocalDateTime registrationDate;
	private LocalDateTime modifyDate;
	private List<ReviewImageResponse> reviewImageList;

	public ReviewResponse(Review review) {
		this.reviewIdx = review.getReviewIdx();
        this.userId = review.getUser().getId();
        this.content = review.getContent();
        this.starRating = review.getStarRating();
        this.deleteYn = review.isDeleteYn();
        this.registrationDate = review.getRegistrationDate();
        this.modifyDate = review.getModifyDate();

		this.reviewImageList = new ArrayList<>();
		if(review.getReviewImageList() != null) {
			for (ReviewImage reviewImage : review.getReviewImageList()) {
                this.reviewImageList.add(new ReviewImageResponse(reviewImage));
            }
		}
	}

}
