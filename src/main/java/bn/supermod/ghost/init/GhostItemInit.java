package bn.supermod.ghost.init;

import java.util.ArrayList;
import java.util.List;

import bn.supermod.Main;
import bn.supermod.items.ItemBase;
import net.minecraft.item.Item;

public class GhostItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Items
	public static final Item GHOST_INGOT = new ItemBase("ghost_ingot", Main.GHOST_TAB, ITEMS);
}
