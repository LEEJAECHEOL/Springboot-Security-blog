package com.cos.blog.config.oauth;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;


// extends DefaultOAuth2UserService
@RequiredArgsConstructor
@Service
public class OAuth2DetailsService extends DefaultOAuth2UserService{
	
	private final UserRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		System.out.println("OAuth 로그인 진행중..........");
		
		System.out.println(userRequest.getAccessToken());
		// 회원정보 요청 -> userRequest.getAccessToken().getTokenValue() 이토큰으로
		
		// 1. AccessToken으로 회원정보를 받았다는 의미
		OAuth2User oauth2User = super.loadUser(userRequest);
		
		System.out.println(oauth2User.getAttributes());
		
		return processOAuth2User(userRequest, oauth2User);
	}
	
	// 구글 로그인 프로세
	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oauth2User) {
		// 1. 통합 클래스를 생성 (네이버, 구글, 깃헙등으로 로그인 되기 때문)
		System.out.println("머로 로그인 : " + userRequest.getClientRegistration());
		System.out.println("머로 로그인 : " + userRequest.getClientRegistration().getClientId());
		System.out.println("머로 로그인 : " + userRequest.getClientRegistration().getClientName());
		
		OAuth2UserInfo auth2UserInfo = null;
		
		if(userRequest.getClientRegistration().getClientName().equals("Google")) {
			auth2UserInfo = new GoogleInfo(oauth2User.getAttributes());	
		} else if(userRequest.getClientRegistration().getClientName().equals("Facebook")) {
			auth2UserInfo = new FacebookInfo(oauth2User.getAttributes());
		}
		
		// 2. 최초 : 회원가입 + 로그인,  최초가 아닐 때 : 로그
		User userEntity = userRepository.findByUsername(auth2UserInfo.getUsername());
		UUID uuid = UUID.randomUUID();
		String encPassword = new BCryptPasswordEncoder().encode(uuid.toString());
		
		if(userEntity == null) {
			System.out.println("최초 사용자입니다. 자동 회원가입을 진행 후 자동 로그인 합니다.");
			User user = User.builder()
					.username(auth2UserInfo.getUsername())
					.password(encPassword)
					.email(auth2UserInfo.getEmail())
					.build();
			userEntity = userRepository.save(user);
			return new PrincipalDetails(userEntity, oauth2User.getAttributes());
		} else { // 회원가입이 완료됬다는 뜻(원래는 구글 정보가 변경될 수 있기 때문에 update해야되는데 지금 안함.)
			System.out.println("회원정보가 있습니다. 바로 로그인 합니다.");
			return new PrincipalDetails(userEntity, oauth2User.getAttributes());
		}
	}
	

}
