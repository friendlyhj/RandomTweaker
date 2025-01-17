package ink.ikx.rt.api.mods.cote.flower;

import cn.hutool.core.lang.Pair;
import crafttweaker.CraftTweakerAPI;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.mods.cote.flower.generating.SubTileGeneratingRepresentation;
import ink.ikx.rt.api.mods.cote.function.botania.BlockActivated;
import ink.ikx.rt.api.mods.cote.function.botania.BlockAdded;
import ink.ikx.rt.api.mods.cote.function.botania.BlockHarvested;
import ink.ikx.rt.api.mods.cote.function.botania.BlockPlacedBy;
import ink.ikx.rt.api.mods.cote.function.botania.CanSelect;
import ink.ikx.rt.api.mods.cote.function.botania.Update;
import ink.ikx.rt.impl.utils.annotation.RTRegisterClass;
import java.util.Objects;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@RTRegisterClass({"contenttweaker", "botania"})
@ZenClass("mods.randomtweaker.cote.SubTileEntity")
public class SubTileRepresentation {

    @ZenProperty
    public int color;
    @ZenProperty
    public String unlocalizedName;
    @ZenProperty
    public int range = 1;
    @ZenProperty
    public int maxMana = 1000;
    @ZenProperty
    public boolean acceptsRedstone;
    @ZenProperty
    public boolean overgrowthAffected = true;
    @ZenProperty
    public Update onUpdate;
    @ZenProperty
    public CanSelect canSelect;
    @ZenProperty
    public BlockAdded onBlockAdded;
    @ZenProperty
    public BlockPlacedBy onBlockPlaceBy;
    @ZenProperty
    public BlockHarvested onBlockHarvested;
    @ZenProperty
    public BlockActivated onBlockActivated;

    public SubTileRepresentation(int color, String unlocalizedName) {
        this.color = color;
        this.unlocalizedName = unlocalizedName;
    }

    @ZenMethod
    public int getColor() {
        return color;
    }

    @ZenMethod
    public void setColor(int color) {
        this.color = color;
    }

    @ZenMethod
    public int getRange() {
        return range;
    }

    @ZenMethod
    public void setRange(int range) {
        this.range = range;
    }

    @ZenMethod
    public boolean isAcceptsRedstone() {
        return acceptsRedstone;
    }

    @ZenMethod
    public void setAcceptsRedstone(boolean acceptsRedstone) {
        this.acceptsRedstone = acceptsRedstone;
    }

    @ZenMethod
    public String getUnlocalizedName() {
        return unlocalizedName;
    }

    @ZenMethod
    public void setUnlocalizedName(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    @ZenMethod
    public int getMaxMana() {
        return maxMana;
    }

    @ZenMethod
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    @ZenMethod
    public boolean isOvergrowthAffected() {
        return overgrowthAffected;
    }

    @ZenMethod
    public void setOvergrowthAffected(boolean overgrowthAffected) {
        this.overgrowthAffected = overgrowthAffected;
    }

    protected void register(String typeName, SubTileRepresentation subtile) {
        if (Objects.nonNull(RandomTweaker.subTileGeneratingMap.putIfAbsent(getUnlocalizedName(), Pair.of(typeName, subtile)))) {
            CraftTweakerAPI.logError("All Potions must be unique. Key: contenttweaker:" + unlocalizedName + " is not.", new UnsupportedOperationException());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SubTileGeneratingRepresentation that = (SubTileGeneratingRepresentation) o;

        return unlocalizedName.equals(that.unlocalizedName);
    }

    @Override
    public int hashCode() {
        return unlocalizedName.hashCode();
    }

}
