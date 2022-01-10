package ex01.service;

import ex01.dao.MemberDao;
import ex01.vo.Member;

// 회원 정보를 하나 출력하는 기능을 추가 -> setter 메서드를 이용해서 의존객체를 주입하는 방법
public class MemberInfoPrint {
	//Field
	private MemberDao memberDao;
	private MemberPrint print;
	
	//Method Setter
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setMemberPrint(MemberPrint print) {
		this.print = print;
	}
	
	// Method 이메일을 받아서 출력
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member==null) {
			System.out.println("일치하는 데이터가 없습니다.");
			return;
		}
		print.print(member);
	}
}
