package com.example.demo.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserDetailVO implements UserDetails{

	final MemberVO memberVO;

//	생성자만들기: 만들면 set필요 없음
//	public UserDetailVO() {}
//	public UserDetailVO(MemberVO memberVOv) {
//		this.memberVO = memberVO;
//	}
////	set만해주기
//	public void setMemberVO(MemberVO memberVO) {
//		this.memberVO = memberVO;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		System.out.println(memberVO.getResponsibility());
		list.add(new SimpleGrantedAuthority(memberVO.getResponsibility()));
		return list;
	}

	@Override
	public String getPassword() {
		return memberVO.getPass();
	}

	@Override
	public String getUsername() {
		return memberVO.getMid();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
