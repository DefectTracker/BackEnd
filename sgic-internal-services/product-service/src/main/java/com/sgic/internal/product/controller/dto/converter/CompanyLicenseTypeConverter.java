package com.sgic.internal.product.controller.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sgic.internal.product.controller.dto.CompanyLicenseTypeDto;
import com.sgic.internal.product.entities.CompanyLicenseType;


@Service
public class CompanyLicenseTypeConverter {
	
	private static Logger logger = LogManager.getLogger(CompanyLicenseType.class);

	// Convert All List<Entity> to List<DTO>
	public static List<CompanyLicenseTypeDto> EntityListTODtoList(List<CompanyLicenseType> companyLicenseTypeList) {
		if (companyLicenseTypeList != null) {
			logger.info("Company LicenceType Converter -> Convert Lists Entity to DTO");
			List<CompanyLicenseTypeDto> listCompanyLicenseTypeDto = new ArrayList<>();
			for (CompanyLicenseType companyLicenseType : companyLicenseTypeList) {
				CompanyLicenseTypeDto companyLicenseTypeDto = new CompanyLicenseTypeDto();
//				companyLicenseTypeDto.setLicenseId(companyLicenseType.getLicenseId());
				companyLicenseTypeDto.setLicenseType(companyLicenseType.getLicenseType());
				listCompanyLicenseTypeDto.add(companyLicenseTypeDto);
			}
			return listCompanyLicenseTypeDto;
		}
		return null;
	}

	// Convert Data To Entity
			public static CompanyLicenseType DtoToEntityUpdate(CompanyLicenseTypeDto companyLicenseTypeDto) {
				CompanyLicenseType companyLicenseType = new CompanyLicenseType();
				if (companyLicenseTypeDto != null) {
					logger.info("Company LicenceTypeDto Converter -> Convert Object DTO to Entity");
//					companyLicenseType.setLicenseId(companyLicenseTypeDto.getLicenseId());
					companyLicenseType.setLicenseType(companyLicenseTypeDto.getLicenseType());
					
					return companyLicenseType;
				}
				return null;
			}

}
