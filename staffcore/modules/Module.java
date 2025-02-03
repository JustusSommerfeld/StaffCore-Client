/*    */ package staffcore.modules;
/*    */ 
/*    */ public class Module
/*    */ {
/*    */   public String name;
/*    */   public String description;
/*    */   private int key;
/*    */   private Category category;
/*    */   public boolean toggled;
/*    */   
/*    */   public Module(String name, String description, Category category) {
/* 12 */     this.name = name;
/* 13 */     this.description = description;
/* 14 */     this.key = 0;
/* 15 */     this.category = category;
/* 16 */     this.toggled = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDescription() {
/* 21 */     return this.description;
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\modules\Module.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */