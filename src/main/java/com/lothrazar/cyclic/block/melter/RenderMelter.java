package com.lothrazar.cyclic.block.melter;

import com.lothrazar.cyclic.render.FluidTankRenderType;
import com.lothrazar.cyclic.util.UtilFluid;
import com.lothrazar.cyclic.util.UtilRender;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

@OnlyIn(Dist.CLIENT)
public class RenderMelter extends TileEntityRenderer<TileMelter> {

  public RenderMelter(TileEntityRendererDispatcher d) {
    super(d);
  }

  @Override
  public void render(TileMelter tankHere, float v, MatrixStack matrix,
      IRenderTypeBuffer renderer, int light, int overlayLight) {
    //TODO: recipe from tag
    IFluidHandler handler = tankHere.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).orElse(null);
    if (handler == null || handler.getFluidInTank(0) == null) {
      return;
    }
    FluidStack fluid = handler.getFluidInTank(0);
    if (fluid.isEmpty()) {
      return;
    }
    IVertexBuilder buffer = renderer.getBuffer(FluidTankRenderType.resizableCuboid());
    matrix.scale(1F, UtilFluid.getScale(tankHere.tank), 1F);
    UtilRender.renderObject(UtilFluid.getFluidModel(fluid, UtilFluid.stages - 1),
        matrix, buffer, UtilRender.getColorARGB(fluid, 0.1F),
        UtilRender.calculateGlowLight(light, fluid));
  }
}
