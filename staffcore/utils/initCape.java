/*    */ package staffcore.utils;
/*    */ 
/*    */ import api.lacodev.mysqlinjector.MySQL;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.TimerTask;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import staffcore.Client;
/*    */ 
/*    */ public class initCape
/*    */   extends TimerTask
/*    */ {
/*    */   public void run() {
/* 14 */     (Client.getInstance().getCapeManager()).capes.clear();
/* 15 */     if (MySQL.isConnected()) {
/* 16 */       ResultSet rs = MySQL.getResult("SELECT * FROM staffcore_capes");
/*    */       
/*    */       try {
/* 19 */         while (rs.next()) {
/* 20 */           (Client.getInstance().getCapeManager()).capes.put(rs.getString("uuid"), new ResourceLocation(rs.getString("download_url")));
/*    */         }
/* 22 */       } catch (SQLException e) {
/* 23 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcor\\utils\initCape.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */