package seia.chickencraft.models;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import seia.chickencraft.api.models.IChickenType;

/**
 * Defines single node in chicken evolution hierarchy.
 * 
 * @author Krzysztof "Sejoslaw" Dobrzynski - k.dobrzynski94@gmail.com
 */
public class ChickenType implements IChickenType {
	// Name of the current chicken type.
	private final String chickenTypeName;
	// Items which are allowed to extra-produce by current chicken type.
	private final List<ItemStack> extraDrops;
	// Possible mutations of current chicken type.
	private final List<String> childrens;

	public ChickenType(String chickenTypeName, ItemStack[] extraDrops) {
		this(chickenTypeName, extraDrops, new String[] {});
	}

	public ChickenType(String chickenTypeName, ItemStack[] extraDrops, String[] childrens) {
		this.chickenTypeName = chickenTypeName;

		this.extraDrops = new ArrayList<>();
		this.addAll(this.extraDrops, extraDrops);

		this.childrens = new ArrayList<>();
		this.addAll(this.childrens, childrens);
	}

	public String getChickenTypeName() {
		return this.chickenTypeName;
	}

	public List<ItemStack> getExtraDrops() {
		return this.extraDrops;
	}

	public List<String> getChildrens() {
		return this.childrens;
	}

	private <T> void addAll(List<T> destination, T[] source) {
		for (T element : source) {
			destination.add(element);
		}
	}
}
