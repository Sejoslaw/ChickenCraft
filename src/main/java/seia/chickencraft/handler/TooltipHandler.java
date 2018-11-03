package seia.chickencraft.handler;

import java.util.List;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import seia.chickencraft.api.genes.IChickenGene;
import seia.chickencraft.api.registries.GeneRegistry;
import seia.chickencraft.core.ChickenCraft;
import seia.chickencraft.helper.MessageHelper;

/**
 * Class which is responsible to handle all events connected with showing egg
 * tooltips / genetics metadata.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public final class TooltipHandler extends BaseHandler {
	private static final String HEADER = "---=== Chicken Genes ===---";

	public TooltipHandler(ChickenCraft chickenCraft) {
		super(chickenCraft);
	}

	/**
	 * This method handles showing egg item tooltips with all genes and metadata.
	 */
	public void handleShowEggTooltip(EntityPlayer player, ItemStack eggStack, List<String> tooltips) {
		tooltips.add(HEADER);
		for (IChickenGene gene : GeneRegistry.getGenes()) {
			String geneValue = gene.getGeneValue(eggStack);
			String geneDisplayName = gene.getDisplayName();
			tooltips.add(geneDisplayName + ": " + geneValue);
		}
	}

	/**
	 * This method handles showing chicken details with all genes and metadata.
	 */
	public void handleShowChickenDetails(EntityPlayer player, EntityChicken clickedEntity) {
		if (!player.world.isRemote) {
			MessageHelper.addChatComponentMessage(player, HEADER);
			for (IChickenGene gene : GeneRegistry.getGenes()) {
				String geneValue = gene.getGeneValue(clickedEntity);
				String geneDisplayName = gene.getDisplayName();
				MessageHelper.addChatComponentMessage(player, geneDisplayName + ": " + geneValue);
			}
		}
	}
}
