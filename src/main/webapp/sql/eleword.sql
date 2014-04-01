/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : eleword

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-04-01 17:07:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `content` text NOT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `post_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `views` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'zhagnsan', '1', '<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">1. find</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">find是最常见和最强大的查找命令，你可以用它找到任何你想找的文件。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">find的使用格式如下：</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ find &lt;指定目录&gt; &lt;指定条件&gt; &lt;指定动作&gt;</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">- &lt;指定目录&gt;： 所要搜索的目录及其所有子目录。默认为当前目录。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">- &lt;指定条件&gt;： 所要搜索的文件的特征。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">- &lt;指定动作&gt;： 对搜索结果进行特定的处理。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">如果什么参数也不加，find默认搜索当前目录及其子目录，并且不过滤任何结果（也就是返回所有文件），将它们全都显示在屏幕上。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">find的使用实例：</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ find . -name \'my*\'</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">搜索当前目录（含子目录，以下同）中，所有文件名以my开头的文件。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ find . -name \'my*\' -ls</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">搜索当前目录中，所有文件名以my开头的文件，并显示它们的详细信息。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ find . -type f -mmin -10</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">搜索当前目录中，所有过去10分钟中更新过的普通文件。如果不加-type f参数，则搜索普通文件+特殊文件+目录。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<br />\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<br />\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">2. locate</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">locate命令其实是\"find -name\"的另一种写法，但是要比后者快得多，原因在于它不搜索具体目录，而是搜索一个数据库（/var/lib/locatedb），这个数据库中含有本地所有文件信息。Linux系统自动创建这个数据库，并且每天自动更新一次，所以使用locate命令查不到最新变动过的文件。为了避免这种情况，可以在使用locate之前，先使用updatedb命令，手动更新数据库。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">locate命令的使用实例：</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ locate /etc/sh</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">搜索etc目录下所有以sh开头的文件。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ locate ~/m</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">搜索用户主目录下，所有以m开头的文件。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ locate -i ~/m</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">搜索用户主目录下，所有以m开头的文件，并且忽略大小写。</span> \r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">3. whereis</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">whereis命令只能用于程序名的搜索，而且只搜索二进制文件（参数-b）、man说明文件（参数-m）和源代码文件（参数-s）。如果省略参数，则返回所有信息。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">whereis命令的使用实例：</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ whereis grep</span> \r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">4. which</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">which命令的作用是，在PATH变量指定的路径中，搜索某个系统命令的位置，并且返回第一个搜索结果。也就是说，使用which命令，就可以看到某个系统命令是否存在，以及执行的到底是哪一个位置的命令。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">which命令的使用实例：</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ which grep</span> \r\n</p>\r\n<p>\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\"></span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">5. type</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">type命令其实不能算查找命令，它是用来区分某个命令到底是由shell自带的，还是由shell外部的独立二进制文件提供的。如果一个命令是外部命令，那么使用-p参数，会显示该命令的路径，相当于which命令。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">type命令的使用实例：</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ type cd</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">系统会提示，cd是shell的自带命令（build-in）。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ type grep</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">系统会提示，grep是一个外部命令，并显示该命令的路径。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">$ type -p grep</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<span style=\"font-family:\'Microsoft YaHei\';font-size:14px;\">加上-p参数后，就相当于which命令。</span> \r\n</p>\r\n<p style=\"text-indent:2em;\">\r\n	<br />\r\n</p>', null, null, '2014-04-01 15:37:59', '0', 'Linux的五个查找命令', '0');
INSERT INTO `article` VALUES ('2', 'zhagnsan', '1', '<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">一. Grep&nbsp;说明</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">grep (global search regular expression(RE) and print out the line)是一种强大的文本搜索工具，它能使用正则表达式搜索文本，并把匹配的行打印出来。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Unix的grep家族包括grep、&nbsp;egrep和fgrep。egrep和fgrep的命令只跟grep有很小不同。egrep是grep的扩展，支持更多的re元字符，&nbsp;fgrep就是&nbsp;fixed grep或fast grep，它们把所有的字母都看作单词，也就是说，正则表达式中的元字符表示回其自身的字面意义，不再特殊。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;linux&nbsp;使用GNU版本的grep。它功能更强，可以通过-G、-E、-F命令行选项来使用egrep和fgrep的功能。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">grep在一个或多个文件中搜索字符串模板。如果模板包括空格，则必须被引用，模板后的所有字符串被看作文件名。搜索的结果被送到屏幕，不影响原文件内容。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">grep可用于shell脚本，因为grep通过返回一个状态值来说明搜索的状态，如果模板搜索成功，则返回0，如果搜索不成功，则返回1，如果搜索的文件不存在，则返回2。&nbsp;利用这些返回值就可进行一些自动化的文本处理工作。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">二.&nbsp;&nbsp;grep正则表达式元字符集(基本集)</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（1）^：&nbsp;锚定行的开始&nbsp;如：\'^grep\'匹配所有以grep开头的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（2）$：锚定行的结束&nbsp;如：\'grep$\'匹配所有以grep结尾的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（3）. :匹配一个非换行符的字符&nbsp;如：\'gr.p\'匹配gr后接一个任意字符，然后是p。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（4）*：匹配零个或多个先前字符&nbsp;如：\'*grep\'匹配所有一个或多个空格后紧跟grep的行。&nbsp;.*一起用代表任意字符。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（5）[]：匹配一个指定范围内的字符，如\'[Gg]rep\'匹配Grep和grep。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（6）[^]：匹配一个不在指定范围内的字符，如：\'[^A-FH-Z]rep\'匹配不包含A-R和T-Z的一个字母开头，紧跟rep的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（7）/(../)&nbsp;：标记匹配字符，如\'/(love/)\'，love被标记为1。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（8）/&lt;&nbsp;：锚定单词的开始，如:\'//&gt;</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">锚定单词的结束，如\'grep/&gt;\'匹配包含以grep结尾的单词的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（9）x/{m/}：重复字符x，m次，如：\'0/{5/}\'匹配包含5个0的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（10）x/{m,/}：重复字符x,至少m次，如：\'o/{5,/}\'匹配至少有5个o的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（11）x/{m,n/}：重复字符x，至少m次，不多于n次，如：\'o/{5,10/}\'匹配5--10个o的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（12）/w：匹配文字和数字字符，也就是[A-Za-z0-9]，如：\'G/w*p\'匹配以G后跟零个或多个文字或数字字符，然后是p。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（13）/W：/w的反置形式，匹配一个或多个非单词字符，如点号句号等。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（14）/b：单词锁定符，如: \'/bgrepb/\'只匹配grep。</span>\r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">三.&nbsp;用于egrep和&nbsp;grep -E的元字符扩展集</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（1）+：匹配一个或多个先前的字符。如：\'[a-z]+able\'，匹配一个或多个小写字母后跟able的串，如loveable,enable,disable等。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（2）?：匹配零个或多个先前的字符。如：\'gr?p\'匹配gr后跟一个或没有字符，然后是p的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（3）a|b|c：匹配a或b或c。如：grep|sed匹配grep或sed</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（4）()&nbsp;：分组符号，如：love(able|rs)ov+匹配loveable或lovers，匹配一个或多个ov。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（5）x{m},x{m,},x{m,n}：作用同x/{m/},x/{m,/},x/{m,n/}</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">四. POSIX字符类</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">为了在不同国家的字符编码中保持一至，POSIX(The Portable Operating System Interface)增加了特殊的字符类，如[:alnum:]是A-Za-z0-9的另一个写法。要把它们放到[]号内才能成为正则表达式，如[A- Za-z0-9]或[[: alnum:]]。在linux下的grep除fgrep外，都支持POSIX的字符类。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（1）[:alnum:]&nbsp;文字数字字符</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（2）[:alpha:]&nbsp;文字字符</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（3）[:digit:]&nbsp;数字字符</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（4）[:graph:]&nbsp;非空字符(非空格、控制字符)</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（5）[:lower:]&nbsp;小写字符</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（6）[:cntrl:]&nbsp;控制字符</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（7）[:print:]&nbsp;非空字符(包括空格)</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（8）[:punct:]&nbsp;标点符号</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（9）[:space:]&nbsp;所有空白字符(新行，空格，制表符)</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（10）[:upper:]&nbsp;大写字符</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（11）[:xdigit:]&nbsp;十六进制数字(0-9，a-f，A-F)</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">五. Grep命令选项</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（1）-?：同时显示匹配行上下的？行，如：grep -2 pattern filename同时显示匹配行的上下2行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（2）-b，--byte-offset&nbsp;：打印匹配行前面打印该行所在的块号码。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（3）-c,--count：只打印匹配的行数，不显示匹配的内容。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（4）-f File，--file=File：从文件中提取模板。空文件中包含0个模板，所以什么都不匹配。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（5）-h，--no-filename：当搜索多个文件时，不显示匹配文件名前缀。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（6）-i，--ignore-case：忽略大小写差别。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（7）-q，--quiet：取消显示，只返回退出状态。0则表示找到了匹配的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（8）-l，--files-with-matches：打印匹配模板的文件清单。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（9）-L，--files-without-match：打印不匹配模板的文件清单。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（10）-n，--line-number：在匹配的行前面打印行号。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（11）-s，--silent：不显示关于不存在或者无法读取文件的错误信息。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（12）-v，--revert-match：反检索，只显示不匹配的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（13）-w，--word-regexp：如果被/&lt;和/&gt;引用，就把表达式做为一个单词搜索。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（14）-V，--version：显示软件版本信息。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">六.&nbsp;实例</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（1）$ ls -l | grep \'^a\'</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">通过管道过滤ls -l输出的内容，只显示以a开头的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（2）$ grep \'test\' d*</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">显示所有以d开头的文件中包含test的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（3）$ grep \'test\' aa bb cc</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">显示在aa，bb，cc文件中匹配test的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（4）$ grep \'[a-z]/{5/}\' aa</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">显示所有包含每个字符串至少有5个连续小写字符的字符串的行。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（5）$ grep \'w/(es/)t.*/1\' aa</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">如果west被匹配，则es就被存储到内存中，并标记为1，然后搜索任意个字符(.*)，这些字符后面紧跟着另外一个es(/1)，找到就显示该行。如果用egrep或grep -E，就不用\"/\"号进行转义，直接写成\'w(es)t.*/1\'就可以了。</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">（6）cat /etc/oratab |grep -v ^#|grep -v ^$|grep -v \'^;\'</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;过滤注释</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">[root@rac1 ~]# cat /etc/oratab</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">#</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\"># This file is used by ORACLE utilities.&nbsp;&nbsp;It is created by root.sh</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\"># and updated by the Database Configuration Assistant when creating</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\"># a database.</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\"># A colon, \':\', is used as the field terminator.&nbsp;&nbsp;A new line terminates</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\"># the entry.&nbsp;&nbsp;Lines beginning with a pound sign, \'#\', are comments.</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">#</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\"># Entries are of the form:</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">#&nbsp;&nbsp;&nbsp;$ORACLE_SID:$ORACLE_HOME:&lt;N|Y&gt;:</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">#</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\"># The first and second fields are the system identifier and home</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\"># directory of the database respectively.&nbsp;&nbsp;The third filed indicates</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\"># to the dbstart utility that the database should , \"Y\", or should not,</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\"># \"N\", be brought up at system boot time.</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">#</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\"># Multiple entries with the same $ORACLE_SID are not allowed.</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">#</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">+ASM1:/u01/app/oracle/product/10.2.0/db_1:N</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">rac:/u01/app/oracle/product/10.2.0/db_1:N</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">过滤之后：</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">[root@rac1 ~]# cat /etc/oratab |grep -v ^#|grep -v ^$|grep -v \'^;\'</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">+ASM1:/u01/app/oracle/product/10.2.0/db_1:N</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">rac:/u01/app/oracle/product/10.2.0/db_1:N</span>\r\n</p>\r\n<p>\r\n	<span style=\"font-size:14px;font-family:\'Microsoft YaHei\';\">&nbsp;</span>\r\n</p>', null, null, '2014-04-01 15:48:24', '0', 'Linux Grep 命令说明', '0');

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_num` int(11) DEFAULT NULL,
  `background` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `mail_notice` bit(1) DEFAULT NULL,
  `phone_notice` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `banner_color` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '0', '255,251,240', '跟着自己的脚步，踏踏实实的往前走', '', '', 'KrisJin点滴技术路程', '240,252,255');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_number` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `order_value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '2', 'Linux命令', '1');

-- ----------------------------
-- Table structure for `color`
-- ----------------------------
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(20) DEFAULT NULL,
  `comment_content` varchar(255) DEFAULT NULL,
  `comment_date` datetime DEFAULT NULL,
  `comment_nickname` varchar(255) DEFAULT NULL,
  `comment_user` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK36EBCB7474B930` (`blog_id`),
  CONSTRAINT `FK36EBCB7474B930` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1c4ca4238a0b923820dcc509a6f75849b.jpg', null, 'admin', 'c4ca4238a0b923820dcc509a6f75849b', 'admin', null);
