/*    */ package staffcore.utils;
/*    */ 
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ public class AnimatedResourceLocation
/*    */ {
/*    */   private final String folder;
/*    */   protected final int frames;
/*    */   protected final int fpt;
/* 11 */   protected int currentTick = 0;
/* 12 */   protected int currentFrame = 0;
/*    */   
/*    */   protected ResourceLocation[] textures;
/*    */   
/*    */   public AnimatedResourceLocation(String folder, int frames, int fpt) {
/* 17 */     this(folder, frames, fpt, false);
/*    */   }
/*    */   
/*    */   public AnimatedResourceLocation(String folder, int frames, int fpt, boolean reverse) {
/* 21 */     this.folder = folder;
/* 22 */     this.frames = frames;
/* 23 */     this.fpt = fpt;
/* 24 */     this.textures = new ResourceLocation[frames];
/*    */     
/* 26 */     for (int i = 0; i < frames; i++) {
/* 27 */       if (reverse) {
/* 28 */         this.textures[i] = new ResourceLocation(String.valueOf(folder) + "/" + (this.textures.length - i) + ".png");
/*    */       } else {
/*    */         
/* 31 */         this.textures[i] = new ResourceLocation(String.valueOf(folder) + "/" + i + ".png");
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getTexture() {
/* 38 */     return this.textures[this.currentFrame];
/*    */   }
/*    */   
/*    */   public int getCurrentFrame() {
/* 42 */     return this.currentFrame;
/*    */   }
/*    */   
/*    */   public void update() {
/* 46 */     if (this.currentTick > this.fpt) {
/* 47 */       this.currentTick = 0;
/* 48 */       this.currentFrame++;
/* 49 */       if (this.currentFrame > this.frames - 1) {
/* 50 */         this.currentFrame = 0;
/*    */       }
/*    */     } 
/* 53 */     this.currentTick++;
/*    */   }
/*    */   
/*    */   public void setCurrentFrame(int currentFrame) {
/* 57 */     this.currentFrame = currentFrame;
/*    */   }
/*    */   
/*    */   public int getFrames() {
/* 61 */     return this.frames;
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcor\\utils\AnimatedResourceLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */