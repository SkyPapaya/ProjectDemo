// 云函数入口文件
const cloud = require('wx-server-sdk')
 
cloud.init({
  env:cloud.DYNAMIC_CURRENT_ENV
})
 
// 云函数入口函数
exports.main = async (event, context) => {
  console.log(event);
  console.log(context);
  try {
    const result = await cloud.openapi.cloudbase.sendMessage({
      env: 'cloud1-2gv8lm5235cb6957',//在云开发控制台中的环境ID
      content: '有内奸！！！停止交易', //短信内容
      phoneNumberList: [
       '15285615707'  //要发送的手机号码，我这是方法中传过来的号码，可以先写死测试
      ]
    })
    return result
  } catch (err) {
    return err
  }
}