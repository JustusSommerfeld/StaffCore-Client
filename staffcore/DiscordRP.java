/*    */ package staffcore;
/*    */ 
/*    */ import net.arikia.dev.drpc.DiscordEventHandlers;
/*    */ import net.arikia.dev.drpc.DiscordRPC;
/*    */ import net.arikia.dev.drpc.DiscordRichPresence;
/*    */ import net.arikia.dev.drpc.DiscordUser;
/*    */ import net.arikia.dev.drpc.callbacks.ReadyCallback;
/*    */ 
/*    */ 
/*    */ public class DiscordRP
/*    */ {
/*    */   private boolean running = true;
/* 13 */   private long created = 0L;
/*    */   
/*    */   public static boolean discordrp = true;
/*    */ 
/*    */   
/*    */   public void start() {
/* 19 */     this.created = System.currentTimeMillis();
/* 20 */     DiscordEventHandlers handlers = (new DiscordEventHandlers.Builder()).setReadyEventHandler(new ReadyCallback()
/*    */         {
/*    */           public void apply(DiscordUser user) {
/* 23 */             System.out.println("Welcome" + user.username + "#" + user.discriminator + ".");
/* 24 */             DiscordRP.this.update("Booting up...", "");
/*    */           }
/* 27 */         }).build();
/*    */     
/* 29 */     DiscordRPC.discordInitialize("", handlers, true);
/*    */     
/* 31 */     (new Thread("Discord RPC Callback")
/*    */       {
/*    */         public void run()
/*    */         {
/* 35 */           while (DiscordRP.this.running) {
/* 36 */             DiscordRPC.discordRunCallbacks();
/*    */           
/*    */           }
/*    */         }
/* 40 */       }).start();
/*    */   }
/*    */   
/*    */   public void shutdown() {
/* 44 */     this.running = false;
/* 45 */     discordrp = false;
/* 46 */     DiscordRPC.discordShutdown();
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(String firstLine, String secondLine) {
/* 51 */     DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
/* 52 */     b.setBigImage("large", "");
/* 53 */     b.setDetails(firstLine);
/* 54 */     b.setStartTimestamps(this.created);
/*    */ 
/*    */     
/* 57 */     DiscordRPC.discordUpdatePresence(b.build());
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\DiscordRP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */