package com.sgic.internal.defecttracker.defectservice.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgic.internal.defecttracker.defectservice.controller.dto.AuditLogData;
import com.sgic.internal.defecttracker.defectservice.controller.dto.converter.AuditLogDtoConverter;
import com.sgic.internal.defecttracker.defectservice.entities.AuditLog;
import com.sgic.internal.defecttracker.defectservice.services.AuditLogService;

import org.springframework.stereotype.Service;

@Service
public class AuditLogMapper {
	
	@Autowired
	private AuditLogDtoConverter auditLogConverter;
	@Autowired
	private AuditLogService auditLogService;

	public AuditLog createAuditLog(AuditLogData auditLogData) {
		AuditLog responseAuditLog = auditLogService.createAuditLog(auditLogConverter.DTOtoEntity(auditLogData));
		return responseAuditLog;
	}
	
	public List<AuditLog> getAuditLogById(Long defectId){
		return auditLogService.getAuditLogById(defectId);
	}
	
	public List<AuditLogData> getAllById(){
		List<AuditLog> auditLogList = auditLogService.getAllAuditLogs();
		return auditLogConverter.ListEntityToDTO(auditLogList);
	}
}