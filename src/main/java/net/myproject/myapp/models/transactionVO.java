package net.myproject.myapp.models;

public class transactionVO {
	//은행계좌를 클릭하면 이런식으로 거래내역을 가져올 수 있음.
	    private String balance_amt; //계좌잔액
	    private String total_record_cnt; //총조회건수
	    private String next_page_yn; //다음페이지 존재 여부
	    private String page_record_cnt; //현재 페이지 레코드 건수
	    private String tran_time;//거래시간
	    private String tran_date;//거래일자
	    private String inout_type;//입출금구분
	    private String tran_type; //거래구분
	    private String tran_amt; //거래금액
	    private String after_balance_amt; //거래후 잔액
	    private String branch_name; //거래점명
		
	    
	    public String getBalance_amt() {
			return balance_amt;
		}
		public void setBalance_amt(String balance_amt) {
			this.balance_amt = balance_amt;
		}
		public String getTotal_record_cnt() {
			return total_record_cnt;
		}
		public void setTotal_record_cnt(String total_record_cnt) {
			this.total_record_cnt = total_record_cnt;
		}
		public String getNext_page_yn() {
			return next_page_yn;
		}
		public void setNext_page_yn(String next_page_yn) {
			this.next_page_yn = next_page_yn;
		}
		public String getPage_record_cnt() {
			return page_record_cnt;
		}
		public void setPage_record_cnt(String page_record_cnt) {
			this.page_record_cnt = page_record_cnt;
		}
		public String getTran_time() {
			return tran_time;
		}
		public void setTran_time(String tran_time) {
			this.tran_time = tran_time;
		}
		public String getTran_date() {
			return tran_date;
		}
		public void setTran_date(String tran_date) {
			this.tran_date = tran_date;
		}
		public String getInout_type() {
			return inout_type;
		}
		public void setInout_type(String inout_type) {
			this.inout_type = inout_type;
		}
		public String getTran_type() {
			return tran_type;
		}
		public void setTran_type(String tran_type) {
			this.tran_type = tran_type;
		}
		public String getTran_amt() {
			return tran_amt;
		}
		public void setTran_amt(String tran_amt) {
			this.tran_amt = tran_amt;
		}
		public String getAfter_balance_amt() {
			return after_balance_amt;
		}
		public void setAfter_balance_amt(String after_balance_amt) {
			this.after_balance_amt = after_balance_amt;
		}
		public String getBranch_name() {
			return branch_name;
		}
		public void setBranch_name(String branch_name) {
			this.branch_name = branch_name;
		}
		
		
		@Override
		public String toString() {
			return "transactionVO [balance_amt=" + balance_amt + ", total_record_cnt=" + total_record_cnt
					+ ", next_page_yn=" + next_page_yn + ", page_record_cnt=" + page_record_cnt + ", tran_time="
					+ tran_time + ", tran_date=" + tran_date + ", inout_type=" + inout_type + ", tran_type=" + tran_type
					+ ", tran_amt=" + tran_amt + ", after_balance_amt=" + after_balance_amt + ", branch_name="
					+ branch_name + "]";
		}
	    
		
	    
         
		
}
