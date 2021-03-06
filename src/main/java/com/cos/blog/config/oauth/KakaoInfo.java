package com.cos.blog.config.oauth;

import java.util.Map;

public class KakaoInfo extends OAuth2UserInfo {

	public KakaoInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		return attributes.get("id").toString();
	}

	@Override
	public String getName() {
		return (String)((Map)attributes.get("profile")).get("nickname");
	}

	@Override
	public String getEmail() {
		return (String)((Map)attributes.get("kakao_account")).get("email");
	}

	@Override
	public String getImageUrl() {
		return (String)((Map)attributes.get("profile")).get("profile_image_url");
	}

	@Override
	public String getUsername() {
		return "Kakao_" + attributes.get("id").toString();
	}
	

}
