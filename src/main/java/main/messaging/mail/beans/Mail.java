package main.messaging.mail.beans;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6767330256589502562L;
	private String recipient;
	private String body;
	private String title;
	private Long keyCodeLocation;
	private MailType type;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Mail() {
		super();
	}

	public Mail(String recipient) {
		super();
		this.type = MailType.DEFAULT;
		this.recipient = recipient;
	}

	public Mail(String recipient, MailType type) {
		super();
		this.recipient = recipient;
		this.type = type;
	}

	public Mail(String recipient, String body, String title, Long keyCodeLocation, MailType type) {
		super();
		this.type = type;
		this.recipient = recipient;
		this.body = body;
		this.title = title;
		this.keyCodeLocation = keyCodeLocation;
	}

	public Mail(String recipient, String body, String title, MailType type) {
		super();
		this.type = type;
		this.recipient = recipient;
		this.body = body;
		this.title = title;
	}

	public Mail(String recipient, Long cdKeyCode, MailType type) {
		this.type = type;
		this.recipient = recipient;
		this.keyCodeLocation = cdKeyCode;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getKeyCodeLocation() {
		return keyCodeLocation;
	}

	public void setKeyCodeLocation(Long keyCodeLocation) {
		this.keyCodeLocation = keyCodeLocation;
	}

	public MailType getType() {
		return type;
	}

	public void setType(MailType type) {
		this.type = type;
	}

	public static Mail fromXml(String xml) {
		return JAXB.unmarshal(new StringReader(xml), Mail.class);
	}

	public String toXml() {
		StringWriter writer = new StringWriter();

		JAXB.marshal(this, writer);
		return writer.toString();

	}

}
