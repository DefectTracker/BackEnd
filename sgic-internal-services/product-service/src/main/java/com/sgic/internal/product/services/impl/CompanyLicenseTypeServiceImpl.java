package com.sgic.internal.product.services.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.CompanyLicenseTypeDto;
import com.sgic.internal.product.entities.CompanyLicenseType;
import com.sgic.internal.product.repositories.CompanyLicenseTypeRepository;
import com.sgic.internal.product.services.CompanyLicenseTypeService;

@Service
public class CompanyLicenseTypeServiceImpl implements CompanyLicenseTypeService{
	@Autowired
	CompanyLicenseTypeRepository companyLicenseTypeRepository;

	private static Logger logger = LogManager.getLogger(CompanyLicenseTypeRepository.class);

	@Override
	public List<CompanyLicenseType> getAllCompanyLicenseType() {
		return companyLicenseTypeRepository.findAll();
	}

	@Override
	public CompanyLicenseType saveCompanyLicenseType(CompanyLicenseType companyLicenseType) {
		companyLicenseTypeRepository.save(companyLicenseType);
		return null;
	}

}
