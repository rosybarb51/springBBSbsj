package com.bitc.bbs.service;

import java.util.List;

import com.bitc.bbs.dto.BbsDto;

public interface BbsService {

	List<BbsDto> selectListBbs() throws Exception;
	
	BbsDto selectDetailBbs(int num) throws Exception;
	
	void insertBbs(BbsDto bbs) throws Exception;
	
	void updateBbs(BbsDto bbs) throws Exception;
	
	void deleteBbs(int num) throws Exception;
}
