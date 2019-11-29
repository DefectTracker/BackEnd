package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.CompanyDto;
import com.sgic.internal.product.entities.Company;
import com.sgic.internal.product.entities.CompanyLicenseType;

@Service
public class CompanyConverter {
	private static Logger logger = LogManager.getLogger(CompanyDto.class);

	// Convert All List Company's Entity to DTO
	public static List<CompanyDto> CompanyEntityTOCompanyDataList(List<Company> companyList) {
		if (companyList != null) {
			logger.info("Company Converter -> Convert Lists Entity to DTO");
			List<CompanyDto> listCompanyData = new ArrayList<>();
			for (Company company : companyList) {
				CompanyDto companyDto = new CompanyDto();

				companyDto.setCompanyId(company.getId());
				companyDto.setCompanyName(company.getName());
				companyDto.setCompanyAbbrivation(company.getAbbrivation());
				companyDto.setCompanyRegNo(company.getRegNo());
				companyDto.setCompanyAdminName(company.getCompanyAdminName());
				companyDto.setCompanyAdminEmail(company.getAdminEmail());
				
				companyDto.setCompanyLicenseTypeId(company.getLicenseTypeId().getLicenseId());
				companyDto.setCompanyLicenseTypeName(company.getLicenseTypeId().getLicenseType());
				
				companyDto.setCompanyLicensePeriod(company.getLicensePeriod());
				companyDto.setLicenseStartDate(company.getStartDate());
				companyDto.setLicenseEndDate(company.getEndDate());
				companyDto.setCompanyDescription(company.getDescription());

				listCompanyData.add(companyDto);
			}
			return listCompanyData;
		}
		return null;
	}

	// Convert CompanyData To CompanyEntity
		public static Company companyDataToCompanyEntity(CompanyDto companyDto) {
			Company company = new Company();
			if (companyDto != null) {
				logger.info("Company Converter -> Convert Object DTO to Entity");
				company.setId(companyDto.getCompanyId());
				company.setName(companyDto.getCompanyName());
				company.setAbbrivation(companyDto.getCompanyAbbrivation());
				company.setRegNo(companyDto.getCompanyRegNo());
				company.setCompanyAdminName(companyDto.getCompanyAdminName());
				company.setAdminEmail(companyDto.getCompanyAdminEmail());
				
				CompanyLicenseType companyLicenseType = new CompanyLicenseType();
				companyLicenseType.setLicenseId(companyDto.getCompanyLicenseTypeId());
				companyLicenseType.setLicenseType(companyDto.getCompanyLicenseTypeName());
				company.setLicenseTypeId(companyLicenseType);
				
				company.setLicensePeriod(companyDto.getCompanyLicensePeriod());
				company.setStartDate(companyDto.getLicenseStartDate());
				company.setEndDate(companyDto.getLicenseEndDate());
				company.setDescription(companyDto.getCompanyDescription());
				return company;
			}
			return null;
		}

		// Convert CompanyEntity To CompanyData
		public static CompanyDto CompanyEntityToCompanyData(Company company) {
			CompanyDto companyDto = new CompanyDto();
			if (company != null) {
				logger.info("Company Converter -> Convert Object Entity to DTO");
				companyDto.setCompanyId(company.getId());
				companyDto.setCompanyName(company.getName());
				companyDto.setCompanyAbbrivation(company.getAbbrivation());
				companyDto.setCompanyRegNo(company.getRegNo());
				companyDto.setCompanyAdminName(company.getCompanyAdminName());
				companyDto.setCompanyAdminEmail(company.getAdminEmail());
				
				companyDto.setCompanyLicenseTypeId(company.getLicenseTypeId().getLicenseId());
				companyDto.setCompanyLicenseTypeName(company.getLicenseTypeId().getLicenseType());
				
				companyDto.setCompanyLicensePeriod(company.getLicensePeriod());
				companyDto.setLicenseStartDate(company.getStartDate());
				companyDto.setLicenseEndDate(company.getEndDate());
				companyDto.setCompanyDescription(company.getDescription());
				return companyDto;
			}
			return null;
		}

}
