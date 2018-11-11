package seia.chickencraft.genes;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import seia.chickencraft.api.core.ChickenCraftConstants;
import seia.chickencraft.api.genes.IChickenGene;
import seia.chickencraft.api.models.IChickenType;
import seia.chickencraft.api.registries.ChickenTypeRegistry;
import seia.chickencraft.api.registries.GeneRegistry;
import seia.chickencraft.core.ChickenCraft;
import seia.chickencraft.helper.DataHelper;
import seia.chickencraft.helper.TextHelper;

/**
 * Gene which is responsible for mutating spawned egg.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class MutateEggGene extends BaseChickenGene {
	public String getDisplayName() {
		return "Mutated Egg";
	}

	public void onChickenProduceEgg(EntityChicken chicken, ItemStack eggStack) {
		if (this.mutationOccurs(chicken)) {
			this.mutateEggStack(chicken, eggStack);
		}
	}

	protected NBTBase getDefaultGeneValue(NBTTagCompound tag) {
		return new NBTTagByte((byte) 0);
	}

	private boolean mutationOccurs(EntityChicken chicken) {
		if (ChickenCraft.DEBUG) {
			return true;
		}

		IChickenGene mutationGene = GeneRegistry.getGene(MutationChanceGene.class);
		String mutationValueString = TextHelper.formatGeneValue(mutationGene.getGeneValue(chicken));
		double mutationValue = Double.parseDouble(mutationValueString);

		double randomizedValue = Double.parseDouble(this.getNewRandomPercentage());

		if (mutationValue > randomizedValue) {
			return true;
		}

		return false;
	}

	private void mutateEggStack(EntityChicken chicken, ItemStack eggStack) {
		// Find genes
		ChickenTypeGene parentGene = null;
		ChickenTypeGene chickenGene = null;

		for (IChickenGene gene : GeneRegistry.getGenes()) {
			if (gene instanceof ChickenTypeGene) {
				ChickenTypeGene chickenTypeGene = (ChickenTypeGene) gene;
				if (chickenTypeGene.getTypeName().equals(ChickenCraftConstants.CHICKEN_TYPE_NAME_PARENT)) {
					parentGene = chickenTypeGene;
				} else if (chickenTypeGene.getTypeName().equals(ChickenCraftConstants.CHICKEN_TYPE_NAME_CHICKEN)) {
					chickenGene = chickenTypeGene;
				}
			}
		}

		// Chicken (Chicken Type) => Egg (Parent Type)
		NBTBase eggStackParentType = chickenGene.getGeneValue(chicken);
		parentGene.setGeneValue(DataHelper.getItemStackData(eggStack), eggStackParentType);

		// Egg (Chicken Type)
		String eggStackParentTypeValue = TextHelper.formatGeneValue(eggStackParentType);
		IChickenType chickenType = ChickenTypeRegistry.getModel(eggStackParentTypeValue);

		if (chickenType == null) { // In case someone deleted / changed the name of current chicken type.
			return;
		}

		int numberOfChildrens = chickenType.getChildrens().size();

		if (numberOfChildrens > 0 && this.canChangeChickenType()) {
			int index = this.rand.nextInt(numberOfChildrens);
			String eggStackChickenTypeValue = chickenType.getChildrens().get(index);
			chickenGene.setGeneValue(DataHelper.getItemStackData(eggStack), new NBTTagString(eggStackChickenTypeValue));
		} else {
			chickenGene.setGeneValue(DataHelper.getItemStackData(eggStack), eggStackParentType);
		}

		// Egg (Item Produce)
		NBTBase chickenTypeBase = chickenGene.getGeneValue(eggStack);
		String chickenTypeValue = TextHelper.formatGeneValue(chickenTypeBase);
		chickenType = ChickenTypeRegistry.getModel(chickenTypeValue);
		int numberOfDrops = chickenType.getExtraDrops().size();

		if (numberOfDrops > 0) {
			int index = this.rand.nextInt(numberOfDrops);
			ItemStack dropStack = chickenType.getExtraDrops().get(index);
			NBTTagCompound tag = new NBTTagCompound();
			dropStack.writeToNBT(tag);
			IChickenGene itemProduceGene = GeneRegistry.getGene(ItemProduceGene.class);
			itemProduceGene.setGeneValue(DataHelper.getItemStackData(eggStack), tag);
		}

		this.newValue = new NBTTagByte((byte) 1);
	}

	// Pseuse-random chance of chicken type evolution.
	private boolean canChangeChickenType() {
		if (ChickenCraft.DEBUG) {
			return this.rand.nextInt(100) < 1000;
		} else {
			return this.rand.nextInt(100) < 10;
		}
	}
}
