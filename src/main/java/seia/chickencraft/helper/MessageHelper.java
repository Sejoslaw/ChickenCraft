package seia.chickencraft.helper;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Contains various helper methods for messaging in Minecraft.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public final class MessageHelper {
	private MessageHelper() {
	}

	/**
	 * Adds a message to Player's chat with no spam.
	 */
	public static void addChatComponentMessage(EntityPlayer player, String msg) {
		addChatComponentMessage(player, new String[] { msg });
	}

	/**
	 * Adds a message to Player's chat with no spam.
	 */
	public static void addChatComponentMessage(EntityPlayer player, String[] msg) {
		for (int i = 0; i < msg.length; ++i) {
			GuiHelper.getChatGui().printChatMessage(TextHelper.wrap(TextHelper.getModInfo(msg[i])));
		}
	}
}
