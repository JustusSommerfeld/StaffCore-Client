/*    */ package staffcore.events;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class Event
/*    */ {
/*    */   private boolean cancelled;
/*    */   
/*    */   public enum State
/*    */   {
/* 37 */     PRE("PRE", 0),
/*    */     
/* 39 */     POST("POST", 1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Event call() {
/* 48 */     this.cancelled = false;
/* 49 */     call(this);
/* 50 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCancelled() {
/* 55 */     return this.cancelled;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCancelled(boolean cancelled) {
/* 60 */     this.cancelled = cancelled;
/*    */   }
/*    */ 
/*    */   
/*    */   private static final void call(Event event) {
/* 65 */     ArrayHelper<Data> dataList = EventManager.get((Class)event.getClass());
/*    */     
/* 67 */     if (dataList != null)
/* 68 */       for (Data data : dataList) {
/*    */         
/*    */         try {
/* 71 */           data.target.invoke(data.source, new Object[] { event });
/* 72 */         } catch (IllegalAccessException e) {
/* 73 */           e.printStackTrace();
/* 74 */         } catch (InvocationTargetException e) {
/* 75 */           e.printStackTrace();
/*    */         } 
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\events\Event.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */