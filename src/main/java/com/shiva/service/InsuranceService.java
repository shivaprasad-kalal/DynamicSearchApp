package com.shiva.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.shiva.commons.InsuranceSearchCriteria;
import com.shiva.entity.Insurance;
import com.shiva.repo.InsuranceRepository;

@Service
public class InsuranceService {
	private InsuranceRepository ipr;

	public InsuranceService(InsuranceRepository ipr) {
		this.ipr = ipr;
	}

	public List<Insurance> search(InsuranceSearchCriteria sc) {
		Insurance ins = new Insurance();
		if (null != sc.getPlanName() && !"".equals(sc.getPlanName())) {
			ins.setPlanName(sc.getPlanName());
		}
		if (null != sc.getPlanStatus() && !"".equals(sc.getPlanStatus())) {
			ins.setPlanStatus(sc.getPlanStatus());
		}
		Example<Insurance> example = Example.of(ins);
		return ipr.findAll(example);
	}
}
