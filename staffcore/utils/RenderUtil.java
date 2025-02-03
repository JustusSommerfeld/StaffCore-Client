/*    */ package staffcore.utils;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public enum RenderUtil
/*    */ {
/*    */   protected Minecraft mc;
/* 14 */   instance;
/*    */   RenderUtil() {
/* 16 */     this.mc = Minecraft.getMinecraft();
/*    */   }
/*    */   public void draw2DImage(ResourceLocation image, int x, int y, int width, int height, Color c) {
/* 19 */     GL11.glDisable(2929);
/* 20 */     GL11.glEnable(3042);
/* 21 */     GL11.glDepthMask(false);
/* 22 */     OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/* 23 */     GL11.glColor4f(c.getRed() / 255.0F, c.getGreen() / 255.0F, c.getBlue() / 255.0F, c.getAlpha());
/* 24 */     this.mc.getTextureManager().bindTexture(image);
/* 25 */     Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, width, height, width, height);
/* 26 */     GL11.glDepthMask(true);
/* 27 */     GL11.glDisable(3042);
/* 28 */     GL11.glEnable(2929);
/* 29 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isHovered(double x, double y, double width, double height, int mouseX, int mouseY) {
/* 34 */     return (mouseX > x && mouseY > y && mouseX < width && mouseY < height);
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcor\\utils\RenderUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */