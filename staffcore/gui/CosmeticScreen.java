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
/*     */ import staffcore.cosmetics.Capes;
/*     */ import staffcore.gui.clickgui.comp.ModButton;
/*     */ import staffcore.utils.CapesButton;
/*     */ import staffcore.utils.ImageButton;
/*     */ 
/*     */ public class CosmeticScreen
/*     */   extends GuiScreen
/*     */ {
/*     */   private float oldMouseX;
/*     */   private float oldMouseY;
/*     */   protected int guiLeft;
/*     */   protected int guiTop;
/*  28 */   ArrayList<ModButton> modButtons = new ArrayList<>();
/*  29 */   protected ArrayList<ImageButton> imageButtons = new ArrayList<>();
/*  30 */   protected ArrayList<CapesButton> capesButtons = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  34 */     super.initGui();
/*  35 */     ScaledResolution sr = new ScaledResolution(this.mc);
/*  36 */     int scale = (Minecraft.getMinecraft()).gameSettings.guiScale;
/*  37 */     this.imageButtons.clear();
/*  38 */     int guiauto = 0;
/*  39 */     int guism = 1;
/*  40 */     int guinm = 2;
/*  41 */     int guilg = 3;
/*     */     
/*  43 */     if (scale == guiauto) {
/*     */       
/*  45 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 25, 30, 30, "", 1));
/*     */       
/*  47 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 65, 30, 30, "", 2));
/*     */       
/*  49 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 105, 30, 30, "", 3));
/*     */       
/*  51 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 145, 30, 30, "", 4));
/*     */       
/*  53 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 185, 30, 30, "", 5));
/*     */       
/*  55 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/RemoveCape.png"), 375, 175, 30, 30, "", 10));
/*  56 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ToggleWings.png"), 331, 175, 30, 30, "", 15));
/*  57 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ToggleEasterEgg.png"), 419, 175, 30, 30, "", 16));
/*     */     }
/*  59 */     else if (scale == guism) {
/*     */       
/*  61 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 155, 100, 100, "", 1));
/*     */       
/*  63 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 265, 100, 100, "", 2));
/*     */       
/*  65 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 375, 100, 100, "", 3));
/*     */       
/*  67 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 485, 100, 100, "", 4));
/*     */       
/*  69 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 595, 100, 100, "", 5));
/*     */       
/*  71 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/RemoveCape.png"), 1420, 600, 100, 100, "", 10));
/*  72 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ToggleWings.png"), 1275, 600, 100, 100, "", 15));
/*  73 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ToggleEasterEgg.png"), 1565, 600, 100, 100, "", 16));
/*     */     }
/*  75 */     else if (scale == guinm) {
/*     */       
/*  77 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 55, 60, 60, "", 1));
/*     */       
/*  79 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 130, 60, 60, "", 2));
/*     */       
/*  81 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 205, 60, 60, "", 3));
/*     */       
/*  83 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 280, 60, 60, "", 4));
/*     */       
/*  85 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 355, 60, 60, "", 5));
/*     */       
/*  87 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/RemoveCape.png"), 770, 340, 60, 60, "", 10));
/*  88 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ToggleWings.png"), 690, 340, 60, 60, "", 15));
/*  89 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ToggleEasterEgg.png"), 850, 340, 60, 60, "", 16));
/*     */     }
/*  91 */     else if (scale == guilg) {
/*     */       
/*  93 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/OptionsIcon.png"), 28, 40, 40, 40, "", 1));
/*     */       
/*  95 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/CosmeticIcon.png"), 28, 95, 40, 40, "", 2));
/*     */       
/*  97 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ModIcon.png"), 28, 150, 40, 40, "", 3));
/*     */       
/*  99 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ServerListIcon.png"), 28, 205, 40, 40, "", 4));
/*     */       
/* 101 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/LeaveIcon.png"), 28, 260, 40, 40, "", 5));
/*     */ 
/*     */       
/* 104 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/RemoveCape.png"), 520, 230, 40, 40, "", 10));
/* 105 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ToggleWings.png"), 465, 230, 40, 40, "", 15));
/* 106 */       this.imageButtons.add(new ImageButton(new ResourceLocation("client/ToggleEasterEgg.png"), 575, 230, 40, 40, "", 16));
/*     */     } 
/*     */     
/* 109 */     int row = 1;
/* 110 */     int column = 0; byte b; int i; Capes[] arrayOfCapes;
/* 111 */     for (i = (arrayOfCapes = Capes.values()).length, b = 0; b < i; ) { Capes cape = arrayOfCapes[b];
/* 112 */       column++;
/*     */       
/* 114 */       if (scale == guilg) {
/* 115 */         if (column == 1) {
/* 116 */           this.capesButtons.add(new CapesButton(cape.getButtonLocation(), 150, 60 * row, 50, 50, "", cape));
/*     */         }
/* 118 */         if (column == 2) {
/* 119 */           this.capesButtons.add(new CapesButton(cape.getButtonLocation(), 235, 60 * row, 50, 50, "", cape));
/*     */         }
/* 121 */         if (column == 3) {
/* 122 */           this.capesButtons.add(new CapesButton(cape.getButtonLocation(), 320, 60 * row, 50, 50, "", cape));
/*     */         }
/* 124 */       } else if (scale == guiauto) {
/* 125 */         this.capesButtons.add(new CapesButton(cape.getButtonLocation(), 40 + 70 * column, 40 * row, 30, 30, "", cape));
/* 126 */       } else if (scale == guinm) {
/* 127 */         this.capesButtons.add(new CapesButton(cape.getButtonLocation(), 100 + 120 * column, 100 * row, 55, 55, "", cape));
/* 128 */       } else if (scale == guism) {
/* 129 */         this.capesButtons.add(new CapesButton(cape.getButtonLocation(), 150 + 220 * column, 180 * row, 100, 100, "", cape));
/*     */       } 
/*     */       
/* 132 */       if (column > 2) {
/* 133 */         column = 0;
/* 134 */         row++;
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 143 */     drawDefaultBackground();
/* 144 */     int scale = (Minecraft.getMinecraft()).gameSettings.guiScale;
/* 145 */     int guiauto = 0;
/* 146 */     int guism = 1;
/* 147 */     int guinm = 2;
/* 148 */     int guilg = 3;
/* 149 */     ScaledResolution sr = new ScaledResolution(this.mc);
/* 150 */     super.drawScreen(mouseX, mouseY, partialTicks);
/* 151 */     this.oldMouseX = mouseX;
/* 152 */     this.oldMouseY = mouseY;
/*     */     
/* 154 */     if (scale == guilg) {
/*     */       
/* 156 */       int i = this.guiLeft;
/* 157 */       int j = this.guiTop;
/* 158 */       drawEntityOnScreen(i + 540, j + 220, 60, (i + 540) - this.oldMouseX, (j + 220 - 100) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 160 */     else if (scale == guiauto) {
/*     */       
/* 162 */       int i = this.guiLeft;
/* 163 */       int j = this.guiTop;
/* 164 */       drawEntityOnScreen(i + 390, j + 165, 45, (i + 390) - this.oldMouseX, (j + 165 - 70) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 166 */     else if (scale == guism) {
/*     */       
/* 168 */       int i = this.guiLeft;
/* 169 */       int j = this.guiTop;
/* 170 */       drawEntityOnScreen(i + 1470, j + 565, 135, (i + 1470) - this.oldMouseX, (j + 565 - 210) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     }
/* 172 */     else if (scale == guinm) {
/*     */       
/* 174 */       int i = this.guiLeft;
/* 175 */       int j = this.guiTop;
/* 176 */       drawEntityOnScreen(i + 800, j + 330, 90, (i + 800) - this.oldMouseX, (j + 330 - 140) - this.oldMouseY, (EntityLivingBase)this.mc.thePlayer);
/*     */     } 
/* 178 */     for (ImageButton b : this.imageButtons) {
/* 179 */       b.draw(mouseX, mouseY, Color.WHITE);
/*     */     }
/* 181 */     for (CapesButton c : this.capesButtons) {
/* 182 */       c.draw(mouseX, mouseY, Color.WHITE);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 188 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/* 189 */     for (ImageButton b : this.imageButtons) {
/* 190 */       b.onClick(mouseX, mouseY);
/*     */     }
/* 192 */     for (CapesButton c : this.capesButtons) {
/* 193 */       c.onClick(mouseX, mouseY);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
/* 198 */     GlStateManager.enableColorMaterial();
/* 199 */     GlStateManager.pushMatrix();
/* 200 */     GlStateManager.translate(posX, posY, 50.0F);
/* 201 */     GlStateManager.scale(-scale, scale, scale);
/* 202 */     GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
/* 203 */     float f = ent.renderYawOffset;
/* 204 */     float f1 = ent.rotationYaw;
/* 205 */     float f2 = ent.rotationPitch;
/* 206 */     float f3 = ent.prevRotationYawHead;
/* 207 */     float f4 = ent.rotationYawHead;
/* 208 */     GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
/* 209 */     RenderHelper.enableStandardItemLighting();
/* 210 */     GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
/* 211 */     GlStateManager.rotate(-((float)Math.atan((mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
/* 212 */     ent.renderYawOffset = (float)Math.atan((mouseX / 40.0F)) * 20.0F;
/* 213 */     ent.rotationYaw = (float)Math.atan((mouseX / 40.0F)) * 40.0F;
/* 214 */     ent.rotationPitch = -((float)Math.atan((mouseY / 40.0F))) * 20.0F;
/* 215 */     ent.rotationYawHead = ent.rotationYaw;
/* 216 */     ent.prevRotationYawHead = ent.rotationYaw;
/* 217 */     GlStateManager.translate(0.0F, 0.0F, 0.0F);
/* 218 */     RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
/* 219 */     rendermanager.setPlayerViewY(180.0F);
/* 220 */     rendermanager.setRenderShadow(false);
/* 221 */     rendermanager.renderEntityWithPosYaw((Entity)ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/* 222 */     rendermanager.setRenderShadow(true);
/* 223 */     ent.renderYawOffset = f;
/* 224 */     ent.rotationYaw = f1;
/* 225 */     ent.rotationPitch = f2;
/* 226 */     ent.prevRotationYawHead = f3;
/* 227 */     ent.rotationYawHead = f4;
/* 228 */     GlStateManager.popMatrix();
/* 229 */     RenderHelper.disableStandardItemLighting();
/* 230 */     GlStateManager.disableRescaleNormal();
/* 231 */     GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
/* 232 */     GlStateManager.disableTexture2D();
/* 233 */     GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\gui\CosmeticScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */