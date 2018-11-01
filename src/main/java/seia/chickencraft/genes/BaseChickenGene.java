package seia.chickencraft.genes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import seia.chickencraft.api.genes.IGene;
import seia.chickencraft.helper.DataHelper;

/**
 * Basic gene for all chickens.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public abstract class BaseChickenGene implements IGene {
	protected String newValue = "";

	public String getGeneValue(Entity entity) {
		return this.getGeneValue(DataHelper.getEntityData(entity));
	}

	public String getGeneValue(ItemStack stack) {
		return this.getGeneValue(DataHelper.getItemStackData(stack));
	}

	public void updateEntity(Entity entity) {
		this.updateChicken((EntityChicken) entity);
		this.writeNewDataToEntity(entity);
	}

	protected String getGeneValue(NBTTagCompound tag) {
		String key = this.getNbtTag();
		if (tag != null) {
			String geneValue = tag.getString(key);
			if (geneValue == null || geneValue.equals("")) {
				return null;
			} else {
				return geneValue;
			}
		} else {
			return null;
		}
	}

	protected String buildNbtTag() {
		return buildNbtTag(null);
	}

	protected String buildNbtTag(String tagData) {
		String tag = "ChickenCraft_" + this.getClass().getName();
		if (tagData != null && !tagData.equals("")) {
			return tag + "_" + tagData;
		}
		return tag;
	}

	private void writeNewDataToEntity(Entity entity) {
		String key = this.getNbtTag();
		DataHelper.getEntityData(entity).setString(key, this.newValue);
	}

	protected abstract void updateChicken(EntityChicken entity);
}
