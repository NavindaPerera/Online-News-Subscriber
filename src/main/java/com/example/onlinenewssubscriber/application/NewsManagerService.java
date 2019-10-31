package com.example.onlinenewssubscriber.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.onlinenewssubscriber.application.transformer.NewsTransformer;
import com.example.onlinenewssubscriber.controller.dto.CreateNewsDTO;
import com.example.onlinenewssubscriber.controller.dto.RetrieveNewsDTO;
import com.example.onlinenewssubscriber.domain.news.News;
import com.example.onlinenewssubscriber.domain.news.NewsService;
import com.example.onlinenewssubscriber.domain.subscriber.Role;
import com.example.onlinenewssubscriber.domain.subscriber.Subscriber;
import com.example.onlinenewssubscriber.domain.subscriber.SubscriberService;

@Service
public class NewsManagerService {

	@Autowired
	private NewsService newsService;

	@Autowired
	private SubscriberService subscriberService;

	public String createNewsManager(String subscriberId, CreateNewsDTO createNewsDTO) {

		News news = NewsTransformer.toNews(createNewsDTO);

		Assert.notNull(subscriberId, "Id must not be null");

		Optional<Subscriber> subscriber = subscriberService.findSubscriberById(subscriberId);

		if (subscriber.get().getRole() == Role.ADMIN) {
			news.setSubscriberFirstName(subscriber.get().getFirstName());
			news.setSubscriberLastName(subscriber.get().getLastName());
			news.setRole(subscriber.get().getRole());
			String id = newsService.saveNews(news).getId();
			if (id != null) {
				return "News item created successfully!";
			} else {
				return "Failed";
			}
		} else {
			throw new IllegalArgumentException("Only Admins can create news items");
		}
	}

	public List<News> getNewsManager() {
		return newsService.readNews();
	}

	public RetrieveNewsDTO findNewsByIdManager(String newsId) {
		Optional<News> news = newsService.findNewsById(newsId);
		return NewsTransformer.toDTO(news);
	}

	public String updateNewsByIdManager(String subscriberId, String newsId, CreateNewsDTO createNewsDTO) {

		Optional<Subscriber> subscriber = subscriberService.findSubscriberById(subscriberId);

		if (subscriber.get().getRole() == Role.ADMIN) {
			Optional<News> news = newsService.findNewsById(newsId);
			Optional<News> covertedNews = NewsTransformer.convertNews(news, createNewsDTO);
			News updateNews = covertedNews.get();
			updateNews.setSubscriberFirstName(subscriber.get().getFirstName());
			updateNews.setSubscriberLastName(subscriber.get().getLastName());
			updateNews.setRole(subscriber.get().getRole());
			News savedNewsDetails = newsService.saveNews(updateNews);
			if (savedNewsDetails != null) {
				return "News item updated successfully!";
			} else {
				return "Failed to update the news items";
			}
		} else {
			throw new IllegalArgumentException("Only Admins can update news items");
		}
	}

	public void deleteNewsByIdManager(String newsId) {
		newsService.deleteNews(newsId);
	}

}
