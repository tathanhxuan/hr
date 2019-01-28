package com.hr.repository;

import java.util.List;

import com.hr.domain.Report;

public interface ReportRepository {
	public List<Report> getAllReports();

	public Report getReport(int id);

	public void updateReport(Report report);

	public void deleteReport(Report report);
}
