/*    */ package staffcore.hud.mod.impl;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import staffcore.hud.mod.HudMod;
/*    */ import staffcore.utils.MultiColorRendering;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FPSMod
/*    */   extends HudMod
/*    */ {
/*    */   public static boolean fpsrainbow = true;
/*    */   public static boolean blue = false;
/*    */   public static boolean green = false;
/*    */   public static boolean red = false;
/*    */   
/*    */   public FPSMod() {
/* 24 */     super("§f[§cFPS: " + Minecraft.getDebugFPS() + "§f]", 5, 5);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw() {
/* 31 */     if (fpsrainbow) {
/* 32 */       MultiColorRendering.drawChromaString("[FPS: " + Minecraft.getDebugFPS() + "]", getX(), getY(), false);
/* 33 */     } else if (blue) {
/* 34 */       this.fr.drawString("§b[FPS: " + Minecraft.getDebugFPS() + "§b]", getX(), getY(), -1);
/* 35 */     } else if (green) {
/* 36 */       this.fr.drawString("§a[FPS: " + Minecraft.getDebugFPS() + "§a]", getX(), getY(), -1);
/* 37 */     } else if (red) {
/* 38 */       this.fr.drawString("§c[FPS: " + Minecraft.getDebugFPS() + "§c]", getX(), getY(), -1);
/*    */     } else {
/* 40 */       this.fr.drawString("§f[FPS: " + Minecraft.getDebugFPS() + "§f]", getX(), getY(), -1);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderDummy(int mouseX, int mouseY) {
/* 48 */     if (fpsrainbow) {
/* 49 */       MultiColorRendering.drawChromaString("[FPS: " + Minecraft.getDebugFPS() + "]", getX(), getY(), false);
/* 50 */       super.renderDummy(mouseX, mouseY);
/* 51 */     } else if (blue) {
/* 52 */       this.fr.drawString("§b[FPS: " + Minecraft.getDebugFPS() + "§b]", getX(), getY(), -1);
/* 53 */       super.renderDummy(mouseX, mouseY);
/* 54 */     } else if (green) {
/* 55 */       this.fr.drawString("§a[FPS: " + Minecraft.getDebugFPS() + "§a]", getX(), getY(), -1);
/* 56 */       super.renderDummy(mouseX, mouseY);
/* 57 */     } else if (red) {
/* 58 */       this.fr.drawString("§c[FPS: " + Minecraft.getDebugFPS() + "§c]", getX(), getY(), -1);
/* 59 */       super.renderDummy(mouseX, mouseY);
/*    */     } else {
/* 61 */       this.fr.drawString("§f[FPS: " + Minecraft.getDebugFPS() + "§f]", getX(), getY(), -1);
/* 62 */       super.renderDummy(mouseX, mouseY);
/*    */     } 
/*    */   }
/*    */   public int getWidth() {
/* 66 */     return this.fr.getStringWidth("§f[§cFPS: " + Minecraft.getDebugFPS() + "§f]");
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 70 */     return this.fr.FONT_HEIGHT;
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\hud\mod\impl\FPSMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */