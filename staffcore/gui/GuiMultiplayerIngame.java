/*    */ package staffcore.gui;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiMultiplayer;
/*    */ 
/*    */ public class GuiMultiplayerIngame
/*    */   extends GuiMultiplayer
/*    */ {
/*    */   public GuiMultiplayerIngame() {
/* 11 */     super(null);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void actionPerformed(GuiButton button) throws IOException {
/* 16 */     if (button.id == 1 || button.id == 4) {
/* 17 */       disconnect();
/*    */     }
/*    */     
/* 20 */     super.actionPerformed(button);
/*    */   }
/*    */ 
/*    */   
/*    */   public void connectToSelected() {
/* 25 */     disconnect();
/* 26 */     super.connectToSelected();
/*    */   }
/*    */ 
/*    */   
/*    */   private void disconnect() {
/* 31 */     if (this.mc.theWorld != null) {
/*    */       
/* 33 */       this.mc.theWorld.sendQuittingDisconnectingPacket();
/* 34 */       this.mc.loadWorld(null);
/* 35 */       this.mc.displayGuiScreen(null);
/* 36 */       this.parentScreen = null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\gui\GuiMultiplayerIngame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */