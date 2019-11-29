package com.sgic.internal.product.controller.dto.mapper;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.CompanyDto;
import com.sgic.internal.product.controller.dto.converter.CompanyConverter;
import com.sgic.internal.product.entities.Company;
import com.sgic.internal.product.services.CompanyService;

@Service
public class CompanyMapper {
	@Autowired
	private CompanyConverter companyConverter;
	@Autowired
	private CompanyService companyService;

	private static Logger logger = LogManager.getLogger(CompanyDto.class);

	// Get All Company
	@SuppressWarnings("static-access")
	public List<CompanyDto> getAllCompany() {
		logger.info("Company Mapper -> All Company Data Retrieved");
		List<Company> companyList = companyService.getAllCompany();
		return companyConverter.CompanyEntityTOCompanyDataList(companyList);
	}

	// Save Company
	@SuppressWarnings("static-access")
	public Company saveCompany(CompanyDto companyDto) {
		logger.info("Company Mapper -> Company Saved");
		return companyService.saveCompany(companyConverter.companyDataToCompanyEntity(companyDto));
	}

	// Update Company
	@SuppressWarnings("static-access")
	public Company updateCompany(CompanyDto companyDto) {
		logger.info("Company Mapper -> Company Updated ", companyDto.getCompanyId());
		return companyService.updateCompany(companyConverter.companyDataToCompanyEntity(companyDto));
	}

	// Delete Company
	public CompanyDto deleteCompanyById(Long companyId) {
		logger.info("Company Mapper -> Company Deleted");
		companyService.deleteCompanyById(companyId);
		return null;
	}

	// Get Company By Id
	@SuppressWarnings("static-access")
	public CompanyDto getCompanyById(Long companyId) {
		logger.info("Company Mapper -> Company Id Found");
		Company company = companyService.getCompanyById(companyId);
		return companyConverter.CompanyEntityToCompanyData(company);
	}

}
