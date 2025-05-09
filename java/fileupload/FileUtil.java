package fileupload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUtil {
    // 파일 업로드
	// getPart와 write 메서드는 각각 ServletException, IOException에 대한 예외처리를 해야함
	// 해당 메서드에서는 예외를 무시하고 호출된 지점으로 던지는데 throws를 사용
    public static String uploadFile(HttpServletRequest req, String sDirectory) 
    				throws ServletException, IOException {
    	// request 내장 객체의 getPart() 메서드로 file 타입으로 전송된 폼값을 받아 part 객체에 저장
    	Part part = req.getPart("ofile");
    	// Part 객체에 content-disposition 라는 헤더값을 읽어옴
    	String partHeader = part.getHeader("content-disposition");
    	// 헤더의 내용에서 파일명을 추출하기 위해 split()메서드로 분리한 후 더블퀘테이션을 제거함
        String[] phArr = partHeader.split("filename=");
        String originalFileName = phArr[1].trim().replace("\"", "");
        // 파일명이 빈 값이 아니라면 디렉터리 파일에 저장
        if (!originalFileName.isEmpty()) {
        	part.write(sDirectory + File.separator + originalFileName);
        }
        
        // 저장된 원본 파일명을 반환
        return originalFileName;
    }

    // 파일명 변경
    public static String renameFile(String sDirectory, String fileName) {
    	// 원본 파일명에서 확장자를 잘라냄
    	String ext = fileName.substring(fileName.lastIndexOf("."));
    	// 현재 날짜_시간 형식의 문자열을 생성
    	String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
    	// 확장자와 파일명을 연결하여 새로운 파일명을 생성
    	String newFileName = now + ext;
    	File oldFile = new File(sDirectory + File.separator + fileName);
    	File newFile = new File(sDirectory + File.separator + newFileName);
    	// 원본파일과 새로운 파일에 대한 file 객체를 생성한 후 파일명을 변경
    	oldFile.renameTo(newFile);
    	// 변경된 파일명을 반환
    	return newFileName;
    }
    
    // multiple 속성 추가로 2개 이상의 파일 업로드
    public static ArrayList<String> mulitpleFile(HttpServletRequest req,String sDirectory)
    		throws ServletException, IOException{
    	
    	// 2개 이상의 파일을 첨부하므로 원본 파일명을 저장하는 ArrayList 컬렉션을 생성함
    	ArrayList<String> listFileName = new ArrayList<>();
    	// getParts메서드로 전송된 폼값을 받음 for문으로 개수만큼 반복
    	Collection<Part> parts = req.getParts();
    	for(Part part : parts) {
    		// 파일을 첨부하는 데 사용할 input태그의 name 속성값은 ofile임. 
    		// 나머지 폼값은 저장의 대상이 아니므로, 파일을 저장하는 용도가 아닌 코드는 continue문을 통해 건너뜀
    		if(!part.getName().equals("ofile"))
    			continue;
    	// 헤더값에서 파일명을 추출하고, 디렉터리에 저장하는 코드는 uploadfile 메서드와 동일
    	String partHeader = part.getHeader("content-disposition");
    	String[] phArr = partHeader.split("filename=");
    	String originalFileName = phArr[1].trim().replace("\"", "");
    	 if (!originalFileName.isEmpty()) {
         	part.write(sDirectory + File.separator + originalFileName);
         }
    	 // 원본 파일명을 arraylist 컬렉션에 추가
    	 listFileName.add(originalFileName);
    	
    	}
    	// 파일명이 담겨있는 컬렉션을 반환
    	return listFileName;
    }
    		
    
}