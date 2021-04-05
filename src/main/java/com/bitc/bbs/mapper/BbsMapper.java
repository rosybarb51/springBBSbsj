package com.bitc.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.bbs.dto.BbsDto;

@Mapper
public interface BbsMapper {

	List<BbsDto> selectListBbs() throws Exception;
	
//	상세내용
	BbsDto selectDetailBbs(int num) throws Exception;
	
	void insertBbs(BbsDto bbs) throws Exception;
	
//	수정
	void updateBbs(BbsDto bbs) throws Exception;
	
//	삭제
	void deleteBbs(int num) throws Exception;
}