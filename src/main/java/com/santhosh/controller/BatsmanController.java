package com.santhosh.controller;

import com.santhosh.dto.BatsmanDTO;
import com.santhosh.service.BatsmanRegistrationService;
import com.santhosh.vo.BatsmanVO;

public class BatsmanController 
{
	private BatsmanRegistrationService service;

	public BatsmanController(BatsmanRegistrationService service) 
	{
		this.service = service;
	}
	public String calculateAverage(BatsmanVO bvo) throws Exception
	{
		BatsmanDTO batsmanDTO=null;
		String result=null;
		batsmanDTO=new BatsmanDTO();
		batsmanDTO.setBatsmanId(bvo.getBatsmanId());
		batsmanDTO.setName(bvo.getName());
		batsmanDTO.setAge(bvo.getAge());
		batsmanDTO.setRunsScored(bvo.getRunsScored());
		batsmanDTO.setNoOfInnings(bvo.getNoOfInnings());
		batsmanDTO.setNotOuts(bvo.getNotOuts());
		result=service.calculateAverageRuns(batsmanDTO);
		return result;
	}
	
}
