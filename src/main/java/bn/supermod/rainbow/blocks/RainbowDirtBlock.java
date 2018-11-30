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

/*
 * 
 * 255,   0,   0
255, 128,   0
255, 255,   0
128, 255,   0
  0, 255,   0
  0, 255, 128
  0, 255, 255
  0, 128, 255
  0,   0, 255
128,   0, 255
255,   0, 255
255,   0, 128


255,   0,   0
255,  64,   0
255, 128,   0
255, 192,   0
255, 255,   0
192, 255,   0
128, 255,   0
 64, 255,   0
  0, 255,   0
  0, 255,  64
  0, 255, 128
  0, 255, 192
  0, 255, 255
  0, 192, 255
  0, 128, 255
  0,  64, 255
  0,   0, 255
 64,   0, 255
128,   0, 255
192,   0, 255
255,   0, 255
255,   0, 192
255,   0, 128
255,   0, 64
 * 
 * */

public class RainbowDirtBlock extends Block implements IHasModel {

	/*public RainbowDirtBlock(String name, Material material, CreativeTabs tab) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
//		setHasSubtypes(true);
		net.minecraft.block.BlockStainedGlass
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));		
	}*/
	
	public static final PropertyEnum<EnumRainbowColor> COLOR = PropertyEnum.<EnumRainbowColor>create("color", EnumRainbowColor.class);
	//public static final PropertyEnum<EnumDyeColor> COLOR2 = PropertyEnum.<EnumDyeColor>create("variant", EnumDyeColor.class);

    public RainbowDirtBlock(String name, Material material, CreativeTabs tab)
    {
        super(material);
        setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
        //this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumDyeColor.WHITE));
        this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumRainbowColor.R4G2B0));
              
        
        
        BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new RainbowDirtItemBlock(this).setRegistryName(name));
				
        //net.minecraft.block.BlockStainedGlass
		//net.minecraft.block.BlockPlanks
		//net.minecraft.block.BlockLog
    }

    @Override
    public int damageDropped(IBlockState state)
    {
    	Main.logger.error("Meta (damageDropped): " + ((EnumRainbowColor)state.getValue(COLOR)).getMetadata());
        return ((EnumRainbowColor)state.getValue(COLOR)).getMetadata();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (EnumRainbowColor color : EnumRainbowColor.values())
        {        	
        	Main.logger.error("getSubBlocks: " + color.getMetadata());
            items.add(new ItemStack(this, 1, color.getMetadata()));
        }
    }
    
    
    /*public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {    	
    	return MapColor.getBlockColor((EnumDyeColor)state.getValue(COLOR));
    } */   

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
    	Main.logger.error("getStateFromMeta: " + meta + " " + this.getDefaultState().withProperty(COLOR, EnumRainbowColor.byMetadata(meta)));
        return this.getDefaultState().withProperty(COLOR, EnumRainbowColor.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
    	Main.logger.error("getMetaFromState: " + ((EnumRainbowColor)state.getValue(COLOR)).getMetadata() + " " + ((EnumRainbowColor)state.getValue(COLOR)).getMetadata());
        return ((EnumRainbowColor)state.getValue(COLOR)).getMetadata();
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {    	
    	Main.logger.error("getStateForPlacement: " + this.getStateFromMeta(meta) + " meta: " + meta);
        return this.getStateFromMeta(meta);
    }
    
    /*
    @Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
    	Main.logger.error("getActualState: " + state);
		// TODO Auto-generated method stub
		return super.getActualState(state, worldIn, pos);
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		// TODO Auto-generated method stub
		Main.logger.error("onBlockAdded: " + state);
		super.onBlockAdded(worldIn, pos, state);
	}*/
/*
	@Override
	public BlockStateContainer getBlockState() {
		// TODO Auto-generated method stub
		Main.logger.error("getBlockState: " + super.getBlockState());
		return super.getBlockState();
	}*/

	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		// TODO Auto-generated method stub
		Main.logger.error("createTileEntity: " + state);
		return super.createTileEntity(world, state);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		// TODO Auto-generated method stub
    	Main.logger.error("onBlockPlacedBy: " + state);
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}

	@Override
	public boolean onBlockActivated(final World worldIn, final BlockPos pos, final IBlockState state, final EntityPlayer playerIn, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ) 
    {
    	Main.logger.error("onBlockActivated: " + state);
    	return worldIn.setBlockState(pos, state.cycleProperty(COLOR));
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
			Main.logger.info("Registering model for " + this.getRegistryName() + "_" + color.getName() + ", meta: " + color.getMetadata());
			Main.proxy.registerModel(Item.getItemFromBlock(this), color.getMetadata(), registryName);
        }
	}
}
