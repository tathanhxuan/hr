package com.hr.repository;

import java.util.List;

import com.hr.domain.History;

public interface HistoryRepository {
	public List<History> getAllHistorys();

	public History getHistory(int id);

	public void updateHistory(History history);

	public void deleteHistory(History history);
}
