# 开发日志 / Log





> 2023 - 8 - 29

发现了使用 vh， vw 时缩放的时候会发生严重错位，准备着手修改

* 根据设计原稿将所有的长度等比例缩放0.7，并且全部替换为px， 真是个耗时间又无聊的工作...



解决父组件传递路径参数子组件404或者无法解析模型的问题

* 正确做法如下：

  > 父组件数据：
  >
  > ```vue
  > data() {
  >         return {
  >             info : [
  >                 {
  >                     "imgSrc" : require('@/assets/ABC.png'),
  >                     "name" : "Vocabulary",
  >                     "openImgSrc" : require('@/assets/ABC-colored.png'),
  >                     "userKey" : 1,
  >                     "firstMenuKey" : 1
  >                 }
  >             ]
  >         }
  > }
  > ```
  >
  > `require()` 函数写在了数据里，而不是写在传参里
  >
  > ```vue
  > <div v-for="(pr, index) in info" :key="index">
  >     <firstMenu
  >                :imgSrc="pr.imgSrc" :name="pr.name" :openImgSrc="pr.openImgSrc">
  >     </firstMenu>
  > </div>
  > ```



解决左侧菜单点击时颜色发生错乱的问题

* 主要思路还是父传子然后通过父亲来控制

  > 一级菜单向儿子传递的信息的格式为 
  >
  > ```json
  > {"father" : this.firstMenuKey, "son" : keyValue, "static" : this.ifOpen}
  > ```
  >
  > 分别为一级菜单的编号， 二级菜单编号， 开闭的状态
  >
  > total-menu用lastClick来记录是谁之前被点击过，通过逻辑判断该如何操作





> 2023 - 8 - 30

对于左侧菜单栏组件耦合程度过高的问题进行了解决，将左侧菜单栏单独封装好

以后需要增加或者修改左侧菜单栏只需要对 `menu-farme.vue` 进行修改就好了

目前还没有向后端请求，只有有请求可以更加精简

* 注意 ： 封装后存在一个问题

  > 组件选项中有一个是否有二级菜单的选项，现阶段如果选择false会存在高亮的问题
  >
  > 暂时先不解决，以后再说

格式化了所有文件，将不同文件放置于对应文件夹，增加可维护性

`menu-farme.vue `数据格式为

```vue
    data(){
        return {
            info : {
                "userKey" : 1,
                "firstMenuInfos" : [
                    {
                        "imgSrc" : require('@/assets/vocabulary/ABC.png'),
                        "openImgSrc" : require('@/assets/vocabulary/ABC-colored.png'),
                        "name" : "Vocabulary",
                        "firstMenuKey" : 1,
                        "ifHaveSecondMenu" : true,
                    },
                    {
                        "imgSrc" : require('@/assets/vocabulary/ABC.png'),
                        "openImgSrc" : require('@/assets/vocabulary/ABC-colored.png'),
                        "name" : "Vocabulary",
                        "firstMenuKey" : 2,
                        "ifHaveSecondMenu" : false,
                    },
                ],
                "secondInfos" : [
                    [
                        {"secondMenuKey": 1, "name": "ALL"},
                        {"secondMenuKey": 2, "name": "四级词汇"},
                        {"secondMenuKey": 3, "name": "六级词汇"},
                        {"secondMenuKey": 4, "name": "考研词汇"}                   
                    ],
                    []
                ]
            }   
            
        }
    },
```



将背景成功移入，并且层级分明



完成了右侧顶部的菜单栏，并且实现了右侧文字随着左侧点击改变，但没有实现左侧secondMenu信息由axiaos传递的功能

使用axios 发送的时候发现没有等数据接收到就渲染，导致二级菜单为空，换成同步传输未成功





> 2023 - 8 - 31

解决了从后端接收数据但是前端无法渲染的问题，问题其实十分的简单

后端发送的数据格式为：

```json
{
    "code": 1,
    "msg": "success",
    "data": {
        "secondInfos": [
            ....
        ]
    }
}
```

而前端接收数据的方法却是 ：

```js
async created() {
        await axios.get("https://yapi.pro/mock/44512/yyym/menu")
                   .then(result => {
                        this.secondMenuInfos = result.data.data
                   })
    }
```

接收的数据为：

```json
"secondInfos": [....]
```

而 secondInfo所需要的数据格式为：

```json
[[{"secondMenuKey": 1,"name": "ALL"}],[{"secondMenuKey": 1,"name": "ALL"}]]
```

所以正确的接收方式为：

```js
async created() {
    await axios.get("https://yapi.pro/mock/44512/yyym/menu")
        .then(result => {
        this.secondMenuInfos = result.data.data.secondInfos
    })
}
```



> 2023 - 9 - 3

某种程度上我觉得自己脑子有点问题....

在配置vue-router的时候发现无论怎么跳转，都无法渲染，最后发现是view组件没有写，

补好之后解决

准备开始书写后端



晚上8点快九点...

今天写了大量后端，完成了后端基本的登录功能，同时注册的时候实现了给邮箱发送验证码，但是可能mysql语句出了点问题

但是太累了，于是决定明天再说

同时觉得对于如何处理验证码的方法有bug，玩意两个人同时注册一样的用户名，但是某人先验证完，后面的人将不会成功写入，考虑解决





> 2023 - 9 - 4

mysql问题解决，出现的问题如下：

* 从database复制下来在开头带有 `@` 
* 少了 `}`

至此， register全部完工
