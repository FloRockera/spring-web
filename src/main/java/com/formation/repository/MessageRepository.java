package com.formation.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdbc.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	// Ajouter la signature d'une méthode de récupération des Messagres par
	// utilisateur
	List<Message> findByToUser(String toUser);

	List<Message> findByFromUser(String fromUser);

	// Ajouter la signature d'une méthode de récupération des Messages par
	// utilisateur dont l'EventTime est entre 2 LocalDateTime fournis en
	// paramètre
	List<Message> findByToUserAndEventTimeBetween(String toUser, LocalDateTime startTime, LocalDateTime endTime);

}
