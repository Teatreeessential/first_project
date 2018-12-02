package net.myproject.myapp.models;

public class LoginVO {
	private String id;
	private String passwd;
	private String access_token; // 엑세스토큰 헤더에 추가 해줘야함 테이블에 생성

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", passwd=" + passwd + ", access_token=" + access_token + "]";
	}

	
}
