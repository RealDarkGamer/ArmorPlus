package jonathan.armor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jonathan.armor.config.Config;
import jonathan.armor.lists.ArmorMaterialList;
import jonathan.armor.lists.BlockLists;
import jonathan.armor.lists.ItemLists;
import jonathan.armor.lists.ToolMaterialList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("armorplus")
public class ArmorPlus
{
    public static ArmorPlus instance;
    public static final String modid = "armorplus";
    private static Logger logger = LogManager.getLogger(modid);
    
    public static final ItemGroup ArmorPlus = new ArmorPlusItemGroup();
	
	public ArmorPlus() 
    {
		instance = this;
		
	    ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config);
	    ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config);
	    
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
    	
	    Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("armorplus-client.toml").toString());
	    Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("armorplus-server.toml").toString());
	    
    	MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	logger.info("Setup Method Registered");
    }
    
    private void clientRegistries(final FMLClientSetupEvent event)
    {
    	logger.info("clientRegistries Method Registered");
    }
    
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
    	@SubscribeEvent
    	public static void registerItems(final RegistryEvent.Register<Item> event) 
    	{
    		event.getRegistry().registerAll
    		(
    		  ItemLists.sapphire = new Item(new Item.Properties().group(ArmorPlus)).setRegistryName(location("sapphire")),
    		  
    		  ItemLists.sapphire_ore = new BlockItem(BlockLists.sapphire_ore,new Item.Properties().group(ArmorPlus)).setRegistryName(BlockLists.sapphire_ore.getRegistryName()),
    		  
    		  ItemLists.sapphire_axe = new AxeItem(ToolMaterialList.sapphire_tools, -1.0f, 6.0f, new Item.Properties().group(ArmorPlus)).setRegistryName(location("sapphire_axe")),
    		  ItemLists.sapphire_hoe = new HoeItem(ToolMaterialList.sapphire_tools, 6.0f, new Item.Properties().group(ArmorPlus)).setRegistryName(location("sapphire_hoe")),
    		  ItemLists.sapphire_pickaxe = new PickaxeItem(ToolMaterialList.sapphire_tools, -1, 6.0f, new Item.Properties().group(ArmorPlus)).setRegistryName(location("sapphire_pickaxe")),
    		  ItemLists.sapphire_shovel = new ShovelItem(ToolMaterialList.sapphire_tools, -3.0f, 6.0f, new Item.Properties().group(ArmorPlus)).setRegistryName(location("sapphire_shovel")),
    		  ItemLists.sapphire_sword = new SwordItem(ToolMaterialList.sapphire_tools, 0, 6.0f, new Item.Properties().group(ArmorPlus)).setRegistryName(location("sapphire_sword")),	
    		
    		  ItemLists.sapphire_helmet = new ArmorItem(ArmorMaterialList.sapphire_armor, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorPlus)).setRegistryName(location("sapphire_helmet")),
    		  ItemLists.sapphire_chestplate = new ArmorItem(ArmorMaterialList.sapphire_armor, EquipmentSlotType.CHEST, new Item.Properties().group(ArmorPlus)).setRegistryName(location("sapphire_chestplate")),
    		  ItemLists.sapphire_leggings = new ArmorItem(ArmorMaterialList.sapphire_armor, EquipmentSlotType.LEGS, new Item.Properties().group(ArmorPlus)).setRegistryName(location("sapphire_leggings")),
    		  ItemLists.sapphire_boots = new ArmorItem(ArmorMaterialList.sapphire_armor, EquipmentSlotType.FEET, new Item.Properties().group(ArmorPlus)).setRegistryName(location("sapphire_boots"))
    		);
    		logger.info("Items Registered");
    	}
    	
    	@SubscribeEvent
    	public static void registerBlocks(final RegistryEvent.Register<Block> event) 
    	{
    		event.getRegistry().registerAll
    		(
    		  BlockLists.sapphire_ore = new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(10.0f, 3.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("sapphire_ore"))
     		);
    		logger.info("Blocks Registered");
    	}
    	
    	private static ResourceLocation location(String name)
    	{
    		return new ResourceLocation(modid, name);
    	}
    }
}
