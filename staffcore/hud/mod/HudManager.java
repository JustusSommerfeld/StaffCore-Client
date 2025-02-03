/*    */ package staffcore.hud.mod;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import staffcore.hud.mod.impl.CoordsMod;
/*    */ import staffcore.hud.mod.impl.FPSMod;
/*    */ import staffcore.hud.mod.impl.FullbrightMod;
/*    */ import staffcore.hud.mod.impl.Keystrokes;
/*    */ import staffcore.hud.mod.impl.TargetHUD;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HudManager
/*    */ {
/* 16 */   public ArrayList<HudMod> hudMods = new ArrayList<>();
/*    */   
/*    */   public FPSMod fps;
/*    */   public CoordsMod cm;
/*    */   public FullbrightMod fullbright;
/*    */   public Keystrokes keystrokes;
/*    */   public TargetHUD targethud;
/* 23 */   ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
/*    */ 
/*    */   
/*    */   public HudManager() {
/* 27 */     this.hudMods.add(this.fps = new FPSMod());
/* 28 */     this.hudMods.add(this.cm = new CoordsMod());
/* 29 */     this.hudMods.add(this.fullbright = new FullbrightMod());
/* 30 */     this.hudMods.add(this.keystrokes = new Keystrokes());
/* 31 */     this.hudMods.add(this.targethud = new TargetHUD());
/*    */   }
/*    */   
/*    */   public void renderMods() {
/* 35 */     for (HudMod m : this.hudMods) {
/* 36 */       if (m.isEnabled())
/* 37 */         m.draw(); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\hud\mod\HudManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */