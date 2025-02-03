/*     */ package staffcore.gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import staffcore.UnicodeFontRenderer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SplashProgress
/*     */ {
/*     */   private static final int MAX = 7;
/*  19 */   private static int PROGRESS = 0;
/*  20 */   private static String CURRENT = "";
/*     */   
/*     */   private static ResourceLocation splash;
/*     */   private static UnicodeFontRenderer ufr;
/*     */   
/*     */   public static void update() {
/*  26 */     if (Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getLanguageManager() == null) {
/*     */       return;
/*     */     }
/*     */     
/*  30 */     drawSplash(Minecraft.getMinecraft().getTextureManager());
/*     */   }
/*     */   
/*     */   public static void setProgress(int givenProgress, String givenText) {
/*  34 */     PROGRESS = givenProgress;
/*  35 */     CURRENT = givenText;
/*  36 */     update();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawSplash(TextureManager tm) {
/*  42 */     ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
/*  43 */     int scaleFactor = scaledResolution.getScaleFactor();
/*     */     
/*  45 */     Framebuffer framebuffer = new Framebuffer(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor, true);
/*  46 */     framebuffer.bindFramebuffer(false);
/*     */     
/*  48 */     GlStateManager.matrixMode(5889);
/*  49 */     GlStateManager.loadIdentity();
/*  50 */     GlStateManager.ortho(0.0D, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), 0.0D, 1000.0D, 3000.0D);
/*  51 */     GlStateManager.matrixMode(5888);
/*  52 */     GlStateManager.loadIdentity();
/*  53 */     GlStateManager.translate(0.0F, 0.0F, -2000.0F);
/*  54 */     GlStateManager.disableLighting();
/*  55 */     GlStateManager.disableFog();
/*  56 */     GlStateManager.disableDepth();
/*  57 */     GlStateManager.enableTexture2D();
/*     */     
/*  59 */     if (splash == null) {
/*  60 */       splash = new ResourceLocation("client/splash.png");
/*     */     }
/*     */     
/*  63 */     tm.bindTexture(splash);
/*     */     
/*  65 */     GlStateManager.resetColor();
/*  66 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/*  68 */     Gui.drawScaledCustomSizeModalRect(0, 0, 0.0F, 0.0F, 1920, 1080, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), 1920.0F, 1080.0F);
/*  69 */     drawProgress();
/*  70 */     framebuffer.unbindFramebuffer();
/*  71 */     framebuffer.framebufferRender(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor);
/*     */     
/*  73 */     GlStateManager.enableAlpha();
/*  74 */     GlStateManager.alphaFunc(516, 0.1F);
/*     */     
/*  76 */     Minecraft.getMinecraft().updateDisplay();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void drawProgress() {
/*  82 */     if ((Minecraft.getMinecraft()).gameSettings == null || Minecraft.getMinecraft().getTextureManager() == null) {
/*     */       return;
/*     */     }
/*     */     
/*  86 */     if (ufr == null) {
/*  87 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*     */     }
/*     */     
/*  90 */     ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
/*     */     
/*  92 */     double nProgress = PROGRESS;
/*  93 */     double calc = nProgress / 7.0D * sr.getScaledWidth();
/*     */     
/*  95 */     Gui.drawRect(0, sr.getScaledHeight() - 35, sr.getScaledWidth(), sr.getScaledHeight(), (new Color(0, 0, 0, 50)).getRGB());
/*     */     
/*  97 */     GlStateManager.resetColor();
/*  98 */     resetTextureState();
/*     */     
/* 100 */     ufr.drawString(CURRENT, 20.0F, (sr.getScaledHeight() - 25), -1);
/*     */     
/* 102 */     String step = String.valueOf(PROGRESS) + "/" + '\007';
/* 103 */     ufr.drawString(step, (sr.getScaledWidth() - 20 - ufr.getStringWidth(step)), (sr.getScaledHeight() - 25), -505290241);
/*     */     
/* 105 */     GlStateManager.resetColor();
/* 106 */     resetTextureState();
/*     */     
/* 108 */     Gui.drawRect(0, sr.getScaledHeight() - 2, (int)calc, sr.getScaledHeight(), (new Color(149, 201, 144)).getRGB());
/*     */     
/* 110 */     Gui.drawRect(0, sr.getScaledHeight() - 2, sr.getScaledWidth(), sr.getScaledHeight(), (new Color(0, 0, 0, 10)).getRGB());
/*     */   }
/*     */ 
/*     */   
/*     */   private static void resetTextureState() {
/* 115 */     (GlStateManager.textureState[GlStateManager.activeTextureUnit]).textureName = -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\gui\SplashProgress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */