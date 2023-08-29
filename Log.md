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

