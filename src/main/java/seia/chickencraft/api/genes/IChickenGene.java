package seia.chickencraft.api.genes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;

/**
 * Describes single gene connected with a chicken.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public interface IChickenGene {
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
	NBTBase getGeneValue(Entity entity);

	/**
	 * @return Returns the value of the current gene for specified stack (egg).
	 */
	NBTBase getGeneValue(ItemStack eggStack);

	/**
	 * Updates specified chicken.
	 */
	void updateChicken(EntityChicken chicken);

	/**
	 * Called when player throws an egg.
	 */
	void onPlayerThrowEgg(EntityPlayer player, ItemStack eggStack, EntityEgg egg);

	/**
	 * Called when egg hits ground.
	 */
	void onChickenSpawnFromEgg(EntityEgg egg, EntityChicken chicken);

	/**
	 * Called when chicken is ready to spawn egg.
	 */
	void onChickenProduceEgg(EntityChicken chicken, ItemStack eggStack);
}
