package jp.co.opst.spring.params;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserForm {

	@NotNull
	private Integer id;

	@NotEmpty
	@Max(8)
	private String pass;

	@NotEmpty
	private String passConf;

	@NotEmpty
	private String tel;

	@NotEmpty
	private String zip;

	@NotEmpty
	private String sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPassConf() {
		return passConf;
	}

	public void setPassConf(String passConf) {
		this.passConf = passConf;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isPassConfValid() {
		return Objects.equals(pass, passConf);
	}

	public boolean isTelValid() {
		return false;
	}

	public boolean isZipValid() {
		return false;
	}

}
