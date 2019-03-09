//const serviceUrl = "http://wxmini.baixingliangfan.cn/baixing/"; //此端口针对于正版用户开放，可自行fiddle获取。
const serviceUrl = "https://wxmini.baixingliangfan.cn/baixing/"; //此端口针对于正版用户开放，可自行fiddle获取。
const servicePath = {
  'homePageContext': serviceUrl+'wxmini/homePageContent', // 商家首页信息
  'homePageBelowConten': serviceUrl + 'wxmini/homePageBelowConten', //商城首页热卖商品拉取
  'getCategory': serviceUrl + 'wxmini/getCategory', //获得商品类别信息
  'getMallGoods':serviceUrl + 'wxmini/getMallGoods', //分类商品列表获取

    "shopGoodsDetailImg" :"https://wxmini.baixingliangfan.cn/baixing/wxmini/getGoodDetailById/" //商品详情
};
