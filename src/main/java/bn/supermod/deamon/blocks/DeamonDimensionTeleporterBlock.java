package bn.supermod.deamon.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

import javax.annotation.Nullable;

import bn.supermod.Main;
import bn.supermod.blocks.BlockBase;
import bn.supermod.commands.util.CustomTeleporter;
import bn.supermod.deamon.tileentities.DeamonDimensionTeleporterTileEntity;
import bn.supermod.init.BlockInit;
import bn.supermod.util.ModConfiguration;

public class DeamonDimensionTeleporterBlock extends BlockBase {
	
	public DeamonDimensionTeleporterBlock(String name, Material material, CreativeTabs tab) 
	{
		super(name, material, tab);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		// TODO Auto-generated method stub
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
	

//	@Override
	//public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		// TODO Auto-generated method stub
		//super.onEntityWalk(worldIn, pos, entityIn);
		
		
		//net.minecraft.tileentity.TileEntityEndPortal
		
		if (entityIn instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP)entityIn;
			
			
			
			
			WorldServer deamonWorld = player.getServer().getWorld(ModConfiguration.DIMENSION_DEAMON_ID);
			
			boolean added = deamonWorld.getBlockState(new BlockPos(1, 100, 0)).getBlock().getRegistryName() == BlockInit.DEAMON_TELEPORTER.getRegistryName();
			if (!added)
			{
				Main.logger.info("Adding return teleporter");
				
				for (int y = 0; y < 5; y++)
				{
					for (int x = -1; x < 2; x++)
					{
						for (int z = -1; z < 2; z++)
						{
							deamonWorld.setBlockToAir(new BlockPos(x, 101 + y, z));
						}					
					}
				}
				
				for (int x = -1; x < 2; x++)
				{
					for (int z = -1; z < 2; z++)
					{
						deamonWorld.setBlockState(new BlockPos(x, 100, z), BlockInit.DEAMON_BLOCK.getDefaultState());
					}					
				}									
				
				double returnPosX = Math.floor(player.posX) + 0.5;
				double returnPosY = player.posY;
				double returnPosZ = Math.floor(player.posZ) + 0.5;
				
				Main.logger.info("Player position: (" + player.posX + " ," + player.posY + " ," + player.posZ + ")");
				Main.logger.info("Returning position: (" + returnPosX + " ," + returnPosY + " ," + returnPosZ + ")");
				
				addTeleporterBlock(deamonWorld, -1, 100, 0, returnPosX, returnPosY, returnPosZ);
				addTeleporterBlock(deamonWorld, 1, 100, 0, returnPosX, returnPosY, returnPosZ);
				addTeleporterBlock(deamonWorld, 0, 100, -1, returnPosX, returnPosY, returnPosZ);
				addTeleporterBlock(deamonWorld, 0, 100, 1, returnPosX, returnPosY, returnPosZ);
			}			
			
			int targetDimension = ModConfiguration.DIMENSION_DEAMON_ID;
			double posX = 0.5;
			double posY = 102;
			double posZ = 0.5;
			if (player.dimension == ModConfiguration.DIMENSION_DEAMON_ID)
			{
				DeamonDimensionTeleporterTileEntity tileEntity = (DeamonDimensionTeleporterTileEntity)worldIn.getTileEntity(pos);
				posX = tileEntity.getPlayerX();
				posY = tileEntity.getPlayerY();
				posZ = tileEntity.getPlayerZ();
				targetDimension = 0;
			}
			
			Main.logger.info("Teleporting to: (" + posX + " ," + posY + " ," + posZ + ")");
			
			CustomTeleporter.teleportToDimension((EntityPlayer)player, targetDimension, posX, posY, posZ);
		}		
	}
	
	private void addTeleporterBlock(WorldServer deamonWorld, int x, int y, int z, double returnPosX, double returnPosY, double returnPosZ)
	{
		deamonWorld.setBlockState(new BlockPos(x, y, z), BlockInit.DEAMON_TELEPORTER.getDefaultState());
		DeamonDimensionTeleporterTileEntity tileEntity = (DeamonDimensionTeleporterTileEntity)deamonWorld.getTileEntity(new BlockPos(x, y, z));
		tileEntity.setReturnXYZ(returnPosX, returnPosY, returnPosZ);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) 
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new DeamonDimensionTeleporterTileEntity();
	}
	
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
	 
	 @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}
