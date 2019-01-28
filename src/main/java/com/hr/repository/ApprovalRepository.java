package com.hr.repository;

import java.util.List;

import com.hr.domain.Approval;

public interface ApprovalRepository {
	public List<Approval> getAllApprovals();

	public Approval getApproval(int id);

	public void updateApproval(Approval approval);

	public void deleteApproval(Approval approval);
}
