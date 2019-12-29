# Huluwa Battle
## 〇、序：配置说明
Project SDK: 1.8(java version "1.8.0_231")  
Project Language Level: >= 8  
Dependencies:   
![Dependencies](./Dependencies.png)

## 一、游戏介绍
### 1. 界面
游戏界面分为3个版块。主版块显示游戏画面。下方版块显示操作说明。右侧版块显示游戏运行动态和战斗日志。

### 2. 单位
游戏中的单位有生物(Creature)和弹道(Trajectory)两大类。Creature衍生出Good和Bad两个类，即两大阵营，再由这两个类衍生出各个具体角色。Creature由Generator产生。Trajectory类代表了生物的攻击行为，由TrajectoryFactory产生，除爷爷(Grandpa)之外每个生物内部都有一个TrajectoryFactory，因为根据设定爷爷没有攻击行为。
下表列出了各个生物体的属性及默认值。可在attributes.xml文件中对属性值进行修改。

Creature | Parent class | Maximum health | Damage | Converging Bonus | Trajectory | Remarks
-|-|-|-|-|-|-
Huluwa | Good | 100 | 24 | 0.20 | HuluwaTrajectory | Melee. Fight against Scorpion and Creep.
Grandpa | Good | 100 | 10 | 0.10 | - | Can't attack. Provide 10% damage bonus for Huluwa if alive. Try to dodge Snake's attack.
Scorpion | Bad | 150 | 20 | 0.15 | ScorpionTrajectory | Melee. Tanky. Fight against Huluwa.
Creep | Bad | 100 | 10 | 0.10 | CreepTrajectory | Melee. Fight against Huluwa.
Snake | Bad | 100 | 50 | 0.10 | SnakeTrajectory | Long-range. Especially hunt Grandpa.

### 3. 伤害计算
1) 蛇精对爷爷的攻击造成等于蛇精Damage的纯粹伤害。
2) 葫芦娃和蝎子精小喽啰之间的交锋造成的伤害按如下方式计算：
khkjhk

### 4. 操作  
1) I. 初始化战斗。将所有生物以满血状态布置到战斗场地上。战场左侧为Good阵营，右侧为Bad阵营。葫芦娃们和蝎子精带领着的小喽啰们分别以8种阵型中的随机一种列阵，朝向相对。爷爷和蛇精分别在各自阵营的大后方。正在战斗和正在回放时无法初始化。
2) Space. 开始战斗。当且仅当战斗已经初始化之后才能开始。战斗期间无法进行其他操作。任意一方获胜时战斗自动结束。
3) S. 保存战斗。当且仅当战斗结束之后才能保存。默认保存至save目录下的.hlwb(Huluwa Battle file)文件。
4) L. 加载战斗。只要不在进行战斗且不在进行回放就可以加载。读取.hlwb文件，然后自动开始回放。

### 5. 规则
战斗场地(Ground)由16x23的格子(Position)组成，一个格子仅能容纳一个活体生物，可以容纳多个生物尸体。即活体生物有碰撞体积，尸体没有碰撞体积。葫芦娃、蝎子精和小喽啰可以在整个场地内移动，爷爷和蛇精只能在他们初始的列里上下移动，相恨相杀。葫芦娃、蝎子精和小喽啰是战斗的主体；爷爷是光环怪，给葫芦娃攻击力加成（类似于复仇之魂的被动），没有攻击能力，被蛇精追杀，全程都在躲避蛇精的攻击；蛇精对爷爷发动密集的追踪攻击，在默认设置下需要且仅需2次攻击即可击杀爷爷。当葫芦娃全部阵亡时，Bad阵营获胜；当蝎子精和小喽啰全部阵亡时，Good阵营获胜。（在代码中已经避免了同归于尽的情况）
