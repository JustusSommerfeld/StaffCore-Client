/*     */ package staffcore.events;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EventManager
/*     */ {
/*     */   public static void register(Object o) {
/*     */     byte b;
/*     */     int i;
/*     */     Method[] arrayOfMethod;
/*  19 */     for (i = (arrayOfMethod = o.getClass().getDeclaredMethods()).length, b = 0; b < i; ) { Method method = arrayOfMethod[b];
/*  20 */       if (!isMethodBad(method))
/*  21 */         register(method, o); 
/*     */       b++; }
/*     */   
/*     */   } public static void register(Object o, Class<? extends Event> clazz) {
/*     */     byte b;
/*     */     int i;
/*     */     Method[] arrayOfMethod;
/*  28 */     for (i = (arrayOfMethod = o.getClass().getDeclaredMethods()).length, b = 0; b < i; ) { Method method = arrayOfMethod[b];
/*  29 */       if (!isMethodBad(method, clazz)) {
/*  30 */         register(method, o);
/*     */       }
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   private static void register(Method method, Object o) {
/*  37 */     Class<?> clazz = method.getParameterTypes()[0];
/*  38 */     Data methodData = new Data(o, method, ((EventTarget)method.<EventTarget>getAnnotation(EventTarget.class)).value());
/*     */     
/*  40 */     if (!methodData.target.isAccessible()) {
/*  41 */       methodData.target.setAccessible(true);
/*     */     }
/*     */     
/*  44 */     if (REGISTRY_MAP.containsKey(clazz)) {
/*  45 */       if (!((ArrayHelper<Data>)REGISTRY_MAP.get(clazz)).contains(methodData)) {
/*  46 */         ((ArrayHelper<Data>)REGISTRY_MAP.get(clazz)).add(methodData);
/*  47 */         sortListValue((Class)clazz);
/*     */       } 
/*     */     } else {
/*  50 */       REGISTRY_MAP.put(clazz, new ArrayHelper<Data>(methodData)
/*     */           {
/*     */           
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unregister(Object o) {
/*  61 */     for (ArrayHelper<Data> flexibalArray : REGISTRY_MAP.values()) {
/*  62 */       for (Data methodData : flexibalArray) {
/*  63 */         if (methodData.source.equals(o)) {
/*  64 */           flexibalArray.remove(methodData);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  69 */     cleanMap(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void unregister(Object o, Class<? extends Event> clazz) {
/*  74 */     if (REGISTRY_MAP.containsKey(clazz)) {
/*  75 */       for (Data methodData : REGISTRY_MAP.get(clazz)) {
/*  76 */         if (methodData.source.equals(o)) {
/*  77 */           ((ArrayHelper<Data>)REGISTRY_MAP.get(clazz)).remove(methodData);
/*     */         }
/*     */       } 
/*     */       
/*  81 */       cleanMap(true);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void cleanMap(boolean b) {
/*  88 */     Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> iterator = REGISTRY_MAP.entrySet().iterator();
/*     */     
/*  90 */     while (iterator.hasNext()) {
/*  91 */       if (!b || ((ArrayHelper)((Map.Entry)iterator.next()).getValue()).isEmpty()) {
/*  92 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removeEnty(Class<? extends Event> clazz) {
/*  99 */     Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> iterator = REGISTRY_MAP.entrySet().iterator();
/*     */     
/* 101 */     while (iterator.hasNext()) {
/* 102 */       if (((Class)((Map.Entry)iterator.next()).getKey()).equals(clazz)) {
/* 103 */         iterator.remove();
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void sortListValue(Class<? extends Event> clazz) {
/* 111 */     ArrayHelper<Data> flexibleArray = new ArrayHelper<>(); byte b; int i;
/*     */     byte[] arrayOfByte;
/* 113 */     for (i = (arrayOfByte = Priority.VALUE_ARRAY).length, b = 0; b < i; ) { byte b1 = arrayOfByte[b];
/* 114 */       for (Data methodData : REGISTRY_MAP.get(clazz)) {
/* 115 */         if (methodData.priority == b1) {
/* 116 */           flexibleArray.add(methodData);
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */     
/* 121 */     REGISTRY_MAP.put(clazz, flexibleArray);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isMethodBad(Method method) {
/* 126 */     return !((method.getParameterTypes()).length == 1 && method.isAnnotationPresent((Class)EventTarget.class));
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isMethodBad(Method method, Class<? extends Event> clazz) {
/* 131 */     return !(!isMethodBad(method) && !method.getParameterTypes()[0].equals(clazz));
/*     */   }
/*     */ 
/*     */   
/*     */   public static ArrayHelper<Data> get(Class<? extends Event> clazz) {
/* 136 */     return REGISTRY_MAP.get(clazz);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void shutdown() {
/* 141 */     REGISTRY_MAP.clear();
/*     */   }
/*     */ 
/*     */   
/* 145 */   private static final Map<Class<? extends Event>, ArrayHelper<Data>> REGISTRY_MAP = new HashMap<>();
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcore\events\EventManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */