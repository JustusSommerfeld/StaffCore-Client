/*    */ package staffcore.hud.mod;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import staffcore.hud.DraggableComponent;
/*    */ 
/*    */ 
/*    */ public class HudMod
/*    */ {
/* 11 */   public Minecraft mc = Minecraft.getMinecraft();
/* 12 */   public FontRenderer fr = this.mc.fontRendererObj;
/*    */   
/*    */   public String name;
/*    */   public boolean enabled = true;
/*    */   public DraggableComponent drag;
/*    */   public int x;
/*    */   public int y;
/*    */   
/*    */   public HudMod(String name, int x, int y) {
/* 21 */     this.name = name;
/* 22 */     this.x = x;
/* 23 */     this.y = y;
/*    */     
/* 25 */     this.drag = new DraggableComponent(x, y, getWidth(), getHeight(), (new Color(0, 0, 0, 0)).getRGB());
/*    */   }
/*    */   
/*    */   public int getWidth() {
/* 29 */     return 50;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 34 */     return 50;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw() {}
/*    */ 
/*    */   
/*    */   public void renderDummy(int mouseX, int mouseY) {
/* 43 */     this.drag.draw(mouseX, mouseY);
/*    */   }
/*    */   
/*    */   public int getX() {
/* 47 */     return this.drag.getxPosition();
/*    */   }
/*    */   
/*    */   public int getY() {
/* 51 */     return this.drag.getyPosition();
/*    */   }
/*    */   public void setEnabled(boolean enabled) {
/* 54 */     this.enabled = enabled;
/*    */   }
/*    */   public void toggle() {
/* 57 */     setEnabled(!this.enabled);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEnabled() {
/* 62 */     return this.enabled;
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\hud\mod\HudMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */