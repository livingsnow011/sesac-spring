package ex01.dao;

// 회원 데이터 관련 클래스

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ex01.vo.Member;

//DAO = Data Access Object
//일반적으로 DB와의 연동을 구현

//여기에서는 HashMap에 데이터를 저장, 수정, 조회 기능을 구현
public class MemberDao {
	//Field
	//회원정보를 저장할 필드를 정의
	private Map<String, Member> map = new HashMap<>();
	//           key     value ==> email을 key로 지정
	
	//회원ID를 부여할 필드를 정의
	private long nextId = 0;
	
	//파라미터로 전달된 이메일과 일치하는 회원 정보(Member)를 조회해서 반환
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	//파라미터로 전달된 회원 정보를 DB에 저장
	public void insert(Member member) {
		nextId++;
		member.setId(nextId);
		map.put(member.getEmail(), member);
	}
	
	//모든 회원 정보를 조회, 반환
	public Collection<Member> selectAll() {
		return map.values();
	}
	
	//회원 정보 수정
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
}
