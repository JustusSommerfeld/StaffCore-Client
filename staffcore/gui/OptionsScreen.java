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
/*     */ public class OptionsScreen
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
/*     */     
/*  39 */     if (scale == guiauto) {
/*     */       
/*  41 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 25, 30, 30, "", 1));
/*     */       
/*  43 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 65, 30, 30, "", 2));
/*     */       
/*  45 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 105, 30, 30, "", 3));
/*     */       
/*  47 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 145, 30, 30, "", 4));
/*     */       
/*  49 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 185, 30, 30, "", 5));
/*     */ 
/*     */       
/*  52 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FullbrightMod.png"), 105, 25, 40, 40, "", 6));
/*  53 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/SwitchToLeftHand.png"), 180, 25, 40, 40, "", 8));
/*  54 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/discord.png"), 255, 25, 40, 40, "", 14));
/*     */     }
/*  56 */     else if (scale == guism) {
/*     */       
/*  58 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 155, 100, 100, "", 1));
/*     */       
/*  60 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 265, 100, 100, "", 2));
/*     */       
/*  62 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 375, 100, 100, "", 3));
/*     */       
/*  64 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 485, 100, 100, "", 4));
/*     */       
/*  66 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 595, 100, 100, "", 5));
/*     */ 
/*     */       
/*  69 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FullbrightMod.png"), 300, 155, 110, 110, "", 6));
/*  70 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/SwitchToLeftHand.png"), 500, 155, 110, 110, "", 8));
/*  71 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/discord.png"), 700, 155, 110, 110, "", 14));
/*  72 */     } else if (scale == guinm) {
/*     */       
/*  74 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 55, 60, 60, "", 1));
/*     */       
/*  76 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 130, 60, 60, "", 2));
/*     */       
/*  78 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 205, 60, 60, "", 3));
/*     */       
/*  80 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 280, 60, 60, "", 4));
/*     */       
/*  82 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 355, 60, 60, "", 5));
/*     */ 
/*     */       
/*  85 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FullbrightMod.png"), 200, 55, 60, 60, "", 6));
/*  86 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/SwitchToLeftHand.png"), 300, 55, 60, 60, "", 8));
/*  87 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/discord.png"), 400, 55, 60, 60, "", 14));
/*     */     }
/*  89 */     else if (scale == guilg) {
/*     */       
/*  91 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 40, 40, 40, "", 1));
/*     */       
/*  93 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 95, 40, 40, "", 2));
/*     */       
/*  95 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 150, 40, 40, "", 3));
/*     */       
/*  97 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 205, 40, 40, "", 4));
/*     */       
/*  99 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 260, 40, 40, "", 5));
/*     */ 
/*     */       
/* 102 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FullbrightMod.png"), 150, 40, 50, 50, "", 6));
/* 103 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/SwitchToLeftHand.png"), 235, 40, 50, 50, "", 8));
/* 104 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/discord.png"), 320, 40, 50, 50, "", 14));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 113 */     drawDefaultBackground();
/* 114 */     int scale = (Minecraft.getMinecraft()).gameSettings.guiScale;
/* 115 */     int guiauto = 0;
/* 116 */     int guism = 1;
/* 117 */     int guinm = 2;
/* 118 */     int guilg = 3;
/* 119 */     ScaledResolution sr = new ScaledResolution(this.mc);
/* 120 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */     
/* 122 */     this.oldMouseX = mouseX;
/* 123 */     this.oldMouseY = mouseY;
/*     */     
/* 125 */     if (scale == guilg) {
/*     */       
/* 127 */       int i = this.guiLeft;
/* 128 */       int j = this.guiTop;
/* 129 */       drawEntityOnScreen(i + 540, j + 220, 60, (i + 540) - this.oldMouseX, (j + 220 - 100) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 131 */     else if (scale == guiauto) {
/*     */       
/* 133 */       int i = this.guiLeft;
/* 134 */       int j = this.guiTop;
/* 135 */       drawEntityOnScreen(i + 390, j + 165, 45, (i + 390) - this.oldMouseX, (j + 165 - 70) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 137 */     else if (scale == guism) {
/*     */       
/* 139 */       int i = this.guiLeft;
/* 140 */       int j = this.guiTop;
/* 141 */       drawEntityOnScreen(i + 1470, j + 565, 135, (i + 1470) - this.oldMouseX, (j + 565 - 210) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 143 */     else if (scale == guinm) {
/*     */       
/* 145 */       int i = this.guiLeft;
/* 146 */       int j = this.guiTop;
/* 147 */       drawEntityOnScreen(i + 800, j + 330, 90, (i + 800) - this.oldMouseX, (j + 330 - 140) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     } 
/*     */     
/* 150 */     for (ImageButton b : this.imageButtons) {
/* 151 */       b.draw(mouseX, mouseY, Color.WHITE);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 157 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/* 158 */     for (ImageButton b : this.imageButtons) {
/* 159 */       b.onClick(mouseX, mouseY);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
/* 164 */     GlStateManager.enableColorMaterial();
/* 165 */     GlStateManager.pushMatrix();
/* 166 */     GlStateManager.translate(posX, posY, 50.0F);
/* 167 */     GlStateManager.scale(-scale, scale, scale);
/* 168 */     GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
/* 169 */     float f = ent.renderYawOffset;
/* 170 */     float f1 = ent.rotationYaw;
/* 171 */     float f2 = ent.rotationPitch;
/* 172 */     float f3 = ent.prevRotationYawHead;
/* 173 */     float f4 = ent.rotationYawHead;
/* 174 */     GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
/* 175 */     RenderHelper.enableStandardItemLighting();
/* 176 */     GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
/* 177 */     GlStateManager.rotate(-((float)Math.atan((mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
/* 178 */     ent.renderYawOffset = (float)Math.atan((mouseX / 40.0F)) * 20.0F;
/* 179 */     ent.rotationYaw = (float)Math.atan((mouseX / 40.0F)) * 40.0F;
/* 180 */     ent.rotationPitch = -((float)Math.atan((mouseY / 40.0F))) * 20.0F;
/* 181 */     ent.rotationYawHead = ent.rotationYaw;
/* 182 */     ent.prevRotationYawHead = ent.rotationYaw;
/* 183 */     GlStateManager.translate(0.0F, 0.0F, 0.0F);
/* 184 */     RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
/* 185 */     rendermanager.setPlayerViewY(180.0F);
/* 186 */     rendermanager.setRenderShadow(false);
/* 187 */     rendermanager.renderEntityWithPosYaw((Entity)ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/* 188 */     rendermanager.setRenderShadow(true);
/* 189 */     ent.renderYawOffset = f;
/* 190 */     ent.rotationYaw = f1;
/* 191 */     ent.rotationPitch = f2;
/* 192 */     ent.prevRotationYawHead = f3;
/* 193 */     ent.rotationYawHead = f4;
/* 194 */     GlStateManager.popMatrix();
/* 195 */     RenderHelper.disableStandardItemLighting();
/* 196 */     GlStateManager.disableRescaleNormal();
/* 197 */     GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
/* 198 */     GlStateManager.disableTexture2D();
/* 199 */     GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\gui\OptionsScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */