package seia.chickencraft.helper;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;

/**
 * Contains various helper methods for sounds in Minecraft.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public final class SoundHelper {
	private SoundHelper() {
	}

	/**
	 * Plays chicken drop sound.
	 */
	public static void playChickenDropSound(Entity entity) {
		Random rand = new Random();
		entity.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
	}
}