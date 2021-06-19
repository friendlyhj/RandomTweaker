package ink.ikx.rt.impl.jei.impl;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IItemStack;
import crafttweaker.mc1120.brackets.BracketHandlerItem;
import ink.ikx.rt.RandomTweaker;
import ink.ikx.rt.api.instance.jei.interfaces.JEIBackground;
import ink.ikx.rt.api.instance.jei.interfaces.JEIPanel;
import ink.ikx.rt.api.instance.jei.interfaces.JEIRecipe;
import ink.ikx.rt.api.instance.jei.interfaces.slots.JEISlot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JEIPanelImpl implements JEIPanel {

    public String uid;
    public String localizationKey;
    public JEIBackground JEIBackground;
    public String modid = RandomTweaker.MODID;
    public List<JEISlot> JEISlots = new ArrayList<>();
    public List<IItemStack> recipeCatalysts = new ArrayList<>();
    public List<JEIRecipe> JEIRecipeList = new ArrayList<>();
    public IItemStack icon = BracketHandlerItem.getItem("minecraft:bedrock", 0);

    public JEIPanelImpl(String uid, String localizationKey) {
        this.uid = uid;
        this.localizationKey = localizationKey;
    }

    @Override
    public String getUid() {
        return this.uid;
    }

    @Override
    public String getLocalizationKey() {
        return this.localizationKey;
    }

    @Override
    public String getModID() {
        return this.modid;
    }

    @Override
    public IItemStack getIcon() {
        return this.icon;
    }

    @Override
    public JEIBackground getJEIBackground() {
        return this.JEIBackground;
    }

    @Override
    public IItemStack[] getRecipeCatalysts() {
        return this.recipeCatalysts.toArray(new IItemStack[0]);
    }

    @Override
    public JEISlot[] getJEISlots() {
        return this.JEISlots.toArray(new JEISlot[0]);
    }

    @Override
    public JEIRecipe[] getJEIRecipes() {
        return this.JEIRecipeList.toArray(new JEIRecipe[0]);
    }

    @Override
    public void setModID(String modid) {
        this.modid = modid;
    }

    @Override
    public void setIcon(IItemStack icon) {
        this.icon = icon;
    }

    @Override
    public void setJEIBackGroup(JEIBackground JEIBackground) {
        this.JEIBackground = JEIBackground;
    }

    @Override
    public void setJEIBackGroup(int width, int heigh) {
        this.JEIBackground = new JEIBackgroundImpl(width, heigh);
    }

    @Override
    public void setJEISlots(JEISlot[] JEISlots) {
        this.JEISlots = Arrays.asList(JEISlots);
    }


    @Override
    public void setRecipeCatalysts(IItemStack[] recipeCatalysts) {
        this.recipeCatalysts = Arrays.asList(recipeCatalysts);
    }

    @Override
    public void setJEIRecipe(JEIRecipe[] JEIRecipes) {
        this.JEIRecipeList = Arrays.asList(getJEIRecipes());
    }

    @Override
    public void addJEISlot(JEISlot JEISlot) {
        this.JEISlots.add(JEISlot);
    }

    @Override
    public void addRecipeCatalyst(IItemStack recipeCatalyst) {
        this.recipeCatalysts.add(recipeCatalyst);
    }

    @Override
    public void addJEIRecipe(JEIRecipe JEIRecipe) {
        this.JEIRecipeList.add(JEIRecipe);
    }

    @Override
    public void register() {
        if (JEIBackground == null || recipeCatalysts.isEmpty() ||
            JEISlots.isEmpty() || JEIRecipeList.isEmpty()) {
            CraftTweakerAPI.getLogger().logError("Parameters mustn't be empty !!!");
            return;
        } else if (icon.matches(BracketHandlerItem.getItem("minecraft:bedrock", 0))) {
            CraftTweakerAPI.getLogger()
                .logInfo("Please modify icon, even though this is not a requirement");
        }

        RandomTweaker.JEIPanelList.add(this);
    }
}
