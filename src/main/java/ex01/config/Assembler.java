package ex01.config;

import ex01.dao.MemberDao;
import ex01.service.ChangePasswordService;
import ex01.service.MemberRegisterService;

public class Assembler {
	//Field
	private MemberDao memberDao;
	private MemberRegisterService memberRegisterService;
	private ChangePasswordService changePasswordService;
	
	//Constructor
	public Assembler() {
		memberDao = new MemberDao();
		memberRegisterService = new MemberRegisterService(memberDao);
		changePasswordService = new ChangePasswordService(memberDao);
	}
	
	//Method (Getter)
	public MemberRegisterService getMemberRegisterService() {
		return this.memberRegisterService;
	}
	public ChangePasswordService getChangePasswordService() {
		return this.changePasswordService;
	}
}
 