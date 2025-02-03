/*     */ package staffcore.gui.clickgui;
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
/*     */ 
/*     */ 
/*     */ public class ClickGUI
/*     */   extends GuiScreen
/*     */ {
/*     */   private float oldMouseX;
/*     */   private float oldMouseY;
/*     */   protected int guiLeft;
/*     */   protected int guiTop;
/*  28 */   ArrayList<ModButton> modButtons = new ArrayList<>();
/*  29 */   protected ArrayList<ImageButton> imageButtons = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  33 */     super.initGui();
/*  34 */     ScaledResolution sr = new ScaledResolution(this.mc);
/*  35 */     int scale = (Minecraft.getMinecraft()).gameSettings.guiScale;
/*  36 */     this.imageButtons.clear();
/*  37 */     int guiauto = 0;
/*  38 */     int guism = 1;
/*  39 */     int guinm = 2;
/*  40 */     int guilg = 3;
/*  41 */     if (scale == guiauto) {
/*     */       
/*  43 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 25, 30, 30, "", 1));
/*     */       
/*  45 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 65, 30, 30, "", 2));
/*     */       
/*  47 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 105, 30, 30, "", 3));
/*     */       
/*  49 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 145, 30, 30, "", 4));
/*     */       
/*  51 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 185, 30, 30, "", 5));
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
/*     */     }
/*  65 */     else if (scale == guinm) {
/*     */       
/*  67 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 55, 60, 60, "", 1));
/*     */       
/*  69 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 130, 60, 60, "", 2));
/*     */       
/*  71 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 205, 60, 60, "", 3));
/*     */       
/*  73 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 280, 60, 60, "", 4));
/*     */       
/*  75 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 355, 60, 60, "", 5));
/*     */     }
/*  77 */     else if (scale == guilg) {
/*     */       
/*  79 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 40, 40, 40, "", 1));
/*     */       
/*  81 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 95, 40, 40, "", 2));
/*     */       
/*  83 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 150, 40, 40, "", 3));
/*     */       
/*  85 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 205, 40, 40, "", 4));
/*     */       
/*  87 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 260, 40, 40, "", 5));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  95 */     drawDefaultBackground();
/*  96 */     int scale = (Minecraft.getMinecraft()).gameSettings.guiScale;
/*  97 */     int guiauto = 0;
/*  98 */     int guism = 1;
/*  99 */     int guinm = 2;
/* 100 */     int guilg = 3;
/* 101 */     ScaledResolution sr = new ScaledResolution(this.mc);
/* 102 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */     
/* 104 */     this.oldMouseX = mouseX;
/* 105 */     this.oldMouseY = mouseY;
/*     */     
/* 107 */     if (scale == guilg) {
/*     */       
/* 109 */       int i = this.guiLeft;
/* 110 */       int j = this.guiTop;
/* 111 */       drawEntityOnScreen(i + 540, j + 220, 60, (i + 540) - this.oldMouseX, (j + 220 - 100) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 113 */     else if (scale == guiauto) {
/*     */       
/* 115 */       int i = this.guiLeft;
/* 116 */       int j = this.guiTop;
/* 117 */       drawEntityOnScreen(i + 390, j + 165, 45, (i + 390) - this.oldMouseX, (j + 165 - 70) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 119 */     else if (scale == guism) {
/*     */       
/* 121 */       int i = this.guiLeft;
/* 122 */       int j = this.guiTop;
/* 123 */       drawEntityOnScreen(i + 1470, j + 565, 135, (i + 1470) - this.oldMouseX, (j + 565 - 210) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 125 */     else if (scale == guinm) {
/*     */       
/* 127 */       int i = this.guiLeft;
/* 128 */       int j = this.guiTop;
/* 129 */       drawEntityOnScreen(i + 800, j + 330, 90, (i + 800) - this.oldMouseX, (j + 330 - 140) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     } 
/*     */     
/* 132 */     for (ImageButton b : this.imageButtons) {
/* 133 */       b.draw(mouseX, mouseY, Color.WHITE);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 139 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/* 140 */     for (ImageButton b : this.imageButtons) {
/* 141 */       b.onClick(mouseX, mouseY);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
/* 146 */     GlStateManager.enableColorMaterial();
/* 147 */     GlStateManager.pushMatrix();
/* 148 */     GlStateManager.translate(posX, posY, 50.0F);
/* 149 */     GlStateManager.scale(-scale, scale, scale);
/* 150 */     GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
/* 151 */     float f = ent.renderYawOffset;
/* 152 */     float f1 = ent.rotationYaw;
/* 153 */     float f2 = ent.rotationPitch;
/* 154 */     float f3 = ent.prevRotationYawHead;
/* 155 */     float f4 = ent.rotationYawHead;
/* 156 */     GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
/* 157 */     RenderHelper.enableStandardItemLighting();
/* 158 */     GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
/* 159 */     GlStateManager.rotate(-((float)Math.atan((mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
/* 160 */     ent.renderYawOffset = (float)Math.atan((mouseX / 40.0F)) * 20.0F;
/* 161 */     ent.rotationYaw = (float)Math.atan((mouseX / 40.0F)) * 40.0F;
/* 162 */     ent.rotationPitch = -((float)Math.atan((mouseY / 40.0F))) * 20.0F;
/* 163 */     ent.rotationYawHead = ent.rotationYaw;
/* 164 */     ent.prevRotationYawHead = ent.rotationYaw;
/* 165 */     GlStateManager.translate(0.0F, 0.0F, 0.0F);
/* 166 */     RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
/* 167 */     rendermanager.setPlayerViewY(180.0F);
/* 168 */     rendermanager.setRenderShadow(false);
/* 169 */     rendermanager.renderEntityWithPosYaw((Entity)ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/* 170 */     rendermanager.setRenderShadow(true);
/* 171 */     ent.renderYawOffset = f;
/* 172 */     ent.rotationYaw = f1;
/* 173 */     ent.rotationPitch = f2;
/* 174 */     ent.prevRotationYawHead = f3;
/* 175 */     ent.rotationYawHead = f4;
/* 176 */     GlStateManager.popMatrix();
/* 177 */     RenderHelper.disableStandardItemLighting();
/* 178 */     GlStateManager.disableRescaleNormal();
/* 179 */     GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
/* 180 */     GlStateManager.disableTexture2D();
/* 181 */     GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\gui\clickgui\ClickGUI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */