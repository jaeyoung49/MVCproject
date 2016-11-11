package org.kosta.mvcproject.model;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO extends AbstractDAO {
	
	// 회원가입
	public void join(MemberVO memberVO) {
		template.insert("member.join", memberVO);
	}

	// 로그인
	public Object login(MemberVO memberVO) {
		return template.selectOne("member.login", memberVO);
	}
	
	// 아이디로 회원검색
	public MemberVO findMemberById(String id) {
		return template.selectOne("member.findMemberById", id);
	}

	// 회원정보변경
	public void changeMyInfo(MemberVO memberVO) {
		template.update("member.changeMyInfo", memberVO);
	}
	
	// 회원 게시글 갯수 증가
	public void updateMemberArticleCount(MemberVO memberVO){
		template.update("member.updateMemberArticleCount", memberVO);
	}
	
}
