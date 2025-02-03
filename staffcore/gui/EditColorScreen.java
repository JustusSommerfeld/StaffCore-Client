/*     */ package staffcore.gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import staffcore.gui.clickgui.comp.ModButton;
/*     */ import staffcore.utils.ImageButton;
/*     */ 
/*     */ public class EditColorScreen
/*     */   extends GuiScreen {
/*     */   private float oldMouseX;
/*     */   private float oldMouseY;
/*     */   protected int guiLeft;
/*     */   protected int guiTop;
/*  25 */   ArrayList<ModButton> modButtons = new ArrayList<>();
/*  26 */   protected ArrayList<ImageButton> imageButtons = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  30 */     super.initGui();
/*  31 */     ScaledResolution sr = new ScaledResolution(this.mc);
/*  32 */     int scale = (Minecraft.getMinecraft()).gameSettings.guiScale;
/*  33 */     this.imageButtons.clear();
/*  34 */     int guiauto = 0;
/*  35 */     int guism = 1;
/*  36 */     int guinm = 2;
/*  37 */     int guilg = 3;
/*  38 */     if (scale == guiauto) {
/*     */       
/*  40 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 25, 30, 30, "", 1));
/*     */       
/*  42 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 65, 30, 30, "", 2));
/*     */       
/*  44 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 105, 30, 30, "", 3));
/*     */       
/*  46 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 145, 30, 30, "", 4));
/*     */       
/*  48 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 185, 30, 30, "", 5));
/*     */       
/*  50 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FPSColor.png"), 105, 5, 70, 70, "", 13));
/*  51 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/KeystrokesColor.png"), 190, 5, 70, 70, "", 19));
/*     */     }
/*  53 */     else if (scale == guism) {
/*     */       
/*  55 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 155, 100, 100, "", 1));
/*     */       
/*  57 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 265, 100, 100, "", 2));
/*     */       
/*  59 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 375, 100, 100, "", 3));
/*     */       
/*  61 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 485, 100, 100, "", 4));
/*     */       
/*  63 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 595, 100, 100, "", 5));
/*     */       
/*  65 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FPSColor.png"), 300, 110, 190, 190, "", 13));
/*  66 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/KeystrokesColor.png"), 540, 110, 190, 190, "", 19));
/*     */     }
/*  68 */     else if (scale == guinm) {
/*     */       
/*  70 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 55, 60, 60, "", 1));
/*     */       
/*  72 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 130, 60, 60, "", 2));
/*     */       
/*  74 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 205, 60, 60, "", 3));
/*     */       
/*  76 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 280, 60, 60, "", 4));
/*     */       
/*  78 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 355, 60, 60, "", 5));
/*     */       
/*  80 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FPSColor.png"), 200, 30, 120, 120, "", 13));
/*  81 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/KeystrokesColor.png"), 350, 30, 120, 120, "", 19));
/*     */     }
/*  83 */     else if (scale == guilg) {
/*     */       
/*  85 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 40, 40, 40, "", 1));
/*     */       
/*  87 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 95, 40, 40, "", 2));
/*     */       
/*  89 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 150, 40, 40, "", 3));
/*     */       
/*  91 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 205, 40, 40, "", 4));
/*     */       
/*  93 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 260, 40, 40, "", 5));
/*     */       
/*  95 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FPSColor.png"), 150, 25, 80, 80, "", 13));
/*  96 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/KeystrokesColor.png"), 250, 25, 80, 80, "", 19));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 104 */     drawDefaultBackground();
/* 105 */     int scale = (Minecraft.getMinecraft()).gameSettings.guiScale;
/* 106 */     int guiauto = 0;
/* 107 */     int guism = 1;
/* 108 */     int guinm = 2;
/* 109 */     int guilg = 3;
/* 110 */     ScaledResolution sr = new ScaledResolution(this.mc);
/* 111 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */     
/* 113 */     this.oldMouseX = mouseX;
/* 114 */     this.oldMouseY = mouseY;
/*     */     
/* 116 */     if (scale == guilg) {
/*     */       
/* 118 */       int i = this.guiLeft;
/* 119 */       int j = this.guiTop;
/* 120 */       drawEntityOnScreen(i + 540, j + 220, 60, (i + 540) - this.oldMouseX, (j + 220 - 100) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 122 */     else if (scale == guiauto) {
/*     */       
/* 124 */       int i = this.guiLeft;
/* 125 */       int j = this.guiTop;
/* 126 */       drawEntityOnScreen(i + 390, j + 165, 45, (i + 390) - this.oldMouseX, (j + 165 - 70) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 128 */     else if (scale == guism) {
/*     */       
/* 130 */       int i = this.guiLeft;
/* 131 */       int j = this.guiTop;
/* 132 */       drawEntityOnScreen(i + 1470, j + 565, 135, (i + 1470) - this.oldMouseX, (j + 565 - 210) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 134 */     else if (scale == guinm) {
/*     */       
/* 136 */       int i = this.guiLeft;
/* 137 */       int j = this.guiTop;
/* 138 */       drawEntityOnScreen(i + 800, j + 330, 90, (i + 800) - this.oldMouseX, (j + 330 - 140) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     } 
/*     */     
/* 141 */     for (ImageButton b : this.imageButtons) {
/* 142 */       b.draw(mouseX, mouseY, Color.WHITE);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 148 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/* 149 */     for (ImageButton b : this.imageButtons) {
/* 150 */       b.onClick(mouseX, mouseY);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
/* 155 */     GlStateManager.enableColorMaterial();
/* 156 */     GlStateManager.pushMatrix();
/* 157 */     GlStateManager.translate(posX, posY, 50.0F);
/* 158 */     GlStateManager.scale(-scale, scale, scale);
/* 159 */     GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
/* 160 */     float f = ent.renderYawOffset;
/* 161 */     float f1 = ent.rotationYaw;
/* 162 */     float f2 = ent.rotationPitch;
/* 163 */     float f3 = ent.prevRotationYawHead;
/* 164 */     float f4 = ent.rotationYawHead;
/* 165 */     GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
/* 166 */     RenderHelper.enableStandardItemLighting();
/* 167 */     GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
/* 168 */     GlStateManager.rotate(-((float)Math.atan((mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
/* 169 */     ent.renderYawOffset = (float)Math.atan((mouseX / 40.0F)) * 20.0F;
/* 170 */     ent.rotationYaw = (float)Math.atan((mouseX / 40.0F)) * 40.0F;
/* 171 */     ent.rotationPitch = -((float)Math.atan((mouseY / 40.0F))) * 20.0F;
/* 172 */     ent.rotationYawHead = ent.rotationYaw;
/* 173 */     ent.prevRotationYawHead = ent.rotationYaw;
/* 174 */     GlStateManager.translate(0.0F, 0.0F, 0.0F);
/* 175 */     RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
/* 176 */     rendermanager.setPlayerViewY(180.0F);
/* 177 */     rendermanager.setRenderShadow(false);
/* 178 */     rendermanager.renderEntityWithPosYaw((Entity)ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/* 179 */     rendermanager.setRenderShadow(true);
/* 180 */     ent.renderYawOffset = f;
/* 181 */     ent.rotationYaw = f1;
/* 182 */     ent.rotationPitch = f2;
/* 183 */     ent.prevRotationYawHead = f3;
/* 184 */     ent.rotationYawHead = f4;
/* 185 */     GlStateManager.popMatrix();
/* 186 */     RenderHelper.disableStandardItemLighting();
/* 187 */     GlStateManager.disableRescaleNormal();
/* 188 */     GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
/* 189 */     GlStateManager.disableTexture2D();
/* 190 */     GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\gui\EditColorScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */