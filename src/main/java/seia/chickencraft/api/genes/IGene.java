package seia.chickencraft.api.genes;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

/**
 * Describes single gene connected with an Entity.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public interface IGene {
	/**
	 * @return Returns the display name for current gene.
	 */
	String getDisplayName();

	/**
	 * @return Returns the tag which should be read / write to NBT entity data.
	 */
	String getNbtTag();

	/**
	 * @return Returns the value of the current gene for specified entity.
	 */
	String getGeneValue(Entity entity);

	/**
	 * @return Returns the value of the current gene for specified stack (egg).
	 */
	String getGeneValue(ItemStack stack);

	/**
	 * Updates specified entity.
	 */
	void updateEntity(Entity entity);
}
