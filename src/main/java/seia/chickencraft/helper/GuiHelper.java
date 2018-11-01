package seia.chickencraft.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;

/**
 * Contains various helper methods for GUI in Minecraft.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public final class GuiHelper {
	private GuiHelper() {
	}

	/**
	 * @return Returns Minecraft chat GUI.
	 */
	public static GuiNewChat getChatGui() {
		return Minecraft.getMinecraft().ingameGUI.getChatGUI();
	}
}
