/*    */ package staffcore.cosmetics;
/*    */ 
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ 
/*    */ public class CosmeticManager
/*    */ {
/*    */   public static boolean shouldRenderTopHat(AbstractClientPlayer player) {
/*  8 */     return true;
/*    */   }
/*    */   
/*    */   public static float[] getTopHatColor(AbstractClientPlayer player) {
/* 12 */     return new float[] { 1.0F, 0.0F, 0.0F };
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\cosmetics\CosmeticManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */