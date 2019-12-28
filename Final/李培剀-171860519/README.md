# Huluwa Battle
## 游戏介绍
### 1. 界面
游戏界面分为3个版块。主版块显示游戏画面。下方版块显示操作说明。右侧版块显示游戏运行动态和战斗日志。
### 2. 单位
游戏中的单位有生物(Creature)和弹道(Trajectory)两大类。Creature衍生出Good和Bad两个类，即两大阵营，再由这两个类衍生出各个具体角色。Creature由Generator产生。Trajectory类代表了生物的攻击行为，由TrajectoryFactory产生，除爷爷(Grandpa)之外每个生物内部都有一个TrajectoryFactory，因为根据设定爷爷没有攻击行为。
下表列出了各个生物体的属性及默认值：
Creature | Parent class | Maximum health | Damage | Converging Bonus | Trajectory | Remarks
-|-|-|-|-|-|-
Huluwa | Good | 100 | 24 | 0.20 | HuluwaTrajectory | Melee. Fight against Scorpion and Creep.
Grandpa | Good | 100 | 10 | 0.10 | - | Can't attack. Provide 10% damage bonus for Huluwa if alive. Try to dodge Snake's attack.
Scorpion | Bad | 150 | 20 | 0.15 | ScorpionTrajectory | Melee. Tanky. Fight against Huluwa.
Creep | Bad | 100 | 10 | 0.10 | CreepTrajectory | Melee. Fight against Huluwa.
Snake | Bad | 100 | 50 | 0.10 | SnakeTrajectory | Long-range. Especially hunt Grandpa.

### 3. 操作  
1) I。初始化游戏。将所有生物以满血状态布置到战斗场地上。
