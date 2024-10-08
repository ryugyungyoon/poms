/**
 * [필수 검증] 객체의 필수 입력 검사
 * ex)
 * 		if(cvalid_isEmpty('memberNms', '이름')){
 * 			return false;
 * 		}
 * @author zisooya
 * @param obj 검증 객체
 * @param objNm 검증 객체명
 * @returns {Boolean}
 */
function cvalid_isEmpty(obj, objNm, target){
	if(cfn_isEmpty(target)){
		target = obj;
	}

	let $obj = $('#'+obj);
	if($obj.val() === null || $obj.val() === 'undefined' || $obj.val() === undefined || $obj.val().replace(/ /gi,'') === ''){
		calert(cutil_getJosa(objNm, '을')+' 입력해 주세요.');
		$('#'+target).focus();
		return true;
	}
	else{
		return false;
	}
}

/**
 * [일반 검증] 문자열의 null 확인
 *
 * @author zisooya
 * @param str 문자열
 * @returns {Boolean}
 */
function cfn_isEmpty(str){
	if(str === null || str === undefined || str === '' || str === 'undefined' || str === 'null'){
		return true;
	}else{
		return false;
	}
}

/**
 * [알림] 공통 alert
 * @author zisooya
 * @param msg : 메세지
 * @returns {void}
 */
function calert(msg){
	alert('[POMS]\n' + msg);
}

/**
 * [util] 한글 조사 자동 생성
 * @author zisooya
 * @param txt 문자열
 * @param josa 문자열 뒤에 붙을 조사
 * @returns {String}
 */
function cutil_getJosa(txt, josa){
	var code = txt.charCodeAt(txt.length-1) - 44032;

	//원본 문구가 없을때는 빈 문자열 반환
	if(txt.length == 0) return '';

	//한글이 아닐때
	if(code < 0 || code > 11171) return txt;

	if(code % 28 == 0) return txt + cutil_getKorJosa(josa, false);
	else return txt + cutil_getKorJosa(josa, true);
}

/**
 * [기능 함수] 일반 기능 ajax 요청 함수
 * @author zisooya
 * @param url : 요청 url
 * @param type : method (post, get)
 * @param data : 전송 데이터
 * @returns {void}
 */
function cfn_ajaxRequest(url, method, data, callbackId){
	let callback = url.split('/').reverse()[0];
	if(callbackId != undefined && callbackId != null) {
		callback = callbackId;
	}

	$.ajax({
		url: url,
		type: method,
		data: data,
		dataType: 'json',
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		//contentType: ' application/json; charset-utf-8',
		async: true,
		success: function(resData){
			fn_callback(callback, resData);
		}

	});
}

//요청 결과 처리 ajax callback
function fn_callback(callbackId, resData){
	if(callbackId === 'login'){
		alert('로그인 되었습니다.');
		alert(resData.body);
		console.log(resData.body.name);

		location.href = '/';
	}
	else{}
}

/**
 * [이벤트 함수] 검색조건 Form 전송하기
 * @author ryugyungyoon
 * @param url : 요청 url
 * @returns {void}
 */
function cfn_searchFormSubmit(url){
	$('#searchForm').attr('method', 'POST');
	$('#searchForm').attr('action', url);
	$('#searchForm').submit();
}