/*    */ package staffcore.cosmetics;
/*    */ 
/*    */ import api.lacodev.mysqlinjector.MySQL;
/*    */ import java.util.HashMap;
/*    */ import java.util.Timer;
/*    */ import java.util.TimerTask;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import staffcore.utils.initCape;
/*    */ 
/*    */ public class CapeManager
/*    */ {
/* 12 */   public HashMap<String, ResourceLocation> capes = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void init() {
/* 20 */     Timer timer = new Timer();
/*    */     
/* 22 */     timer.scheduleAtFixedRate((TimerTask)new initCape(), 0L, 20000L);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasCape(String uuid) {
/* 27 */     return this.capes.containsKey(uuid);
/*    */   }
/*    */   
/*    */   public ResourceLocation getCape(String uuid) {
/* 31 */     return this.capes.get(uuid);
/*    */   }
/*    */   
/*    */   public void updateCape(String uuid, ResourceLocation location) {
/* 35 */     if (hasCape(uuid)) {
/* 36 */       MySQL.update("UPDATE staffcore_capes SET download_url = '" + location.getResourcePath() + "' WHERE uuid = '" + uuid + "'");
/* 37 */       this.capes.replace(uuid, location);
/*    */     } else {
/* 39 */       MySQL.update("INSERT INTO staffcore_capes(uuid,download_url) VALUES ('" + uuid + "','" + location.getResourcePath() + "')");
/* 40 */       this.capes.put(uuid, location);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void removeCape(String uuid) {
/* 45 */     MySQL.update("DELETE FROM staffcore_capes WHERE uuid = '" + uuid + "'");
/* 46 */     this.capes.remove(uuid);
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\cosmetics\CapeManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */