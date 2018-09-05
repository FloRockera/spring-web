package com.formation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.formation.repository.MessageRepository;
import com.formation.user.ChatConsole;

@ContextConfiguration(classes = { AppConfigMess.class })
@RunWith(SpringRunner.class)
public class ChatConsoleTest {

	@Autowired
	private ChatConsole chatConsole;

	@Test
	public void shouldSimulateAConversationBetweenSamAndBob() {

		// Insert
		this.chatConsole.setCurrentUser("sam");
		this.chatConsole.sendHelloTo("bob");
		this.chatConsole.sendGoodbyeTo("bob");
		this.chatConsole.sendHelloTo("foo");
		this.chatConsole.sendGoodbyeTo("foo");

		// Update
		chatConsole.editMessage("Big Up bob !", 2);

		// delete
		chatConsole.deleteMessageToUser("sam", "bob");

		// find
		chatConsole.findMessageToUserToday("bob");

	}

	@Autowired
	private MessageRepository mess;

	@Test
	public void test() {
		mess.findByToUser("bob");

		// assertTrue("Hello bob", chat.sendHelloTo("bob"));
		// assertTrue("Goodbye bob", chat.sendGoodbyeTo("bob"));
		// assertTrue("foo", chat.sendHelloTo("foo"));
		// assertTrue("foo", chat.sendHelloTo("foo"));

	}

}
