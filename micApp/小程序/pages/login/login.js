
Page({
  data:{
   zhanghao:'666666',
   mima:'666666'
  },
  getzhh(event){
   //console.log(event.detail.value)
   this.setData({
     zhanghao:event.detail.value
   })
  },
  getmima(event){
    this.setData({
      mima:event.detail.value
    })
  },

  //登录逻辑，密码账号z'na'chznach
  denglu(){
    let zhanghao=this.data.zhanghao
    let mima=this.data.mima
    //console.log(zhanghao)
    if(zhanghao == this.data.mima && mima == this.data.zhanghao){
        wx.navigateTo({
          url: '/pages/HomePage/HomePage',
        })
    }
  
   //登陆
//    wx.cloud.database().collection('user').where({
//      zhanghao:zhanghao,
//    }).get({
//      success(res){
//        console.log("获取数据成功",res)
//        let user=res.data[0]
//        console.log("user",user)
//        if(mima==user.mima){
//          console.log('登录成功')
//         wx.navigateTo({
//           url: '/pages/HomePage/HomePage.js',

//         })
//         wx.reLaunch({
//           url: '../me/me'
//         })
//         wx.setStorageSync('chuancan', user.name),
//         //保存用户信息
//         wx.setStorageSync('user', user)
//        }else{
//          console.log('登录失败')
//          wx.showToast({
//           title: '账号或密码错误',
//           icon:'none'
//         })
//        }
//      },
//      fail(res){
//        console.log("获取数据失败",res)
//      }
//    })
  }

  
})