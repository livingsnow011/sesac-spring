package ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ex01.dao.MemberDao;
import ex01.exception.DuplicateMemberException;
import ex01.exception.MemberNotFoundException;
import ex01.exception.WrongIdPasswordException;
import ex01.service.ChangePasswordService;
import ex01.service.MemberRegisterService;
import ex01.vo.RegistRequest;

public class Main {
	
	static MemberDao dao = new MemberDao();
	
	public static void main(String[] args) throws IOException {
		//import
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//프로그램 실행
		while(true) {
			System.out.println("| new: 등록 | change: 변경 | exit: 종료 |");
			System.out.print("명령어를 입력하세요>> ");
			String command = reader.readLine();
			// 선택 조건
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				break;
			} else if(command.startsWith("new")) {
				//new_email_name_password confirm_password
				doRegist(command.split(" "));
			} else if(command.startsWith("change")) {
				doChangePassword(command.split(" "));
			}
		}
	}
	
	// 비밀번호 변경 메서드
	private static void doChangePassword(String[] args) {
		// change email old_password new_password
		if(args.length !=4 ) {
			System.out.println("change email oldpassword new password");
			return;
		}
		
		// change_password_variable
		ChangePasswordService cps = new ChangePasswordService(dao);
		try {
			cps.changePassword(args[1], args[2], args[3]);
		} catch (MemberNotFoundException e) {
			System.out.println("일치하는 회원 정보가 존재하지 않습니다.");
		} catch (WrongIdPasswordException e) {
			System.out.println("이메일과 패스워드가 일치하지 않습니다.");
		}
	}
	
	// 회원 가입
	private static void doRegist(String[] args) {
		// new email name password confirm_password
		if(args.length != 5) {
			System.out.println("new email name password confirmpassword");
			return;
		}
		
		MemberRegisterService mrs = new MemberRegisterService(dao);
			RegistRequest request = new RegistRequest();
			request.setEmail(args[1]);
			request.setName(args[2]);
			request.setPassword(args[3]);
			request.setConfirmPassword(args[4]);
			
			try {
				mrs.regist(request);
				System.out.println("정상적으로 등록되었습니다.");
			} catch (DuplicateMemberException e) {
				System.out.println("이미 등록된 사용자 입니다.");
			}
		
	}
	

}
