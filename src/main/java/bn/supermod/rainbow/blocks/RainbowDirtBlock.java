package bn.supermod.rainbow.blocks;

import java.util.Random;

import bn.supermod.Main;
import bn.supermod.init.BlockInit;
import bn.supermod.init.ItemInit;
import bn.supermod.rainbow.EnumRainbowColor;
import bn.supermod.rainbow.items.RainbowDirtItemBlock;
import bn.supermod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RainbowDirtBlock extends Block implements IHasModel {

	public static final PropertyEnum<EnumRainbowColor> COLOR = PropertyEnum.<EnumRainbowColor>create("color", EnumRainbowColor.class);

    public RainbowDirtBlock(String name, Material material, CreativeTabs tab)
    {
        super(material);
        setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumRainbowColor.R4G0B0));
        
        BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new RainbowDirtItemBlock(this).setRegistryName(name));
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (EnumRainbowColor color : EnumRainbowColor.values())
        {        	
            items.add(new ItemStack(this, 1, color.getMetadata()));
        }
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return ((EnumRainbowColor)state.getValue(COLOR)).getMetadata();
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(COLOR, EnumRainbowColor.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumRainbowColor)state.getValue(COLOR)).getMetadata();
    }        
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] { COLOR });
    }

	@Override
	public void registerModels() 
	{
		for (EnumRainbowColor color : EnumRainbowColor.values())
        {
			String registryName = this.getRegistryName() + "_" + color.getName();			
			Main.proxy.registerModel(Item.getItemFromBlock(this), color.getMetadata(), registryName);
        }
	}
}
