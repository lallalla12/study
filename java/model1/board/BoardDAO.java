package model1.board;

import jakarta.servlet.ServletContext;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import common.JDBConnect;
import java.sql.*;

public class BoardDAO extends JDBConnect {

    public BoardDAO(ServletContext application) {
        super(application);
    }

    // 게시물 수를 반환 (검색 조건 포함)
    public int selectCount(Map<String, Object> map) {
        int totalCount = 0;
        String query = "SELECT COUNT(*) FROM board";
        
        if (map.get("searchWord") != null) {
            query += " WHERE " + map.get("searchField") + " LIKE ?";
        }

        try {
            psmt = con.prepareStatement(query);
            if (map.get("searchWord") != null) {
                psmt.setString(1, "%" + map.get("searchWord") + "%");
            }
            rs = psmt.executeQuery();
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("게시물 수를 구하는 중 예외 발생");
            e.printStackTrace();
        }
        return totalCount;
    }
    
    // 검색 조건에 맞는 게시물 목록을 반환합니다.
    public List<BoardDTO> selectList(Map<String, Object> map) {
        List<BoardDTO> bbs = new Vector<BoardDTO>();

        String query = "SELECT * FROM board";
        if (map.get("searchWord")!=null) {
            query += " WHERE " + map.get("searchField") + " " + " LIKE '%" + map.get("searchWord") + "%' ";
        }

        query += " ORDER BY num DESC";

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);


            while (rs.next()) {
                BoardDTO dto = new BoardDTO();
                dto.setNum(rs.getString("num"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setPostdate(rs.getDate("postdate"));
                dto.setId(rs.getString("id"));
                dto.setVisitcount(rs.getString("visitcount"));
                bbs.add(dto);
            }

        } catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        }

        return bbs;
    }

    // 게시물 목록 조회 (검색 + 페이징)
    public List<BoardDTO> selectListPage(Map<String, Object> map) {
    	// 결과(게시물 목록)을 담을 변수
        List<BoardDTO> bbs = new Vector<BoardDTO>();
        
        // rownum 쿼리문
        String query = "SELECT * FROM board";
        boolean hasSearch = map.get("searchWord") != null;

        if (hasSearch) {
            query += " WHERE " + map.get("searchField") + " LIKE ?";
        }

        query += " ORDER BY num DESC LIMIT ?, ?";

        try {
            psmt = con.prepareStatement(query);

            int paramIndex = 1;

            if (hasSearch) {
                psmt.setString(paramIndex++, "%" + map.get("searchWord") + "%");
            }

            int start = Integer.parseInt(map.get("start").toString()) - 1;  // LIMIT는 0부터 시작
            int count = Integer.parseInt(map.get("end").toString()) - Integer.parseInt(map.get("start").toString()) + 1;

            psmt.setInt(paramIndex++, start);
            psmt.setInt(paramIndex, count);

            rs = psmt.executeQuery();

            while (rs.next()) {
                BoardDTO dto = new BoardDTO();
                dto.setNum(rs.getString("num"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setPostdate(rs.getDate("postdate"));
                dto.setId(rs.getString("id"));
                dto.setVisitcount(rs.getString("visitcount"));
                bbs.add(dto);
            }

        } catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        }

        return bbs;
    }


    // 게시물 작성
    public int insertWrite(BoardDTO dto) {
        int result = 0;

        try {
            String query = "INSERT INTO board (title, content, id, visitcount) VALUES (?, ?, ?, 0)";
            psmt = con.prepareStatement(query);
            psmt.setString(1, dto.getTitle());
            psmt.setString(2, dto.getContent());
            psmt.setString(3, dto.getId());

            result = psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("게시물 입력 중 예외 발생");
            e.printStackTrace();
        }

        return result;
    }

    // 게시물 상세 보기
    public BoardDTO selectView(String num) {
        BoardDTO dto = new BoardDTO();
        String query = "SELECT B.*, M.name FROM member M INNER JOIN board B ON M.id = B.id WHERE B.num = ?";

        try {
            psmt = con.prepareStatement(query);
            psmt.setString(1, num);
            rs = psmt.executeQuery();

            if (rs.next()) {
                dto.setNum(rs.getString("num"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setPostdate(rs.getDate("postdate"));
                dto.setId(rs.getString("id"));
                dto.setVisitcount(rs.getString("visitcount"));
                dto.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("게시물 상세보기 중 예외 발생");
            e.printStackTrace();
        }

        return dto;
    }

    // 조회수 증가
    public void updateVisitCount(String num) {
        String query = "UPDATE board SET visitcount = visitcount + 1 WHERE num = ?";

        try {
            psmt = con.prepareStatement(query);
            psmt.setString(1, num);
            psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("게시물 조회수 증가 중 예외 발생");
            e.printStackTrace();
        }
    }

    // 게시물 수정
    public int updateEdit(BoardDTO dto) {
        int result = 0;

        try {
            String query = "UPDATE board SET title = ?, content = ? WHERE num = ?";
            psmt = con.prepareStatement(query);
            psmt.setString(1, dto.getTitle());
            psmt.setString(2, dto.getContent());
            psmt.setString(3, dto.getNum());

            result = psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("게시물 수정 중 예외 발생");
            e.printStackTrace();
        }

        return result;
    }

    // 게시물 삭제
    public int deletePost(BoardDTO dto) {
        int result = 0;

        try {
            String query = "DELETE FROM board WHERE num = ?";
            psmt = con.prepareStatement(query);
            psmt.setString(1, dto.getNum());

            result = psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("게시물 삭제 중 예외 발생");
            e.printStackTrace();
        }

        return result;
    }
}
