package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
// @RequestMapping 없으므로 /* 로 실행
@Log4j
public class UploadController {
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		
		log.info("upload form");
	}
	
	@PostMapping("/uploadFormAction")
	// 첨부 파일이 여러 개일 수 있으므로 배열 타입으로 설정
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "C:\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {
			
			log.info("----------------------------");
			log.info("upload File Name : " + multipartFile.getOriginalFilename());
			log.info("upload File Size : " + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				// transferTo() - 파일을 저장하는 메서드(파라미터는 File타입)
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			} // try-catch 끝
			
		} // for문 끝
		
		
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax");
	}
	
	// 년월일 폴더 생성
	private String getFolder() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}
	 

	
	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {

		List<AttachFileDTO> list = new ArrayList<AttachFileDTO>();
		String uploadFolder = "C:\\upload";

		String uploadFolderPath = getFolder();
		// make folder --------
		File uploadPath = new File(uploadFolder, uploadFolderPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		// make yyyy/MM/dd folder

		for (MultipartFile multipartFile : uploadFile) {

			AttachFileDTO attachDTO = new AttachFileDTO();

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name: " + uploadFileName);
			attachDTO.setFileName(uploadFileName);
			
			// 파일명이 중복이 되면 새로운 파일이 기존에 있는 파일을 덮어쓰기가 되므로 기존에 있는 파일
			// 이걸 해결하기 위해 UUID클래스에 있는 randomUUID 메소드를 파일명과 조합해서 
			
			UUID uuid = UUID.randomUUID();

			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);

				// 섬네일 이미지 파일도 저장
				// 이미지 인지 아닌지 판단
				if (checkImageType(saveFile)) {
					
					// 이미지파일이면
					attachDTO.setImage(true);

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);

					thumbnail.close();
				}

				// add to List
				list.add(attachDTO);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} // end for
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	 
	 // 이미지 파일인지 판단
	 private boolean checkImageType(File file) {

			try {
				String contentType = Files.probeContentType(file.toPath());

				return contentType.startsWith("image");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return false;
	} // checkImageType 끝
	 
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {

		log.info("fileName: " + fileName);

		File file = new File("c:\\upload\\" + fileName);

		log.info("file: " + file);

		ResponseEntity<byte[]> result = null;

		try {
			HttpHeaders header = new HttpHeaders();

			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	} // getFile 끝
	

	
	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(
			@RequestHeader("User-Agent") String userAgent, String fileName) {

		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);

		if (resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String resourceName = resource.getFilename();

		// remove UUID
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

		HttpHeaders headers = new HttpHeaders();
		try {

			boolean checkIE = (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1);

			String downloadName = null;

			if (checkIE) {
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF8").replaceAll("\\+", " ");
			} else {
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}

			headers.add("Content-Disposition", "attachment; filename=" + downloadName);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
		

		@PostMapping("/deleteFile")
		@ResponseBody
		public ResponseEntity<String> deleteFile(String fileName, String type) {

			log.info("deleteFile: " + fileName);

			File file;

			try {
				file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));

				file.delete();

				if (type.equals("image")) {

					String largeFileName = file.getAbsolutePath().replace("s_", "");

					log.info("largeFileName: " + largeFileName);

					file = new File(largeFileName);

					file.delete();
				}

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<String>("deleted", HttpStatus.OK);

		}
		
}



