/*    */ package staffcore.cosmetics;
/*    */ 
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class CosmeticTopHat
/*    */   extends CosmeticBase {
/*    */   private final ModelTopHat modelTopHat;
/* 15 */   private static final ResourceLocation TEXTURE = new ResourceLocation("cosmetics/hat.png");
/*    */   
/*    */   public CosmeticTopHat(RenderPlayer renderPlayer) {
/* 18 */     super(renderPlayer);
/* 19 */     this.modelTopHat = new ModelTopHat(renderPlayer);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
/* 25 */     if (CosmeticManager.shouldRenderTopHat(player)) {
/* 26 */       GlStateManager.pushMatrix();
/* 27 */       this.playerRenderer.bindTexture(TEXTURE);
/*    */ 
/*    */ 
/*    */       
/* 31 */       if (player.isSneaking()) {
/* 32 */         GL11.glTranslated(0.0D, 0.225D, 0.0D);
/*    */       }
/*    */       
/* 35 */       float[] color = CosmeticManager.getTopHatColor(player);
/* 36 */       GL11.glColor3d(color[0], color[1], color[2]);
/* 37 */       this.modelTopHat.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, headYaw, headPitch, scale);
/* 38 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 39 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */   
/*    */   private class ModelTopHat
/*    */     extends CosmeticModelBase
/*    */   {
/*    */     private ModelRenderer rim;
/*    */     private ModelRenderer pointy;
/*    */     
/*    */     public ModelTopHat(RenderPlayer player) {
/* 50 */       super(player);
/* 51 */       this.rim = new ModelRenderer((ModelBase)this.playerModel, 0, 0);
/* 52 */       this.rim.addBox(-5.5F, -9.0F, -5.5F, 11, 2, 11);
/* 53 */       this.pointy = new ModelRenderer((ModelBase)this.playerModel, 0, 13);
/* 54 */       this.pointy.addBox(-3.5F, -17.0F, -3.5F, 7, 8, 7);
/*    */     }
/*    */ 
/*    */     
/*    */     public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
/* 59 */       this.rim.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
/* 60 */       this.rim.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
/* 61 */       this.rim.rotationPointX = 0.0F;
/* 62 */       this.rim.rotationPointY = 0.0F;
/* 63 */       this.rim.render(scale);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\cosmetics\CosmeticTopHat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */