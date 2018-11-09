package seia.chickencraft.genes;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import seia.chickencraft.api.genes.IChickenGene;
import seia.chickencraft.helper.DataHelper;

/**
 * Basic gene for all chickens.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public abstract class BaseChickenGene implements IChickenGene {
	protected NBTBase newValue = null;
	protected Random rand = new Random();

	public NBTBase getGeneValue(Entity entity) {
		return this.getGeneValue(DataHelper.getEntityData(entity));
	}

	public NBTBase getGeneValue(ItemStack stack) {
		return this.getGeneValue(DataHelper.getItemStackData(stack));
	}

	public String getNbtTag() {
		return this.buildNbtTag();
	}

	public void updateChicken(EntityChicken chicken) {
	}

	public void onPlayerThrowEgg(EntityPlayer player, ItemStack eggStack, EntityEgg egg) {
	}

	public void onChickenSpawnFromEgg(EntityEgg egg, EntityChicken chicken) {
	}

	public void onChickenProduceEgg(EntityChicken chicken, ItemStack eggStack) {
	}

	protected NBTBase getGeneValue(NBTTagCompound tag) {
		String key = this.getNbtTag();
		if (tag != null) {
			NBTBase geneValue = tag.getTag(key);
			if (geneValue == null) {
				return this.getDefaultGeneValue(tag);
			} else {
				return geneValue;
			}
		} else {
			return this.getDefaultGeneValue(tag);
		}
	}

	protected NBTBase getDefaultGeneValue(NBTTagCompound tag) {
		return null;
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

	protected void writeNewDataToStack(ItemStack eggStack) {
		String key = this.getNbtTag();
		DataHelper.getItemStackData(eggStack).setTag(key, this.newValue);
	}

	protected void writeNewDataToEntity(Entity entity) {
		String key = this.getNbtTag();
		DataHelper.getEntityData(entity).setTag(key, this.newValue);
	}

	protected String getNewRandomPercentage() {
		double percent = this.rand.nextDouble();
		percent *= 100;

		String percentValue = String.valueOf(percent);
		if (percent < 10) {
			percentValue = percentValue.substring(0, 4);
		} else {
			percentValue = percentValue.substring(0, 5);
		}

		return percentValue;
	}
}
