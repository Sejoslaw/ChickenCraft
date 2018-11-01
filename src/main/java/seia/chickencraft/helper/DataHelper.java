package seia.chickencraft.helper;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Helper which is used to retrieve metadata from objects.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public final class DataHelper {
	private DataHelper() {
	}

	public static NBTTagCompound getEntityData(Entity entity) { // Wrapper for Forge added method.
		return entity.getEntityData();
	}

	public static NBTTagCompound getItemStackData(ItemStack stack) { // Wrapper for Forge added method.
		return stack.getTagCompound();
	}
}
