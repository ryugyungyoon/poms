package com.jg.poms.core.error;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

	//Http 상태 코드
	HTTP_HANDLE_ACCESS_DENIED(403, "H403", "Access is Denied"),
	HTTP_METHOD_NOT_ALLOWED(405, "H405", " Method Not Allowed"),
	HTTP_INTERNAL_SERVER_ERROR(500, "H500", "Server Error"),

	//Common
	COMMON_INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
	COMMON_INVALID_TYPE_VALUE(400, "C002", " Invalid Type Value"),
	COMMON_SAVE_FAIL(400, "C003", "저장에 실패 하였습니다."),
	COMMON_FILE_UPLOAD_FAIL(400, "C004", "File Upload Fail."),
	COMMON_JSON_PARSING_FAIL(400, "C005","JSON Parings Failed"),
	COMMON_REQUEST_CONNECTION(400, "C005","커넥션 실패"),

	//Member
	MEMBER_EMAIL_DUPLICATION(400, "M001", "Email is Duplication"),
	MEMBER_LOGIN_INPUT_INVALID(400, "M002", "Login input is invalid"),
	MEMBER_LOGIN_EMPTY_MEMBER(400, "M003", "가입 되지 않은 아이디 입니다."),
	MEMBER_LOGIN_APPROVAL_REQUIRED(400, "M004", "회원가입 승인 처리 중입니다."),
	MEMBER_LOGIN_PASSWARD_ERROR(400, "M005", "비밀번호가 정확하지 않습니다."),
	MEMBER_LOGIN_DELYN_ERROR(400, "M006", "이용 불가한 아이디 입니다."),

	//견적관련
	ESTIMATE_INVALID_MANAGER(400, "M101", "담당자가 올바르지 않아 변경이 필요합니다."),

	//엑셀관련 (공통)
	ETC_EXCEL_ERROR(400, "M201", "업로드에 문제가 발생했습니다."),
	ETC_EXCEL_ALLOWED(400, "M202", "허용되지 않는 서식이 존재합니다."),
	EXCEL_READ_EMPTY_ERROR(400, "M203", "미입력 항목이 있습니다."),
	ETC_EXCEL_DUPLICATION_ERROR(400, "M204", "중복된 서식이 존재합니다."),
	ETC_EXCEL_DOWNLOAD_ERROR(400, "M205", "다운로드에 문제가 발생했습니다."),

	//엑셀일괄 등록 / 수정 (부품)

	EXCEL_ITEM_PARTS_ALLOWED_ERROR(400, "M301", "parts_seq 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_MANUFACTURER_ALLOWED_ERROR(400, "M302", "manufacturer_seq 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_MODEL_ALLOWED_ERROR(400, "M303", "model_seq 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_GROUP_DIVISION_TYPE_CD_ALLOWED_ERROR(400, "M304", "group_division_type_cd) 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_MODEL_DIVISION_TYPE_CD_ALLOWED_ERROR(400, "M304", "model_division_type_cd) 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_GROUP_ALLOWED_ERROR(400, "M305", "group_seq 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_GROUP_IN_NUM_ALLOWED_ERROR(400, "M306", "item_group_in_num 항목에 공백이 있습니다."),
	EXCEL_ITEM_CD_ALLOWED_ERROR(400, "M307", "item_cd 항목에 공백이 있습니다."),
	EXCEL_ITEM_NM_ALLOWED_ERROR(400, "M308", "item_nm 항목에 공백이 있습니다."),
	EXCEL_ITEM_NM_KO_ALLOWED_ERROR(400, "M309", "item_nm_ko 항목에 공백이 있습니다."),
	EXCEL_ITEM_FILE_NM_NOT_EXIST_ERROR(400, "M310", "file_nm 항목에 해당하는 이미지가 존재하지 않습니다.\n이미지 확인해주세요!"),
	EXCEL_ITEM_FILE_NM_ALLOWED_ERROR(400, "M311", "file_nm 항목에 공백이거나 업로드 누락 파일이 있습니다."),
	EXCEL_ITEM_MEMO_ALLOWED_ERROR(400, "M312", "memo 항목에 공백이 있습니다."),


	EXCEL_ITEM_PARTS_PRICE_ALLOWED_ERROR(400, "M313", "price 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_PARTS_MIN_USED_PRICE_ALLOWED_ERROR(400, "M314", "min_used_price 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_PARTS_MAX_USED_PRICE_ALLOWED_ERROR(400, "M315", "max_used_price 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_PARTS_USED_PRICE_DAY_ALLOWED_ERROR(400, "M323", "used_price_day 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_PARTS_WORKINGTIME_ALLOWED_ERROR(400, "M316", "working_time 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_DISPLAYORDERNUM_ALLOWED_ERROR(400, "M317", "display_order_num 항목에 허용되지 않는 값이 있습니다."),
	EXCEL_ITEM_DISPLAYYN_ALLOWED_ERROR(400, "M322", "display_yn 항목에 허용되지 않는 값이 있습니다."),

	EXCEL_ITEM_GROUP_NM_ALLOWED_ERROR(400, "M318", "group_nm 항목에 공백이 있습니다."),
	EXCEL_ITEM_MODEL_NM1_ALLOWED_ERROR(400, "M319", "model_nm1 항목에 공백이 있습니다."),
	EXCEL_ITEM_MODEL_NM2_ALLOWED_ERROR(400, "M320", "model_nm2 항목에 공백이 있습니다."),
	EXCEL_ITEM_YEAR_ALLOWED_ERROR(400, "M321", "year 항목에 공백이 있습니다."),

	// server
	EXCEPTION_SERVER_SQL(400, "5901", "DB 사용 오류."),
	EXCEPTION_SERVER_FILE(400, "5902", "File 처리 오류."),
	EXCEPTION_SERVER_CONNECT(400, "5903", "서버 연결 오류."),
	;

	private final int status;
	private final String code;
	private final String message;

	ErrorCode(final int status, final String code, final String message){
		this.status = status;
		this.message = message;
		this.code = code;
	}

	public int getStatus(){
		return this.status;
	}

	public String getMessage(){
		return this.message;
	}

	public String getCode(){
		return code;
	}

}