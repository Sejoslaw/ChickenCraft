package seia.chickencraft.helper;

import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Contains various helper methods for messaging in Minecraft.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class MessageHelper {

	private static final int _DELETION_ID = 2525277;
	private static int LAST_ADDED;

	private MessageHelper() {
	}

	/**
	 * Adds a message to Player's chat with no spam.
	 */
	public static void addChatComponentMessageNoSpam(EntityPlayer player, String msg) {
		addChatComponentMessageNoSpam(player, new String[] { msg });
	}

	/**
	 * Adds a message to Player's chat with no spam.
	 */
	public static void addChatComponentMessageNoSpam(EntityPlayer player, String[] msg) {
		GuiNewChat chat = GuiHelper.getChatGui();
		for (int i = _DELETION_ID + msg.length - 1; i <= LAST_ADDED; ++i)
			chat.deleteChatLine(i);
		for (int i = 0; i < msg.length; ++i)
			chat.printChatMessageWithOptionalDeletion(TextHelper.wrap(TextHelper.getModInfo(msg[i])), _DELETION_ID + i); // TODO: Crash - fix me.
		LAST_ADDED = _DELETION_ID + msg.length - 1;
	}
}
