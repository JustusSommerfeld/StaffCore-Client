/*    */ package staffcore.mods;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import staffcore.events.EventManager;
/*    */ import staffcore.modules.Category;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Mod
/*    */ {
/* 11 */   public Minecraft mc = Minecraft.getMinecraft();
/*    */   
/*    */   public String name;
/*    */   public String description;
/*    */   
/*    */   public Mod(String name, String description, Category category) {
/* 17 */     this.name = name;
/* 18 */     this.description = description;
/* 19 */     this.category = category;
/*    */     
/* 21 */     this.enabled = true;
/*    */   }
/*    */   public boolean enabled; public Category category;
/*    */   
/*    */   public void onEnable() {
/* 26 */     EventManager.register(this);
/*    */   }
/*    */   
/*    */   private void onDisable() {
/* 30 */     EventManager.unregister(this);
/*    */   }
/*    */   
/*    */   public void setEnabled(boolean enabled) {
/* 34 */     this.enabled = enabled;
/* 35 */     if (enabled) {
/* 36 */       onEnable();
/*    */     } else {
/* 38 */       onDisable();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void toggle() {
/* 43 */     setEnabled(!this.enabled);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 48 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 52 */     return this.description;
/*    */   }
/*    */   
/*    */   public boolean isEnabled() {
/* 56 */     return this.enabled;
/*    */   }
/*    */   
/*    */   public Category getCategory() {
/* 60 */     return this.category;
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\mods\Mod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */