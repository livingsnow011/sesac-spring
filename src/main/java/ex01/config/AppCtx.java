package ex01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex01.dao.MemberDao;
import ex01.service.ChangePasswordService;
import ex01.service.MemberInfoPrint;
import ex01.service.MemberListPrint;
import ex01.service.MemberPrint;
import ex01.service.MemberRegisterService;
import ex01.service.VersionPrinter;

@Configuration
public class AppCtx {
	
	// 해당 메서드가 생성한 객체를 스프링 빈으로 설정 (메서드 이름을 빈(Bean) 객체의 이름으로 사용
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		//생성자를 이용해서 의존 객체를 주입
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		//setter 메서드를 이용해서 의존 객체를 주입
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberPrint memberPrint() {
		return new MemberPrint();
	}
	
	@Bean
	public MemberListPrint memberListPrint() {
		return new MemberListPrint(memberDao(), memberPrint());
	}
	
	@Bean
	public MemberInfoPrint memberInfoPrint() {
		MemberInfoPrint mip = new MemberInfoPrint();
		mip.setMemberDao(memberDao());
		mip.setMemberPrint(memberPrint());
		return mip;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(1);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
