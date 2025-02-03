/*    */ package staffcore.utils;
/*    */ 
/*    */ import java.io.BufferedOutputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipInputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UnzipUtility
/*    */ {
/*    */   private static final int BUFFER_SIZE = 4096;
/*    */   
/*    */   public void unzip(String zipFilePath, String destDirectory) throws IOException {
/* 31 */     File destDir = new File(destDirectory);
/* 32 */     if (!destDir.exists()) {
/* 33 */       destDir.mkdir();
/*    */     }
/* 35 */     ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
/* 36 */     ZipEntry entry = zipIn.getNextEntry();
/*    */     
/* 38 */     while (entry != null) {
/* 39 */       String filePath = String.valueOf(destDirectory) + File.separator + entry.getName();
/* 40 */       if (!entry.isDirectory()) {
/*    */         
/* 42 */         extractFile(zipIn, filePath);
/*    */       } else {
/*    */         
/* 45 */         File dir = new File(filePath);
/* 46 */         dir.mkdirs();
/*    */       } 
/* 48 */       zipIn.closeEntry();
/* 49 */       entry = zipIn.getNextEntry();
/*    */     } 
/* 51 */     zipIn.close();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
/* 60 */     BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
/* 61 */     byte[] bytesIn = new byte[4096];
/* 62 */     int read = 0;
/* 63 */     while ((read = zipIn.read(bytesIn)) != -1) {
/* 64 */       bos.write(bytesIn, 0, read);
/*    */     }
/* 66 */     bos.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcor\\utils\UnzipUtility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */