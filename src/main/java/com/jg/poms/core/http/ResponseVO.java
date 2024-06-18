package com.jg.poms.core.http;

import lombok.Data;
import lombok.ToString;

/**
 * POST 요청에 대한 Response 객체
 * 
 * @author zisooyq
 */
@Data
@ToString
public class ResponseVO {

	private Header header;
	private Object body;

	public ResponseVO(String responseCode){
		this.header = new Header(responseCode);
	}

	@Data
	public static class Header {
		private String responseCode;
		private String responseMsg;

		public Header(String responseCode){
			this.responseCode = responseCode;
		}
	}

}
