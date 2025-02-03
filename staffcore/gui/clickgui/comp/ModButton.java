/*    */ package staffcore.gui.clickgui.comp;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import staffcore.hud.mod.HudMod;
/*    */ import staffcore.utils.ImageButton;
/*    */ 
/*    */ 
/*    */ public class ModButton
/*    */ {
/*    */   public int x;
/*    */   public int y;
/*    */   public int w;
/*    */   public int h;
/*    */   public HudMod m;
/* 17 */   protected ArrayList<ImageButton> imageButtons = new ArrayList<>();
/*    */ 
/*    */   
/*    */   public ModButton(int x, int y, int w, int h, HudMod m) {
/* 21 */     this.x = x;
/* 22 */     this.y = y;
/* 23 */     this.w = w;
/* 24 */     this.h = h;
/* 25 */     this.m = m;
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw() {
/* 30 */     (Minecraft.getMinecraft()).fontRendererObj.drawString(this.m.name, this.x + 2, this.y + 2, getColor());
/*    */   }
/*    */   
/*    */   private int getColor() {
/* 34 */     if (this.m.isEnabled()) {
/* 35 */       return (new Color(0, 255, 0, 255)).getRGB();
/*    */     }
/* 37 */     return (new Color(255, 0, 0, 255)).getRGB();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onClick(int mouseX, int mouseY, int button) {
/* 42 */     if (mouseX >= this.x && mouseX <= this.x + this.w && mouseY >= this.y && mouseY <= this.y + this.h)
/* 43 */       if (this.m.isEnabled()) {
/* 44 */         this.m.setEnabled(false);
/*    */       } else {
/*    */         
/* 47 */         this.m.setEnabled(true);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\gui\clickgui\comp\ModButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */