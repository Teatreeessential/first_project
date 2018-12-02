package net.myproject.myapp.models;

public class Get_UseNumVO {
        private String bank_name;
        private String fintech_use_num;
        
        
		public String getBank_name() {
			return bank_name;
		}


		public void setBank_name(String bank_name) {
			this.bank_name = bank_name;
		}


		public String getFintech_use_num() {
			return fintech_use_num;
		}


		public void setFintech_use_num(String fintech_use_num) {
			this.fintech_use_num = fintech_use_num;
		}


		@Override
		public String toString() {
			return "['" + bank_name + "','" + fintech_use_num + "']";
		}
}
