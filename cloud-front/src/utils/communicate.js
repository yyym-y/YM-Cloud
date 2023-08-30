import axios from "axios";

// 获取左侧菜单栏信息， 需携带用户的ID
export async function getSecondMenuInfos(userId) {
    console.log(userId)
    await axios.get("https://yapi.pro/mock/44512/yyym/menu")
        .then(result => {
            if(result.data.code != 0){
                console.log(result.data.data)
                return result.data.data
            }
        })
}