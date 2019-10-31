package com.example.onlinenewssubscriber.application.transformer;

import java.util.Optional;

import com.example.onlinenewssubscriber.controller.dto.CreateNewsDTO;
import com.example.onlinenewssubscriber.controller.dto.RetrieveNewsDTO;
import com.example.onlinenewssubscriber.domain.news.News;

public class NewsTransformer {

	public static News toNews(CreateNewsDTO createNewsDTO) {
		News news = new News();
		news.setNewsTitle(createNewsDTO.getNewsTitle());
		news.setNewsDescription(createNewsDTO.getNewsDescription());

		return news;
	}

	public static RetrieveNewsDTO toDTO(Optional<News> news) {
		RetrieveNewsDTO retrieveNewsDTO = new RetrieveNewsDTO();
		retrieveNewsDTO.setId(news.get().getId());
		retrieveNewsDTO.setNewsTitle(news.get().getNewsTitle());
		retrieveNewsDTO.setNewsDescription(news.get().getNewsDescription());
		retrieveNewsDTO.setSubscriberFirstName(news.get().getSubscriberFirstName());
		retrieveNewsDTO.setSubscriberLastName(news.get().getSubscriberLastName());
		retrieveNewsDTO.setRole(news.get().getRole());

		return retrieveNewsDTO;
	}

	public static Optional<News> convertNews(Optional<News> news, CreateNewsDTO createNewsDTO) {
		News toNews = NewsTransformer.toNews(createNewsDTO);
		news.get().setNewsTitle(toNews.getNewsTitle());
		news.get().setNewsDescription(toNews.getNewsDescription());

		return news;
	}

}
