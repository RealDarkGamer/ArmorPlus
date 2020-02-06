package jonathan.armor.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig 
{
	public static ForgeConfigSpec.IntValue rare_ore_chance;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Oregen Config");
		
		rare_ore_chance = server
				.comment("Maximum number of rares ores in a single vein")
				.defineInRange("oregen.rare_ore_chance", 100, 10, 1000);
	}
}
