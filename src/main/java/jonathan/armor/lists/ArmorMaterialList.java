package jonathan.armor.lists;

import jonathan.armor.ArmorPlus;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial
{
	sapphire_armor("Sapphire", 400, new int[] {8, 10, 9, 7}, 25, ItemLists.sapphire, "entity.ender_dragon.growl", 0.0f);
	
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmount;
	private float toughness;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmount, int enchantability, Item repairItem,String equipSound, float toughness) 
	{
		
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{	
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) 
	{	
		return this.damageReductionAmount[slot.getIndex()];
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public String getName() 
	{
		return ArmorPlus.modid + ":" + this.name;
	}

	@Override
	public float getToughness() 
	{	
		return this.toughness;
	}
}
