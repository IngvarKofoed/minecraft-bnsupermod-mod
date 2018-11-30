package bn.supermod.rainbow;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.IStringSerializable;

public enum EnumRainbowColor implements IStringSerializable {
	R4G0B0(0, 0, "r4g0b0"),
	R4G2B0(1, 1, "r4g2b0");

	private static final EnumRainbowColor[] META_LOOKUP = new EnumRainbowColor[values().length];
	private final int meta;
    private final int damage;    
    private final String unlocalizedName;
	
	private EnumRainbowColor(int meta, int damage, String unlocalizedName) {
		this.meta = meta;
		this.damage = damage;
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
            // DYE_DMG_LOOKUP[enumdyecolor.getDyeDamage()] = enumdyecolor;
        }
    }
}
