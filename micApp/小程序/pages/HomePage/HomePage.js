// pages/index1/index1.js
var zhenzisms = require('../../utils/zhenzisms.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
      phoneNumber: "15285615707",
      location:"",
      name:"",
  },
  

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  },

  goBlueTooth(){
      wx.navigateTo({
        url: 'pages/BlueTooth/BlueTooth',
      })

  },

  onCall(){
      wx.makePhoneCall({
        phoneNumber: this.data.phoneNumber,
      })

      let phone=['13515109712']
      for(let i=0;i<phone.length;i++){
        wx.cloud.callFunction({
          name:"sendMessage",    //这个名字要跟上传并部署的那个文件名一样
          data:{
            name:phone[i]
          }
        }).then(res=>{
              console.log("发送成功",res);
        }).catch(err=>{
            console.log("发送失败",err);
        })
      }

  }
})