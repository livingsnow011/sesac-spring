package ex01.service;

import ex01.vo.Member;

public class MemberPrint {
	//멤버 객체의 내용을 형식에 맞춰서 출력
	public void print(Member member) {
		System.out.printf("회원정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
				member.getId(), member.getEmail(), member.getName(), member.getRegistDate());
	}
}
