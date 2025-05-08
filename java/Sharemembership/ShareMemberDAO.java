package Sharemembership;

import common.JDBConnect;
import Sharemembership.ShareMemberDTO;

public class ShareMemberDAO extends JDBConnect{
	
	// 명시한 데이터베이스의 연결이 완료된 MemberDAO 객체를 생성
		public ShareMemberDAO(String drv, String url, String id, String pw) {
			// 부모 클래스 생성자를 호출
			super(drv, url, id, pw);
		}
		
		// 명시한 아이디/패스워드와 일치하는 회원 정보를 반환
		// 로그인 용
		public ShareMemberDTO getMemberDTO(String uid, String upass) {
			ShareMemberDTO dto = new ShareMemberDTO();				// 회원 정보 DTO 객체 생성
			String query = "SELECT * FROM member WHERE id =? AND pass=?";
							// 쿼리문 템플릿
			
			try {
				// 쿼리 실행
				psmt = con.prepareStatement(query);				// 동적 쿼리문을 실행하기위한 객체 새엉
				psmt.setString(1, uid);							// 쿼리문의 첫 번째 안피라미터의 값 설정
				psmt.setString(2, upass);						// 쿼리문의 두 번째 안피라미터의 값 설정
				rs = psmt.executeQuery();						// 쿼리문 실행
				
				// 결과 처리
				if (rs.next()) {
					// 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
					dto.setId(rs.getString("id"));
					dto.setPass(rs.getString("pass"));
					dto.setName(rs.getString("name"));
					dto.setBirth(rs.getString("birth"));
					dto.setEmail(rs.getString("email"));
					
					
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return dto;		// DTO 객체 반환
		}
		public int insertMember(ShareMemberDTO dto) {
		    int result = 0;

		    try {
		        String query = "INSERT INTO member (id, pass, name, birth, email) VALUES (?, ?, ?, ?, ?)";
		        psmt = con.prepareStatement(query);
		        psmt.setString(1, dto.getId());
		        psmt.setString(2, dto.getPass());
		        psmt.setString(3, dto.getName());
		        psmt.setString(4, dto.getBirth());
		        psmt.setString(5, dto.getEmail());

		        result = psmt.executeUpdate(); // 성공 시 1 반환
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return result;
		}
}
