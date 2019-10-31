package com.example.onlinenewssubscriber.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.onlinenewssubscriber.application.transformer.SubscriberTransformer;
import com.example.onlinenewssubscriber.controller.dto.CreateSubscriberDTO;
import com.example.onlinenewssubscriber.controller.dto.RetrieveSubscriberDTO;
import com.example.onlinenewssubscriber.domain.subscriber.Subscriber;
import com.example.onlinenewssubscriber.domain.subscriber.SubscriberService;

@Service
public class SubscriberManagerService {

	@Autowired
	private SubscriberService subscriberService;

	public String createSubscriberManager(CreateSubscriberDTO createSubscriberDTO) {

		Subscriber subscriber = SubscriberTransformer.toSubscriber(createSubscriberDTO);

		Assert.notNull(subscriber.getRole(), "Role cannot be empty!");
		Assert.notNull(subscriber.getFirstName(), "First name cannot be empty!");

		if (subscriber.getAge() >= 25) {
			String id = subscriberService.saveSubscriber(subscriber).getId();
			if (id != null) {
				return id;
			} else {
				return "Failed";
			}
		} else {
			throw new IllegalArgumentException("You must be above 25 years old to sign up");
		}

	}

	public List<Subscriber> getSubscriberManager() {
		return subscriberService.readSubscriber();
	}

	public RetrieveSubscriberDTO findSubscriberByIdManager(String subscriberId) {
		Optional<Subscriber> subscriber = subscriberService.findSubscriberById(subscriberId);
		return SubscriberTransformer.toDTO(subscriber);
	}

	public String updateSubscriberByIdManager(String subscriberId, CreateSubscriberDTO createSubscriberDTO) {
		Optional<Subscriber> subscriber = subscriberService.findSubscriberById(subscriberId);
		Optional<Subscriber> covertedSubscriber = SubscriberTransformer.convertSubscriber(subscriber,
				createSubscriberDTO);
		Subscriber updateSubscriber = covertedSubscriber.get();

		Assert.notNull(updateSubscriber.getRole(), "Role cannot be empty!");
		Assert.notNull(updateSubscriber.getFirstName(), "First name cannot be empty!");

		if (updateSubscriber.getAge() >= 25) {
			Subscriber savedSubscriberDetails = subscriberService.saveSubscriber(updateSubscriber);
			if (savedSubscriberDetails != null) {
				return "Details saved successfully!";
			} else {
				return "Failed";
			}
		} else {
			throw new IllegalArgumentException("You must be above 25 years old");
		}
	}

	public void deleteSubscriberManager(String subscriberId) {
		subscriberService.deleteSubscriber(subscriberId);
	}

}
