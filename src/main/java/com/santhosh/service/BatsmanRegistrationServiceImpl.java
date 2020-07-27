package com.santhosh.service;

import com.santhosh.bo.BatsmanBO;
import com.santhosh.dao.BatsmanRegistrationDAO;
import com.santhosh.dto.BatsmanDTO;

public class BatsmanRegistrationServiceImpl implements BatsmanRegistrationService
{
	private BatsmanRegistrationDAO bdao;

	public BatsmanRegistrationServiceImpl(BatsmanRegistrationDAO bdao) {
		this.bdao = bdao;
	}

	@Override
	public String calculateAverageRuns(BatsmanDTO dto) throws Exception {
		int avgruns=0;
		avgruns=dto.getRunsScored()/(dto.getNoOfInnings()-dto.getNotOuts());
		BatsmanBO batsmanBO=new BatsmanBO();
		batsmanBO.setBatsmanId(dto.getBatsmanId());
		batsmanBO.setName(dto.getName());
		batsmanBO.setAge(dto.getAge());
		batsmanBO.setNoOfInnings(dto.getNoOfInnings());
		batsmanBO.setRunsScored(dto.getRunsScored());
		batsmanBO.setNotOuts(dto.getNotOuts());
		int count=bdao.insertBatsman(batsmanBO);
		if(count==1)
			return "Batsman Registration Succeded :: Name is "+dto.getName()+"  and Average is "+avgruns;
		else 
			return "Batsman Registration Failed";
	}
	
}
