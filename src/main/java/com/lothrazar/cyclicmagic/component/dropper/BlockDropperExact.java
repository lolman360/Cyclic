package com.lothrazar.cyclicmagic.component.dropper;
import com.lothrazar.cyclicmagic.IHasRecipe;
import com.lothrazar.cyclicmagic.block.base.BlockBaseFacingOmni;
import com.lothrazar.cyclicmagic.gui.ForgeGuiHandler;
import com.lothrazar.cyclicmagic.registry.RecipeRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDropperExact extends BlockBaseFacingOmni implements IHasRecipe {
  public BlockDropperExact() {
    super(Material.ROCK);
    this.setGuiId(ForgeGuiHandler.GUI_INDEX_DROPPER);
  }
  @Override
  public TileEntity createTileEntity(World worldIn, IBlockState state) {
    return new TileEntityDropperExact();
  }
  @Override
  public IRecipe addRecipe() {
    return RecipeRegistry.addShapedRecipe(new ItemStack(this),
        "ggg",
        "gdg",
        "ggg",
        'g', "ingotGold",
        's', Blocks.DROPPER);
  }
}
