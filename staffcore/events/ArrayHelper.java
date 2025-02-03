/*     */ package staffcore.events;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayHelper<T>
/*     */   implements Iterable<T>
/*     */ {
/*     */   private T[] elements;
/*     */   
/*     */   public ArrayHelper(Object[] array) {
/*  16 */     this.elements = (T[])array;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayHelper() {
/*  21 */     this.elements = (T[])new Object[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(T t) {
/*  26 */     if (t != null) {
/*  27 */       Object[] array = new Object[size() + 1];
/*     */       
/*  29 */       for (int i = 0; i < array.length; i++) {
/*  30 */         if (i < size()) {
/*  31 */           array[i] = get(i);
/*     */         } else {
/*  33 */           array[i] = t;
/*     */         } 
/*     */       } 
/*     */       
/*  37 */       set((T[])array);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(T t) {
/*     */     Object[] array;
/*  45 */     for (int lenght = (array = (Object[])array()).length, i = 0; i < lenght; i++) {
/*  46 */       T entry = (T)array[i];
/*  47 */       if (entry.equals(t)) {
/*  48 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  52 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(T t) {
/*  57 */     if (contains(t)) {
/*  58 */       Object[] array = new Object[size() - 1];
/*  59 */       boolean b = true;
/*     */       
/*  61 */       for (int i = 0; i < size(); i++) {
/*  62 */         if (b && get(i).equals(t)) {
/*  63 */           b = false;
/*     */         } else {
/*  65 */           array[b ? i : (i - 1)] = get(i);
/*     */         } 
/*     */       } 
/*     */       
/*  69 */       set((T[])array);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public T[] array() {
/*  75 */     return this.elements;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  80 */     return (array()).length;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Object[] array) {
/*  85 */     this.elements = (T[])array;
/*     */   }
/*     */ 
/*     */   
/*     */   public T get(int index) {
/*  90 */     return array()[index];
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  95 */     this.elements = (T[])new Object[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 100 */     return (size() == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<T> iterator() {
/* 106 */     return new Iterator<T>()
/*     */       {
/* 108 */         private int index = 0;
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hasNext() {
/* 113 */           return (this.index < ArrayHelper.this.size() && ArrayHelper.this.get(this.index) != null);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public T next() {
/* 119 */           return ArrayHelper.this.get(this.index++);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void remove() {
/* 125 */           ArrayHelper.this.remove(ArrayHelper.this.get(this.index));
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\events\ArrayHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */