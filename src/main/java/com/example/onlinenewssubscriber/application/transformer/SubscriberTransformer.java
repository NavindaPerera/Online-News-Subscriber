package com.example.onlinenewssubscriber.application.transformer;

import java.util.Optional;

import com.example.onlinenewssubscriber.controller.dto.CreateSubscriberDTO;
import com.example.onlinenewssubscriber.controller.dto.RetrieveSubscriberDTO;
import com.example.onlinenewssubscriber.domain.subscriber.Subscriber;

public class SubscriberTransformer {

	public static Subscriber toSubscriber(CreateSubscriberDTO createSubscriberDTO) {
		Subscriber subscriber = new Subscriber();
		subscriber.setRole(createSubscriberDTO.getRole());
		subscriber.setFirstName(createSubscriberDTO.getFirstName());
		subscriber.setLastName(createSubscriberDTO.getLastName());
		subscriber.setAge(createSubscriberDTO.getAge());

		return subscriber;
	}

	public static RetrieveSubscriberDTO toDTO(Optional<Subscriber> subscriber) {
		RetrieveSubscriberDTO retrieveSubscriberDTO = new RetrieveSubscriberDTO();
		retrieveSubscriberDTO.setId(subscriber.get().getId());
		retrieveSubscriberDTO.setRole(subscriber.get().getRole());
		retrieveSubscriberDTO.setFirstName(subscriber.get().getFirstName());
		retrieveSubscriberDTO.setLastName(subscriber.get().getLastName());
		retrieveSubscriberDTO.setAge(subscriber.get().getAge());

		return retrieveSubscriberDTO;
	}

	public static Optional<Subscriber> convertSubscriber(Optional<Subscriber> subscriber,
			CreateSubscriberDTO createSubscriberDTO) {
		Subscriber toSubscriber = SubscriberTransformer.toSubscriber(createSubscriberDTO);
		subscriber.get().setRole(toSubscriber.getRole());
		subscriber.get().setFirstName(toSubscriber.getFirstName());
		subscriber.get().setLastName(toSubscriber.getLastName());
		subscriber.get().setAge(toSubscriber.getAge());

		return subscriber;
	}

}
