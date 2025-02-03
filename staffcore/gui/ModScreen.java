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
/*     */ public class ModScreen
/*     */   extends GuiScreen
/*     */ {
/*     */   private float oldMouseX;
/*     */   private float oldMouseY;
/*     */   protected int guiLeft;
/*     */   protected int guiTop;
/*  26 */   ArrayList<ModButton> modButtons = new ArrayList<>();
/*  27 */   protected ArrayList<ImageButton> imageButtons = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  31 */     super.initGui();
/*  32 */     ScaledResolution sr = new ScaledResolution(this.mc);
/*  33 */     int scale = (Minecraft.getMinecraft()).gameSettings.guiScale;
/*  34 */     this.imageButtons.clear();
/*  35 */     int guiauto = 0;
/*  36 */     int guism = 1;
/*  37 */     int guinm = 2;
/*  38 */     int guilg = 3;
/*     */     
/*  40 */     if (scale == guiauto) {
/*     */       
/*  42 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 25, 30, 30, "", 1));
/*     */       
/*  44 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 65, 30, 30, "", 2));
/*     */       
/*  46 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 105, 30, 30, "", 3));
/*     */       
/*  48 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 145, 30, 30, "", 4));
/*     */       
/*  50 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 185, 30, 30, "", 5));
/*     */ 
/*     */       
/*  53 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FPS.png"), 105, 25, 40, 40, "", 7));
/*     */       
/*  55 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/Keystrokes.png"), 180, 25, 40, 40, "", 9));
/*     */       
/*  57 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/Coords.png"), 255, 25, 40, 40, "", 11));
/*     */       
/*  59 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/TargetHUD.png"), 105, 85, 40, 40, "", 12));
/*     */       
/*  61 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/EditColor.png"), 365, 155, 50, 50, "", 17));
/*     */     }
/*  63 */     else if (scale == guism) {
/*     */       
/*  65 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 155, 100, 100, "", 13));
/*     */       
/*  67 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 265, 100, 100, "", 2));
/*     */       
/*  69 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 375, 100, 100, "", 3));
/*     */       
/*  71 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 485, 100, 100, "", 4));
/*     */       
/*  73 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 595, 100, 100, "", 5));
/*     */ 
/*     */       
/*  76 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FPS.png"), 300, 155, 110, 110, "", 7));
/*     */       
/*  78 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/Keystrokes.png"), 500, 155, 110, 110, "", 9));
/*     */       
/*  80 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/Coords.png"), 700, 155, 110, 110, "", 11));
/*     */       
/*  82 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/TargetHUD.png"), 300, 315, 110, 110, "", 12));
/*     */       
/*  84 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/EditColor.png"), 1391, 538, 160, 160, "", 17));
/*     */     }
/*  86 */     else if (scale == guinm) {
/*     */       
/*  88 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 55, 60, 60, "", 1));
/*     */       
/*  90 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 130, 60, 60, "", 2));
/*     */       
/*  92 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 205, 60, 60, "", 3));
/*     */       
/*  94 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 280, 60, 60, "", 4));
/*     */       
/*  96 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 355, 60, 60, "", 5));
/*     */ 
/*     */       
/*  99 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FPS.png"), 200, 55, 60, 60, "", 7));
/*     */       
/* 101 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/Keystrokes.png"), 300, 55, 60, 60, "", 9));
/*     */       
/* 103 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/Coords.png"), 400, 55, 60, 60, "", 11));
/*     */       
/* 105 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/TargetHUD.png"), 200, 140, 60, 60, "", 12));
/*     */       
/* 107 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/EditColor.png"), 746, 303, 110, 110, "", 17));
/*     */     }
/* 109 */     else if (scale == guilg) {
/*     */       
/* 111 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 40, 40, 40, "", 1));
/*     */       
/* 113 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 95, 40, 40, "", 2));
/*     */       
/* 115 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 150, 40, 40, "", 3));
/*     */       
/* 117 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 205, 40, 40, "", 4));
/*     */       
/* 119 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 260, 40, 40, "", 5));
/*     */ 
/*     */       
/* 122 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/FPS.png"), 150, 40, 50, 50, "", 7));
/*     */       
/* 124 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/Keystrokes.png"), 235, 40, 50, 50, "", 9));
/*     */       
/* 126 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/Coords.png"), 320, 40, 50, 50, "", 11));
/*     */       
/* 128 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/TargetHUD.png"), 150, 120, 50, 50, "", 12));
/*     */       
/* 130 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/EditColor.png"), 506, 205, 70, 70, "", 17));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 139 */     drawDefaultBackground();
/* 140 */     int scale = (Minecraft.getMinecraft()).gameSettings.guiScale;
/* 141 */     int guiauto = 0;
/* 142 */     int guism = 1;
/* 143 */     int guinm = 2;
/* 144 */     int guilg = 3;
/* 145 */     ScaledResolution sr = new ScaledResolution(this.mc);
/* 146 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */     
/* 148 */     this.oldMouseX = mouseX;
/* 149 */     this.oldMouseY = mouseY;
/*     */     
/* 151 */     if (scale == guilg) {
/*     */       
/* 153 */       int i = this.guiLeft;
/* 154 */       int j = this.guiTop;
/* 155 */       drawEntityOnScreen(i + 540, j + 220, 60, (i + 540) - this.oldMouseX, (j + 220 - 100) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 157 */     else if (scale == guiauto) {
/*     */       
/* 159 */       int i = this.guiLeft;
/* 160 */       int j = this.guiTop;
/* 161 */       drawEntityOnScreen(i + 390, j + 165, 45, (i + 390) - this.oldMouseX, (j + 165 - 70) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 163 */     else if (scale == guism) {
/*     */       
/* 165 */       int i = this.guiLeft;
/* 166 */       int j = this.guiTop;
/* 167 */       drawEntityOnScreen(i + 1470, j + 565, 135, (i + 1470) - this.oldMouseX, (j + 565 - 210) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 169 */     else if (scale == guinm) {
/*     */       
/* 171 */       int i = this.guiLeft;
/* 172 */       int j = this.guiTop;
/* 173 */       drawEntityOnScreen(i + 800, j + 330, 90, (i + 800) - this.oldMouseX, (j + 330 - 140) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     } 
/*     */     
/* 176 */     for (ImageButton b : this.imageButtons) {
/* 177 */       b.draw(mouseX, mouseY, Color.WHITE);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 183 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/* 184 */     for (ImageButton b : this.imageButtons) {
/* 185 */       b.onClick(mouseX, mouseY);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
/* 190 */     GlStateManager.enableColorMaterial();
/* 191 */     GlStateManager.pushMatrix();
/* 192 */     GlStateManager.translate(posX, posY, 50.0F);
/* 193 */     GlStateManager.scale(-scale, scale, scale);
/* 194 */     GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
/* 195 */     float f = ent.renderYawOffset;
/* 196 */     float f1 = ent.rotationYaw;
/* 197 */     float f2 = ent.rotationPitch;
/* 198 */     float f3 = ent.prevRotationYawHead;
/* 199 */     float f4 = ent.rotationYawHead;
/* 200 */     GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
/* 201 */     RenderHelper.enableStandardItemLighting();
/* 202 */     GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
/* 203 */     GlStateManager.rotate(-((float)Math.atan((mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
/* 204 */     ent.renderYawOffset = (float)Math.atan((mouseX / 40.0F)) * 20.0F;
/* 205 */     ent.rotationYaw = (float)Math.atan((mouseX / 40.0F)) * 40.0F;
/* 206 */     ent.rotationPitch = -((float)Math.atan((mouseY / 40.0F))) * 20.0F;
/* 207 */     ent.rotationYawHead = ent.rotationYaw;
/* 208 */     ent.prevRotationYawHead = ent.rotationYaw;
/* 209 */     GlStateManager.translate(0.0F, 0.0F, 0.0F);
/* 210 */     RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
/* 211 */     rendermanager.setPlayerViewY(180.0F);
/* 212 */     rendermanager.setRenderShadow(false);
/* 213 */     rendermanager.renderEntityWithPosYaw((Entity)ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/* 214 */     rendermanager.setRenderShadow(true);
/* 215 */     ent.renderYawOffset = f;
/* 216 */     ent.rotationYaw = f1;
/* 217 */     ent.rotationPitch = f2;
/* 218 */     ent.prevRotationYawHead = f3;
/* 219 */     ent.rotationYawHead = f4;
/* 220 */     GlStateManager.popMatrix();
/* 221 */     RenderHelper.disableStandardItemLighting();
/* 222 */     GlStateManager.disableRescaleNormal();
/* 223 */     GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
/* 224 */     GlStateManager.disableTexture2D();
/* 225 */     GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\gui\ModScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */