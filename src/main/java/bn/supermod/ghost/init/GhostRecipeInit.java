package bn.supermod.ghost.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GhostRecipeInit
{
	public static void init()
	{
		GameRegistry.addSmelting(GhostBlockInit.GHOST_ORE, new ItemStack(GhostItemInit.GHOST_INGOT, 1), 1.5f);
	}
}
