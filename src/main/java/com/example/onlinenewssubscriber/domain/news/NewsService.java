package com.example.onlinenewssubscriber.domain.news;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

	@Autowired
	private NewsRepository newsRepository;

	public News saveNews(News news) {
		return newsRepository.save(news);
	}

	public List<News> readNews() {
		return newsRepository.findAll();
	}

	public void deleteNews(String newsId) {
		newsRepository.deleteById(newsId);
	}

	public Optional<News> findNewsById(String newsId) {
		return newsRepository.findById(newsId);
	}

}
