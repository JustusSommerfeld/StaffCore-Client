/*    */ package staffcore.utils;
/*    */ 
/*    */ import api.lacodev.mysqlinjector.MySQL;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.TimerTask;
/*    */ import staffcore.ClientIndicatorManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class initIndicator
/*    */   extends TimerTask
/*    */ {
/*    */   public void run() {
/* 16 */     ClientIndicatorManager.online_players.clear();
/* 17 */     if (MySQL.isConnected()) {
/* 18 */       ResultSet rs = MySQL.getResult("SELECT uuid FROM staffcore_indicator WHERE online = '1'");
/*    */       
/*    */       try {
/* 21 */         while (rs.next()) {
/* 22 */           ClientIndicatorManager.online_players.add(rs.getString("uuid"));
/*    */         }
/* 24 */       } catch (SQLException e) {
/* 25 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcor\\utils\initIndicator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */