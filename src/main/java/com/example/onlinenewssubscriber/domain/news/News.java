package com.example.onlinenewssubscriber.domain.news;

import org.springframework.data.annotation.Id;

import com.example.onlinenewssubscriber.domain.subscriber.Role;

public class News {

	@Id
	private String id;
	private String newsTitle;
	private String newsDescription;
	private String subscriberFirstName;
	private String subscriberLastName;
	private Role role;

	public String getId() {
		return id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsDescription() {
		return newsDescription;
	}

	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}

	public String getSubscriberFirstName() {
		return subscriberFirstName;
	}

	public void setSubscriberFirstName(String subscriberFirstName) {
		this.subscriberFirstName = subscriberFirstName;
	}

	public String getSubscriberLastName() {
		return subscriberLastName;
	}

	public void setSubscriberLastName(String subscriberLastName) {
		this.subscriberLastName = subscriberLastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
