/*     */ package staffcore.hud.mod.impl;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import staffcore.hud.mod.HudMod;
/*     */ import staffcore.utils.MultiColorRendering;
/*     */ 
/*     */ public class Keystrokes
/*     */   extends HudMod
/*     */ {
/*     */   private KeystrokesMode mode;
/*     */   
/*     */   public Keystrokes() {
/*  17 */     super("Keystrokes", 570, 33);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     this.mode = KeystrokesMode.WASD_JUMP_MOUSE;
/*     */   } public enum KeystrokesMode {
/*     */     WASD((String)new Keystrokes.Key[] { Keystrokes.Key.access$0(), Keystrokes.Key.access$1(), Keystrokes.Key.access$2(), Keystrokes.Key.access$3() }), WASD_MOUSE((String)new Keystrokes.Key[] { Keystrokes.Key.access$0(), Keystrokes.Key.access$1(), Keystrokes.Key.access$2(), Keystrokes.Key.access$3(), Keystrokes.Key.access$4(), Keystrokes.Key.access$5() }), WASD_JUMP((String)new Keystrokes.Key[] { Keystrokes.Key.access$0(), Keystrokes.Key.access$1(), Keystrokes.Key.access$2(), Keystrokes.Key.access$3() }), WASD_JUMP_MOUSE((String)new Keystrokes.Key[] { Keystrokes.Key.access$0(), Keystrokes.Key.access$1(), Keystrokes.Key.access$2(), Keystrokes.Key.access$3(), Keystrokes.Key.access$4(), Keystrokes.Key.access$5() }); public final Keystrokes.Key[] keys; private int width; private int height; KeystrokesMode(Keystrokes.Key... keysIn) { this.keys = keysIn; byte b; int i; Keystrokes.Key[] arrayOfKey; for (i = (arrayOfKey = this.keys).length, b = 0; b < i; ) { Keystrokes.Key key = arrayOfKey[b]; this.width = Math.max(this.width, key.getX() + key.getWidth()); this.height = Math.max(this.height, key.getY() + key.getHeight()); b++; }  } public int getHeight() { return this.height; }
/*     */     public int getWidth() { return this.width; }
/*     */     public Keystrokes.Key[] getKeys() { return this.keys; } }
/* 102 */   public int getWidth() { return 58; }
/*     */ 
/*     */   
/*     */   public int getHeight()
/*     */   {
/* 107 */     return 72;
/*     */   }
/*     */   public static class Key {
/*     */     public static Minecraft mc = Minecraft.getMinecraft();
/*     */     private static final Key W = new Key("W", mc.gameSettings.keyBindForward, 21, 1, 18, 18);
/* 112 */     private static final Key A = new Key("A", mc.gameSettings.keyBindLeft, 1, 21, 18, 18); private static final Key S = new Key("S", mc.gameSettings.keyBindBack, 21, 21, 18, 18); private static final Key D = new Key("D", mc.gameSettings.keyBindRight, 41, 21, 18, 18); private static final Key LMB = new Key("LMB", mc.gameSettings.keyBindAttack, 1, 41, 28, 18); private static final Key RMB = new Key("RMB", mc.gameSettings.keyBindUseItem, 31, 41, 28, 18); private final String name; private final KeyBinding keyBind; private final int x; private final int y; private final int w; private final int h; public Key(String name, KeyBinding keyBind, int x, int y, int w, int h) { this.name = name; this.keyBind = keyBind; this.x = x; this.y = y; this.w = w; this.h = h; } public boolean isDown() { return this.keyBind.isKeyDown(); } public int getHeight() { return this.h; } public int getWidth() { return this.w; } public String getName() { return this.name; } public int getX() { return this.x; } public int getY() { return this.y; } } public void draw() { GL11.glPushMatrix(); byte b; int i;
/*     */     Key[] arrayOfKey;
/* 114 */     for (i = (arrayOfKey = this.mode.getKeys()).length, b = 0; b < i; ) { Key key = arrayOfKey[b];
/* 115 */       int textWidth = this.fr.getStringWidth(key.getName());
/*     */       
/* 117 */       Gui.drawRect(getX() + key.getX(), getY() + key.getY(), getX() + key.getX() + key.getWidth(), getY() + key.getY() + key.getHeight(), key.isDown() ? (new Color(255, 255, 255, 102)).getRGB() : (new Color(0, 0, 0, 120)).getRGB());
/*     */ 
/*     */       
/* 120 */       MultiColorRendering.drawChromaString(key.getName(), getX() + key.getX() + key.getWidth() / 2 - textWidth / 2, getY() + key.getY() + key.getHeight() / 2 - 4, key.isDown());
/*     */       b++; }
/*     */     
/* 123 */     GL11.glPopMatrix();
/* 124 */     super.draw(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderDummy(int mouseX, int mouseY) {
/* 131 */     GL11.glPushMatrix(); byte b; int i;
/*     */     Key[] arrayOfKey;
/* 133 */     for (i = (arrayOfKey = this.mode.getKeys()).length, b = 0; b < i; ) { Key key = arrayOfKey[b];
/* 134 */       int textWidth = this.fr.getStringWidth(key.getName());
/*     */       
/* 136 */       Gui.drawRect(getX() + key.getX(), getY() + key.getY(), getX() + key.getX() + key.getWidth(), getY() + key.getY() + key.getHeight(), key.isDown() ? (new Color(255, 255, 255, 102)).getRGB() : (new Color(0, 0, 0, 120)).getRGB());
/*     */       
/* 138 */       MultiColorRendering.drawChromaString(key.getName(), getX() + key.getX() + key.getWidth() / 2 - textWidth / 2, getY() + key.getY() + key.getHeight() / 2 - 4, key.isDown());
/*     */       b++; }
/*     */     
/* 141 */     GL11.glPopMatrix();
/* 142 */     super.renderDummy(mouseX, mouseY);
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\hud\mod\impl\Keystrokes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */