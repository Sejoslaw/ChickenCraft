package seia.chickencraft.modloader.forge;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import seia.chickencraft.core.ChickenCraft;
import seia.chickencraft.handler.ChickenHandler;
import seia.chickencraft.handler.EggHandler;
import seia.chickencraft.handler.TooltipHandler;

/**
 * Class which is responsible to register events in Forge.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class ChickenCraftForgeEvents {
	private final ChickenCraft chickenCraft;

	public ChickenCraftForgeEvents(ChickenCraft chickenCraft) {
		this.chickenCraft = chickenCraft;
	}

	@SubscribeEvent
	public void handleChickenProduceItem(LivingUpdateEvent event) {
		EntityLivingBase entityBase = event.getEntityLiving();

		if (!(entityBase instanceof EntityChicken)) {
			return;
		}

		String entityClassName = entityBase.getClass().getName();
		String chickenClassName = EntityChicken.class.getName();

		if (entityClassName.equals(chickenClassName)) {
			this.chickenCraft.chickenHandler.handleChickenProduceItem((EntityChicken) entityBase);
		}
	}

	@SubscribeEvent
	public void handleEggHitGround(ProjectileImpactEvent.Throwable event) {
		EntityThrowable egg = event.getThrowable();

		if (!(egg instanceof EntityEgg)) {
			return;
		}

		RayTraceResult impactedThing = event.getRayTraceResult();

		String eggClassName = egg.getClass().getName();
		String entityClassName = EntityEgg.class.getName();

		if (eggClassName.equals(entityClassName)) {
			this.chickenCraft.eggHandler.handleEggHitGround((EntityEgg) egg, impactedThing);
		}
	}

	@SubscribeEvent
	public void handleShowEggTooltip(ItemTooltipEvent event) {
		ItemStack currentStack = event.getItemStack();
		String currentItemName = currentStack.getItem().getRegistryName().toString();
		String eggItemName = Items.EGG.getRegistryName().toString();

		if (eggItemName.equals(currentItemName)) {
			EntityPlayer player = event.getEntityPlayer();
			List<String> tooltips = event.getToolTip();
			this.chickenCraft.tooltipHandler.handleShowEggTooltip(player, currentStack, tooltips);
		}
	}

	@SubscribeEvent
	public void handleShowChickenDetails(EntityInteract event) {
		Entity clickedEntity = event.getTarget();

		if (!(clickedEntity instanceof EntityChicken)) {
			return;
		}

		String entityClassName = clickedEntity.getClass().getName();
		String chickenClassName = EntityChicken.class.getName();

		if (entityClassName.equals(chickenClassName)) {
			EntityPlayer player = event.getEntityPlayer();
			this.chickenCraft.tooltipHandler.handleShowChickenDetails(player, (EntityChicken) clickedEntity);
		}
	}
}
