package com.example.onlinenewssubscriber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinenewssubscriber.application.SubscriberManagerService;
import com.example.onlinenewssubscriber.controller.dto.CreateSubscriberDTO;
import com.example.onlinenewssubscriber.controller.dto.RetrieveSubscriberDTO;
import com.example.onlinenewssubscriber.domain.exception.ResponseHandlerException;
import com.example.onlinenewssubscriber.domain.subscriber.Subscriber;

@RestController
public class SubscriberController extends ResponseHandlerException {

	@Autowired
	private SubscriberManagerService subscriberManagerService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "Welcome to Online News Subscriber";
	}

	@RequestMapping(value = "/subscriber", method = RequestMethod.POST)
	public String createSubscriber(@RequestBody CreateSubscriberDTO createSubscriberDTO) {
		return subscriberManagerService.createSubscriberManager(createSubscriberDTO);
	}

	@RequestMapping(value = "/subscriber/", method = RequestMethod.GET)
	public @ResponseBody List<Subscriber> getSubscriber() {
		return subscriberManagerService.getSubscriberManager();
	}

	@RequestMapping(value = "/subscriber", method = RequestMethod.GET)
	public @ResponseBody RetrieveSubscriberDTO findSubscriberById(@RequestParam("id") String subscriberId) {
		return subscriberManagerService.findSubscriberByIdManager(subscriberId);
	}

	@RequestMapping(value = "/subscriber", method = RequestMethod.PUT)
	public String updateSubscriberById(@RequestParam("id") String subscriberId,
			@RequestBody CreateSubscriberDTO createSubscriberDTO) {
		return subscriberManagerService.updateSubscriberByIdManager(subscriberId, createSubscriberDTO);
	}

	@RequestMapping(value = "/subscriber", method = RequestMethod.DELETE)
	public void deleteSubscriber(@RequestParam("id") String subscriberId) {
		subscriberManagerService.deleteSubscriberManager(subscriberId);
	}

}
