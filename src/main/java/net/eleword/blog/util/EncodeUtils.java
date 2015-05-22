package net.eleword.blog.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author shenmiao@staff.hexun.com
 * @ClassName: EncodeUtils
 * @Description: 各种格式的编码加码工具类.集成Commons-Codec,Commons-Lang及JDK提供的编解码方法.
 * @date 2012-10-15 下午03:21:43
 */
public class EncodeUtils {

    private static final String DEFAULT_URL_ENCODING = "UTF-8";

    /**
     * @param input
     * @return
     * @Title: hexEncode
     * @Description: Hex编码.
     */
    public static String hexEncode(byte[] input) {
        return Hex.encodeHexString(input);
    }

    /**
     * @param input
     * @return
     * @Title: hexDecode
     * @Description: Hex解码.
     */
    public static byte[] hexDecode(String input) {
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException e) {
            throw new IllegalStateException("Hex Decoder exception", e);
        }
    }

    /**
     * @param input
     * @return
     * @Title: base64Encode
     * @Description: Base64编码.
     */
    public static String base64Encode(byte[] input) {
        return new String(Base64.encodeBase64(input));
    }

    /**
     * @param input
     * @return
     * @Title: base64UrlSafeEncode
     * @Description: Base64编码, URL安全(将Base64中的URL非法字符如+,/=转为其他字符, 见RFC3548).
     */
    public static String base64UrlSafeEncode(byte[] input) {
        return Base64.encodeBase64URLSafeString(input);
    }

    /**
     * @param input
     * @return
     * @Title: base64Decode
     * @Description: Base64解码.
     */
    public static byte[] base64Decode(String input) {
        return Base64.decodeBase64(input);
    }

    /**
     * @param input
     * @return
     * @Title: urlEncode
     * @Description: URL 编码, Encode默认为UTF-8.
     */
    public static String urlEncode(String input) {
        try {
            return URLEncoder.encode(input, DEFAULT_URL_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Unsupported Encoding Exception", e);
        }
    }

    /**
     * @param input
     * @return
     * @Title: urlDecode
     * @Description: URL 解码, Encode默认为UTF-8.
     */
    public static String urlDecode(String input) {
        try {
            return URLDecoder.decode(input, DEFAULT_URL_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Unsupported Encoding Exception", e);
        }
    }

    /**
     * @param html
     * @return
     * @Title: htmlEscape
     * @Description: Html 转码.
     */
    public static String htmlEscape(String html) {
        return StringEscapeUtils.escapeHtml(html);
    }

    /**
     * @param htmlEscaped
     * @return
     * @Title: htmlUnescape
     * @Description: Html 解码.
     */
    public static String htmlUnescape(String htmlEscaped) {
        return StringEscapeUtils.unescapeHtml(htmlEscaped);
    }

    /**
     * @param xml
     * @return
     * @Title: xmlEscape
     * @Description: Xml 转码.
     */
    public static String xmlEscape(String xml) {
        return StringEscapeUtils.escapeXml(xml);
    }

    /**
     * @param xmlEscaped
     * @return
     * @Title: xmlUnescape
     * @Description: Xml 解码.
     */
    public static String xmlUnescape(String xmlEscaped) {
        return StringEscapeUtils.unescapeXml(xmlEscaped);
    }
}
