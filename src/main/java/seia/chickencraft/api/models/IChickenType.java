package seia.chickencraft.api.models;

import java.util.List;

import net.minecraft.item.ItemStack;

/**
 * Defines single node in chicken evolution hierarchy.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public interface IChickenType {
	/**
	 * @return Returns the name of the current chicken type.
	 */
	String getChickenTypeName();

	/**
	 * @return Returns the collection of all extra-drops which current chicken type
	 *         can produce.
	 */
	List<ItemStack> getExtraDrops();

	/**
	 * @return Returns the name of the childrens of current chicken type.
	 */
	List<String> getChildrens();
}
