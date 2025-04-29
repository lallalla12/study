package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletContext;


public class JDBConnect {
	// Connection : 데이터베이스와 연결을 담당
	public Connection con;
	// Statement : 인파라미터가 없는 정적 쿼리문을 실행할 때 사용
	public Statement stmt;
	// PreparedStatement : 인파라미터가 있는 동적 쿼리문을 실행할 때 사용
	public PreparedStatement psmt;
	// ResultSet : SELECT 쿼리문의 결과를 저장할 때 사용
	public ResultSet rs;
	
	
	// 기본 생성자
	public JDBConnect() {
		try {
			// JDBC 드라이버 로드 , forName : 클래스명을 통해 직접 객체를 생성한 후 메모리에 로드하는 메서드
			Class.forName("com.mysql.jdbc.Driver");
			// DB에 연결
			String url = "jdbc:mysql://localhost:3306/musthave?serverTimezone=Asia/Seoul";
			String id = "root";
			String pwd = "0000";
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(기본 생성자)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 두 번째 생성자
	public JDBConnect(String driver, String url, String id, String pwd) {
		try {
			// JDBC 드라이버 로드
			Class.forName(driver);
			
			// DB에 연결
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(인수 생성자1)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 세 번째 생성자
	public JDBConnect(ServletContext application) {
		try {
			// JDBC 드라이버 로드
			String driver = application.getInitParameter("MySQLDriver");
			Class.forName(driver);
			
			// DB에 연결
			String url = application.getInitParameter("MySQLURL");
			String id = application.getInitParameter("MySQLId");
			String pwd = application.getInitParameter("MySQLpwd");
			con= DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(인수 생성자 2)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// 연결 해제 (자원 반납)
	public void close() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (psmt != null) psmt.close();
			if (con != null) con.close();
			
			System.out.println("JDBC 자원 해제");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
