package com.hr.domain.ApprovalCore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.hr.domain.ATForm;
import com.hr.domain.Department;
import com.hr.domain.DepartmentApprover;
import com.hr.domain.Employee;
import com.hr.domain.Form;
import com.hr.domain.FormLog;
import com.hr.domain.FormStatus;
import com.hr.domain.LeaveForm;
import com.hr.domain.OTForm;
import com.hr.domain.StepApprover;
import com.hr.logging.ILogger.LogLevel;
import com.hr.logging.LoggerImpl;
import com.hr.repository.storage.DataAccessRepositoryFacade;

//Implement detail proxy pattern by client
public class ApprovalCenter implements IApproval {

	private Employee emp;

	ApprovalCenter(Employee emp) {
		this.emp = emp;
	}

	// Get list of waiting approve forms base on employee
	public ArrayList<Form> getWaitedApproveForms() {
		// TODO Auto-generated method stub

		// get step [X] approve info from [department approver] table BASE ON EMPID AND
		// DEPTID
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();

		int approvalLevel = 0;
		ArrayList<DepartmentApprover> departmentApprovers = da.getListDepartmentApprover();
		//System.out.println("1: " + emp.getEmpID());
		//System.out.println(departmentApprovers);
		for (DepartmentApprover departmentApprover : departmentApprovers) {
			if (emp.getEmpID().equals(departmentApprover.getEmpID())) {
				//System.out.println("1: " + emp.getEmpID());
				//System.out.println("1:" + departmentApprover.getEmpID());
				//System.out.println("2: " + emp.getDept().getDeptID());
				//System.out.println("2:" + departmentApprover.getDeptID());
				if (emp.getDept().getDeptID().equals(departmentApprover.getDeptID())) {
					approvalLevel = departmentApprover.getApprovalLevel();
				}
			}
		}
		//System.out.println(approvalLevel);
		// get data from FORM (OT,AT,LEAVE) table WHERE DEPTID AND step = STEP X-1

		ArrayList<OTForm> oTForms = da.getListOTForm();
		ArrayList<ATForm> aTForms = da.getListATForm();
		ArrayList<LeaveForm> leaveForms = da.getListLeaveForm();

		ArrayList<Form> allForms = new ArrayList<Form>();
		for (OTForm oTForm : oTForms) {
			//System.out.println(oTForm.getOwner().getEmpID());
			if (emp.getDepartment().getDeptID().equals(oTForm.getOwner().getDepartment().getDeptID())
					&& oTForm.getStatus().getValue() == (approvalLevel - 1)) {
				allForms.add(oTForm);
			}
		}

		for (ATForm aTForm : aTForms) {
			//System.out.println(aTForm.getOwner().getEmpID());
			if (emp.getDepartment().getDeptID().equals(aTForm.getOwner().getDepartment().getDeptID())
					&& aTForm.getStatus().getValue() == (approvalLevel - 1)) {
				allForms.add(aTForm);
			}
		}

		for (LeaveForm leaveForm : leaveForms) {
			//System.out.println(leaveForm.getOwner().getEmpID());
			if (emp.getDepartment().getDeptID().equals(leaveForm.getOwner().getDepartment().getDeptID())
					&& leaveForm.getStatus().getValue() == (approvalLevel - 1)) {
				allForms.add(leaveForm);
			}
		}

		return allForms;
	}

	// approve forms base on form code
	public Boolean Approve(String formCode) {
		// TODO Auto-generated method stub
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		LoggerImpl logger = new LoggerImpl();
		ArrayList<OTForm> oTForms = da.getListOTForm();
		ArrayList<ATForm> aTForms = da.getListATForm();
		ArrayList<LeaveForm> leaveForms = da.getListLeaveForm();
		for (OTForm oTForm : oTForms) {
			if (oTForm.getFormCode().equals(formCode)) {
				//FormStatus formStatus1 = oTForm.getStatus();
				//formStatus1.setValue(oTForm.getStatus().getValue() + 1);
				if (oTForm.getStatus().getValue() == 1) {
					oTForm.setStatus(FormStatus.APPROVED_1ST);
				} else if (oTForm.getStatus().getValue() == 2) {
					oTForm.setStatus(FormStatus.APPROVED_2ND);
				} else if (oTForm.getStatus().getValue() == 3) {
					oTForm.setStatus(FormStatus.HRACCEPTED);
				}
				da.updateOTForm(oTForm);
				FormLog log = new FormLog(oTForm.getFormCode(),oTForm.getOwner().getEmpID(),oTForm.getStatus().toString(),"OT Form");
				log.SaveLog();
				// System.out.println(da.readOTFormMap());
				// Write to console log:				
				logger.message(oTForm.getFormCode().toString() + " " + oTForm.getStatus().toString(), LogLevel.INFO);
			}
		}

		for (ATForm aTForm : aTForms) {
			if (aTForm.getFormCode().equals(formCode)) {
				//FormStatus formStatus2 = aTForm.getStatus();
				//formStatus2.setValue(aTForm.getStatus().getValue() + 1);
				if (aTForm.getStatus().getValue() == 1) {
					aTForm.setStatus(FormStatus.APPROVED_1ST);
				} else if (aTForm.getStatus().getValue() == 2) {
					aTForm.setStatus(FormStatus.APPROVED_2ND);
				} else if (aTForm.getStatus().getValue() == 3) {
					aTForm.setStatus(FormStatus.HRACCEPTED);
				}
				da.updateATForm(aTForm);
				FormLog log = new FormLog(aTForm.getFormCode(),aTForm.getOwner().getEmpID(),aTForm.getStatus().toString(),"AT Form");
				log.SaveLog();
				// System.out.println(da.readATFormMap());
				// Write to console log:				
				logger.message(aTForm.getFormCode().toString() + " " + aTForm.getStatus().toString(), LogLevel.INFO);
			}
		}

		for (LeaveForm leaveForm : leaveForms) {
			if (leaveForm.getFormCode().equals(formCode)) {
				//FormStatus formStatus3 = leaveForm.getStatus();
				//formStatus3.setValue(leaveForm.getStatus().getValue() + 1);
				if (leaveForm.getStatus().getValue() == 1) {
					leaveForm.setStatus(FormStatus.APPROVED_1ST);
				} else if (leaveForm.getStatus().getValue() == 2) {
					leaveForm.setStatus(FormStatus.APPROVED_2ND);
				} else if (leaveForm.getStatus().getValue() == 3) {
					leaveForm.setStatus(FormStatus.HRACCEPTED);
				}

				da.updateLeaveForm(leaveForm);
				FormLog log = new FormLog(leaveForm.getFormCode(),leaveForm.getOwner().getEmpID(),leaveForm.getStatus().toString(),"Leave Form");
				log.SaveLog();
				// System.out.println(da.readLeaveFormMap());
				// Write to console log:				
				logger.message(leaveForm.getFormCode().toString() + " " + leaveForm.getStatus().toString(), LogLevel.INFO);
			}
		}

		return true;
	}

	// approve forms base on employee
	public Boolean Refuse(String formCode, String remark) {
		// TODO Auto-generated method stub

		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		LoggerImpl logger = new LoggerImpl();
		ArrayList<OTForm> oTForms = da.getListOTForm();
		ArrayList<ATForm> aTForms = da.getListATForm();
		ArrayList<LeaveForm> leaveForms = da.getListLeaveForm();
		for (OTForm oTForm : oTForms) {
			if (oTForm.getFormCode().equals(formCode)) {
				oTForm.setStatus(FormStatus.REFUSED);
				da.updateOTForm(oTForm);
				FormLog log = new FormLog(oTForm.getFormCode(),oTForm.getOwner().getEmpID(),FormStatus.REFUSED.toString(),remark);
				log.SaveLog();
				//System.out.println(da.readOTFormMap());
				// Write to console log:				
				logger.message(oTForm.getFormCode().toString() + " " + oTForm.getStatus().toString(), LogLevel.INFO);
			}
		}

		for (ATForm aTForm : aTForms) {
			if (aTForm.getFormCode().equals(formCode)) {
				aTForm.setStatus(FormStatus.REFUSED);
				da.updateATForm(aTForm);
				FormLog log = new FormLog(aTForm.getFormCode(),aTForm.getOwner().getEmpID(),FormStatus.REFUSED.toString(),remark);
				log.SaveLog();
				//System.out.println(da.readATFormMap());
				// Write to console log:				
				logger.message(aTForm.getFormCode().toString() + " " + aTForm.getStatus().toString(), LogLevel.INFO);
			}
		}

		for (LeaveForm leaveForm : leaveForms) {
			if (leaveForm.getFormCode().equals(formCode)) {
				leaveForm.setStatus(FormStatus.REFUSED);
				da.updateLeaveForm(leaveForm);
				FormLog log = new FormLog(leaveForm.getFormCode(),leaveForm.getOwner().getEmpID(),FormStatus.REFUSED.toString(),remark);
				log.SaveLog();
				//System.out.println(da.readLeaveFormMap());
				// Write to console log:				
				logger.message(leaveForm.getFormCode().toString() + " " + leaveForm.getStatus().toString(), LogLevel.INFO);
			}
		}

		return true;
	}

	public Boolean SetDepartmentApprover(ArrayList<DepartmentApprover> approvers) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean ApproveAll(ArrayList<Form> forms) throws Exception {
		// TODO Auto-generated method stub
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		LoggerImpl logger = new LoggerImpl();
		// implement transaction here for approve all form
		for (Form form : forms) {
			if (form instanceof OTForm) {
				OTForm oTForm = (OTForm) form;
				/*FormStatus formStatus = oTForm.getStatus();
				formStatus.setValue(oTForm.getStatus().getValue() + 1);
				oTForm.setStatus(formStatus);*/
				if (oTForm.getStatus().getValue() == 1) {
					oTForm.setStatus(FormStatus.APPROVED_1ST);
				} else if (oTForm.getStatus().getValue() == 2) {
					oTForm.setStatus(FormStatus.APPROVED_2ND);
				} else if (oTForm.getStatus().getValue() == 3) {
					oTForm.setStatus(FormStatus.HRACCEPTED);
				}
				da.updateOTForm(oTForm);
				
				// Write to FORM_LOG table
				FormLog log = new FormLog(oTForm.getFormCode(),oTForm.getOwner().getEmpID(),oTForm.getStatus().toString(),"OT Form");
				log.SaveLog();
				
				// Write to console log:				
				logger.message(oTForm.getFormCode().toString() + " " + oTForm.getStatus().toString(), LogLevel.INFO);
				
			} else if (form instanceof ATForm) {
				ATForm aTForm = (ATForm) form;
				if (aTForm.getStatus().getValue() == 1) {
					aTForm.setStatus(FormStatus.APPROVED_1ST);
				} else if (aTForm.getStatus().getValue() == 2) {
					aTForm.setStatus(FormStatus.APPROVED_2ND);
				} else if (aTForm.getStatus().getValue() == 3) {
					aTForm.setStatus(FormStatus.HRACCEPTED);
				}
				da.updateATForm(aTForm);
				// Write to FORM_LOG table
				FormLog log = new FormLog(aTForm.getFormCode(),aTForm.getOwner().getEmpID(),aTForm.getStatus().toString(),"AT Form");
				log.SaveLog();
				// Write to console log:				
				logger.message(aTForm.getFormCode().toString() + " " + aTForm.getStatus().toString(), LogLevel.INFO);
			} else if (form instanceof LeaveForm) {
				LeaveForm leaveForm = (LeaveForm) form;
				if (leaveForm.getStatus().getValue() == 1) {
					leaveForm.setStatus(FormStatus.APPROVED_1ST);
				} else if (leaveForm.getStatus().getValue() == 2) {
					leaveForm.setStatus(FormStatus.APPROVED_2ND);
				} else if (leaveForm.getStatus().getValue() == 3) {
					leaveForm.setStatus(FormStatus.HRACCEPTED);
				}
				
				da.updateLeaveForm(leaveForm);
				// Write to FORM_LOG table
				FormLog log = new FormLog(leaveForm.getFormCode(),leaveForm.getOwner().getEmpID(),leaveForm.getStatus().toString(),"Leave Form");
				log.SaveLog();
				
				// Write to console log:				
				logger.message(leaveForm.getFormCode().toString() + " " + leaveForm.getStatus().toString(), LogLevel.INFO);
			}
		}
		/*System.out.println(da.readATFormMap());
		System.out.println(da.readOTFormMap());
		System.out.println(da.readLeaveFormMap());*/
		System.out.println("Approve All Sussessfully");

		return null;
	}

	@Override
	public ArrayList<Form> getRefusedForms() throws Exception {
		// TODO Auto-generated method stub
		DataAccessRepositoryFacade da = new DataAccessRepositoryFacade();
		ArrayList<OTForm> oTForms = da.getListOTForm();
		ArrayList<ATForm> aTForms = da.getListATForm();
		ArrayList<LeaveForm> leaveForms = da.getListLeaveForm();

		ArrayList<Form> allForms = new ArrayList<Form>();
		for (OTForm oTForm : oTForms) {
				if (emp.getDepartment().getDeptID().equals(oTForm.getOwner().getDepartment().getDeptID())
					&& oTForm.getStatus().equals(FormStatus.REFUSED)) {
				allForms.add(oTForm);
			}
		}

		for (ATForm aTForm : aTForms) {
			if (emp.getDepartment().getDeptID().equals(aTForm.getOwner().getDepartment().getDeptID())
					&& aTForm.getStatus().equals(FormStatus.REFUSED)) {
				allForms.add(aTForm);
			}
		}

		for (LeaveForm leaveForm : leaveForms) {
			if (emp.getDepartment().getDeptID().equals(leaveForm.getOwner().getDepartment().getDeptID())
					&& leaveForm.getStatus().equals(FormStatus.REFUSED)) {
				allForms.add(leaveForm);
			}
		}

		return allForms;
		//return null;
	}

}
