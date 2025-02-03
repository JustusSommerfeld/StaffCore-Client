/*    */ package staffcore.hud;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import staffcore.Client;
/*    */ import staffcore.hud.mod.HudMod;
/*    */ import staffcore.utils.ImageButton;
/*    */ 
/*    */ 
/*    */ public class HUDConfigScreen
/*    */   extends GuiScreen
/*    */ {
/* 13 */   protected ArrayList<ImageButton> imageButtons = new ArrayList<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 18 */     drawDefaultBackground();
/*    */     
/* 20 */     for (HudMod m : (Client.getInstance()).hudManager.hudMods) {
/* 21 */       if (m.isEnabled()) {
/* 22 */         m.renderDummy(mouseX, mouseY);
/*    */       }
/*    */     } 
/*    */     
/* 26 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\hud\HUDConfigScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */