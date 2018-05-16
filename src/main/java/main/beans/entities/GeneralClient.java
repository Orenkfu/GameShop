package main.beans.entities;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.JAXB;

@MappedSuperclass
public class GeneralClient {
	protected String name;
	protected String username;
	protected String password;
	protected String email;
	protected Date signUpDate;
	protected Long id;

	public GeneralClient() {
		super();
	}

	public GeneralClient(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public GeneralClient(String name, String username, String password, String email, Date signUpDate) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.signUpDate = signUpDate;
	}

	@Column(name = "REAL_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "USER_NAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SIGNUP_DATE")
	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static GeneralClient fromXml(String xml) {
		return JAXB.unmarshal(new StringReader(xml), GeneralClient.class);
	}

	public String toXml() {
		StringWriter writer = new StringWriter();

		JAXB.marshal(this, new StringWriter());
		return writer.toString();

	}

}
