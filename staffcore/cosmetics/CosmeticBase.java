/*    */ package staffcore.cosmetics;
/*    */ 
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerRenderer;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public abstract class CosmeticBase implements LayerRenderer<AbstractClientPlayer> {
/*    */   protected final RenderPlayer playerRenderer;
/*    */   
/*    */   public CosmeticBase(RenderPlayer playerRenderer) {
/* 12 */     this.playerRenderer = playerRenderer;
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRenderLayer(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
/* 17 */     if (player.hasPlayerInfo() && !player.isInvisible()) {
/* 18 */       render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldCombineTextures() {
/* 28 */     return false;
/*    */   }
/*    */   
/*    */   public abstract void render(AbstractClientPlayer paramAbstractClientPlayer, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7);
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\cosmetics\CosmeticBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */