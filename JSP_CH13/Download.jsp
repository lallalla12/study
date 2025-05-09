<%@ page import="utils.JSFunction"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.OutputStream"%>
<%@ page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// Uploads 폴더의 물리적 경로를 얻어옴
String saveDirectory = application.getRealPath("/Uploads");
// 저장된 파일명과 원본 파일명을 매개변수로 받아 변수에 저장
String saveFilename = request.getParameter("sName");
String originalFilename = request.getParameter("oName");

try {
    // 파일을 찾아 입력 스트림 생성
    File file = new File(saveDirectory, saveFilename);  
    InputStream inStream = new FileInputStream(file);
    
    // 한글 파일명 깨짐 방지
    // reqeust 내장 객체를 통해 요청 헤더 중 User-Agent를 읽어옴, 이 값으로 요청을 보낸 웹 브라우저의 종류를 알 수 있음
    String client = request.getHeader("User-Agent");
    // 파일 깨짐 방지를 위한 처리
    if (client.indexOf("WOW64") == -1) {
        originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-8859-1");
    }
    else {
        originalFilename = new String(originalFilename.getBytes("KSC5601"), "ISO-8859-1");
    }
   
    // 파일 다운로드용 응답 헤더 설정 
    // 응답 헤더를 초기화한 후 
    response.reset();
    // 파일 다운로드 창을 띄우기위한 콘텐츠 타입을 지정
    // octet-stream은 8비트 단위의 바이너리 데이터를 의미함, 응답 헤더로 설정하게되면 파일 종류 상관없이 다운로드 창 띄움
    response.setContentType("application/octet-stream");
    // 웹 브라우저에서 파일 다운로드 창이 뜰 때 원본 파일명이 기본으로 입력되어 있도록 설정
    response.setHeader("Content-Disposition", 
                       "attachment; filename=\"" + originalFilename + "\"");
    response.setHeader("Content-Length", "" + file.length() );
    
    // 새로운 출력 스트림을 생성하기 위해 초기화
    // JSP가 열린 상태에서 다운로드를 하려고 또 열게되면 중복으로 생성되기 때문
    out.clear();  
    
    // response 내장 객체로부터 새로운 출력 스트림 생성
    OutputStream outStream = response.getOutputStream();  

    // 출력 스트림에 파일 내용 출력
    byte b[] = new byte[(int)file.length()];
    int readBuffer = 0;    
    while ( (readBuffer = inStream.read(b)) > 0 ) {
        outStream.write(b, 0, readBuffer);
    }

    // 입/출력 스트림 닫음
    inStream.close(); 
    outStream.close();
}
catch (FileNotFoundException e) {
    JSFunction.alertBack("파일을 찾을 수 없습니다.", out);
}
catch (Exception e) {
    JSFunction.alertBack("예외가 발생하였습니다.", out);
}
%>