package com.formation.service;

import java.time.LocalDate;
import java.util.List;

import com.jdbc.MessageDto;

public interface IMessageService {

	/**
	 * Envoi un message au système
	 *
	 * @param message
	 *            : Le messsage à envoyer
	 */
	void send(MessageDto message);

	/**
	 * Permet d'éditer un message.
	 *
	 * @param editedMsg
	 *            : Le message à éditer : On modifie :
	 *            <ul>
	 *            <li>le contenu</li>
	 *            <li>l'heure/date d'enregistrement de l'évènement</li>
	 *            </ul>
	 *            En fonction de l'identifiant de message <i>le reste du message
	 *            reste inchangé</i>
	 */
	void edit(MessageDto editedMsg);

	/**
	 * Supprime les messages d'un utilisateur vers un autre
	 *
	 * @param fromUser
	 *            : l'expéditeur des messages
	 * @param toUser
	 *            : le destinataire des messages
	 */
	void delete(String fromUser, String toUser);

	/**
	 * Récupère l'ensemble des messages
	 *
	 * @return une liste de tous les messages émis
	 */
	List<MessageDto> findAllMessages();

	/**
	 * Récupère l'ensemble des messages envoyés à un utilisateur
	 * <code>toUser</code>, le jour <code>day</code>
	 *
	 * @param toUser
	 *            : le destinataire des messages
	 * @param day
	 *            : le jour des messages à récupérer
	 *
	 * @return Une liste de messages filtrés par destinataire et par jour
	 */
	List<MessageDto> findMessageSendToAUserADay(String toUser, LocalDate day);

	/**
	 * Récupère tous les messages envoyés par l'utilisateur
	 * <code>fromUser</code>
	 *
	 * @param fromUser
	 *            : expéditeur des messages envoyés
	 *
	 * @return Une liste des messages filtrés par expéditeur
	 */
	List<MessageDto> findAllMessageFromUser(String fromUser);

}
