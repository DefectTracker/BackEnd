package com.sgic.internal.defecttracker.defectservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.internal.defecttracker.defectservice.entities.ModuleAllocation;
import com.sgic.internal.defecttracker.defectservice.entities.ModuleAssign;

@Repository
public interface ModuleAssignRepository extends JpaRepository<ModuleAssign, Long> {

}
