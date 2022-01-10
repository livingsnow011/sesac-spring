package ex01.service;

import ex01.exception.DuplicateMemberException;
import ex01.dao.MemberDao;
import ex01.vo.Member;
import ex01.vo.RegistRequest;

//회원 가입 처리 관련 클래스

public class MemberRegisterService {
	private MemberDao memberDao = new MemberDao();	//의존객체
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//회원 가입 서비스
	public Long regist(RegistRequest req) throws DuplicateMemberException {
		//이메일 중복 체크
		Member member = memberDao.selectByEmail(req.getEmail());
		//동일한 이메일 주소를 사용하는 사용자가 존재
		if (member != null) {
			throw new DuplicateMemberException("이메일 중복" + req.getEmail());
		}
		// 동일한 이메일 주소가 없는 경우, 사용자 정보를 등록
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
