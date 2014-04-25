/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : eleword

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2014-04-10 02:49:20
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
INSERT INTO `article` VALUES ('2', 'admin', '1', '<p>\r\n	nginx通过ngx_http_rewrite_module模块支持url重写、支持if条件判断，但不支持else。\r\n</p>\r\n<p>\r\n	该模块需要PCRE支持，应在编译nginx时指定PCRE源码目录,<a href=\"http://www.nginx.cn/install\" target=\"_blank\">nginx安装方法</a>。\r\n</p>\r\n<h3>\r\n	nginx rewrite指令执行顺序：\r\n</h3>\r\n<p>\r\n	1.执行server块的rewrite指令(这里的块指的是server关键字后{}包围的区域，其它xx块类似)<br />\r\n2.执行location匹配<br />\r\n3.执行选定的location中的rewrite指令<br />\r\n如果其中某步URI被重写，则重新循环执行1-3，直到找到真实存在的文件\r\n</p>\r\n<p>\r\n	如果循环超过10次，则返回500 Internal Server Error错误\r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<h3>\r\n	break指令\r\n</h3>\r\n<p>\r\n	语法：break;<br />\r\n默认值：无<br />\r\n作用域：server,location,if\r\n</p>\r\n<p>\r\n	停止执行当前虚拟主机的后续rewrite指令集<br />\r\nbreak指令实例：\r\n</p>\r\nif ($slow) {\r\n     limit_rate 10k;\r\n     break;\r\n }\r\n<h3>\r\n	if指令\r\n</h3>\r\n<p>\r\n	语法：if(condition){...}<br />\r\n默认值：无<br />\r\n作用域：server,location<br />\r\n对给定的条件condition进行判断。如果为真，大括号内的rewrite指令将被执行。<br />\r\nif条件(conditon)可以是如下任何内容:\r\n</p>\r\n<ul>\r\n	<li>\r\n		一个变量名；false如果这个变量是空字符串或者以0开始的字符串；\r\n	</li>\r\n	<li>\r\n		使用= ,!= 比较的一个变量和字符串\r\n	</li>\r\n	<li>\r\n		是用~， ~*与正则表达式匹配的变量，如果这个正则表达式中包含}，;则整个表达式需要用\" 或\' 包围\r\n	</li>\r\n	<li>\r\n		使用-f ，!-f 检查一个文件是否存在\r\n	</li>\r\n	<li>\r\n		使用-d, !-d 检查一个目录是否存在\r\n	</li>\r\n	<li>\r\n		使用-e ，!-e 检查一个文件、目录、符号链接是否存在\r\n	</li>\r\n	<li>\r\n		使用-x ， !-x 检查一个文件是否可执行\r\n	</li>\r\n</ul>\r\n<p>\r\n	if指令实例\r\n</p>\r\nif ($http_user_agent ~ MSIE) {\r\n     rewrite ^(.*)$ /msie/$1 break;\r\n }\r\n if ($http_cookie ~* \"id=([^;]+)(?:;|$)\") {\r\n     set $id $1;\r\n }\r\n if ($request_method = POST) {\r\n     return 405;\r\n }\r\n if ($slow) {\r\n     limit_rate 10k;\r\n }\r\n if ($invalid_referer) {\r\n     return 403;\r\n }\r\n<h3>\r\n	return指令\r\n</h3>\r\n<p>\r\n	语法：return code;\r\n</p>\r\n<p>\r\n	return code URL;\r\n</p>\r\n<p>\r\n	return URL;<br />\r\n默认值：无<br />\r\n作用域：server,location,if\r\n</p>\r\n<p>\r\n	停止处理并返回指定状态码(code)给客户端。<br />\r\n非标准状态码444表示关闭连接且不给客户端发响应头。<br />\r\n从0.8.42版本起，return 支持响应URL重定向(对于301，302，303，307），或者文本响应(对于其他状态码).<br />\r\n对于文本或者URL重定向可以包含变量\r\n</p>\r\n<h3>\r\n	rewrite指令\r\n</h3>\r\n<p>\r\n	语法：rewrite regex replacement [flag];<br />\r\n默认值：无<br />\r\n作用域：server,location,if<br />\r\n如果一个URI匹配指定的正则表达式regex，URI就按照replacement重写。<br />\r\nrewrite按配置文件中出现的顺序执行。flags标志可以停止继续处理。<br />\r\n如果replacement以\"http://\"或\"https://\"开始，将不再继续处理，这个重定向将返回给客户端。<br />\r\nflag可以是如下参数<br />\r\nlast 停止处理后续rewrite指令集，然后对当前重写的新URI在rewrite指令集上重新查找。<br />\r\nbreak 停止处理后续rewrite指令集，并不在重新查找,但是当前location内剩余非rewrite语句和location外的的非rewrite语句可以执行。<br />\r\nredirect 如果replacement不是以http:// 或https://开始，返回302临时重定向<br />\r\npermant 返回301永久重定向<br />\r\n最终完整的重定向URL包括请求scheme(http://,https://等),请求的server_name_in_redirect和&nbsp;port_in_redirec三部分 ，说白了也就是http协议 域名 端口三部分组成。\r\n</p>\r\n<p>\r\n	rewrite实例\r\n</p>\r\nserver {\r\n     ...\r\n     rewrite ^(/download/.*)/media/(.*)\\..*$ $1/mp3/$2.mp3 last;\r\n     rewrite ^(/download/.*)/audio/(.*)\\..*$ $1/mp3/$2.ra last;\r\n     return 403;\r\n     ...\r\n }\r\n<p>\r\n	如果这些rewrite放到&nbsp;“/download/” location如下所示, 那么应使用break而不是last&nbsp;, 使用last将循环10次匹配，然后返回 500错误:\r\n</p>\r\nlocation /download/ {\r\n     rewrite ^(/download/.*)/media/(.*)\\..*$ $1/mp3/$2.mp3 break;\r\n     rewrite ^(/download/.*)/audio/(.*)\\..*$ $1/mp3/$2.ra break;\r\n     return 403;\r\n }\r\n<p>\r\n	对于重写后的URL（replacement）包含原请求的请求参数，原URL的?后的内容。如果不想带原请求的参数 ，可以在replacement后加一个问号。如下，我们加了一个自定义的参数user=$1,然后在结尾处放了一个问号?,把原请的参数去掉。\r\n</p>\r\nrewrite ^/users/(.*)$ /show?user=$1? last;\r\n<p>\r\n	如果正则表达regex式中包含&nbsp;“}” 或 “;”, 那么整个表达式需要用双引号或单引号包围.\r\n</p>\r\n<h3>\r\n	rewrite_log指令\r\n</h3>\r\n<p>\r\n	<br />\r\n语法：rewrite_log on|off;<br />\r\n默认值：rewrite_log off;<br />\r\n作用域：http,server,location,if<br />\r\n开启或关闭以notice级别打印rewrite处理日志到error log文件。\r\n</p>\r\n<p>\r\n	nginx打开rewrite log例子\r\n</p>\r\n<p>\r\n	rewrite_log on;<br />\r\nerror_log logs/xxx.error.log notice;\r\n</p>\r\n<p>\r\n	1.打开rewrite on<br />\r\n2.把error log的级别调整到 notice\r\n</p>\r\n<h3>\r\n	set指令\r\n</h3>\r\n<p>\r\n	<br />\r\n语法：set variable value;<br />\r\n默认值：none<br />\r\n作用域：server,location,if<br />\r\n定义一个变量并赋值，值可以是文本，变量或者文本变量混合体。\r\n</p>\r\n<h3>\r\n	uninitialized_variable_warn指令\r\n</h3>\r\n<p>\r\n	<br />\r\n语法：uninitialized_variable_warn on | off;<br />\r\n默认值：uninitialized_variable_warn on<br />\r\n作用域：http,server,location,if\r\n</p>\r\n<p>\r\n	控制是否输出为初始化的变量到日志\r\n</p>', null, null, '2014-04-10 02:02:08', '0', 'nginx rewrite 指令', '0');
INSERT INTO `article` VALUES ('3', 'admin', '1', 'ttt', null, null, '2014-04-10 02:02:55', '0', 'test', '0');

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
  `banner_color` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '0', '255,251,240', '跟着自己的脚步，踏踏实实的往前走', '', '', 'KrisJin点滴技术路程', '189,221,3');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL auto_increment,
  `article_number` int(11) default NULL,
  `name` varchar(255) NOT NULL,
  `order_value` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '2', 'Linux命令', '1');

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
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `folder`
-- ----------------------------
DROP TABLE IF EXISTS `folder`;
CREATE TABLE `folder` (
  `id` bigint(20) NOT NULL auto_increment,
  `content` varchar(255) default NULL,
  `create_time` datetime default NULL,
  `ename` varchar(255) NOT NULL,
  `father_id` bigint(20) default NULL,
  `level` int(11) default NULL,
  `name` varchar(255) NOT NULL,
  `path` varchar(255) default NULL,
  `sort` int(11) default NULL,
  `status` int(11) default NULL,
  `type` varchar(255) default NULL,
  `update_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of folder
-- ----------------------------
INSERT INTO `folder` VALUES ('1', '<p>\r\n	<img src=\"/eleword/upload/image/20140407/20140407144352_194.jpg\" alt=\"\" />\r\n</p>\r\n<p>\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:16px;\">个人资料：</span>\r\n</p>', '2014-04-07 20:47:28', 'aboutme', '0', '0', '关于我', null, '0', '1', null, null);

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
INSERT INTO `user` VALUES ('1', '1c4ca4238a0b923820dcc509a6f75849b.jpg', null, 'admin', '202cb962ac59075b964b07152d234b70', 'admin', null);



DROP TABLE IF EXISTS `webstatistics`;
CREATE TABLE `webstatistics` (
  `id` bigint(20) NOT NULL auto_increment,
  `ip` varchar(512) default NULL,
  `url` varchar(512) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `media`;
CREATE TABLE `media` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(512) DEFAULT NULL,
  `url` varchar(512) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text,
  `media` varchar(255) DEFAULT NULL,
  `media_url` varchar(255) DEFAULT NULL,
  `post_date` datetime DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `thumbnails_url` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
