package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MessageId id;
	private String content;

	@ManyToOne
	@JoinColumn(name="idSender",referencedColumnName="id",insertable=false,updatable=false)
	private User sender;
	
	@ManyToOne
	@JoinColumn(name="idReciver",referencedColumnName="id",insertable=false,updatable=false)
	private User reciver;

	public Message() {
	}

	public Message(String content, User sender, User reciver) {
		super();
		this.id = new MessageId(sender.getId(), reciver.getId());
		this.content = content;
		this.sender = sender;
		this.reciver = reciver;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageId getId() {
		return id;
	}

	public void setId(MessageId id) {
		this.id = id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReciver() {
		return reciver;
	}

	public void setReciver(User reciver) {
		this.reciver = reciver;
	}

}
