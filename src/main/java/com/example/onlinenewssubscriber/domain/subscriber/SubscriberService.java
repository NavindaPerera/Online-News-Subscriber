package com.example.onlinenewssubscriber.domain.subscriber;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberService {

	@Autowired
	private SubscriberRepository subscriberRepository;

	public Subscriber saveSubscriber(Subscriber subscriber) {
		return subscriberRepository.save(subscriber);
	}

	public List<Subscriber> readSubscriber() {
		return subscriberRepository.findAll();
	}

	public Optional<Subscriber> findSubscriberById(String subscriberId) {
		return subscriberRepository.findById(subscriberId);
	}

	public void deleteSubscriber(String subscriberId) {
		subscriberRepository.deleteById(subscriberId);
	}

}
