package ex01.service;

import java.util.Collection;

import ex01.dao.MemberDao;

public class MemberListPrint {
	
	private MemberDao memberDao;
	private MemberPrint print;
	
	//생성자를 이용해서 의존객체 주입
	public MemberListPrint(MemberDao memberDao, MemberPrint print) {
		this.memberDao = memberDao;
		this.print = print;
	}
	
	public void printAll() {
		Collection<ex01.vo.Member> members = memberDao.selectAll();
		members.forEach(m -> print.print(m));
	}
}
