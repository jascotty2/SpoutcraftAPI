package org.spoutcraft.spoutcraftapi.material.block;

import org.spoutcraft.spoutcraftapi.material.Plant;

public class Tree extends GenericBlock implements Plant{

	public Tree(int id, int data) {
		super(id, data);
	}

	public boolean isHasGrowthStages() {
		return false;
	}

	public int getNumGrowthStages() {
		return 0;
	}

	public int getMinimumLightToGrow() {
		return 0;
	}

}
