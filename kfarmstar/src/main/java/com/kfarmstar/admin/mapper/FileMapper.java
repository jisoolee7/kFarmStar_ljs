package com.kfarmstar.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.FileDto;

@Mapper
public interface FileMapper {

	// 단일 파일 삽입
	public int addFile(FileDto fileDto);

	// 여러개 파일 삽입
	public int addFiles(List<FileDto> fileList);
	
	// 1:N 관계 테이블(파일)
	public int addFilesContol(List<Map<String,String>> paramMapList);
}
