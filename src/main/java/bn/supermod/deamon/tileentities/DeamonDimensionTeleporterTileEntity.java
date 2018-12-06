package bn.supermod.deamon.tileentities;

import bn.supermod.Main;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DeamonDimensionTeleporterTileEntity extends TileEntity 
{	
	private static final String PLAYER_X = "PlayerPrevX";
	private static final String PLAYER_Y = "PlayerPrevY";
	private static final String PLAYER_Z = "PlayerPrevZ";	
	
	private double playerX;
	private double playerY;
	private double playerZ;
	
	public DeamonDimensionTeleporterTileEntity() {
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		playerX = nbt.getDouble(PLAYER_X);
		playerY = nbt.getDouble(PLAYER_Y);
		playerZ = nbt.getDouble(PLAYER_Z);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setDouble(PLAYER_X, playerX);
		nbt.setDouble(PLAYER_Y, playerY);
		nbt.setDouble(PLAYER_Z, playerZ);
		return nbt;
	}
	
	public double getPlayerX()
	{
		return playerX;
	}
	
	public double getPlayerY()
	{
		return playerY;
	}
	
	public double getPlayerZ()
	{
		return playerZ;
	}

	public void setReturnXYZ(double posX, double posY, double posZ)
	{
		// Main.logger.info("setReturnXYZ: (" + posX + " ," + posY + " ," + posZ + ")");
		playerX = posX;
		playerY = posY;
		playerZ = posZ;
	}
}
