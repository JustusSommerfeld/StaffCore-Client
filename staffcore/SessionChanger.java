/*    */ package staffcore;
/*    */ 
/*    */ import com.mojang.authlib.Agent;
/*    */ import com.mojang.authlib.UserAuthentication;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*    */ import com.mojang.util.UUIDTypeAdapter;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.Session;
/*    */ 
/*    */ 
/*    */ public class SessionChanger
/*    */ {
/*    */   private static SessionChanger instance;
/*    */   private final UserAuthentication auth;
/*    */   
/*    */   public static SessionChanger getInstance() {
/* 18 */     if (instance == null) {
/* 19 */       instance = new SessionChanger();
/*    */     }
/*    */     
/* 22 */     return instance;
/*    */   }
/*    */ 
/*    */   
/*    */   private SessionChanger() {
/* 27 */     UUID notSureWhyINeedThis = UUID.randomUUID();
/* 28 */     YggdrasilAuthenticationService yggdrasilAuthenticationService = new YggdrasilAuthenticationService(Minecraft.getMinecraft().getProxy(), notSureWhyINeedThis.toString());
/* 29 */     this.auth = yggdrasilAuthenticationService.createUserAuthentication(Agent.MINECRAFT);
/* 30 */     yggdrasilAuthenticationService.createMinecraftSessionService();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUser(String email, String password) {
/* 37 */     if (!Minecraft.getMinecraft().getSession().getUsername().equals(email) || Minecraft.getMinecraft().getSession().getToken().equals("0")) {
/*    */       
/* 39 */       this.auth.logOut();
/* 40 */       this.auth.setUsername(email);
/* 41 */       this.auth.setPassword(password);
/*    */       try {
/* 43 */         this.auth.logIn();
/* 44 */         Session session = new Session(this.auth.getSelectedProfile().getName(), UUIDTypeAdapter.fromUUID(this.auth.getSelectedProfile().getId()), this.auth.getAuthenticatedToken(), this.auth.getUserType().getName());
/* 45 */         setSession(session);
/*    */       }
/* 47 */       catch (Exception e) {
/* 48 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSession(Session session) {
/* 57 */     (Minecraft.getMinecraft()).session = session;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUserOffline(String username) {
/* 63 */     this.auth.logOut();
/* 64 */     Session session = new Session(username, username, "0", "legacy");
/* 65 */     setSession(session);
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\SessionChanger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */