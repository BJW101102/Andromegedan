# Andromegedan
This game is a recreation of the retro video game, Space Invaders, created in Java using our CSC-1351's framework, BasicGraphics. Unlike Space Invaders, Andromegedan allows the player to 
play with a horizontal view, allies occasionally spawn to help the player, and enemies all have different features. 

**Player Controls/Information:
- W/Up_Arrow: Up
- A/Left_Arrow: Left
- S/Down_Arrow: Down
- D/Right_Arrow: Right
- Spacebar: Shoots
- Health: 10hp
- Bullet Damage: 1hp

**Ally:
- Spawns in each round on the player side, shoots a single bullet randomly
- Bullet Damage: 0.5-1hp
- Hp: 5 

**Enemeny 1:
- Only Attacks when hitting the border, shoots a single bullet 
- Bullet Damage: 0.5hp
- Hp: 1
  
**Enemeny 2:
- Attacks at different times, shoots a larger bullet
- Bullet Damage: 1hp
- Hp: 1
  
**Enemeny 3:
- Shoots a bullet at the border that  gradually gains speed
- Hp: 3

** MiniBoss:
- Shoots two projectiles randomly, once at half heat spawns in two Enemeny 2's
- Bullet Damage: 1.5hp
- Hp: 10

** Boss:
- Gradually gains speed when hitting the border, and spawns in Enemeny 1,2,3 types on the impact of the border. Once health is divisible by 50, spawns in MiniBoss.
- Bullet Damage: 0hp //No Bullets from Boss
- Hp: 200




