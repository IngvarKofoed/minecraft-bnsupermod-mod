package bn.supermod.rainbow;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.IStringSerializable;


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

r4g0b0
r4g2b0
r4g4b0
r2g4b0
r0g4b0
r0g4b2
r0g4b4
r0g2b4
r0g0b4
r2g0b4
r4g0b4
r4g0b2



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

public enum EnumRainbowColor implements IStringSerializable {
	R4G0B0(0, "r4g0b0"),
	R4G2B0(1, "r4g2b0"),
	R4G4B0(2, "r4g4b0"),
	R2G4B0(3, "r2g4b0"),
	R0G4B0(4, "r0g4b0"),
	R0G4B2(5, "r0g4b2"),
	R0G4B4(6, "r0g4b4"),
	R0G2B4(7, "r0g2b4"),
	R0G0B4(8, "r0g0b4"),
	R2G0B4(9, "r2g0b4"),
	R4G0B4(10, "r4g0b4"),
	R4G2B2(11, "r4g0b2");

	private static final EnumRainbowColor[] META_LOOKUP = new EnumRainbowColor[values().length];
	private final int meta;
    private final String unlocalizedName;
	
	private EnumRainbowColor(int meta, String unlocalizedName) {
		this.meta = meta;
		this.unlocalizedName = unlocalizedName;
	}
	
	public int getMetadata()
    {
        return this.meta;
    }
	
	public static EnumRainbowColor byMetadata(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }
	
	@Override
	public String getName() {
		return this.unlocalizedName;
	}

	public String toString()
    {
        return this.unlocalizedName;
    }
	
	static
    {
        for (EnumRainbowColor color : values())
        {
            META_LOOKUP[color.getMetadata()] = color;
        }
    }
}
