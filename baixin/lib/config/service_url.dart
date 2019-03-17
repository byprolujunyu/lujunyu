const serviceUrl =
    "https://wxmini.baixingliangfan.cn/baixing/"; //此端口针对于正版用户开放，可自行fiddle获取。
const servicePath = {
  'homePageContext': serviceUrl + 'wxmini/homePageContent', // 商家首页信息
  'homePageBelowConten': serviceUrl + 'wxmini/homePageBelowConten', //商城首页热卖商品拉取
  'getCategory': serviceUrl + 'wxmini/getCategory', //获得商品类别信息
  'getMallGoods': serviceUrl + 'wxmini/getMallGoods', //分类商品列表获取
  "shopGoodsDetailImg": serviceUrl + "wxmini/getGoodDetailById/", //商品详情
  'searachGoods': serviceUrl+ "wxmini/searchGoods", //商品搜索接口
  'integralGoodsShops':serviceUrl+'wxmini/integralGoodsShops',//门店信息列表接口
  'shopInfoDetail':serviceUrl + "wxmini/integralGoods",//门店信息详情接口
  'ada':serviceUrl+'wxmini/getHomePageTip',//广告页
};
