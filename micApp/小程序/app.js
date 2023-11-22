App({
  onLaunch:function(){
    wx.cloud.init({
      env:'cloud1-2gv8lm5235cb6957',
      traceUser:true
    })
  },
  globalData: {},
  onPullDownRefresh:function(){
    this.onRefresh();
  },
onRefresh:function(){
    //导航条加载动画
    wx.showNavigationBarLoading();
    setTimeout(function () {
      wx.hideNavigationBarLoading();
      //停止下拉刷新
      wx.stopPullDownRefresh();
    }, 2000);
  },
})