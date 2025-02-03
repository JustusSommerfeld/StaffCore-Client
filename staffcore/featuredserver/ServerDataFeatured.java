/*    */ package staffcore.FeaturedServer;
/*    */ 
/*    */ import net.minecraft.client.multiplayer.ServerData;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class ServerDataFeatured
/*    */   extends ServerData {
/*  8 */   public static final ResourceLocation ICON = new ResourceLocation("featuredserver.png");
/*    */   
/*    */   public ServerDataFeatured(String serverName, String serverIP) {
/* 11 */     super(serverName, serverIP, false);
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\FeaturedServer\ServerDataFeatured.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */