/*     */ package staffcore.notify;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Notification
/*     */ {
/*     */   private NotificationType type;
/*     */   private String title;
/*     */   private String messsage;
/*     */   private long start;
/*     */   private long fadedIn;
/*     */   private long fadeOut;
/*     */   private long end;
/*     */   
/*     */   public Notification(NotificationType type, String title, String messsage, int length) {
/*  28 */     this.type = type;
/*  29 */     this.title = title;
/*  30 */     this.messsage = messsage;
/*     */     
/*  32 */     this.fadedIn = (200 * length);
/*  33 */     this.fadeOut = this.fadedIn + (500 * length);
/*  34 */     this.end = this.fadeOut + this.fadedIn;
/*     */   }
/*     */   
/*     */   public void show() {
/*  38 */     this.start = System.currentTimeMillis();
/*     */   }
/*     */   
/*     */   public boolean isShown() {
/*  42 */     return (getTime() <= this.end);
/*     */   }
/*     */   
/*     */   private long getTime() {
/*  46 */     return System.currentTimeMillis() - this.start;
/*     */   }
/*     */   public void render() {
/*     */     Color color1;
/*  50 */     double offset = 0.0D;
/*     */ 
/*     */     
/*  53 */     int width = 140;
/*  54 */     int height = 30;
/*  55 */     long time = getTime();
/*     */     
/*  57 */     if (time < this.fadedIn) {
/*  58 */       offset = Math.tanh(time / this.fadedIn * 3.0D) * width;
/*  59 */     } else if (time > this.fadeOut) {
/*  60 */       offset = Math.tanh(3.0D - (time - this.fadeOut) / (this.end - this.fadeOut) * 3.0D) * width;
/*     */     } else {
/*  62 */       offset = width;
/*     */     } 
/*     */     
/*  65 */     Color color = new Color(255, 255, 255, 220);
/*     */ 
/*     */     
/*  68 */     if (this.type == NotificationType.INFO) {
/*     */       
/*  70 */       color1 = new Color(255, 109, 109);
/*  71 */     } else if (this.type == NotificationType.WARNING) {
/*  72 */       color1 = new Color(204, 193, 0);
/*     */     } else {
/*  74 */       color1 = new Color(204, 0, 18);
/*  75 */       int i = Math.max(0, Math.min(255, (int)(Math.sin(time / 100.0D) * 255.0D / 2.0D + 127.5D)));
/*  76 */       color = new Color(i, 0, 0, 220);
/*     */     } 
/*     */     
/*  79 */     FontRenderer fontRenderer = (Minecraft.getMinecraft()).fontRendererObj;
/*     */ 
/*     */ 
/*     */     
/*  83 */     drawRect(GuiScreen.width - offset, (GuiScreen.height - 5 - height), GuiScreen.width, (GuiScreen.height - 5), color.getRGB());
/*  84 */     drawRect(GuiScreen.width - offset, (GuiScreen.height - 5 - height), GuiScreen.width - offset + 4.0D, (GuiScreen.height - 5), color1.getRGB());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     fontRenderer.drawString(this.title, (int)(GuiScreen.width - offset + 8.0D), GuiScreen.height - 2 - height, -1);
/*  90 */     fontRenderer.drawString(this.messsage, (int)(GuiScreen.width - offset + 8.0D), GuiScreen.height - 15, -1);
/*     */   }
/*     */   
/*     */   public static void drawRect(double left, double top, double right, double bottom, int color) {
/*  94 */     if (left < right) {
/*  95 */       double i = left;
/*  96 */       left = right;
/*  97 */       right = i;
/*     */     } 
/*     */     
/* 100 */     if (top < bottom) {
/* 101 */       double j = top;
/* 102 */       top = bottom;
/* 103 */       bottom = j;
/*     */     } 
/*     */     
/* 106 */     float f3 = (color >> 24 & 0xFF) / 255.0F;
/* 107 */     float f = (color >> 16 & 0xFF) / 255.0F;
/* 108 */     float f1 = (color >> 8 & 0xFF) / 255.0F;
/* 109 */     float f2 = (color & 0xFF) / 255.0F;
/* 110 */     Tessellator tessellator = Tessellator.getInstance();
/* 111 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 112 */     GlStateManager.enableBlend();
/* 113 */     GlStateManager.disableTexture2D();
/* 114 */     GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/* 115 */     GlStateManager.color(f, f1, f2, f3);
/* 116 */     worldrenderer.begin(7, DefaultVertexFormats.POSITION);
/* 117 */     worldrenderer.pos(left, bottom, 0.0D).endVertex();
/* 118 */     worldrenderer.pos(right, bottom, 0.0D).endVertex();
/* 119 */     worldrenderer.pos(right, top, 0.0D).endVertex();
/* 120 */     worldrenderer.pos(left, top, 0.0D).endVertex();
/* 121 */     tessellator.draw();
/* 122 */     GlStateManager.enableTexture2D();
/* 123 */     GlStateManager.disableBlend();
/*     */   }
/*     */   
/*     */   public static void drawRect(int mode, double left, double top, double right, double bottom, int color) {
/* 127 */     if (left < right) {
/* 128 */       double i = left;
/* 129 */       left = right;
/* 130 */       right = i;
/*     */     } 
/*     */     
/* 133 */     if (top < bottom) {
/* 134 */       double j = top;
/* 135 */       top = bottom;
/* 136 */       bottom = j;
/*     */     } 
/*     */     
/* 139 */     float f3 = (color >> 24 & 0xFF) / 255.0F;
/* 140 */     float f = (color >> 16 & 0xFF) / 255.0F;
/* 141 */     float f1 = (color >> 8 & 0xFF) / 255.0F;
/* 142 */     float f2 = (color & 0xFF) / 255.0F;
/* 143 */     Tessellator tessellator = Tessellator.getInstance();
/* 144 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 145 */     GlStateManager.enableBlend();
/* 146 */     GlStateManager.disableTexture2D();
/* 147 */     GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/* 148 */     GlStateManager.color(f, f1, f2, f3);
/* 149 */     worldrenderer.begin(mode, DefaultVertexFormats.POSITION);
/* 150 */     worldrenderer.pos(left, bottom, 0.0D).endVertex();
/* 151 */     worldrenderer.pos(right, bottom, 0.0D).endVertex();
/* 152 */     worldrenderer.pos(right, top, 0.0D).endVertex();
/* 153 */     worldrenderer.pos(left, top, 0.0D).endVertex();
/* 154 */     tessellator.draw();
/* 155 */     GlStateManager.enableTexture2D();
/* 156 */     GlStateManager.disableBlend();
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\notify\Notification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */