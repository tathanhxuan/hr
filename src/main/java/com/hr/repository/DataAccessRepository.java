package com.hr.repository;

import java.util.HashMap;

public interface DataAccessRepository {

	public HashMap<String, UserRepository> readUserMap();

	public HashMap<String, ApprovalRepository> readApprovalMap();

	public HashMap<String, AuthenticationRepository> readAuthenticationMap();

	public HashMap<String, FormRepository> readFormMap();

	public HashMap<String, HistoryRepository> readHistoryMap();

	public HashMap<String, ReportRepository> readReportMap();

}
