/*    */ package staffcore.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ public enum OSHelper
/*    */ {
/*  8 */   WINDOWS("AppData" + File.separator + "Roaming" + File.separator + ".minecraft"),
/*  9 */   MAC("Library" + File.separator + "Applacation Support" + File.separator + "minecraft"),
/* 10 */   LINUX(".minecraft");
/*    */   
/*    */   private final String mc;
/*    */   
/*    */   OSHelper(String mc) {
/* 15 */     this.mc = String.valueOf(String.valueOf(File.separator)) + mc + File.separator;
/*    */   }
/*    */   
/*    */   public String getMc() {
/* 19 */     return String.valueOf(String.valueOf(System.getProperty("user.home"))) + this.mc;
/*    */   }
/*    */   
/*    */   public static final OSHelper getOS() {
/* 23 */     String currentOS = System.getProperty("os.name").toLowerCase();
/* 24 */     if (currentOS.startsWith("windows")) {
/* 25 */       return WINDOWS;
/*    */     }
/* 27 */     if (currentOS.startsWith("mac")) {
/* 28 */       return WINDOWS;
/*    */     }
/* 30 */     return LINUX;
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcor\\utils\OSHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */