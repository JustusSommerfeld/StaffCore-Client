/*    */ package staffcore.cosmetics;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class CosmeticEasterEggs
/*    */   extends CosmeticBase
/*    */ {
/*    */   private final CosmeticVilligerNose2 EggsModel;
/*    */   public static boolean active = false;
/*    */   
/*    */   public CosmeticEasterEggs(RenderPlayer renderPlayer) {
/* 22 */     super(renderPlayer);
/* 23 */     this.EggsModel = new CosmeticVilligerNose2(renderPlayer);
/*    */   }
/*    */   
/*    */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
/* 27 */     if (active && 
/* 28 */       player.getUniqueID().toString().matches((Minecraft.getMinecraft()).thePlayer.getUniqueID().toString())) {
/* 29 */       GL11.glPushMatrix();
/*    */       
/* 31 */       if (player.isSneaking())
/*    */       {
/* 33 */         GlStateManager.translate(0.0D, 0.262D, 0.0D);
/*    */       }
/*    */       
/* 36 */       GlStateManager.rotate(netHeadYaw, 0.0F, 1.0F, 0.0F);
/* 37 */       GlStateManager.rotate(headPitch, 0.0F, -1.7F, 0.0F);
/* 38 */       GlStateManager.rotate(ageInTicks * 17.0F, 0.0F, 1.0F, 0.0F);
/*    */       
/* 40 */       GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
/*    */       
/* 42 */       this.EggsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/* 43 */       GL11.glColor3d(1.0D, 1.0D, 1.0D);
/*    */       
/* 45 */       if (player == (Minecraft.getMinecraft()).thePlayer) {
/* 46 */         this.EggsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/*    */       }
/*    */       
/* 49 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */   
/*    */   public class CosmeticVilligerNose2
/*    */     extends CosmeticModelBase
/*    */   {
/*    */     public CosmeticVilligerNose2(RenderPlayer player) {
/* 57 */       super(player);
/*    */     }
/*    */     
/*    */     public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
/* 61 */       GlStateManager.pushMatrix();
/*    */       
/* 63 */       GlStateManager.scale(0.45D, 0.45D, 0.45D);
/*    */       
/* 65 */       GlStateManager.translate(2.0D, -1.7D, 0.0D);
/* 66 */       ItemStack itemsword = new ItemStack(Items.iron_sword);
/* 67 */       Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
/* 68 */       GlStateManager.translate(-4.0F, 0.0F, 0.0F);
/* 69 */       Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
/* 70 */       GlStateManager.translate(2.0F, 0.0F, 2.0F);
/* 71 */       Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
/* 72 */       GlStateManager.translate(0.0F, 0.0F, -4.0F);
/* 73 */       Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
/* 74 */       GlStateManager.popMatrix();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\cosmetics\CosmeticEasterEggs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */