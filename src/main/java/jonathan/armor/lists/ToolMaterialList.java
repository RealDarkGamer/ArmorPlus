package jonathan.armor.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier
{
	sapphire_tools(10.0f,9.0f,2000, 3, 25, ItemLists.sapphire);
	
	private float attackDamge, efficiency;
	private int durability, harvestlevel, enchantability;
	private Item reapirMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability,int harvestlevel, int enchantability, Item repairMaterial) 
	{
		this.attackDamge = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestlevel = harvestlevel;
		this.enchantability = enchantability;
		this.reapirMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses() 
	{
		return this.durability;
	}

	@Override
	public float getEfficiency() 
	{
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() 
	{
		return this.attackDamge;
	}

	@Override
	public int getHarvestLevel() 
	{
		return this.harvestlevel;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.reapirMaterial);
	}
}
