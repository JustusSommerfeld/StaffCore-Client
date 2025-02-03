/*    */ package staffcore.utils;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import staffcore.Client;
/*    */ import staffcore.cosmetics.Capes;
/*    */ import staffcore.hud.mod.HudMod;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CapesButton
/*    */ {
/*    */   protected ResourceLocation image;
/*    */   protected int x;
/*    */   protected int y;
/*    */   protected int width;
/*    */   protected int height;
/* 25 */   protected int ani = 0;
/*    */   protected Capes target;
/*    */   protected String description;
/*    */   protected Minecraft mc;
/*    */   public HudMod m;
/*    */   
/*    */   public CapesButton(ResourceLocation image, int x, int y, int width, int height, String description, Capes cape) {
/* 32 */     this.image = image;
/* 33 */     this.x = x;
/* 34 */     this.y = y;
/* 35 */     this.width = width;
/* 36 */     this.height = height;
/* 37 */     this.description = description;
/* 38 */     this.target = cape;
/* 39 */     this.mc = Minecraft.getMinecraft();
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(int mouseX, int mouseY, Color c) {
/* 44 */     hoverAnimation(mouseX, mouseY);
/* 45 */     if (this.ani > 0) {
/* 46 */       RenderUtil.instance.draw2DImage(this.image, this.x - this.ani, this.y - this.ani, this.width + this.ani * 2, this.height + this.ani * 2, c);
/* 47 */       double d = this.mc.fontRendererObj.getStringWidth(this.description);
/*    */     }
/*    */     else {
/*    */       
/* 51 */       RenderUtil.instance.draw2DImage(this.image, this.x, this.y, this.width, this.height, c);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void onClick(int mouseX, int mouseY) {
/* 57 */     if (isHovered(mouseX, mouseY)) {
/* 58 */       Client.getInstance().getCapeManager().updateCape(this.mc.thePlayer.getUniqueID().toString(), this.target.getResourceLocation());
/*    */     }
/*    */   }
/*    */   
/*    */   protected void hoverAnimation(int mouseX, int mouseY) {
/* 63 */     if (isHovered(mouseX, mouseY)) {
/* 64 */       if (this.ani < 5) {
/* 65 */         this.ani++;
/*    */       }
/* 67 */     } else if (this.ani > 0) {
/* 68 */       this.ani--;
/*    */     } 
/*    */   }
/*    */   
/*    */   protected boolean isHovered(int mouseX, int mouseY) {
/* 73 */     return RenderUtil.instance.isHovered(this.x, this.y, (this.x + this.width), (this.y + this.height), mouseX, mouseY);
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcor\\utils\CapesButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */