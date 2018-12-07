package bn.supermod.rainbow.blocks;

import bn.supermod.Main;
import bn.supermod.blocks.BlockBase;
import bn.supermod.init.BlockInit;
import bn.supermod.util.ModConfiguration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockRedFlower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RainbowPortalBrickBlock extends BlockBase 
{
	public RainbowPortalBrickBlock(String name, Material material, CreativeTabs tab) 
	{
		super(name, material, tab);
	}
			
	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) 
	{	
		super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
		
		if (!(entityIn instanceof EntityItem)) return;
		
		EntityItem entityItem = (EntityItem)entityIn;
		ItemStack itemStack = entityItem.getItem();
		Item item = itemStack.getItem();
		
		if (!(item instanceof ItemBlock)) return;
		
		ItemBlock itemBlock = (ItemBlock)item;
		Block block = itemBlock.getBlock();
		
		if (!(block instanceof BlockRedFlower)) return;
		
		IBlockState portalFrame = BlockInit.RAINBOW_PORTAL_BRICK.getDefaultState();
		IBlockState portalTeleporter = BlockInit.DEAMON_TELEPORTER.getDefaultState();
		
		double posX = pos.getX();
		double posY = pos.getY();
		double posZ = pos.getZ();
		
		for (int x = 0; x < 9; x++)
		{			
			worldIn.setBlockState(new BlockPos(posX + x, posY, posZ), portalFrame);
			worldIn.setBlockState(new BlockPos(posX + x, posY + 14, posZ), portalFrame);
		}
		
		for (int y = 0; y < 15; y++)
		{			
			worldIn.setBlockState(new BlockPos(posX , posY + y, posZ), portalFrame);
			worldIn.setBlockState(new BlockPos(posX + 8, posY + y, posZ), portalFrame);
		}
		
		for (int y = 1; y < 14; y++)
		{
			for (int x = 1; x < 8; x++)
			{
				worldIn.setBlockState(new BlockPos(posX + x, posY + y, posZ), portalTeleporter);
			}
		}
			
		// deamonWorld.setBlockState(new BlockPos(x, 100, z), BlockInit.DEAMON_BLOCK.getDefaultState());
	}		
}
