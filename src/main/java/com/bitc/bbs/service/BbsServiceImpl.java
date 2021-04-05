package com.bitc.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.bbs.dto.BbsDto;
import com.bitc.bbs.mapper.BbsMapper;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	private BbsMapper bbsMapper;
	
	@Override
	public List<BbsDto> selectListBbs() throws Exception {
		return bbsMapper.selectListBbs();
	}
	
	@Override
	public BbsDto selectDetailBbs(int num) throws Exception {
		return bbsMapper.selectDetailBbs(num);
	}
	
	@Override
	public void insertBbs(BbsDto bbs) throws Exception {
		bbsMapper.insertBbs(bbs);
	}
	
	@Override
	public void updateBbs(BbsDto bbs) throws Exception {
		bbsMapper.updateBbs(bbs);
	}
	
	@Override
	public void deleteBbs(int num) throws Exception {
		bbsMapper.deleteBbs(num);
	}
}
