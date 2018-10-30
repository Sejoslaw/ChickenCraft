package seia.chickencraft.genes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import seia.chickencraft.api.genes.IGene;

/**
 * Basic gene for all chickens.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public abstract class BaseChickenGene implements IGene {
	protected String newValue = "";

	public String getGeneValue(Entity entity) {
		String key = this.getNbtTag();
		return this.getEntityData(entity).getString(key);
	}

	public String getGeneValue(ItemStack stack) {
		String key = this.getNbtTag();
		NBTTagCompound tag = this.getItemStackData(stack);

		if (tag != null) {
			return tag.getString(key);
		} else {
			return "";
		}
	}

	public void updateEntity(Entity entity) {
		this.updateChicken((EntityChicken) entity);
		this.writeNewDataToEntity(entity);
	}

	protected NBTTagCompound getEntityData(Entity entity) { // Wrapper for Forge added method.
		return entity.getEntityData();
	}

	protected NBTTagCompound getItemStackData(ItemStack stack) { // Wrapper for Forge added method.
		return stack.getTagCompound();
	}

	private void writeNewDataToEntity(Entity entity) {
		String key = this.getNbtTag();
		this.getEntityData(entity).setString(key, this.newValue);
	}

	protected abstract void updateChicken(EntityChicken entity);
}
