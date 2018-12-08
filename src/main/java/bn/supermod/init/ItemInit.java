package bn.supermod.init;

import java.util.ArrayList;
import java.util.List;

import bn.supermod.Main;
import bn.supermod.Reference;
import bn.supermod.items.ItemBase;
import bn.supermod.items.armor.ArmourBase;
import bn.supermod.items.tools.ToolAxeBase;
import bn.supermod.items.tools.ToolHoeBase;
import bn.supermod.items.tools.ToolPickaxeBase;
import bn.supermod.items.tools.ToolShovelBase;
import bn.supermod.items.tools.ToolSwordBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Armour Materials
	public static final ArmorMaterial DEAMON_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("deamon_model", Reference.MODID + ":deamon_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0f);
	public static final ArmorMaterial GHOST_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ghost_model", Reference.MODID + ":ghost_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0f);
	
	// Tool Materials
	public static final ToolMaterial DEAMON_TOOL_MATERIAL = EnumHelper.addToolMaterial("deamon_tool", 2, 400, 3.0f, 5.0f, 20);	
	
	// Items
	public static final Item DEAMON_INGOT = new ItemBase("deamon_ingot", Main.DEAMON_TAB);
	
	// Armour
	public static final Item DEAMON_HELMET = new ArmourBase("deamon_helmet", Main.DEAMON_TAB, DEAMON_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD);
	public static final Item DEAMON_CHESTPLATE = new ArmourBase("deamon_chestplate", Main.DEAMON_TAB, DEAMON_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST);
	public static final Item DEAMON_LEGGINGS = new ArmourBase("deamon_leggings", Main.DEAMON_TAB, DEAMON_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS);
	public static final Item DEAMON_BOOTS = new ArmourBase("deamon_boots", Main.DEAMON_TAB, DEAMON_ARMOR_MATERIAL, EntityEquipmentSlot.FEET);
	
	public static final Item GHOST_HELMET = new ArmourBase("ghost_helmet", Main.GHOST_TAB, GHOST_ARMOR_MATERIAL, EntityEquipmentSlot.HEAD);
	public static final Item GHOST_CHESTPLATE = new ArmourBase("ghost_chestplate", Main.GHOST_TAB, GHOST_ARMOR_MATERIAL, EntityEquipmentSlot.CHEST);
	public static final Item GHOST_LEGGINGS = new ArmourBase("ghost_leggings", Main.GHOST_TAB, GHOST_ARMOR_MATERIAL, EntityEquipmentSlot.LEGS);
	public static final Item GHOST_BOOTS = new ArmourBase("ghost_boots", Main.GHOST_TAB, GHOST_ARMOR_MATERIAL, EntityEquipmentSlot.FEET);
	
	// Tools
	public static final Item DEAMON_AXE = new ToolAxeBase("deamon_axe", DEAMON_TOOL_MATERIAL, Main.DEAMON_TAB);
	public static final Item DEAMON_HOE = new ToolHoeBase("deamon_hoe", DEAMON_TOOL_MATERIAL, Main.DEAMON_TAB);
	public static final Item DEAMON_PICKAXE = new ToolPickaxeBase("deamon_pickaxe", DEAMON_TOOL_MATERIAL, Main.DEAMON_TAB);
	public static final Item DEAMON_SHOVEL = new ToolShovelBase("deamon_shovel", DEAMON_TOOL_MATERIAL, Main.DEAMON_TAB);
	public static final Item DEAMON_SWORD = new ToolSwordBase("deamon_sword", DEAMON_TOOL_MATERIAL, Main.DEAMON_TAB);
}
