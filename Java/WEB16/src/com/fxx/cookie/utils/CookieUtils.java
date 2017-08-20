package com.fxx.cookie.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


public class CookieUtils {
	public static Cookie getCookie(HttpServletRequest request,String cookieName) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if(name.equals(cookieName)) {
					return cookie;
				}
			}
		}
		return null;
	}
}
