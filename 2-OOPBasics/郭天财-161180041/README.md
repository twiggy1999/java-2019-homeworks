#####葫芦娃类CalabashBoy
![CalabashBoy]("/image/CalabashBoy.png")

#####地砖类Tile
![Tile]("/image/Tile.png")
然后构造两个枚举：Color和Order，且我们可以根据每个葫芦娃对象的color或order属性来获得其在枚举中的index，而这个index用来表明其在七兄弟中的出生次序。

运用这个可得到的次序，我们可以对随机站列的七兄弟进行排序：

    randomSort函数：先创造一个0~6的随机list，分别随机代表七兄弟的初始位置。

    1. Bubble Sort：
        根据葫芦娃对象的出生次序（即Order枚举中的index）对位排序的比较对象，就能对七兄弟重新排序

    2. Binary Sort：
        根据葫芦娃对象的出生次序（即Color枚举中的index）对位排序的比较对象，就能对七兄弟重新排序
    

