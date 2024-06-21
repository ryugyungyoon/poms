/**
 * [poms 함수] 리스트 조회 요청
 * ajax 요청
 * @author zisooya
 * @param url 요청 url
 * @returns {void}
 */
function cinit_list(url, callbackId){
	let listReqData = $('#searchForm').serialize();
	cfn_ajaxRequest(url, 'POST', listReqData, callbackId);
}



