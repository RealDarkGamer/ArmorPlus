package jonathan.armor;

import jonathan.armor.lists.ItemLists;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ArmorPlusItemGroup extends ItemGroup
{
  public ArmorPlusItemGroup() 
  {
	super("Armor+");
  }

@Override
public ItemStack createIcon() 
  {
	
	return new ItemStack(ItemLists.sapphire_sword);
  }
}
