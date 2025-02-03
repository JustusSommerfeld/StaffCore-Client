/*     */ package staffcore.cosmetics;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CosmeticDragonWings
/*     */   extends CosmeticBase
/*     */ {
/*  23 */   private static final ResourceLocation TEXTURE = new ResourceLocation("cosmetics/wings.png");
/*     */   
/*     */   private static ModelRenderer wing;
/*     */   
/*     */   private static ModelRenderer wingTip;
/*     */   
/*     */   boolean flying = false;
/*     */   
/*     */   private final ModelDragonWings modelDragonWings;
/*     */   
/*     */   public static boolean active = false;
/*     */   
/*     */   public CosmeticDragonWings(RenderPlayer renderPlayer) {
/*  36 */     super(renderPlayer);
/*  37 */     this.modelDragonWings = new ModelDragonWings(renderPlayer);
/*     */ 
/*     */     
/*  40 */     this.modelDragonWings.setTextureOffset("wingTip.bone", 112, 136);
/*  41 */     this.modelDragonWings.setTextureOffset("wing.skin", -56, 88);
/*  42 */     this.modelDragonWings.setTextureOffset("wing.bone", 112, 88);
/*  43 */     this.modelDragonWings.setTextureOffset("wingTip.skin", -56, 144);
/*     */     
/*  45 */     int bw = this.modelDragonWings.textureWidth;
/*  46 */     int bh = this.modelDragonWings.textureHeight;
/*     */ 
/*     */ 
/*     */     
/*  50 */     this.modelDragonWings.textureWidth = 256;
/*  51 */     this.modelDragonWings.textureHeight = 256;
/*     */ 
/*     */     
/*  54 */     wing = new ModelRenderer(this.modelDragonWings, "wing");
/*  55 */     wing.setRotationPoint(-12.0F, 5.0F, 2.0F);
/*  56 */     wing.addBox("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8);
/*  57 */     wing.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
/*  58 */     wing.isHidden = true;
/*  59 */     wingTip = new ModelRenderer(this.modelDragonWings, "wingTip");
/*  60 */     wingTip.setRotationPoint(-56.0F, 0.0F, 0.0F);
/*  61 */     wingTip.isHidden = true;
/*  62 */     wingTip.addBox("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4);
/*  63 */     wingTip.addBox("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
/*  64 */     wing.addChild(wingTip);
/*  65 */     this.modelDragonWings.textureWidth = bw;
/*  66 */     this.modelDragonWings.textureWidth = bh;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float HeadYaw, float headPitch, float scale) {
/*  81 */     if (active && 
/*  82 */       player.getUniqueID().toString().matches((Minecraft.getMinecraft()).thePlayer.getUniqueID().toString())) {
/*  83 */       GlStateManager.pushMatrix();
/*     */       
/*  85 */       this.modelDragonWings.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, HeadYaw, headPitch, scale);
/*  86 */       this.modelDragonWings.setRotationAngles(scale, limbSwing, limbSwingAmount, ageInTicks, HeadYaw, headPitch, (Entity)player);
/*  87 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class ModelDragonWings
/*     */     extends CosmeticModelBase
/*     */   {
/*     */     public ModelDragonWings(RenderPlayer player) {
/* 102 */       super(player);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
/* 111 */       super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/*     */ 
/*     */       
/* 114 */       GlStateManager.pushMatrix();
/*     */       
/* 116 */       float f1 = 0.0F;
/*     */       
/* 118 */       if ((Minecraft.getMinecraft()).thePlayer.capabilities.isFlying) {
/* 119 */         f1 = ageInTicks / 200.0F;
/*     */       } else {
/* 121 */         f1 = ageInTicks / 80.0F;
/*     */       } 
/*     */ 
/*     */       
/* 125 */       if (entityIn.isSneaking()) {
/* 126 */         GL11.glTranslated(0.0D, 0.225D, 0.0D);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 131 */       Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/entity/enderdragon/dragon.png"));
/*     */       
/* 133 */       float anSpeed = 100.0F;
/* 134 */       if (!entityIn.onGround || CosmeticDragonWings.this.flying) {
/*     */         
/* 136 */         anSpeed = 50.0F;
/* 137 */         CosmeticDragonWings.this.flying = true;
/*     */       } 
/* 139 */       GlStateManager.scale(0.14D, 0.14D, 0.14D);
/* 140 */       GlStateManager.translate(0.0D, 0.3D, 1.0D);
/* 141 */       GlStateManager.rotate(10.0F, -50.0F, 0.0F, 0.0F);
/*     */       
/* 143 */       int x = 0;
/* 144 */       int index = 0;
/*     */       
/* 146 */       for (int i = 0; i < 2; i++) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 152 */         float f6 = f1 * 9.141593F * 2.0F;
/* 153 */         CosmeticDragonWings.wing.rotateAngleX = 0.125F - (float)Math.cos(f6) * 0.2F;
/* 154 */         CosmeticDragonWings.wing.rotateAngleY = 0.25F;
/* 155 */         CosmeticDragonWings.wing.rotateAngleZ = (float)(Math.sin(f6) + 1.225D) * 0.3F;
/*     */         
/* 157 */         CosmeticDragonWings.wingTip.rotateAngleZ = -((float)(Math.sin((f6 + 2.0F)) + 0.5D)) * 0.75F;
/* 158 */         CosmeticDragonWings.wing.isHidden = false;
/* 159 */         CosmeticDragonWings.wingTip.isHidden = false;
/*     */         
/* 161 */         if (!entityIn.isInvisible()) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 166 */           GlStateManager.pushMatrix();
/*     */           
/* 168 */           GlStateManager.disableLighting();
/*     */           
/* 170 */           CosmeticDragonWings.wing.render(scale);
/* 171 */           GlStateManager.blendFunc(1, 1);
/* 172 */           GlStateManager.enableLighting();
/* 173 */           GlStateManager.popMatrix();
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 178 */         CosmeticDragonWings.wing.isHidden = false;
/* 179 */         CosmeticDragonWings.wingTip.isHidden = false;
/*     */         
/* 181 */         if (i == 0) {
/* 182 */           GlStateManager.scale(-1.0F, 1.0F, 1.0F);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 188 */       GlStateManager.popMatrix();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {}
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\cosmetics\CosmeticDragonWings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */