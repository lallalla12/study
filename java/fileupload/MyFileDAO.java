package fileupload;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

// 커넥션 풀을 사용하기 위해 DBCoonPool을 상속
public class MyFileDAO extends DBConnPool {
	// 새로운 게시물을 입력하기 위한 메서드, 매개변수로 DTO 객체를 받음. 작성폼을 통해 전송된 값이 DTO 객체에 저장한 후 
	// 이 insertFile메서드의 인수로 전달됨
    public int insertFile(MyFileDTO dto) {
    	// INSERT 쿼리문을 실행한 후 적용된 행의 개수를 저장하기 위한 변수 생성
        int applyResult = 0;
        try {
        	String query = "INSERT INTO myfile (title, cate, ofile, sfile) "
                    		+ "VALUES (?, ?, ?, ?)";
                        
        	// prepareStatement객체 생성
            psmt = con.prepareStatement(query);
            // ?로 지정된 인파라미터를 설정, DTO 객체의 게터 메서드를 사용
            psmt.setString(1, dto.getTitle());
            psmt.setString(2, dto.getCate());
            psmt.setString(3, dto.getOfile());
            psmt.setString(4, dto.getSfile());
            
            // INSERT 쿼리문 변수의 값 할당
            // 쿼리문을 실행하면 적용된 행의 개수가 정수로 반환 1이라면 성공, 0이라면 실패
            applyResult = psmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("INSERT 중 예외 발생");
            e.printStackTrace();
        }        
        return applyResult;
    }

    // 파일 목록을 반환합니다.
    public List<MyFileDTO> myFileList() {
    	// List컬렉션을 생성
        List<MyFileDTO> fileList = new Vector<MyFileDTO>();

        // 쿼리문 작성
        String query = "SELECT * FROM myfile ORDER BY idx DESC";
        try {
        	// 쿼리 준비
            stmt = con.createStatement();  
            // 쿼리 실행
            rs = stmt.executeQuery(query);  
            
            // 목록 안의 파일 수만큼 반복
            while (rs.next()) {  
                // DTO에 저장하고 컬럼의 순서대로 인덱스를 이용하여 추출
            	MyFileDTO dto = new MyFileDTO();
                dto.setIdx(rs.getString(1));
                dto.setTitle(rs.getString(2));
                dto.setCate(rs.getString(3));
                dto.setOfile(rs.getString(4));
                dto.setSfile(rs.getString(5));
                dto.setPostdate(rs.getString(6));
                
                // 목록에 추가
                fileList.add(dto);  
            }
        }
        catch (Exception e) {
            System.out.println("SELECT 시 예외 발생");
            e.printStackTrace();
        }        
        
     // 목록 반환
        return fileList;  
    }
}