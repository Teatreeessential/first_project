package net.myproject.myapp.models;

/**
 * @author student
 *
 */
public class get_transactionVO {
	// 기존의 핀테크 이용번호와 토큰 그리고 이 파라미터 값을 추가하면 은행마다 각각의 거래내역이 생성된다.

	private String inquiry_type; // 조회구분코드 A:ALL I:입금 O:출금
	private String from_date; // 조회 시작일자
	private String to_date; // 조회 끝나는 일자
	private String sort_order;// 정렬순서 D 디센딩 A 어센딩
	private String page_index; // 페이지번호
	private String tran_dtime; // 요청일시

	public String getInquiry_type() {
		return inquiry_type;
	}

	public void setInquiry_type(String inquiry_type) {
		this.inquiry_type = inquiry_type;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public String getSort_order() {
		return sort_order;
	}

	public void setSort_order(String sort_order) {
		this.sort_order = sort_order;
	}

	public String getPage_index() {
		return page_index;
	}

	public void setPage_index(String page_index) {
		this.page_index = page_index;
	}

	public String getTran_dtime() {
		return tran_dtime;
	}

	public void setTran_dtime(String tran_dtime) {
		this.tran_dtime = tran_dtime;
	}

	@Override
	public String toString() {
		return "get_transactionVO [inquiry_type=" + inquiry_type + ", from_date=" + from_date + ", to_date=" + to_date
				+ ", sort_order=" + sort_order + ", page_index=" + page_index + ", tran_dtime=" + tran_dtime + "]";
	}

}
