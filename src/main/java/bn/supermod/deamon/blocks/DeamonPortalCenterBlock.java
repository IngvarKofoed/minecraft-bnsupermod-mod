package bn.supermod.deamon.blocks;

import bn.supermod.Main;
import bn.supermod.blocks.BlockBase;
import bn.supermod.deamon.tileentities.DeamonDimensionTeleporterTileEntity;
import bn.supermod.init.BlockInit;
import bn.supermod.util.ModConfiguration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedFlower;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFireworkCharge;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class DeamonPortalCenterBlock extends BlockBase 
{
	private static Vec3i[] netherRackPositions = 
		{
			new Vec3i(-1, 0, 0),
			new Vec3i(1, 0, 0),
			new Vec3i(0, 0, -1),
			new Vec3i(0, 0, 1)
		};
	IBlockState netherRackToMatch = Blocks.NETHERRACK.getDefaultState();
	
	private static Vec3i[] firePositions = 
		{
			new Vec3i(-1, 1, 0),
			new Vec3i(1, 1, 0),
			new Vec3i(0, 1, -1),
			new Vec3i(0, 1, 1)
		};
	IBlockState fireToMatch = Blocks.FIRE.getDefaultState();
	
	private static Vec3i[] swirlBrickPositions = 
		{
			new Vec3i(-1, 0, -1),
			new Vec3i(-1, 0, 1),
			new Vec3i(1, 0, -1),
			new Vec3i(1, 0, 1),
			
			new Vec3i(-2, 4, -2),
			new Vec3i(2, 4, -2),
			new Vec3i(-2, 4, 2),
			new Vec3i(2, 4, 2),
		};
	IBlockState swirlBrickToMatch = Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.CHISELED_META);
	
	private static Vec3i[] stoneBrickPositions = 
		{
			// Floor
			new Vec3i(-3, 0, -3),
			new Vec3i(-3, 0, -2),
			new Vec3i(-3, 0, -1),
			new Vec3i(-3, 0, 0),
			new Vec3i(-3, 0, 1),
			new Vec3i(-3, 0, 2),
			new Vec3i(-3, 0, 3),
			
			new Vec3i(-2, 0, -3),
			new Vec3i(-2, 0, -2),
			new Vec3i(-2, 0, -1),
			new Vec3i(-2, 0, 0),
			new Vec3i(-2, 0, 1),
			new Vec3i(-2, 0, 2),
			new Vec3i(-2, 0, 3),
			
			new Vec3i(-1, 0, -3),
			new Vec3i(-1, 0, -2),
			new Vec3i(-1, 0, 2),
			new Vec3i(-1, 0, 3),
			
			new Vec3i(0, 0, -3),
			new Vec3i(0, 0, -2),
			new Vec3i(0, 0, 2),
			new Vec3i(0, 0, 3),
			
			new Vec3i(1, 0, -3),
			new Vec3i(1, 0, -2),
			new Vec3i(1, 0, 2),
			new Vec3i(1, 0, 3),
			
			new Vec3i(2, 0, -3),
			new Vec3i(2, 0, -2),
			new Vec3i(2, 0, -1),
			new Vec3i(2, 0, 0),
			new Vec3i(2, 0, 1),
			new Vec3i(2, 0, 2),
			new Vec3i(2, 0, 3),
			
			new Vec3i(3, 0, -3),
			new Vec3i(3, 0, -2),
			new Vec3i(3, 0, -1),
			new Vec3i(3, 0, 0),
			new Vec3i(3, 0, 1),
			new Vec3i(3, 0, 2),
			new Vec3i(3, 0, 3),
			
			// Pilars
			new Vec3i(-3, 1, -3),
			new Vec3i(-3, 2, -3),
			new Vec3i(-3, 3, -3),
			
			new Vec3i(3, 1, -3),
			new Vec3i(3, 2, -3),
			new Vec3i(3, 3, -3),
			
			new Vec3i(-3, 1, 3),
			new Vec3i(-3, 2, 3),
			new Vec3i(-3, 3, 3),
			
			new Vec3i(3, 1, 3),
			new Vec3i(3, 2, 3),
			new Vec3i(3, 3, 3),
			
			// Ceiling
			new Vec3i(-3, 4, -3),
			new Vec3i(-3, 4, -2),
			new Vec3i(-3, 4, -1),
			new Vec3i(-3, 4, 0),
			new Vec3i(-3, 4, 1),
			new Vec3i(-3, 4, 2),
			new Vec3i(-3, 4, 3),
			
			new Vec3i(-2, 4, -3),
			new Vec3i(-1, 4, -3),
			new Vec3i(0, 4, -3),
			new Vec3i(1, 4, -3),
			new Vec3i(2, 4, -3),
			
			new Vec3i(-2, 4, 3),
			new Vec3i(-1, 4, 3),
			new Vec3i(0, 4, 3),
			new Vec3i(1, 4, 3),
			new Vec3i(2, 4, 3),

			new Vec3i(3, 4, -3),
			new Vec3i(3, 4, -2),
			new Vec3i(3, 4, -1),
			new Vec3i(3, 4, 0),
			new Vec3i(3, 4, 1),
			new Vec3i(3, 4, 2),
			new Vec3i(3, 4, 3),

		};
	IBlockState stoneBrickToMatch = Blocks.STONEBRICK.getStateFromMeta(BlockStoneBrick.DEFAULT_META);

	private static Vec3i[] portalPositions = 
		{
			new Vec3i(-1, 4, -2),
			new Vec3i(0, 4, -2),
			new Vec3i(1, 4, -2),
			
			new Vec3i(-2, 4, -1),
			new Vec3i(-1, 4, -1),
			new Vec3i(0, 4, -1),
			new Vec3i(1, 4, -1),
			new Vec3i(2, 4, -1),
			
			new Vec3i(-2, 4, 0),
			new Vec3i(-1, 4, 0),
			new Vec3i(0, 4, 0),
			new Vec3i(1, 4, 0),
			new Vec3i(2, 4, 0),
			
			new Vec3i(-2, 4, 1),
			new Vec3i(-1, 4, 1),
			new Vec3i(0, 4, 1),
			new Vec3i(1, 4, 1),
			new Vec3i(2, 4, 1),
			
			new Vec3i(-1, 4, 2),
			new Vec3i(0, 4, 2),
			new Vec3i(1, 4, 2),
	};
	
	
	public DeamonPortalCenterBlock(String name, Material material, CreativeTabs tab) 
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
		
		if (!(item instanceof ItemFireworkCharge)) return;
		
		Main.logger.info("Checking for correct deamon portal");
				
		if (!testBlocks(worldIn, pos, netherRackPositions, netherRackToMatch)) return;
		if (!testBlocks(worldIn, pos, swirlBrickPositions, swirlBrickToMatch)) return;
		if (!testBlocks(worldIn, pos, stoneBrickPositions, stoneBrickToMatch)) return;
		if (!testFireBlocks(worldIn, pos, firePositions, fireToMatch)) return;
		
		MinecraftServer server = worldIn.getMinecraftServer();
		if (server == null) {
			Main.logger.warn("Server is null");
			return;
		}
		
		Main.logger.info("All ok, creating portal");
		
		
		BlockPos deamonWorldPos = new BlockPos(25, 100, 0);		
		
		World deamonWorld = server.getWorld(ModConfiguration.DIMENSION_DEAMON_ID);
			
		createPortal(worldIn, pos, deamonWorldPos);
		createReturnPortal(deamonWorld, deamonWorldPos, pos);
	}
	
	private static void createPortal(World worldIn, BlockPos position, BlockPos returnPosition) 
	{
		IBlockState blockToPlace = BlockInit.DEAMON_TELEPORTER.getDefaultState();
		
		double returnPosX = returnPosition.getX() + 0.5;
		double returnPosY = returnPosition.getY() + 2;
		double returnPosZ = returnPosition.getZ() + 0.5;
		
		for (Vec3i offset : portalPositions)
		{
			BlockPos pos = position.add(offset);
			worldIn.setBlockState(pos, blockToPlace);
			
			DeamonDimensionTeleporterTileEntity tileEntity = (DeamonDimensionTeleporterTileEntity)worldIn.getTileEntity(pos);
			tileEntity.setReturnXYZ(returnPosX, returnPosY, returnPosZ);
		}
	}
	
	private static void createReturnPortal(World deamonWorld, BlockPos position, BlockPos returnPosition) 
	{
		// Clear area
		for (int y = 0; y < 5; y++)
		{
			for (int x = -1; x < 2; x++)
			{
				for (int z = -1; z < 2; z++)
				{
					BlockPos pos = new BlockPos(position.getX() + x, position.getY() + y, position.getZ() + z);
					deamonWorld.setBlockToAir(pos);
				}					
			}
		}
		
		// Add floor
		for (int x = -1; x < 2; x++)
		{
			for (int z = -1; z < 2; z++)
			{
				BlockPos pos = new BlockPos(position.getX() + x, position.getY(), position.getZ() + z);
				deamonWorld.setBlockState(pos, BlockInit.DEAMON_BLOCK.getDefaultState());
			}					
		}									
		
		double returnPosX = returnPosition.getX() + 0.5;
		double returnPosY = returnPosition.getY() + 2;
		double returnPosZ = returnPosition.getZ() + 0.5;
		
		Vec3i[] portalBlockPositions = {
			new Vec3i(-1, 0, 0),
			new Vec3i(1, 0, 0),
			new Vec3i(0, 0, -1),
			new Vec3i(0, 0, 1),
		};
		
		for (Vec3i offset : portalBlockPositions) {
			BlockPos pos = position.add(offset);
			deamonWorld.setBlockState(pos, BlockInit.DEAMON_TELEPORTER.getDefaultState());
			
			DeamonDimensionTeleporterTileEntity tileEntity = (DeamonDimensionTeleporterTileEntity)deamonWorld.getTileEntity(pos);
			tileEntity.setReturnXYZ(returnPosX, returnPosY, returnPosZ);
		}
	}
	
	private static boolean testBlocks(World worldIn, BlockPos position, Vec3i[] offsets, IBlockState blockToMatch)
	{
		for (Vec3i offset : offsets)
		{
			BlockPos pos = position.add(offset);
			IBlockState blockState = worldIn.getBlockState(pos);
				
			if (!blockState.equals(blockToMatch)) {
				Main.logger.warn("[" + blockState + "] does not match  [" + blockToMatch + "] at the position " + pos);
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean testFireBlocks(World worldIn, BlockPos position, Vec3i[] offsets, IBlockState blockToMatch)
	{
		for (Vec3i offset : offsets)
		{
			BlockPos pos = position.add(offset);
			IBlockState blockState = worldIn.getBlockState(pos);
						
			if (!blockState.getBlock().getRegistryName().equals(blockToMatch.getBlock().getRegistryName())) {
				Main.logger.warn("[" + blockState + "] does not match  [" + blockToMatch + "] at the position " + pos);
				return false;
			}
		}
		
		return true;
	}
}
