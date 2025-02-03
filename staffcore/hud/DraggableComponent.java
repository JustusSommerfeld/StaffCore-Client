/*    */ package staffcore.hud;
/*    */ 
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import org.lwjgl.input.Mouse;
/*    */ 
/*    */ 
/*    */ public class DraggableComponent
/*    */ {
/*    */   private int x;
/*    */   private int y;
/*    */   private int width;
/*    */   private int height;
/*    */   private int color;
/*    */   private int lastX;
/*    */   private int lastY;
/*    */   private boolean dragging;
/*    */   
/*    */   public DraggableComponent(int x, int y, int width, int height, int color) {
/* 19 */     this.width = width;
/* 20 */     this.height = height;
/* 21 */     this.x = x;
/* 22 */     this.y = y;
/* 23 */     this.color = color;
/*    */   }
/*    */   
/*    */   public int getxPosition() {
/* 27 */     return this.x;
/*    */   }
/*    */   
/*    */   public int getyPosition() {
/* 31 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setxPosition(int x) {
/* 35 */     this.x = x;
/*    */   }
/*    */   
/*    */   public void setyPosition(int y) {
/* 39 */     this.y = y;
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 43 */     return this.height;
/*    */   }
/*    */   
/*    */   public int getWidth() {
/* 47 */     return this.width;
/*    */   }
/*    */   
/*    */   public int getColor() {
/* 51 */     return this.color;
/*    */   }
/*    */   
/*    */   public void setColor(int color) {
/* 55 */     this.color = color;
/*    */   }
/*    */   
/*    */   public void draw(int mouseX, int mouseY) {
/* 59 */     draggingFix(mouseX, mouseY);
/* 60 */     Gui.drawRect(getxPosition(), getyPosition(), getxPosition() + getWidth(), getyPosition() + getHeight(), getColor());
/* 61 */     boolean mouseOverX = (mouseX >= getxPosition() && mouseX <= getxPosition() + getWidth());
/* 62 */     boolean mouseOverY = (mouseY >= getyPosition() && mouseY <= getyPosition() + getHeight());
/* 63 */     if (mouseOverX && mouseOverY && 
/* 64 */       Mouse.isButtonDown(0) && 
/* 65 */       !this.dragging) {
/* 66 */       this.lastX = this.x - mouseX;
/* 67 */       this.lastY = this.y - mouseY;
/* 68 */       this.dragging = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void draggingFix(int mouseX, int mouseY) {
/* 75 */     if (this.dragging) {
/* 76 */       this.x = mouseX + this.lastX;
/* 77 */       this.y = mouseY + this.lastY;
/* 78 */       if (!Mouse.isButtonDown(0)) this.dragging = false; 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\hud\DraggableComponent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */