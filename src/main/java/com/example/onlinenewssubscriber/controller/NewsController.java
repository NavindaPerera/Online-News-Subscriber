package com.example.onlinenewssubscriber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinenewssubscriber.application.NewsManagerService;
import com.example.onlinenewssubscriber.controller.dto.CreateNewsDTO;
import com.example.onlinenewssubscriber.controller.dto.RetrieveNewsDTO;
import com.example.onlinenewssubscriber.domain.exception.ResponseHandlerException;
import com.example.onlinenewssubscriber.domain.news.News;

@RestController
public class NewsController extends ResponseHandlerException {

	@Autowired
	private NewsManagerService newsManagerService;

	@RequestMapping(value = "/subscriber/{subscriberId}/news", method = RequestMethod.POST)
	public String createNews(@PathVariable("subscriberId") String subscriberId,
			@RequestBody CreateNewsDTO createNewsDTO) {
		return newsManagerService.createNewsManager(subscriberId, createNewsDTO);
	}

	@RequestMapping(value = "/news/", method = RequestMethod.GET)
	public @ResponseBody List<News> getNews() {
		return newsManagerService.getNewsManager();
	}

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public @ResponseBody RetrieveNewsDTO getNewsById(@RequestParam("id") String newsId) {
		return newsManagerService.findNewsByIdManager(newsId);
	}

	@RequestMapping(value = "/subscriber/{subscriberId}/news", method = RequestMethod.PUT)
	public String updateNewsById(@PathVariable("subscriberId") String subscriberId, @RequestParam("id") String newsId,
			@RequestBody CreateNewsDTO createNewsDTO) {
		return newsManagerService.updateNewsByIdManager(subscriberId, newsId, createNewsDTO);
	}

	@RequestMapping(value = "/news", method = RequestMethod.DELETE)
	public void deleteNewsById(@RequestParam("id") String newsId) {
		newsManagerService.deleteNewsByIdManager(newsId);
	}

}
