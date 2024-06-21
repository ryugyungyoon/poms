package com.jg.poms.core.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jg.poms.core.error.ErrorCode;
import com.jg.poms.core.error.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * POST 요청에 대한 Response를 만들어 주는 클래스
 * 
 * @author zisooyq
 */
@Slf4j
@Component
public class HttpBuilder {

	public static final String MESSAGE_PREFIX = "error.message.";
	public static final String SUCCESS_CODE = "200";
	public static final String FAIL_CODE = "500";

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ObjectMapper objectMapper;

	/*==============================================================================
	 * 일반 요청 관련
	 ==============================================================================*/
	/**
	 * 성공 리턴
	 * 
	 * @author zisooya
	 * @return ResponseVO
	 */
	public ResponseVO resultSuccess(){
		return resultMake(null);
	}
	
	/**
	 * object 리턴
	 * 
	 * @author zisooya
	 * @return ResponseVO
	 */
	public ResponseVO resultForObject(String returnKey, Object resData){
		Map<String, Object> map = new HashMap<>();
		map.put(returnKey, resData);
		return resultMake(map);
	}

	/**
	 * object list 리턴
	 * 
	 * @author zisooya
	 * @return ResponseVO
	 */
	public ResponseVO resultForObjectList(Object resData){
		Map<String, Object> map = new HashMap<>();
		map.put("list", resData);
		System.out.println(resData.toString());
		ResponseVO resVO = new ResponseVO(SUCCESS_CODE);
		resVO.setBody(map);
		resVO.getHeader().setResponseMsg(messageSource.getMessage(MESSAGE_PREFIX + resVO.getHeader().getResponseCode(),
				null, LocaleContextHolder.getLocale()));
		printResponse(resVO);
		return resVO;
	}
	
	/**
	 * 페이징 list 리턴
	 * 
	 * @author zisooya
	 * @return ResponseVO
	 */
	public ResponseVO resultForPagingList(Object resData, Object pagingData){
		Map<String, Object> map = new HashMap<>();
		map.put("list", resData);
		map.put("paging", pagingData);
		
		ResponseVO resVO = new ResponseVO(SUCCESS_CODE);
		resVO.setBody(map);
		resVO.getHeader().setResponseMsg(messageSource.getMessage(MESSAGE_PREFIX + resVO.getHeader().getResponseCode(),
				null, LocaleContextHolder.getLocale()));
		printResponse(resVO);
		return resVO;
	}
	
	/**
	 * 0 이상이면 성공 반환
	 * 
	 * @author zisooya
	 * @return ResponseVO
	 */
	public ResponseVO resultForCount(int returnData){
		if(returnData > 0){
			return resultMake(null);
		}
		else{
			throw new BusinessException(ErrorCode.COMMON_SAVE_FAIL);
		}
	}

	/**
	 * 요청 성공일때 결과 객체 생성
	 * 
	 * @author zisooya
	 * @return ResponseVO
	 */
	public ResponseVO resultMake(Object resData){
		ResponseVO resVO = new ResponseVO(SUCCESS_CODE);
		//resVO.getHeader().setResponseCode();
		resVO.setBody(resData);
		resVO.getHeader().setResponseMsg(messageSource.getMessage(MESSAGE_PREFIX + resVO.getHeader().getResponseCode(),
				null, LocaleContextHolder.getLocale()));
		printResponse(resVO);
		return resVO;
	}

	/*==============================================================================
	 * 로그 포맷 관련
	 ==============================================================================*/
	/**
	 * 결과 로그 포맷
	 * 
	 * @author zisooya
	 */
	private void printResponse(ResponseVO resVO){
		try{
			log.info("##### ========================= [Response values] =========================");
			log.info("[header]");
			log.info("\t{}", objectMapper.writeValueAsString(resVO.getHeader()));
			log.info("[body]");
			log.info("\t{}", objectMapper.writeValueAsString(resVO.getBody()));
			log.info("##### =====================================================================");
		}
		catch(JsonProcessingException e){
			log.error("", e);
		}
	}

}
