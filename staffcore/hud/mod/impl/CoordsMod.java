/*    */ package staffcore.hud.mod.impl;
/*    */ 
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.chunk.Chunk;
/*    */ import staffcore.hud.mod.HudMod;
/*    */ import staffcore.utils.MultiColorRendering;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CoordsMod
/*    */   extends HudMod
/*    */ {
/*    */   public static boolean crainbow1 = true;
/*    */   public static boolean blue1 = false;
/*    */   public static boolean green1 = false;
/*    */   public static boolean red1 = false;
/*    */   
/*    */   public CoordsMod() {
/* 19 */     super("Coordinates", 5, 15);
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw() {
/* 24 */     BlockPos blockpos = new BlockPos((this.mc.getRenderViewEntity()).posX, (this.mc.getRenderViewEntity().getEntityBoundingBox()).minY, (this.mc.getRenderViewEntity()).posZ);
/* 25 */     Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(blockpos);
/*    */     
/* 27 */     if (crainbow1) {
/* 28 */       MultiColorRendering.drawChromaString("X: " + Math.round(this.mc.thePlayer.posX), getX(), getY(), false);
/* 29 */       MultiColorRendering.drawChromaString("Y: " + Math.round(this.mc.thePlayer.posY), getX(), getY() + this.fr.FONT_HEIGHT, false);
/* 30 */       MultiColorRendering.drawChromaString("Z: " + Math.round(this.mc.thePlayer.posZ), getX(), getY() + this.fr.FONT_HEIGHT * 2, false);
/* 31 */       MultiColorRendering.drawChromaString("Biome: " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, getX(), getY() + this.fr.FONT_HEIGHT * 3, false);
/* 32 */     } else if (blue1) {
/* 33 */       this.fr.drawString("§bX: " + Math.round(this.mc.thePlayer.posX), getX(), getY(), -1);
/* 34 */       this.fr.drawString("§bY: " + Math.round(this.mc.thePlayer.posY), getX(), getY() + this.fr.FONT_HEIGHT, -1);
/* 35 */       this.fr.drawString("§bZ: " + Math.round(this.mc.thePlayer.posZ), getX(), getY() + this.fr.FONT_HEIGHT * 2, -1);
/* 36 */       this.fr.drawString("§bBiome: " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, getX(), getY() + this.fr.FONT_HEIGHT * 3, -1);
/* 37 */     } else if (green1) {
/* 38 */       this.fr.drawString("§aX: " + Math.round(this.mc.thePlayer.posX), getX(), getY(), -1);
/* 39 */       this.fr.drawString("§aY: " + Math.round(this.mc.thePlayer.posY), getX(), getY() + this.fr.FONT_HEIGHT, -1);
/* 40 */       this.fr.drawString("§aZ: " + Math.round(this.mc.thePlayer.posZ), getX(), getY() + this.fr.FONT_HEIGHT * 2, -1);
/* 41 */       this.fr.drawString("§aBiome: " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, getX(), getY() + this.fr.FONT_HEIGHT * 3, -1);
/* 42 */     } else if (red1) {
/* 43 */       this.fr.drawString("§cX: " + Math.round(this.mc.thePlayer.posX), getX(), getY(), -1);
/* 44 */       this.fr.drawString("§cY: " + Math.round(this.mc.thePlayer.posY), getX(), getY() + this.fr.FONT_HEIGHT, -1);
/* 45 */       this.fr.drawString("§cZ: " + Math.round(this.mc.thePlayer.posZ), getX(), getY() + this.fr.FONT_HEIGHT * 2, -1);
/* 46 */       this.fr.drawString("§cBiome: " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, getX(), getY() + this.fr.FONT_HEIGHT * 3, -1);
/*    */     } else {
/* 48 */       this.fr.drawString("§fX: " + Math.round(this.mc.thePlayer.posX), getX(), getY(), -1);
/* 49 */       this.fr.drawString("§fY: " + Math.round(this.mc.thePlayer.posY), getX(), getY() + this.fr.FONT_HEIGHT, -1);
/* 50 */       this.fr.drawString("§fZ: " + Math.round(this.mc.thePlayer.posZ), getX(), getY() + this.fr.FONT_HEIGHT * 2, -1);
/* 51 */       this.fr.drawString("§fBiome: " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, getX(), getY() + this.fr.FONT_HEIGHT * 3, -1);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderDummy(int mouseX, int mouseY) {
/* 57 */     BlockPos blockpos = new BlockPos((this.mc.getRenderViewEntity()).posX, (this.mc.getRenderViewEntity().getEntityBoundingBox()).minY, (this.mc.getRenderViewEntity()).posZ);
/* 58 */     Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(blockpos);
/* 59 */     if (crainbow1) {
/* 60 */       MultiColorRendering.drawChromaString("X: " + Math.round(this.mc.thePlayer.posX), getX(), getY(), false);
/* 61 */       MultiColorRendering.drawChromaString("Y: " + Math.round(this.mc.thePlayer.posY), getX(), getY() + this.fr.FONT_HEIGHT, false);
/* 62 */       MultiColorRendering.drawChromaString("Z: " + Math.round(this.mc.thePlayer.posZ), getX(), getY() + this.fr.FONT_HEIGHT * 2, false);
/* 63 */       MultiColorRendering.drawChromaString("Biome: " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, getX(), getY() + this.fr.FONT_HEIGHT * 3, false);
/* 64 */       super.renderDummy(mouseX, mouseY);
/* 65 */     } else if (blue1) {
/* 66 */       this.fr.drawString("§bX: " + Math.round(this.mc.thePlayer.posX), getX(), getY(), -1);
/* 67 */       this.fr.drawString("§bY: " + Math.round(this.mc.thePlayer.posY), getX(), getY() + this.fr.FONT_HEIGHT, -1);
/* 68 */       this.fr.drawString("§bZ: " + Math.round(this.mc.thePlayer.posZ), getX(), getY() + this.fr.FONT_HEIGHT * 2, -1);
/* 69 */       this.fr.drawString("§bBiome: " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, getX(), getY() + this.fr.FONT_HEIGHT * 3, -1);
/* 70 */       super.renderDummy(mouseX, mouseY);
/* 71 */     } else if (green1) {
/* 72 */       this.fr.drawString("§aX: " + Math.round(this.mc.thePlayer.posX), getX(), getY(), -1);
/* 73 */       this.fr.drawString("§aY: " + Math.round(this.mc.thePlayer.posY), getX(), getY() + this.fr.FONT_HEIGHT, -1);
/* 74 */       this.fr.drawString("§aZ: " + Math.round(this.mc.thePlayer.posZ), getX(), getY() + this.fr.FONT_HEIGHT * 2, -1);
/* 75 */       this.fr.drawString("§aBiome: " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, getX(), getY() + this.fr.FONT_HEIGHT * 3, -1);
/* 76 */       super.renderDummy(mouseX, mouseY);
/* 77 */     } else if (red1) {
/* 78 */       this.fr.drawString("§cX: " + Math.round(this.mc.thePlayer.posX), getX(), getY(), -1);
/* 79 */       this.fr.drawString("§cY: " + Math.round(this.mc.thePlayer.posY), getX(), getY() + this.fr.FONT_HEIGHT, -1);
/* 80 */       this.fr.drawString("§cZ: " + Math.round(this.mc.thePlayer.posZ), getX(), getY() + this.fr.FONT_HEIGHT * 2, -1);
/* 81 */       this.fr.drawString("§cBiome: " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, getX(), getY() + this.fr.FONT_HEIGHT * 3, -1);
/* 82 */       super.renderDummy(mouseX, mouseY);
/*    */     } else {
/* 84 */       this.fr.drawString("§fX: " + Math.round(this.mc.thePlayer.posX), getX(), getY(), -1);
/* 85 */       this.fr.drawString("§fY: " + Math.round(this.mc.thePlayer.posY), getX(), getY() + this.fr.FONT_HEIGHT, -1);
/* 86 */       this.fr.drawString("§fZ: " + Math.round(this.mc.thePlayer.posZ), getX(), getY() + this.fr.FONT_HEIGHT * 2, -1);
/* 87 */       this.fr.drawString("§fBiome: " + (chunk.getBiome(blockpos, this.mc.theWorld.getWorldChunkManager())).biomeName, getX(), getY() + this.fr.FONT_HEIGHT * 3, -1);
/* 88 */       super.renderDummy(mouseX, mouseY);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 94 */     return 50;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getWidth() {
/* 99 */     return 80;
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\hud\mod\impl\CoordsMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */