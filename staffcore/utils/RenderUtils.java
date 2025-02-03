/*    */ package staffcore.utils;
/*    */ 
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.WorldRenderer;
/*    */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderUtils
/*    */ {
/*    */   public static void drawRect(float left, float top, float right, float bottom, int color) {
/* 14 */     float f3 = (color >> 24 & 0xFF) / 255.0F;
/* 15 */     float f = (color >> 16 & 0xFF) / 255.0F;
/* 16 */     float f1 = (color >> 8 & 0xFF) / 255.0F;
/* 17 */     float f2 = (color & 0xFF) / 255.0F;
/* 18 */     Tessellator tessellator = Tessellator.getInstance();
/* 19 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 20 */     GlStateManager.enableBlend();
/* 21 */     GlStateManager.disableTexture2D();
/* 22 */     GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/* 23 */     GlStateManager.color(f, f1, f2, f3);
/* 24 */     worldrenderer.begin(7, DefaultVertexFormats.POSITION);
/* 25 */     worldrenderer.pos(left, bottom, 0.0D).endVertex();
/* 26 */     worldrenderer.pos(left + right, bottom, 0.0D).endVertex();
/* 27 */     worldrenderer.pos(left + right, bottom + top, 0.0D).endVertex();
/* 28 */     worldrenderer.pos(left, bottom + top, 0.0D).endVertex();
/* 29 */     tessellator.draw();
/* 30 */     GlStateManager.enableTexture2D();
/* 31 */     GlStateManager.disableBlend();
/*    */   }
/*    */   
/*    */   public static void drawCircle(float x, float y, float radius, int color) {
/* 35 */     float f3 = (color >> 24 & 0xFF) / 255.0F;
/* 36 */     float f = (color >> 16 & 0xFF) / 255.0F;
/* 37 */     float f1 = (color >> 8 & 0xFF) / 255.0F;
/* 38 */     float f2 = (color >> 8 & 0xFF) / 255.0F;
/* 39 */     Tessellator tessellator = Tessellator.getInstance();
/*    */     
/* 41 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 42 */     GlStateManager.enableBlend();
/* 43 */     GlStateManager.disableTexture2D();
/* 44 */     GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/* 45 */     GlStateManager.color(f, f1, f2, f3);
/* 46 */     worldrenderer.begin(7, DefaultVertexFormats.POSITION);
/* 47 */     for (int count = 0; count <= 360; count++) {
/* 48 */       worldrenderer.pos(x + Math.sin(count * Math.PI / 180.0D) * radius, y - Math.cos(count * Math.PI / 180.0D) * radius, 0.0D).endVertex();
/*    */     }
/* 50 */     tessellator.draw();
/* 51 */     GlStateManager.enableTexture2D();
/* 52 */     GlStateManager.disableBlend();
/*    */   }
/*    */   
/*    */   public static float[] RGBA(int hex) {
/* 56 */     if ((hex & 0xFC000000) == 0)
/*    */     {
/* 58 */       hex |= 0xFF000000;
/*    */     }
/* 60 */     float alpha = (hex >> 24 & 0xFF) / 255.0F;
/* 61 */     float red = (hex >> 16 & 0xFF) / 255.0F;
/* 62 */     float green = (hex >> 8 & 0xFF) / 255.0F;
/* 63 */     float blue = (hex & 0xFF) / 255.0F;
/* 64 */     return new float[] { red, green, blue, alpha };
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcor\\utils\RenderUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */