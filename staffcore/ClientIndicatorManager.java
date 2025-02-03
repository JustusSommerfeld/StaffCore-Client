/*    */ package staffcore;
/*    */ 
/*    */ import api.lacodev.mysqlinjector.MySQL;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Timer;
/*    */ import java.util.TimerTask;
/*    */ import staffcore.utils.initIndicator;
/*    */ 
/*    */ public class ClientIndicatorManager
/*    */ {
/* 13 */   public static ArrayList<String> online_players = new ArrayList<>();
/*    */ 
/*    */   
/*    */   public static void init() {
/* 17 */     Timer timer = new Timer();
/*    */     
/* 19 */     timer.scheduleAtFixedRate((TimerTask)new initIndicator(), 0L, 15000L);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isOnline(String uuid) {
/* 24 */     return online_players.contains(uuid);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setOnline(String uuid) {
/* 29 */     if (existsEntry(uuid)) {
/* 30 */       MySQL.update("UPDATE staffcore_indicator SET online = '1' WHERE uuid = '" + uuid + "'");
/* 31 */       online_players.add(uuid);
/*    */     } else {
/* 33 */       MySQL.update("INSERT INTO staffcore_indicator(uuid,online) VALUES ('" + uuid + "','1')");
/* 34 */       online_players.add(uuid);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean existsEntry(String uuid) {
/* 41 */     ResultSet rs = MySQL.getResult("SELECT uuid FROM staffcore_indicator WHERE uuid = '" + uuid + "'");
/*    */     
/*    */     try {
/* 44 */       if (rs.next()) {
/* 45 */         return (rs.getString("uuid") != null);
/*    */       }
/* 47 */     } catch (SQLException e) {
/* 48 */       e.printStackTrace();
/*    */     } 
/* 50 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setOffline(String uuid) {
/* 56 */     if (existsEntry(uuid)) {
/* 57 */       MySQL.update("UPDATE staffcore_indicator SET online = '0' WHERE uuid = '" + uuid + "'");
/* 58 */       online_players.remove(uuid);
/*    */     } else {
/* 60 */       MySQL.update("INSERT INTO staffcore_indicator(uuid,online) VALUES ('" + uuid + "','0')");
/* 61 */       online_players.remove(uuid);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\ClientIndicatorManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */