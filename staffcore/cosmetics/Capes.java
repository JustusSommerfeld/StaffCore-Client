/*    */ package staffcore.cosmetics;
/*    */ 
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public enum Capes
/*    */ {
/*  7 */   ZEROTWO("Capes/zerotwo.png", "client/BTN_ZeroTwo.png"),
/*  8 */   LUNAR("Capes/Lunar.png", "client/BTN_Lunar.png"),
/*  9 */   MYLES("Capes/Myles.png", "client/BTN_Myles.png"),
/* 10 */   NOEL("Capes/Noel.jpg", "client/BTN_Noel.png"),
/* 11 */   STAFFCORECLIENT("Capes/StaffCoreClientCape.jpg", "client/BTN_StaffCoreClientCape.png"),
/* 12 */   CELINA("Capes/heart.png", "client/BTN_heart.png"),
/* 13 */   FELIX("Capes/KaktusMadeByFelix.png", "client/BTN_KaktusMadeByFelix.png"),
/* 14 */   GREYSILLY7("Capes/Greysilly7.png", "client/BTN_Greysilly7.png");
/*    */   
/*    */   String resourceLocation;
/*    */   String buttonLocation;
/*    */   
/*    */   Capes(String resourceLocation, String buttonLocation) {
/* 20 */     this.resourceLocation = resourceLocation;
/* 21 */     this.buttonLocation = buttonLocation;
/*    */   }
/*    */   
/*    */   public ResourceLocation getResourceLocation() {
/* 25 */     return new ResourceLocation(this.resourceLocation);
/*    */   }
/*    */   
/*    */   public ResourceLocation getButtonLocation() {
/* 29 */     return new ResourceLocation(this.buttonLocation);
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\cosmetics\Capes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */