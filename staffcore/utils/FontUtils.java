/*     */ package staffcore.utils;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.StringUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.newdawn.slick.Color;
/*     */ import org.newdawn.slick.UnicodeFont;
/*     */ import org.newdawn.slick.font.effects.ColorEffect;
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
/*     */ public class FontUtils
/*     */ {
/*  24 */   private Minecraft mc = Minecraft.getMinecraft();
/*     */   
/*     */   private final UnicodeFont unicodeFont;
/*  27 */   private final int[] colorCodes = new int[32];
/*     */   
/*     */   private int fontType;
/*     */   private int size;
/*     */   private String fontName;
/*     */   private float kerning;
/*     */   
/*     */   public FontUtils(String fontName, int fontType, int size) {
/*  35 */     this(fontName, fontType, size, 0.0F);
/*     */   }
/*     */   
/*     */   public FontUtils(String fontName, int fontType, int size, float kerning) {
/*  39 */     this.fontName = fontName;
/*  40 */     this.fontType = fontType;
/*  41 */     this.size = size;
/*     */     
/*  43 */     this.unicodeFont = new UnicodeFont(new Font(fontName, fontType, size));
/*  44 */     this.kerning = kerning;
/*     */     
/*  46 */     this.unicodeFont.addAsciiGlyphs();
/*  47 */     this.unicodeFont.getEffects().add(new ColorEffect(Color.WHITE));
/*     */     
/*     */     try {
/*  50 */       this.unicodeFont.loadGlyphs();
/*  51 */     } catch (Exception e) {
/*  52 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  55 */     for (int i = 0; i < 32; i++) {
/*  56 */       int shadow = (i >> 3 & 0x1) * 85;
/*  57 */       int red = (i >> 2 & 0x1) * 170 + shadow;
/*  58 */       int green = (i >> 1 & 0x1) * 170 + shadow;
/*  59 */       int blue = (i >> 0 & 0x1) * 170 + shadow;
/*     */       
/*  61 */       if (i == 6) {
/*  62 */         red += 85;
/*     */       }
/*     */       
/*  65 */       if (i >= 16) {
/*  66 */         red /= 4;
/*  67 */         green /= 4;
/*  68 */         blue /= 4;
/*     */       } 
/*     */       
/*  71 */       this.colorCodes[i] = (red & 0xFF) << 16 | (green & 0xFF) << 8 | blue & 0xFF;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int drawString(String text, float x, float y, int color) {
/*  77 */     x *= 2.0F;
/*  78 */     y *= 2.0F;
/*  79 */     float originalX = x;
/*     */     
/*  81 */     GL11.glPushMatrix();
/*  82 */     GL11.glScaled(0.5D, 0.5D, 0.5D);
/*     */     
/*  84 */     boolean blend = GL11.glIsEnabled(3042);
/*  85 */     boolean lighting = GL11.glIsEnabled(2896);
/*  86 */     boolean texture = GL11.glIsEnabled(3553);
/*  87 */     if (!blend)
/*  88 */       GL11.glEnable(3042); 
/*  89 */     if (lighting)
/*  90 */       GL11.glDisable(2896); 
/*  91 */     if (texture) {
/*  92 */       GL11.glDisable(3553);
/*     */     }
/*  94 */     int currentColor = color;
/*  95 */     char[] characters = text.toCharArray();
/*     */     
/*  97 */     int index = 0; byte b; int i; char[] arrayOfChar1;
/*  98 */     for (i = (arrayOfChar1 = characters).length, b = 0; b < i; ) { char c = arrayOfChar1[b];
/*  99 */       if (c == '\r') {
/* 100 */         x = originalX;
/*     */       }
/* 102 */       if (c == '\n') {
/* 103 */         y += getHeight(Character.toString(c)) * 2.0F;
/*     */       }
/* 105 */       if (c != '§' && (index == 0 || index == characters.length - 1 || characters[index - 1] != '§')) {
/* 106 */         this.unicodeFont.drawString(x, y, Character.toString(c), new Color(currentColor));
/* 107 */         x += getWidth(Character.toString(c)) * 2.0F;
/* 108 */       } else if (c == ' ') {
/* 109 */         x += this.unicodeFont.getSpaceWidth();
/* 110 */       } else if (c == '§' && index != characters.length - 1) {
/* 111 */         int codeIndex = "0123456789abcdefg".indexOf(text.charAt(index + 1));
/* 112 */         if (codeIndex < 0)
/*     */           continue; 
/* 114 */         int col = this.colorCodes[codeIndex];
/* 115 */         currentColor = col;
/*     */       } 
/*     */       
/* 118 */       index++; continue;
/*     */       b++; }
/*     */     
/* 121 */     GL11.glScaled(2.0D, 2.0D, 2.0D);
/* 122 */     if (texture)
/* 123 */       GL11.glEnable(3553); 
/* 124 */     if (lighting)
/* 125 */       GL11.glEnable(2896); 
/* 126 */     if (!blend)
/* 127 */       GL11.glDisable(3042); 
/* 128 */     GL11.glPopMatrix();
/* 129 */     return (int)x;
/*     */   }
/*     */   
/*     */   public int drawStringWithShadow(String text, float x, float y, int color) {
/* 133 */     drawString(StringUtils.stripControlCodes(text), x + 0.5F, y + 0.5F, 0);
/* 134 */     return drawString(text, x, y, color);
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String text, float x, float y, int color) {
/* 138 */     drawString(text, x - ((int)getWidth(text) / 2), y, color);
/*     */   }
/*     */   
/*     */   public void drawCenteredStringWithShadow(String text, float x, float y, int color) {
/* 142 */     drawCenteredString(StringUtils.stripControlCodes(text), x + 0.5F, y + 0.5F, color);
/* 143 */     drawCenteredString(text, x, y, color);
/*     */   }
/*     */   
/*     */   public float getWidth(String s) {
/* 147 */     float width = 0.0F;
/*     */     
/* 149 */     String str = StringUtils.stripControlCodes(s); byte b; int i; char[] arrayOfChar;
/* 150 */     for (i = (arrayOfChar = str.toCharArray()).length, b = 0; b < i; ) { char c = arrayOfChar[b];
/* 151 */       width += this.unicodeFont.getWidth(Character.toString(c)) + this.kerning;
/*     */       b++; }
/*     */     
/* 154 */     return width / 2.0F;
/*     */   }
/*     */   
/*     */   public float getCharWidth(char c) {
/* 158 */     return this.unicodeFont.getWidth(String.valueOf(c));
/*     */   }
/*     */   
/*     */   public float getHeight(String s) {
/* 162 */     return this.unicodeFont.getHeight(s) / 2.0F;
/*     */   }
/*     */   
/*     */   public UnicodeFont getFont() {
/* 166 */     return this.unicodeFont;
/*     */   }
/*     */ 
/*     */   
/*     */   public String trimStringToWidth(String par1Str, int par2) {
/* 171 */     StringBuilder var4 = new StringBuilder();
/* 172 */     float var5 = 0.0F;
/* 173 */     int var6 = 0;
/* 174 */     int var7 = 1;
/* 175 */     boolean var8 = false;
/* 176 */     boolean var9 = false;
/*     */     
/* 178 */     for (int var10 = var6; var10 >= 0 && var10 < par1Str.length() && var5 < par2; var10 += var7) {
/*     */       
/* 180 */       char var11 = par1Str.charAt(var10);
/* 181 */       float var12 = getCharWidth(var11);
/*     */       
/* 183 */       if (var8) {
/*     */         
/* 185 */         var8 = false;
/*     */         
/* 187 */         if (var11 != 'l' && var11 != 'L')
/*     */         {
/* 189 */           if (var11 == 'r' || var11 == 'R')
/*     */           {
/* 191 */             var9 = false;
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 196 */           var9 = true;
/*     */         }
/*     */       
/* 199 */       } else if (var12 < 0.0F) {
/*     */         
/* 201 */         var8 = true;
/*     */       }
/*     */       else {
/*     */         
/* 205 */         var5 += var12;
/*     */         
/* 207 */         if (var9)
/*     */         {
/* 209 */           var5++;
/*     */         }
/*     */       } 
/*     */       
/* 213 */       if (var5 > par2) {
/*     */         break;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 220 */       var4.append(var11);
/*     */     } 
/*     */ 
/*     */     
/* 224 */     return var4.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcor\\utils\FontUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */