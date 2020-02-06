package jonathan.armor.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config 
{
	private static final ForgeConfigSpec.Builder sbuilder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec server_config;
	private static final ForgeConfigSpec.Builder cbuilder = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec client_config;
	
	static
	{
		OregenConfig.init(sbuilder, cbuilder);
		
		server_config = sbuilder.build();
		client_config = cbuilder.build();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path)
	{
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		file.load();
		config.setConfig(file);
	}
}
