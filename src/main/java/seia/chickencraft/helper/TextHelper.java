package seia.chickencraft.helper;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;

/**
 * Contains various helper methods for helping with text / output formatting in
 * Minecraft.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public final class TextHelper {
	public static final String ENTER = "\n";

	public static final String CHANGING = "§k";
	public static final String BOLD = "§l";
	public static final String ITALIC = "§o";
	public static final String STRIKED = "§m";
	public static final String UNDERLINED = "§n";
	public static final String NONE = "§r";

	public static final String COLOR_BLACK = "§0";
	public static final String COLOR_DARK_BLUE = "§1";
	public static final String COLOR_DARK_GREEN = "§2";
	public static final String COLOR_TUEQUOISE = "§3";
	public static final String COLOR_DARK_RED = "§4";
	public static final String COLOR_PURPLE = "§5";
	public static final String COLOR_ORANGE = "§6";
	public static final String COLOR_GREY = "§7";
	public static final String COLOR_DARK_GREY = "§8";
	public static final String COLOR_BLUE = "§9";
	public static final String COLOR_GREEN = "§a";
	public static final String COLOR_CYAN = "§b";
	public static final String COLOR_RED = "§c";
	public static final String COLOR_PINK = "§d";
	public static final String COLOR_YELLOW = "§e";
	public static final String COLOR_WHITE = "§f";

	private TextHelper() {
	}

	/**
	 * @return Returns given number of enters in text.
	 */
	public static String getEnters(int numberOfEnters) {
		String s = "";
		for (int i = 0; i < numberOfEnters; ++i) {
			s += ENTER;
		}
		return s;
	}

	/**
	 * @return Returns translated string.
	 */
	public static String translateToLocal(String text) {
		return I18n.translateToLocal(text);
	}

	/**
	 * @return Returns given string with mod prefix.
	 */
	public static String getModInfo(String s) {
		return COLOR_GREEN + "[ChickenCraft] " + COLOR_WHITE + s;
	}

	/**
	 * @return Returns wrapped string with TextComponentString.
	 */
	public static ITextComponent wrap(String s) {
		return new TextComponentString(s);
	}
}