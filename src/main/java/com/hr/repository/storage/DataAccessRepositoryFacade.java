package com.hr.repository.storage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import com.hr.domain.Approval;
import com.hr.domain.Form;
import com.hr.domain.History;
import com.hr.domain.Report;
import com.hr.domain.User;
import com.hr.repository.ApprovalRepository;
import com.hr.repository.DataAccessRepository;
import com.hr.repository.FormRepository;
import com.hr.repository.HistoryRepository;
import com.hr.repository.ReportRepository;
import com.hr.repository.UserRepository;
import com.hr.service.impl.UserServiceImpl;

//import model.dataaccess.DataAccessFacade.StorageType;

//import model.dataaccess.DataAccessFacade.StorageType;

public class DataAccessRepositoryFacade implements DataAccessRepository {

	enum StorageType {
		USERS, ADDRESSES;
	}

	public static final String OUTPUT_DIR = System.getProperty("user.dir")
			+ "//src//main//java//com//hr//repository//storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";

	@SuppressWarnings("unchecked")
	public HashMap<String, UserRepository> readUserMap() {
		// TODO Auto-generated method stub
		//return null;
		return (HashMap<String, UserRepository>)readFromStorage(StorageType.USERS);
	}

	public HashMap<String, ApprovalRepository> readApprovalMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, FormRepository> readFormMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, HistoryRepository> readHistoryMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, ReportRepository> readReportMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveNewUser(User user) {
		// TODO Auto-generated method stub

	}

	public void saveNewApproval(Approval approval) {
		// TODO Auto-generated method stub

	}

	public void saveNewForm(Form form) {
		// TODO Auto-generated method stub

	}

	public void saveNewHistory(History history) {
		// TODO Auto-generated method stub

	}

	public void saveNewReport(Report report) {
		// TODO Auto-generated method stub

	}
	
	
	/*@SuppressWarnings("unchecked")
	public HashMap<String, UserServiceImpl> readUserMapImpl() {
		// TODO Auto-generated method stub
		return (HashMap<String, UserServiceImpl>)readFromStorage(StorageType.USERS);
	}*/

	static void loadUserMap(List<UserServiceImpl> allUsers) {
		HashMap<String, UserServiceImpl> users = new HashMap<String, UserServiceImpl>();
		allUsers.forEach(user -> users.put(user.getEmpID(), user));
		saveToStorage(StorageType.USERS, users);
	}

	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}
	
	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}

}
