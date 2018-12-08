package bn.supermod.ghost.init;

import java.util.ArrayList;
import java.util.List;

import bn.supermod.Main;
import bn.supermod.items.ItemBase;
import bn.supermod.items.tools.ToolAxeBase;
import bn.supermod.items.tools.ToolHoeBase;
import bn.supermod.items.tools.ToolPickaxeBase;
import bn.supermod.items.tools.ToolShovelBase;
import bn.supermod.items.tools.ToolSwordBase;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class GhostItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final ToolMaterial GHOST_TOOL_MATERIAL = EnumHelper.addToolMaterial("ghost_tool", 2, 400, 3.0f, 5.0f, 20);
	
	// Items
	public static final Item GHOST_INGOT = new ItemBase("ghost_ingot", Main.GHOST_TAB, ITEMS);
	
	// Tools
	public static final Item GHOST_AXE = new ToolAxeBase("ghost_axe", GHOST_TOOL_MATERIAL, Main.GHOST_TAB, ITEMS);
	public static final Item GHOST_HOE = new ToolHoeBase("ghost_hoe", GHOST_TOOL_MATERIAL, Main.GHOST_TAB, ITEMS);
	public static final Item GHOST_PICKAXE = new ToolPickaxeBase("ghost_pickaxe", GHOST_TOOL_MATERIAL, Main.GHOST_TAB, ITEMS);
	public static final Item GHOST_SHOVEL = new ToolShovelBase("ghost_shovel", GHOST_TOOL_MATERIAL, Main.GHOST_TAB, ITEMS);
	public static final Item GHOST_SWORD = new ToolSwordBase("ghost_sword", GHOST_TOOL_MATERIAL, Main.GHOST_TAB, ITEMS);

}
