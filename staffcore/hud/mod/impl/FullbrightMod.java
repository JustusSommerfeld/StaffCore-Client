/*    */ package staffcore.hud.mod.impl;
/*    */ 
/*    */ import staffcore.hud.mod.HudMod;
/*    */ 
/*    */ 
/*    */ public class FullbrightMod
/*    */   extends HudMod
/*    */ {
/*    */   public FullbrightMod() {
/* 10 */     super("Fullbright", 0, 0);
/*    */   }
/*    */   
/*    */   public void draw() {
/* 14 */     this.mc.gameSettings.gammaSetting = 10.0F;
/* 15 */     super.draw();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isEnabled() {
/* 21 */     this.mc.gameSettings.gammaSetting = 0.0F;
/* 22 */     return this.enabled;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderDummy(int mouseX, int mouseY) {
/* 28 */     this.mc.gameSettings.gammaSetting = 10.0F;
/* 29 */     super.renderDummy(mouseX, mouseY);
/*    */   }
/*    */   public int getWidth() {
/* 32 */     return this.fr.getStringWidth("");
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 36 */     return this.fr.FONT_HEIGHT;
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\hud\mod\impl\FullbrightMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */