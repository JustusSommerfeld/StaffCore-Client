/*    */ package staffcore.hud.mod.impl;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import staffcore.hud.mod.HudMod;
/*    */ 
/*    */ public class TargetHUD
/*    */   extends HudMod
/*    */ {
/*    */   public TargetHUD() {
/* 16 */     super("TargetHUD", 550, 10);
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw() {
/* 21 */     renderTargetHUD();
/* 22 */     super.draw();
/*    */   }
/*    */   
/*    */   public void renderDummy(int mouseX, int mouseY) {
/* 26 */     this.fr.drawStringWithShadow(Minecraft.getMinecraft().getSession().getUsername(), (getX() + 2), (getY() + 2), -1);
/* 27 */     this.fr.drawStringWithShadow("20.0 ❤", (getX() + 2), (getY() + 2 + this.fr.FONT_HEIGHT), -1);
/* 28 */     drawEntityOnScreen(getX() + 70, getY() + 25, 15, 0.0F, (EntityLivingBase)this.mc.thePlayer);
/* 29 */     super.renderDummy(mouseX, mouseY);
/*    */   }
/*    */   
/*    */   public int getWidth() {
/* 33 */     return 100;
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 37 */     return this.fr.FONT_HEIGHT * 2 + 4;
/*    */   }
/*    */ 
/*    */   
/*    */   private void renderTargetHUD() {
/* 42 */     if (this.mc.thePlayer != null) {
/* 43 */       this.fr.drawStringWithShadow(Minecraft.getMinecraft().getSession().getUsername(), (getX() + 2), (getY() + 2), -1);
/* 44 */       this.fr.drawStringWithShadow(String.valueOf(Math.round(this.mc.thePlayer.getHealth())) + " ❤", (getX() + 2), (getY() + 2 + this.fr.FONT_HEIGHT), -1);
/* 45 */       drawEntityOnScreen(getX() + 70, getY() + 25, 15, 0.0F, (EntityLivingBase)this.mc.thePlayer);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void drawEntityOnScreen(int posX, int posY, int scale, float rotation, EntityLivingBase ent) {
/* 50 */     float rY = ent.rotationYaw % 360.0F;
/* 51 */     float rYH = ent.rotationYawHead % 360.0F;
/* 52 */     float rYO = ent.renderYawOffset;
/*    */ 
/*    */     
/* 55 */     ent.rotationYawHead = rotation + rYH - rYO;
/* 56 */     ent.rotationYaw = rotation;
/* 57 */     ent.renderYawOffset = rotation;
/* 58 */     GlStateManager.enableColorMaterial();
/* 59 */     GlStateManager.pushMatrix();
/*    */     
/* 61 */     GlStateManager.translate(posX, posY, 50.0F);
/* 62 */     GlStateManager.scale(-scale, scale, scale);
/* 63 */     GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
/*    */     
/* 65 */     GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
/* 66 */     RenderHelper.enableStandardItemLighting();
/*    */     
/* 68 */     GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
/* 69 */     GlStateManager.translate(0.0F, 0.0F, 0.0F);
/* 70 */     RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
/* 71 */     rendermanager.setPlayerViewY(180.0F);
/* 72 */     rendermanager.setRenderShadow(false);
/* 73 */     rendermanager.renderEntityWithPosYaw((Entity)ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/* 74 */     rendermanager.setRenderShadow(true);
/* 75 */     GlStateManager.popMatrix();
/* 76 */     RenderHelper.disableStandardItemLighting();
/* 77 */     GlStateManager.disableRescaleNormal();
/* 78 */     GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
/* 79 */     GlStateManager.disableTexture2D();
/* 80 */     GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
/* 81 */     ent.rotationYaw = rY;
/* 82 */     ent.rotationYawHead = rYH;
/* 83 */     ent.renderYawOffset = rYO;
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\hud\mod\impl\TargetHUD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */