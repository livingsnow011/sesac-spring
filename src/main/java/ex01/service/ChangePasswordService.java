package ex01.service;

import ex01.dao.MemberDao;
import ex01.exception.MemberNotFoundException;
import ex01.exception.WrongIdPasswordException;
import ex01.vo.Member;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	// 생성자를 통해서 의존객체를 주입
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public ChangePasswordService() {
		// TODO Auto-generated constructor stub
	}

	// setter 메서드를 통해서 의존객체 주입
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//패스워드 변경
	public void changePassword(String email, String oldPw, String newPw) throws MemberNotFoundException, WrongIdPasswordException {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPw, newPw);
		
		memberDao.update(member);
	}
}
