package com.hr.repository;

import java.util.List;

import com.hr.domain.DepartmentApprover;

public interface DepartmentApproverRepository {
	
	public List<DepartmentApprover> getAllApprovals();

	public DepartmentApprover getApproval(int id);

	public void updateApproval(DepartmentApprover approval);

	public void deleteApproval(DepartmentApprover approval);
}
