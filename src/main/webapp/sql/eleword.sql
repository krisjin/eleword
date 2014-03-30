/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : eleword

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2014-03-31 07:47:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL auto_increment,
  `author` varchar(255) NOT NULL,
  `category_id` bigint(20) default NULL,
  `content` text NOT NULL,
  `keywords` varchar(255) default NULL,
  `modify_date` datetime default NULL,
  `post_date` datetime default NULL,
  `status` int(11) default NULL,
  `title` varchar(255) NOT NULL,
  `views` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('2', 'zhagnsan', '1', '<p style=\"text-indent:2em;\">\r\n	受益于海外投资者配置新兴市场和高科技资产高涨的需求，越来越多的中国科技公司宣布或筹划在今年启动海外上市计划。最近，京东商城递交在美上市招股书，金山网络计划从集团分拆赴美IPO，另有在线旅游服务商途牛、手游企业触控科技和乐动卓越、以在线娱乐为核心业务的天鸽集团等多家国内互联网企业被指已启动上市进程，计划在今年赴美或赴港上市。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	今年最值得期待的中国科技公司IPO仍然是<a href=\"http://stockhtm.finance.qq.com/hk/ggcx/01688.htm\" target=\"_blank\">阿里巴巴</a>。市场预期这家中国互联网巨头仍将争取今年下半年在香港上市，其估值可能高达1200亿美元。此外，爱奇艺、UC优视、蓝港在线等国内知名互联网企业也可能选择在今年IPO，不完全统计称，今年上市的中国科技企业将接近30家。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	最新上市潮与以往略有不同。过去，中国科技公司IPO主要集中于美国资本市场，而现在，香港对内地科技企业IPO的吸引力明显增强。除阿里巴巴外，市场传闻今年在港筹划上市的已包括乐动卓越、天鸽集团、科通芯城等企业。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	香港资本市场过去并非中概股的热地。除<a href=\"http://stockhtm.finance.qq.com/hk/ggcx/00700.htm\" target=\"_blank\">腾讯控股</a>、<a href=\"http://stockhtm.finance.qq.com/hk/ggcx/00992.htm\" target=\"_blank\">联想集团</a>在香港上市，阿里巴巴B2B业务曾在香港挂牌外，内地科技公司和互联网企业的IPO较多仍偏爱活跃的美国资本市场。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	但现在，多种因素让香港资本市场对国内科技公司的吸引力加大。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	首先，科技股的稀缺，使得香港证券市场投资者对相关股票更加青睐，理论上可避开同类模式公司的竞争。腾讯、博雅互动等公司在过去一年的出色表现，也增强了香港市场对优质科技类公司的投资信心和投资需求。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	其次，美国资本市场的政策风险为中概股前景蒙上不稳定因素。由于未能遵守SEC要求提供与会计造假调查相关的文件，美国法院此前处罚四大会计师事务所的中国分部6个月内不得为在美上市公司提供审计服务。虽然这一判定很可能不会正式生效，但中国政府和美国关于信息分享的分歧和争议已久，长期来看也会拖累中概股表现。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	华兴资本CEO包凡(<a href=\"http://t.qq.com/baofan#pref=qqcom.keyword\" target=\"_blank\">微博</a>)接受腾讯科技采访时曾表示，中国经济最有活力的的高科技公司只能选择在体制外的国外资本市场上市，靠体外循坏输血，处处受制于人，长期来看也会疲于应付。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	包凡认为，中国内地和香港的证券资本市场未来需要提供更好的支持，吸纳这些公司在国内上市，才能避免受到美国体制的种种桎梏——事实上，两年前当中概股在美国受到阻击时，中国和香港的交易所已经失去了一个绝好良机说服中国互联网优秀企业回归本土市场。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	不过，对于阿里巴巴这样的企业来说，倾向于在香港上市更多又是自身的特殊性：避免资本市场与经营市场脱节，公司维护成本更低；投资者更容易理解其商业模式，避免受到VIE结构和支付宝股权转让风波带来的不利影响等。\r\n</p>\r\n<div>\r\n	<img alt=\"科技公司上市去哪儿？香港美国争夺中概股\" src=\"http://img1.gtimg.com/tech/pics/hv1/246/231/1518/98767101.jpg\" /> \r\n</div>\r\n<p style=\"text-indent:2em;\">\r\n	2013年美国和香港上市科技公司概览（统计截至2014年2月12日收盘）\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	美国资本市场仍具备一定优势\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	过去的2013年，有6家中国内地科技公司成功登陆美国资本市场，另有博雅互动和云游控股两家手游公司成功在香港上市。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	腾讯科技统计整理的数据显示，去年上市时上述公司的融资能力相当，按截止昨日的收盘价计算，两地新上市公司股价较发行价的涨幅也都较为可观；不过，从市盈率来看，美国市场公司普遍要比香港高出很多。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	总的来说，未来美国依然是更多国内互联网公司上市的首选。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	香港交易所集团行政总裁李小加称，科技公司往往选择到美国上市主要是因为上市前股东普遍对美国市场比较熟悉，再加上香港对上市公司有连续三年盈利等硬性要求，不符合互联网公司上市前的普遍特征。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	很多投资机构更熟悉华尔街和上市各个流程，使得互联网公司在美国上市更为容易——驻旧金山投资人童士豪表示，对于互联网企业而言，一旦时机错过，很可能就因为资金链断裂倒在黎明前的黑暗里。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	启明创投主管合伙人甘剑平也向腾讯科技表示，虽然阿里巴巴和一些手游公司倾向于在香港上市，但美国今年的资本市场环境依然不错，制度更开放和公平，上市审批流程更快，而且众多国内外科技股也积累了丰富相关上市经验。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	况且，美国资本市场还有其他各种各样的融资工具，企业创始人在不稀释股权的前提下也能募集到后续发展资金，这对预上市企业也有很强的吸引力。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	不过，清科资本副总裁吕卓荣在接受腾讯科技采访时表示，香港证券市场也没必要做更多政策上的调整来吸引内地科技公司的加入。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<br />\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	当然可以肯定的是，无论选择在何地上市，科技公司所代表的新经济领域将成为证券市场投资重点。在博雅互动和徽商银行同一天登陆港交所时，华兴资本CEO包凡曾评论称，从交易量来看，新经济活跃，而传统经济死水一潭，这就是中国未来经济的写照。\r\n</p>', null, '2014-03-30 06:47:10', '2014-02-13 21:50:22', '0', '科技公司上市去哪里？香港美国争夺中概股', '0');
INSERT INTO `article` VALUES ('3', 'zhagnsan', '3', '<p style=\"text-indent:2em;\">\r\n	在77天的打车软件补贴大战后，嘀嘀打车交出了一份成绩单：嘀嘀打车用户从2200万增加至1亿，日均订单从35万增长至521.83万，通过微信支付的补贴达到14亿。这意味着嘀嘀每个新用户的获得成本仅为18元左右。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	过去的两个月，嘀嘀打车和快的打车上演了过山车式的补贴大战：1月初，补贴潮初涌，2月进入白热化，一周内双方交替提高补贴，但高补贴无法长期维续，3月，双方不约而同降温，进入了后补贴时代。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	在嘀嘀宣布微信支付补贴超过14亿后，快的打车对腾讯科技表示目前尚未有新的数据宣布，但双方背后巨头之间的较量仍在继续，不仅给打车软件现金支持，还开放资源和入口，比如嘀嘀接入了多款手机游戏，快的也和阿里的部分O2O业务达成合作，以提高软件的竞争力。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	事实证明，尽管补贴总价看似高昂，但单个用户的获取成本很低，唯一的问题是，当打车软件补贴大赛暂告一个段落后，还有哪些业务可以使用类似的活动快速扩张？\r\n</p>\r\n<h2 style=\"text-indent:2em;\">\r\n	补贴大战的逻辑\r\n</h2>\r\n<p style=\"text-indent:2em;\">\r\n	这场两个月的补贴大战给嘀嘀带来了一份不菲的成绩单。嘀嘀的数据显示了这种变化——1月10日，全国32个城市日均35万单；2月24日，全国120个城市日均316万单；3月28日，全国178个城市，日均521.83万单。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	用户数方面，补贴之前，嘀嘀约为2200万用户，3月27日，嘀嘀打车用户数突破1亿。嘀嘀打车在过去77天里，以日均521.83万的订单量超过了京东13.27万单、淘宝410.95万单和美团21.91万单，成为了国内最大的移动互联网日均订单交易平台。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	按照补贴14亿元，嘀嘀新增7800万用户推算，单个用户获取补贴的成本约为18元。相比较而言，目前很多移动应用推广单用户获取成本动辄已经上升到40-50元，微信支付获取用户的成本尚算适中。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	对微信支付更划算的一点是，至少培养了用户的移动支付习惯。在3月28日深圳举行的互联网金融论坛上，艾瑞金融行业研究分析师王维东表示，腾讯、阿里PK之所以如此激烈，一个核心目的就是培养用户行为习惯。互联网前15年发展过程已经证明，电子商务对于用户和在线金融服务人士具有重要意义，移动支付也是如此。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	此外，另一个受益的副产品是消解了人们对移动支付安全的担忧。在嘀嘀打车引入微信支付后，活动最开始的一周内，从嘀嘀打车的后台数据来看，80%左右的出租车司机是收到一笔车费立刻就提现，后来降成一天提现一次，现在，近90%司机每3天提现一次。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	嘀嘀的相关负责人曾解释，最开始司机不了解微信，担心这种新型支付模式的安全，后续逐步了解，对安全性的担忧减低。\r\n</p>\r\n<h2 style=\"text-indent:2em;\">\r\n	补贴大战实为入口之争\r\n</h2>\r\n<p style=\"text-indent:2em;\">\r\n	打车软件的补贴大战少不了身后腾讯和阿里支持的功劳，也让创业公司市场占有率的争夺变成大公司的入口之争，双方不断加码补贴。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	2014年初，快的打车宣布投入1亿元补贴用户的时候，或许曾未料到一场补贴大战持续上演。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	1月9日，在嘀嘀宣布融资后，嘀嘀表示将借助微信支付进行补贴用户的活动。一个月后，双方均交出了一份成绩单：\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	嘀嘀的官方数据透露，1月10日至2月9日，嘀嘀打车中平均日微信支付订单数为70万单，总微信支付订单约为2100万单，补贴总额达4亿元。活动期间，嘀嘀打车用户突破4000万，较活动前增长了一倍；日均订单为183万单，2月7日节后第一天达到峰值262万单，微信支付订单峰值过200万单。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	2月8日，快的发布的数据显示，截止到当时，日均订单量已达128万，单日最高订单量突破162万，其中使用支付宝钱包付车费的日订单数最高突破60万。\r\n</p>\r\n<h2 style=\"text-indent:2em;\">\r\n	后补贴时代迎来监管\r\n</h2>\r\n<p style=\"text-indent:2em;\">\r\n	在两家打车软件高额补贴迅速引爆市场的同时，也产生了诸多问题，比如：\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	出租车司机开始挑活儿，原本是提高打车效率的打车软件导致空车拒载的现象愈演愈烈；\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	一些乘客手机网络差或忘记支付密码；\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	打车软件后台系统处理不了爆炸式增长的用户需求信息，导致打车软件经常显示支付不成功；\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	一些司机为了奖励在驾驶途中不断抢单，行车安全无法保障，甚至违背了行驶途中不能打电话的交通法规。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	目前，双方已经主动进行补贴降温。嘀嘀从3月初连续4次进行调整随机减免的数额，从最高减20元降至3月18日立减5元。快的从3月22日零点起做出调整，北京、上海、杭州等城市保持每单立减5元、每天2单不变。其他城市的补贴金额调整为每单立减3元，每天2单。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	降低补贴也削减了用户在打车软件上的热情，但无伤大局，有司机和乘客明确表示，在补贴软件降到5元以下后，吸引力已经不大，使用打车软件打车的次数会减少，但是仍会使用打车软件。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	打车软件兴起之初，交通部门曾有政策上的干预，致使部分打车软件偃旗息鼓，最近，又有新的监管声音响起。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	3月28日，交通运输部召开2014年度第二次例行新闻发布会，交通运输部政策研究室副主任李扬在发布会上表示，出租车电召服务中，当前有些企业对使用手机打车软件的乘客和司机都给予了物质奖励，这个可能会对市场的公平性产生影响。\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<br />\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	此前，两会期间，交通运输部党组书记、部长杨传堂表示，交通运输部将会同有关部门加快研究制定规范手机召车软件发展的指导性意见，制定出租车电召服务规范化技术标准，支持和引导地级以上的城市建立出租车服务管理的信息系统。\r\n</p>', null, null, '2014-03-30 06:30:26', '0', '解密打车软件大战：巨额补贴背后的低成本扩张', '0');

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` bigint(20) NOT NULL auto_increment,
  `article_num` int(11) default NULL,
  `background` varchar(255) default NULL,
  `description` varchar(255) default NULL,
  `mail_notice` bit(1) default NULL,
  `phone_notice` bit(1) default NULL,
  `title` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '0', '240,240,244', '明月几时有-----', '', '', '爱江山更爱美人');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `priority` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '开源技术', '5');
INSERT INTO `category` VALUES ('3', '云计算研究', '1');
INSERT INTO `category` VALUES ('4', '大数据', '1');
INSERT INTO `category` VALUES ('8', '搜索引擎', '2');

-- ----------------------------
-- Table structure for `color`
-- ----------------------------
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color` (
  `id` bigint(20) NOT NULL auto_increment,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of color
-- ----------------------------
INSERT INTO `color` VALUES ('1', '255,179,167', '粉红，即浅红色。别称：妃色杨妃色湘妃色妃红色。', '粉红');
INSERT INTO `color` VALUES ('2', '237,87,54', '妃红色：古同“绯”，粉红色。杨妃色 湘妃色 粉红皆同义。', '妃色');
INSERT INTO `color` VALUES ('3', '240,0,86', '比大红浅的红色', '品红');
INSERT INTO `color` VALUES ('4', '244,121,131', '桃花的颜色，比粉红略鲜润的颜色', '桃红');
INSERT INTO `color` VALUES ('5', '219,90,107', '淡紫红色、较桃红色深一些，是非常妩媚娇艳的颜色', '海棠红');
INSERT INTO `color` VALUES ('6', '242,12,0', '石榴花的颜色，高色度和纯度的红色', '石榴红');
INSERT INTO `color` VALUES ('7', '201,55,86', '鲜红色', '樱桃色');
INSERT INTO `color` VALUES ('8', '240,86,84', '银朱和粉红色颜料配成的颜色。多用来形容有光泽的各种红色，尤指有光泽浅红', '银红');
INSERT INTO `color` VALUES ('9', '255,33,33', '正红色，三原色中的红，传统的中国红，又称绛色', '大红');
INSERT INTO `color` VALUES ('10', '140,67,86', '紫中略带红的颜色', '绛紫');
INSERT INTO `color` VALUES ('11', '200,60,35', '艳丽的深红', '绯红');
INSERT INTO `color` VALUES ('12', '157,41,51', '1，女子装扮时用的胭脂的颜色。 2，国画暗红色颜料', '胭脂');
INSERT INTO `color` VALUES ('13', '255,76,0', '朱砂的颜色，比大红活泼，也称铅朱朱色丹色', '朱红');
INSERT INTO `color` VALUES ('14', '255,78,32', '丹砂的鲜艳红色', '丹');
INSERT INTO `color` VALUES ('15', '243,83,54', '赤色', '彤');
INSERT INTO `color` VALUES ('16', '203,58,86', '茜草染的色彩，呈深红色', '茜色');
INSERT INTO `color` VALUES ('17', '255,45,81', '火焰的红色，赤色', '火红');
INSERT INTO `color` VALUES ('18', '201,31,55', '深红，火红。泛指赤色、火红色', '赫赤');
INSERT INTO `color` VALUES ('19', '239,122,130', '鲜艳的红色', '嫣红');
INSERT INTO `color` VALUES ('20', '255,0,151', '色橘红', '洋红');
INSERT INTO `color` VALUES ('21', '255,51,0', '引申为红色', '炎');
INSERT INTO `color` VALUES ('22', '195,39,43', '本义火的颜色，即红色', '赤');
INSERT INTO `color` VALUES ('23', '169,129,117', '绛色；浅绛色', '绾');
INSERT INTO `color` VALUES ('24', '195,33,54', '即深红', '枣红');
INSERT INTO `color` VALUES ('25', '179,109,97', '浅红色，浅绛色', '檀');
INSERT INTO `color` VALUES ('26', '190,0,47', '发黑的红色', '殷红');
INSERT INTO `color` VALUES ('27', '220,48,35', '像饮酒后脸上泛现的红色，泛指脸红', '酡红');
INSERT INTO `color` VALUES ('28', '249,144,111', '饮酒脸红的样子。亦泛指脸红色', '酡颜');
INSERT INTO `color` VALUES ('29', '255,241,67', '淡黄色', '鹅黄');
INSERT INTO `color` VALUES ('30', '250,255,114', '小鸭毛的黄色', '鸭黄');
INSERT INTO `color` VALUES ('31', '234,255,86', '淡黄色', '樱草色');
INSERT INTO `color` VALUES ('32', '255,166,49', '成熟杏子的黄色', '杏黄');
INSERT INTO `color` VALUES ('33', '255,140,​​49', '成熟杏子偏红色的一种颜色', '杏红');
INSERT INTO `color` VALUES ('34', '255,137,54', '柑橘的黄色', '橘黄');
INSERT INTO `color` VALUES ('35', '255,164,0', '橙的黄色。 （现代感比较强。广告上用得较多）', '橙黄');
INSERT INTO `color` VALUES ('36', '255,117,0', '柑橘皮所呈现的红色', '橘红');
INSERT INTO `color` VALUES ('37', '255,199,115', '橙的黄色。 （现代感比较强。广告上用得较多）', '姜黄');
INSERT INTO `color` VALUES ('38', '240,194,57', '浅黄色', '缃色');
INSERT INTO `color` VALUES ('39', '250,140,​​53', '界于红色和黄色之间的混合色', '橙色');
INSERT INTO `color` VALUES ('40', '179,92,68', '一种比栗色稍红的棕橙色至浅棕色', '茶色');
INSERT INTO `color` VALUES ('41', '168,132,98', '一种比哢叽色稍红而微淡、比肉桂色黄而稍淡和比核桃棕色黄而暗的浅黄棕色', '驼色');
INSERT INTO `color` VALUES ('42', '178,93,37', '棕毛的颜色,即褐色。 1，在红色和黄色之间的任何一种颜色2，适中的暗淡和适度的浅黑', '棕色');
INSERT INTO `color` VALUES ('43', '124,75,0', '深​​棕色', '棕黑');
INSERT INTO `color` VALUES ('44', '202,105,36', '无', '琥珀');
INSERT INTO `color` VALUES ('45', '149,85,57', '红色、赤红色。古人用以饰面', '赭色');
INSERT INTO `color` VALUES ('46', '211,177,125', '干枯焦黄', '枯黄');
INSERT INTO `color` VALUES ('47', '226,156,69', '一种落叶灌木，花黄绿色,叶子秋天变成红色。木材黄色可做染料', '黄栌');
INSERT INTO `color` VALUES ('48', '137,108,57', '1，中常橄榄棕色,它比一般橄榄棕色稍暗,且稍稍绿些。 2，古以秋为金,其色白,故代指白色', '秋色');
INSERT INTO `color` VALUES ('49', '189,221,3', '像刚长出的嫩叶的浅绿色', '嫩绿');
INSERT INTO `color` VALUES ('50', '120,146,98', '竹子的绿色', '竹青');
INSERT INTO `color` VALUES ('51', '163,217,0', '黄绿色，嫩黄色', '葱青');
INSERT INTO `color` VALUES ('52', '10,163,68', '翠绿色,形容植物浓绿', '青葱');
INSERT INTO `color` VALUES ('53', '0,188,18', '光润而浓绿的颜色。以上几种绿色都是明亮可爱的色彩', '油绿');
INSERT INTO `color` VALUES ('54', '12,137,24', '深绿', '绿沉');
INSERT INTO `color` VALUES ('55', '27,209,165', '1，青绿色。 2，青白色,浅蓝色', '碧色');
INSERT INTO `color` VALUES ('56', '42,221,156', '鲜艳的青绿色', '碧绿');
INSERT INTO `color` VALUES ('57', '72,192,163', '鲜艳的青蓝色', '青碧');
INSERT INTO `color` VALUES ('58', '61,225,173', '1，翡翠鸟羽毛的青绿色。 2，翡翠宝石的颜色。 (注：C-Y≧30 的系列色彩，多与白色配合以体现清新明丽感觉，与黑色配合效果不好：该色个性柔弱，会被黑色牵制)', '翡翠色');
INSERT INTO `color` VALUES ('59', '64,222,90', '绿而略黄的颜色', '草绿');
INSERT INTO `color` VALUES ('60', '0,224,158', '1，一类带绿的蓝色,中等深浅,高度饱和。 3，本义是蓝色。 4，一般指深绿色。 5，也指黑色。 6，四色印刷中的一色。 2，特指三补色中的一色。', '青色');
INSERT INTO `color` VALUES ('61', '0,224,121', '鲜绿', '青翠');
INSERT INTO `color` VALUES ('62', '192,235,215', '白而发青,尤指脸没有血色', '青白');
INSERT INTO `color` VALUES ('63', '224,238,232', '淡青灰色，极淡的青绿色', '鸭卵青');
INSERT INTO `color` VALUES ('64', '187,205,197', '深灰绿色', '蟹壳青');
INSERT INTO `color` VALUES ('65', '66,76,80', '鸦羽的颜色。即黑而带有紫绿光的颜色', '鸦青');
INSERT INTO `color` VALUES ('66', '158,208,72', '浅黄绿色', '豆绿');
INSERT INTO `color` VALUES ('67', '150,206,84', '浅青绿色', '豆青');
INSERT INTO `color` VALUES ('68', '123,207,166', '淡灰绿色', '石青');
INSERT INTO `color` VALUES ('69', '46,223,163', '玉的颜色，高雅的淡绿、淡青色', '玉色');
INSERT INTO `color` VALUES ('70', '127,236,173', '绿色而微白', '缥');
INSERT INTO `color` VALUES ('71', '164,226,198', '艾草的颜色。偏苍白的绿色', '艾绿');
INSERT INTO `color` VALUES ('72', '33,166,117', '经冬松柏叶的深绿', '松柏绿');
INSERT INTO `color` VALUES ('73', '5,119,72', '亦作“松花”、“松绿”。偏黑的深绿色,墨绿', '松花绿');
INSERT INTO `color` VALUES ('74', '68,206,246', '三原色的一种。像晴天天空的颜色（注：这里的蓝色指的不是RGB色彩中的B，而是CMY色彩中的C）', '蓝');
INSERT INTO `color` VALUES ('75', '23,124,176', '也叫“蓝靛”。用蓼蓝叶泡水调和与石灰沉淀所得的蓝色染料。呈深蓝绿色 （注：有些地方将蓝墨水称为“靛水”或者“兰靛水”）', '靛青');
INSERT INTO `color` VALUES ('76', '6,82,121', '由植物(例如靛蓝或菘蓝属植物)得到的蓝色染料', '靛蓝');
INSERT INTO `color` VALUES ('77', '62,237,231', '青蓝色', '碧蓝');
INSERT INTO `color` VALUES ('78', '112,243,255', '类似晴朗天空的颜色的一种蓝色', '蔚蓝');
INSERT INTO `color` VALUES ('79', '75,92,196', '鲜艳明亮的蓝色（注：英文中为RoyalBlue 即皇家蓝色，是皇室选用的色彩，多和小面积纯黄色（金色）配合使用。 ）', '宝蓝');
INSERT INTO `color` VALUES ('80', '161,175,201', '一种近于灰略带蓝的深灰色', '蓝灰色');
INSERT INTO `color` VALUES ('81', '46,78,126', '蓝而近黑', '藏青');
INSERT INTO `color` VALUES ('82', '59,46,126', '蓝里略透红色', '藏蓝');
INSERT INTO `color` VALUES ('83', '74,66,102', '青黑色的颜料。古代女子用以画眉', '黛');
INSERT INTO `color` VALUES ('84', '66,102,102', '墨绿', '黛绿');
INSERT INTO `color` VALUES ('85', '66,80,102', '深蓝色', '黛蓝');
INSERT INTO `color` VALUES ('86', '87,66,102', '深紫色', '黛紫');
INSERT INTO `color` VALUES ('87', '129,84,99', '浑浊的紫色', '紫酱');
INSERT INTO `color` VALUES ('88', '129,84,118', '紫中略带红的颜色', '酱紫');
INSERT INTO `color` VALUES ('89', '76,34,27', '檀木的颜色，也称乌檀色乌木色', '紫檀');
INSERT INTO `color` VALUES ('90', '0,51,113', '纯度较低的深紫色', '绀青');
INSERT INTO `color` VALUES ('91', '86,0,79', '黑红色', '紫棠');
INSERT INTO `color` VALUES ('92', '76,141,174', '深蓝色', '群青');
INSERT INTO `color` VALUES ('93', '176,164,227', '浅蓝紫色', '雪青');
INSERT INTO `color` VALUES ('94', '204,164,227', '紫丁香的颜色，浅浅的紫色，很娇柔淡雅的色彩', '丁香色');
INSERT INTO `color` VALUES ('95', '237,209,216', '浅灰而略带红的颜色', '藕色');
INSERT INTO `color` VALUES ('96', '228,198,208', '浅紫而略带红的颜色', '藕荷色');
INSERT INTO `color` VALUES ('97', '117,135,138', '即各种颜色掺入黑色后的颜色，如苍翠', '苍色');
INSERT INTO `color` VALUES ('98', '81,154,115', '无', '苍黄');
INSERT INTO `color` VALUES ('99', '162,155,124', '无', '苍青');
INSERT INTO `color` VALUES ('100', '115,151,171', '无', '苍黑');
INSERT INTO `color` VALUES ('101', '209,217,224', '无', '苍白');
INSERT INTO `color` VALUES ('102', '136,173,166', '无', '水色');
INSERT INTO `color` VALUES ('103', '243,211,231', '无', '水红');
INSERT INTO `color` VALUES ('104', '212,242,231', '无', '水绿');
INSERT INTO `color` VALUES ('105', '210,240,244', '无', '水蓝');
INSERT INTO `color` VALUES ('106', '211,224,243', '无', '淡青');
INSERT INTO `color` VALUES ('107', '255,255,255', '纯白，洁白，净白，粉白', '精白');
INSERT INTO `color` VALUES ('108', '255,251,240', '乳白色', '像牙白');
INSERT INTO `color` VALUES ('109', '240,252,255', '如雪般洁白', '雪白');
INSERT INTO `color` VALUES ('110', '214,236,240', '淡蓝色', '月白');
INSERT INTO `color` VALUES ('111', '186,202,198', '金属氧化后的色彩', '老银');
INSERT INTO `color` VALUES ('112', '167,142,68', '无', '乌金');
INSERT INTO `color` VALUES ('113', '84,150,136', '无', '铜绿');
INSERT INTO `color` VALUES ('114', '233,231,239', '带银光的白色', '银白');
INSERT INTO `color` VALUES ('115', '234,205,118', '平均为深黄色带光泽的颜色', '金色');
INSERT INTO `color` VALUES ('116', '深黑色、泛指黑色', '无', '65,85,93');
INSERT INTO `color` VALUES ('117', '93,81,60', '黑中带黄的颜色', '黝');
INSERT INTO `color` VALUES ('118', '57,47,65', '深黑', '乌黑');
INSERT INTO `color` VALUES ('119', '22,24,35', '非常黑的', '漆黑');
INSERT INTO `color` VALUES ('120', '240,240,244', '铅粉的白色。铅粉，国画颜料，日久易氧化“返铅”变黑。铅粉在古时用以搽脸的化妆品。 （注：冷白）', '玄青');
INSERT INTO `color` VALUES ('121', '238,222,176', '与像牙相似的淡黄色（注：暖白）', '牙色');
INSERT INTO `color` VALUES ('122', '128,128,128', '黑色和白色混和成的一种颜色', '灰色');
INSERT INTO `color` VALUES ('123', '227,239,253', '晶莹洁白', '莹白');
INSERT INTO `color` VALUES ('124', '252,239,232', '似鱼腹部的颜色，多指黎明时东方的天色颜色', '鱼肚白');
INSERT INTO `color` VALUES ('125', '194,204,208', '白色和黑色混杂的。斑白的 夹杂有灰色的白', '花白');
INSERT INTO `color` VALUES ('126', '233,241,246', '白霜的颜色', '霜色');
INSERT INTO `color` VALUES ('127', '242,190,69', '足金的颜色', '赤金');
INSERT INTO `color` VALUES ('128', '98,42,29', '赤黑色，黑中带红的颜色，又泛指黑色', '玄色');
INSERT INTO `color` VALUES ('129', '117,138,153', '即黑灰', '墨灰');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL auto_increment,
  `article_id` bigint(20) default NULL,
  `comment_content` varchar(255) default NULL,
  `comment_date` datetime default NULL,
  `comment_nickname` varchar(255) default NULL,
  `comment_user` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK38A5EE5FEE5D3F84` (`article_id`),
  CONSTRAINT `FK38A5EE5FEE5D3F84` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('19', '3', 'aaaaaaaa', '2014-03-30 06:37:53', 'ee', null, 'a@126.com');
INSERT INTO `comment` VALUES ('20', '3', 'bbbbbbbbbbbbbbbbb', '2014-03-30 06:39:12', 'bbbb', null, 'a@126.com');
INSERT INTO `comment` VALUES ('21', '3', '徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记徐福记', '2014-03-30 06:44:43', '徐福记', null, 'a@126.com');
INSERT INTO `comment` VALUES ('22', '3', 'ccccccccccccccccccccccccccc', '2014-03-30 07:03:44', 'cccccccccc', null, 'a@126.com');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL auto_increment,
  `avatar` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `nickname` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  `blog_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK36EBCB7474B930` (`blog_id`),
  CONSTRAINT `FK36EBCB7474B930` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1c4ca4238a0b923820dcc509a6f75849b.jpg', null, 'admin', 'c4ca4238a0b923820dcc509a6f75849b', 'admin', null);
