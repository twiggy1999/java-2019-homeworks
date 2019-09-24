我建立了一个类：Huluwa，其有两个属性：color 和 order, 及三种方法：setID, getColor, getOrder

然后构造两个枚举：Color和Order，且我们可以根据每个葫芦娃对象的color或order属性来获得其在枚举中的index，而这个index用来表明其在七兄弟中的出生次序。

运用这个可得到的次序，我们可以对随机站列的七兄弟进行排序：

    randomSort函数：先创造一个0~6的随机list，分别随机代表七兄弟的初始位置。

    1. Bubble Sort：
        根据葫芦娃对象的出生次序（即Order枚举中的index）对位排序的比较对象，就能对七兄弟重新排序

    2. Binary Sort：
        根据葫芦娃对象的出生次序（即Color枚举中的index）对位排序的比较对象，就能对七兄弟重新排序
    
DEMO
===========================

###########环境依赖
node v0.10.28+
redIs ~

###########部署步骤
1. 添加系统环境变量
    export $PORTAL_VERSION="production" // production, test, dev


2. npm install  //安装node运行环境

3. gulp build   //前端编译

4. 启动两个配置(已forever为例)
    eg: forever start app-service.js
        forever start logger-service.js


###########目录结构描述
├── Readme.md                   // help
├── app                         // 应用
├── config                      // 配置
│   ├── default.json
│   ├── dev.json                // 开发环境
│   ├── experiment.json         // 实验
│   ├── index.js                // 配置控制
│   ├── local.json              // 本地
│   ├── production.json         // 生产环境
│   └── test.json               // 测试环境
├── data
├── doc                         // 文档
├── environment
├── gulpfile.js
├── locales
├── logger-service.js           // 启动日志配置
├── node_modules
├── package.json
├── app-service.js              // 启动应用配置
├── static                      // web静态资源加载
│   └── initjson
│       └── config.js         // 提供给前端的配置
├── test
├── test-service.js
└── tools



###########V1.0.0 版本内容更新
1. 新功能     aaaaaaaaa
2. 新功能     bbbbbbbbb
3. 新功能     ccccccccc
4. 新功能     ddddddddd
