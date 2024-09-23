/**
 * 날짜 필드 출력
 * ex) 20210101 -> 2021-01-01
 * ex) 202101011230 -> 2021-01-01 12:30
 * @author zisooya
 * @param dateStr
 * @param separator
 * @param separator2
 * @returns {String}
 */
function cfmt_date(dateStr, separator, separator2){

}

/**
 * [출력] 숫자에 , 표시
 * @author ryugyungyoon
 * @param number
 * @returns {String}
 */
function cfmt_numAddComma(number){
	if(number === null || number === undefined || number === 'null' || number === ''){
		return '';
	}

	return String(number).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

/**
 * [출력] 숫자에 , 제거
 * @author ryugyungyoon
 * @param str
 * @returns {String}
 */
function cfmt_numDelComma(str){
	if(str === '0'){
		return '0';
	}

	//console.log('str : ' + str);
	if(str === null || str === 'null' || str === ''){
		return '';
	}
	else{
		return cutil_replaceAll(String(str), ',', '');
	}
}

/**
 * [util] replaceAll 구현
 * ex) replaceAll('000-0000-0000', '-', '')
 * @author ryugyungyoon
 * @param str 전체 문자열
 * @param searchStr 변경전 문자
 * @param replaceStr 변경후 문자
 * @returns {String}
 */
function cutil_replaceAll(str, searchStr, replaceStr){
	while(str.indexOf(searchStr) != -1){
		str = str.replace(searchStr, replaceStr);
	}

	return str;
}