/*     */ package staffcore.utils;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiMultiplayer;
/*     */ import net.minecraft.client.gui.GuiOptions;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiSelectWorld;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.entity.RenderEntityItem;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import staffcore.Client;
/*     */ import staffcore.DiscordRP;
/*     */ import staffcore.cosmetics.CosmeticDragonWings;
/*     */ import staffcore.cosmetics.CosmeticEasterEggs;
/*     */ import staffcore.gui.CosmeticScreen;
/*     */ import staffcore.gui.EditColorScreen;
/*     */ import staffcore.gui.GuiMultiplayerIngame;
/*     */ import staffcore.gui.ModScreen;
/*     */ import staffcore.gui.OptionsScreen;
/*     */ import staffcore.hud.mod.HudMod;
/*     */ import staffcore.hud.mod.impl.CoordsMod;
/*     */ import staffcore.hud.mod.impl.FPSMod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImageButton
/*     */ {
/*     */   protected ResourceLocation image;
/*     */   protected int x;
/*     */   protected int y;
/*     */   protected int width;
/*     */   protected int height;
/*  35 */   protected int ani = 0;
/*     */   
/*     */   protected int target;
/*     */   protected String description;
/*     */   
/*     */   public ImageButton(ResourceLocation image, int x, int y, int width, int height, String description, int target) {
/*  41 */     this.image = image;
/*  42 */     this.x = x;
/*  43 */     this.y = y;
/*  44 */     this.width = width;
/*  45 */     this.height = height;
/*  46 */     this.description = description;
/*  47 */     this.target = target;
/*  48 */     this.mc = Minecraft.getMinecraft();
/*     */   }
/*     */   protected Minecraft mc; public HudMod m;
/*     */   
/*     */   public void draw(int mouseX, int mouseY, Color c) {
/*  53 */     hoverAnimation(mouseX, mouseY);
/*  54 */     if (this.ani > 0) {
/*  55 */       RenderUtil.instance.draw2DImage(this.image, this.x - this.ani, this.y - this.ani, this.width + this.ani * 2, this.height + this.ani * 2, c);
/*  56 */       double d = this.mc.fontRendererObj.getStringWidth(this.description);
/*     */     }
/*     */     else {
/*     */       
/*  60 */       RenderUtil.instance.draw2DImage(this.image, this.x, this.y, this.width, this.height, c);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onClick(int mouseX, int mouseY) {
/*  66 */     if (isHovered(mouseX, mouseY)) {
/*     */ 
/*     */       
/*  69 */       if (this.target == 88)
/*  70 */         this.mc.shutdown(); 
/*  71 */       if (this.target == 89)
/*  72 */         this.mc.displayGuiScreen((GuiScreen)new GuiOptions(this.mc.currentScreen, this.mc.gameSettings)); 
/*  73 */       if (this.target == 90)
/*  74 */         this.mc.displayGuiScreen((GuiScreen)new GuiSelectWorld(this.mc.currentScreen)); 
/*  75 */       if (this.target == 91) {
/*  76 */         this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer(this.mc.currentScreen));
/*     */       }
/*     */       
/*  79 */       if (this.target == 1)
/*  80 */         this.mc.displayGuiScreen((GuiScreen)new OptionsScreen()); 
/*  81 */       if (this.target == 2)
/*  82 */         this.mc.displayGuiScreen((GuiScreen)new CosmeticScreen()); 
/*  83 */       if (this.target == 3)
/*  84 */         this.mc.displayGuiScreen((GuiScreen)new ModScreen()); 
/*  85 */       if (this.target == 4)
/*  86 */         this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayerIngame()); 
/*  87 */       if (this.target == 5)
/*  88 */         this.mc.displayGuiScreen(null); 
/*  89 */       if (this.target == 17) {
/*  90 */         this.mc.displayGuiScreen((GuiScreen)new EditColorScreen());
/*     */       }
/*     */       
/*  93 */       if (this.target == 6)
/*  94 */         (Client.getInstance()).hudManager.fullbright.toggle(); 
/*  95 */       if (this.target == 8)
/*  96 */         if (ItemRenderer.leftHand) {
/*  97 */           ItemRenderer.leftHand = false;
/*     */         } else {
/*  99 */           ItemRenderer.leftHand = true;
/*     */         }  
/* 101 */       if (this.target == 14)
/* 102 */         if (DiscordRP.discordrp) {
/* 103 */           Client.getInstance().getDiscordRP().shutdown();
/*     */         } else {
/* 105 */           DiscordRP.discordrp = true;
/* 106 */           Client.getInstance().getDiscordRP().start();
/*     */         }  
/* 108 */       if (this.target == 18) {
/* 109 */         if (RenderEntityItem.itemphysics) {
/* 110 */           RenderEntityItem.itemphysics = false;
/*     */         } else {
/* 112 */           RenderEntityItem.itemphysics = true;
/*     */         } 
/*     */       }
/*     */       
/* 116 */       if (this.target == 13) {
/* 117 */         if (FPSMod.fpsrainbow) {
/* 118 */           FPSMod.fpsrainbow = false;
/* 119 */           FPSMod.blue = true;
/* 120 */           FPSMod.green = false;
/* 121 */           FPSMod.red = false;
/* 122 */         } else if (FPSMod.blue) {
/* 123 */           FPSMod.fpsrainbow = false;
/* 124 */           FPSMod.blue = false;
/* 125 */           FPSMod.green = true;
/* 126 */           FPSMod.red = false;
/* 127 */         } else if (FPSMod.green) {
/* 128 */           FPSMod.fpsrainbow = false;
/* 129 */           FPSMod.blue = false;
/* 130 */           FPSMod.green = false;
/* 131 */           FPSMod.red = true;
/* 132 */         } else if (FPSMod.red) {
/* 133 */           FPSMod.fpsrainbow = false;
/* 134 */           FPSMod.blue = false;
/* 135 */           FPSMod.green = false;
/* 136 */           FPSMod.red = false;
/*     */         } else {
/* 138 */           FPSMod.fpsrainbow = true;
/* 139 */           FPSMod.blue = false;
/* 140 */           FPSMod.green = false;
/* 141 */           FPSMod.red = false;
/*     */         } 
/*     */       }
/* 144 */       if (this.target == 19) {
/* 145 */         if (CoordsMod.crainbow1) {
/* 146 */           CoordsMod.crainbow1 = false;
/* 147 */           CoordsMod.blue1 = true;
/* 148 */           CoordsMod.green1 = false;
/* 149 */           CoordsMod.red1 = false;
/* 150 */         } else if (CoordsMod.blue1) {
/* 151 */           CoordsMod.crainbow1 = false;
/* 152 */           CoordsMod.blue1 = false;
/* 153 */           CoordsMod.green1 = true;
/* 154 */           CoordsMod.red1 = false;
/* 155 */         } else if (CoordsMod.green1) {
/* 156 */           CoordsMod.crainbow1 = false;
/* 157 */           CoordsMod.blue1 = false;
/* 158 */           CoordsMod.green1 = false;
/* 159 */           CoordsMod.red1 = true;
/* 160 */         } else if (CoordsMod.red1) {
/* 161 */           CoordsMod.crainbow1 = false;
/* 162 */           CoordsMod.blue1 = false;
/* 163 */           CoordsMod.green1 = false;
/* 164 */           CoordsMod.red1 = false;
/*     */         } else {
/* 166 */           CoordsMod.crainbow1 = true;
/* 167 */           CoordsMod.blue1 = false;
/* 168 */           CoordsMod.green1 = false;
/* 169 */           CoordsMod.red1 = false;
/*     */         } 
/*     */       }
/*     */       
/* 173 */       if (this.target == 7) {
/* 174 */         (Client.getInstance()).hudManager.fps.toggle();
/*     */       }
/* 176 */       if (this.target == 9) {
/* 177 */         (Client.getInstance()).hudManager.keystrokes.toggle();
/*     */       }
/* 179 */       if (this.target == 11) {
/* 180 */         (Client.getInstance()).hudManager.cm.toggle();
/*     */       }
/* 182 */       if (this.target == 12) {
/* 183 */         (Client.getInstance()).hudManager.targethud.toggle();
/*     */       }
/*     */       
/* 186 */       if (this.target == 10) {
/* 187 */         Client.getInstance().getCapeManager().removeCape(this.mc.thePlayer.getUniqueID().toString());
/*     */       }
/* 189 */       if (this.target == 15) {
/* 190 */         if (CosmeticDragonWings.active) {
/* 191 */           CosmeticDragonWings.active = false;
/*     */         } else {
/* 193 */           CosmeticDragonWings.active = true;
/*     */         } 
/*     */       }
/* 196 */       if (this.target == 16) {
/* 197 */         if (CosmeticEasterEggs.active) {
/* 198 */           CosmeticEasterEggs.active = false;
/*     */         } else {
/* 200 */           CosmeticEasterEggs.active = true;
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverAnimation(int mouseX, int mouseY) {
/* 208 */     if (isHovered(mouseX, mouseY)) {
/* 209 */       if (this.ani < 5) {
/* 210 */         this.ani++;
/*     */       }
/* 212 */     } else if (this.ani > 0) {
/* 213 */       this.ani--;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean isHovered(int mouseX, int mouseY) {
/* 218 */     return RenderUtil.instance.isHovered(this.x, this.y, (this.x + this.width), (this.y + this.height), mouseX, mouseY);
/*     */   }
/*     */ }


/* Location:              C:\Users\justu\AppData\Roaming\.minecraft\versions\StaffCoreClient\StaffCoreClient.jar!\staffcor\\utils\ImageButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */