/*     */ package staffcore;
/*     */ 
/*     */ import api.lacodev.mysqlinjector.MySQL;
/*     */ import java.awt.Color;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import staffcore.cosmetics.CapeManager;
/*     */ import staffcore.events.EventManager;
/*     */ import staffcore.events.EventTarget;
/*     */ import staffcore.events.impl.ClientTick;
/*     */ import staffcore.gui.SplashProgress;
/*     */ import staffcore.gui.clickgui.ClickGUI;
/*     */ import staffcore.hud.HUDConfigScreen;
/*     */ import staffcore.hud.mod.HudManager;
/*     */ import staffcore.modules.ModManager;
/*     */ import staffcore.utils.OSHelper;
/*     */ 
/*     */ 
/*     */ public class Client
/*     */ {
/*  26 */   public String NAME = "StaffCore"; public String VERSION = "1.2"; public String AUTHOR = "Lunar";
/*  27 */   public Minecraft mc = Minecraft.getMinecraft();
/*  28 */   private static final Client INSTANCE = new Client(); public static CapeManager capemanager;
/*     */   public HudManager hudManager;
/*     */   public EventManager eventManager;
/*     */   public ModManager modManager;
/*     */   
/*     */   public static final Client getInstance() {
/*  34 */     return INSTANCE;
/*     */   }
/*     */   
/*     */   public void startup() {
/*  38 */     this.hudManager = new HudManager();
/*  39 */     System.err.println("Registered HudManager");
/*  40 */     this.eventManager = new EventManager();
/*  41 */     System.err.println("Registered EventManager");
/*  42 */     this.modManager = new ModManager();
/*  43 */     System.err.println("Registered ModManager");
/*  44 */     System.err.println("Starting " + this.NAME + " " + this.VERSION + " by " + this.AUTHOR);
/*     */     
/*  46 */     EventManager.register(this);
/*  47 */     ClientIndicatorManager.setOnline(this.mc.getSession().getProfile().getId().toString());
/*  48 */     System.err.println(this.mc.getSession().getProfile().getId().toString());
/*     */   }
/*     */   
/*  51 */   private DiscordRP discordRP = new DiscordRP();
/*     */ 
/*     */   
/*     */   public void init() {
/*  55 */     SplashProgress.setProgress(1, "Client - Initalising Discord RP...");
/*  56 */     this.discordRP.start();
/*     */     
/*  58 */     SplashProgress.setProgress(2, "Client - Connecting Database...");
/*  59 */     MySQL.connect();
/*  60 */     MySQL.createTable();
/*     */     
/*  62 */     capemanager = new CapeManager();
/*  63 */     capemanager.init();
/*  64 */     ClientIndicatorManager.init();
/*     */   }
/*     */   
/*     */   public CapeManager getCapeManager() {
/*  68 */     return capemanager;
/*     */   }
/*     */   
/*     */   public void shutdown() {
/*  72 */     ClientIndicatorManager.setOffline(this.mc.getSession().getProfile().getId().toString());
/*  73 */     EventManager.unregister(this);
/*  74 */     System.err.println("Shutting down " + this.NAME);
/*  75 */     this.discordRP.shutdown();
/*     */   }
/*     */ 
/*     */   
/*     */   @EventTarget
/*     */   public void onTick(ClientTick event) {
/*  81 */     if (this.mc.gameSettings.HUD_CONFIG.isPressed()) {
/*  82 */       this.mc.displayGuiScreen((GuiScreen)new HUDConfigScreen());
/*     */     }
/*  84 */     if (this.mc.gameSettings.CLICK_GUI.isPressed()) {
/*  85 */       this.mc.displayGuiScreen((GuiScreen)new ClickGUI());
/*     */     }
/*  87 */     if (this.mc.gameSettings.STAFFCORE_GUI.isPressed()) {
/*  88 */       this.mc.thePlayer.sendChatMessage("/staffcore gui");
/*     */     }
/*  90 */     if (this.mc.gameSettings.STAFFCORE_REPORTS.isPressed()) {
/*  91 */       this.mc.thePlayer.sendChatMessage("/reports");
/*     */     }
/*  93 */     if (this.mc.gameSettings.STAFFCORE_BAN_LIST.isPressed()) {
/*  94 */       this.mc.thePlayer.sendChatMessage("/banlist");
/*     */     }
/*  96 */     if (this.mc.gameSettings.STAFFCORE_CHATFILTER.isPressed()) {
/*  97 */       this.mc.thePlayer.sendChatMessage("/chatfilter");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public DiscordRP getDiscordRP() {
/* 103 */     return this.discordRP;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void update() {
/* 108 */     File minecraftDirectory = new File(OSHelper.getOS().getMc());
/* 109 */     File minecraftAssets = new File(String.valueOf(minecraftDirectory.toString()) + File.separator + "assets");
/*     */     
/* 111 */     File jar = new File(minecraftDirectory + File.separator + "versions" + File.separator + "StaffCoreClient" + File.separator + "StaffCoreClient.jar");
/*     */     
/*     */     try {
/* 114 */       FileUtils.copyURLToFile(new URL("https://github.com/LunqrDev/StaffCore-Launcher/raw/main/StaffCoreClient.jar"), jar);
/* 115 */       System.err.println("Files downloaded");
/* 116 */     } catch (MalformedURLException e) {
/* 117 */       e.printStackTrace();
/* 118 */     } catch (IOException e) {
/* 119 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int RainbowEffect(int i, float f) {
/* 126 */     return Color.HSBtoRGB((float)(System.currentTimeMillis() % 20000L) / 1000.0F, 0.8F, 0.8F);
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\Client.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */