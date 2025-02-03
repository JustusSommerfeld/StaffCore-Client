/*    */ package staffcore.utils;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public class MultiColorRendering
/*    */ {
/*    */   public static void drawChromaString(String string, int x, int y, boolean shadow) {
/*  9 */     Minecraft mc = Minecraft.getMinecraft();
/*    */     
/* 11 */     int xTmp = x; byte b; int i; char[] arrayOfChar;
/* 12 */     for (i = (arrayOfChar = string.toCharArray()).length, b = 0; b < i; ) { char textChar = arrayOfChar[b];
/* 13 */       long l = System.currentTimeMillis() - (xTmp * 10 - y * 10);
/* 14 */       int j = Color.HSBtoRGB((float)(l % 2000L) / 2000.0F, 0.8F, 0.8F);
/* 15 */       String tmp = String.valueOf(textChar);
/* 16 */       mc.fontRendererObj.drawString(tmp, xTmp, y, j, shadow);
/* 17 */       xTmp += mc.fontRendererObj.getCharWidth(textChar);
/*    */       b++; }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcor\\utils\MultiColorRendering.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */