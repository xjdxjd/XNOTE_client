package com.xnote.client.common.utils.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component("securitySHA1Utils")
public class SecuritySHA1Utils {


	/*
	 * 加密操作
	 *
	 */
	public static String encrypt(String password) {

		if(null == password || "".equals(password)) {

			return null;
		}else {

			return DigestUtils.sha1Hex(password);
		}
	}
	/*
	 * 验证密码
	 * 密码输入错误，返回true
	 * 密码输入正确，返回false
	 * @Param password 用户输入密码
	 * @Param userPass 查询到的密码字段
	 */
	public static Boolean passwordVerify(String password, String userPass) {
		String enPass = DigestUtils.sha1Hex(password);
		if(StringUtils.isEmpty(enPass)){
			return true;
		}
		if(!userPass.equals(DigestUtils.sha1Hex(password))){
			return true;
		}
		return false;
	}
	
}
