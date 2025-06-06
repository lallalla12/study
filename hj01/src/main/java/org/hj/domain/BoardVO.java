package org.hj.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	

	private int bno;
	private String title;
	private String content;
	private String writer;
	private int count;
	private Date regdate;
	private Date updatedate;
}
