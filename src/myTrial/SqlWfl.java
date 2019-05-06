package myTrial;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SqlWfl {

	public static void main(String[] args) {
		String menu = "Accounting Rule";
		String createdBy = "rumaria";
		String docCode = "ACCRULE";
		String apiInsert = "api/accountingrule/transaction/workflow-proccess/v.1";
		String apiGetById = "api/accountingrule/view/get-byId/v.1";
		String apiDelete = "api/accountingrule/transaction/delete/v.1";
		
		String newObjTypeId = UUID.randomUUID().toString();
		String insertDocTrans = "INSERT INTO canalis_db.wfl_document_transition\r\n"
				+ "(transition_id, from_doc_status, to_doc_status, doc_type_id, is_active, is_start, is_end, \"ordering\", \"name\", description, json_rest, json_form_setting, \"version\", created_by, created_date, modified_by, modified_date, is_show_user_list, is_ho, frm_doc_status, frm_role_id, last_approved_by, locked_status, locked_by, last_approved_date, is_used, to_role_id, from_role_id, access_role)\r\n"
				+ "VALUES(";
		final String saveDraftTransId = UUID.randomUUID().toString();
		final String insertDocTransSaveDraft = insertDocTrans + "'" + saveDraftTransId + "', ";
		insertDocTrans += "uuid_generate_v4(), ";
		String str = "INSERT INTO canalis_db.wfl_document_type\r\n"
				+ "(doc_type_id, is_active, is_workflow, \"name\", document_url, txt_task_format, \"version\", created_by, created_date, modified_by, modified_date, last_approved_by, locked_status, locked_by, last_approved_date, number_of_approver, doc_code, description, is_used)\r\n"
				+ "VALUES('" + newObjTypeId + "', true, true, '" + menu + "', 'test', NULL, 1, '" + createdBy
				+ "', now(), '" + createdBy + "', now(), NULL, NULL, NULL, NULL, 2, '" + docCode + "', '" + menu
				+ "', NULL);\r\n";
		String str1 = insertDocTrans + "3, 4, '" + newObjTypeId + "', true, false, false, 2, 'REJECT', '" + menu
				+ " Reject', '{\"transitionId\": \"" + saveDraftTransId + "\"}', '{}', 1, '" + createdBy + "', now(), '"
				+ createdBy
				+ "', now(), true, true, 1, NULL, NULL, NULL, NULL, NULL, NULL, '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}', '{a5c24e32-882d-4996-a252-f20ac6432b67}', '{e11c0ce5-2e3e-4054-ae7b-8d30c9d6dc64}');";
		String str2 = insertDocTrans + "11, 12, '" + newObjTypeId + "', true, false, false, 1, 'DRAFT DELETE', '" + menu
				+ " Draft Delete', '{}', '{}', 1, '" + createdBy + "', now(), '" + createdBy
				+ "', now(), true, true, 1, NULL, NULL, NULL, NULL, NULL, NULL, '{a5c24e32-882d-4996-a252-f20ac6432b67}', '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}', '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}');";
		String str3 = insertDocTrans + "12, 13, '" + newObjTypeId + "', true, false, true, 2, 'REJECT DELETE', '" + menu
				+ " Reject Delete', '{\"transitionId\": \"" + saveDraftTransId + "\"}', '{}', 1, '" + createdBy
				+ "', now(), '" + createdBy
				+ "', now(), true, true, 1, NULL, NULL, NULL, NULL, NULL, NULL, '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}', '{a5c24e32-882d-4996-a252-f20ac6432b67}', '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}');";
		String str4 = insertDocTrans + "7, 4, '" + newObjTypeId + "', true, false, false, 2, 'REJECT', '" + menu
				+ " Reject step 2', '{\"transitionId\": \"" + saveDraftTransId + "\"}', '{}', 1, '" + createdBy
				+ "', now(), '" + createdBy
				+ "', now(), true, true, 1, NULL, NULL, NULL, NULL, NULL, NULL, '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}', '{a5c24e32-882d-4996-a252-f20ac6432b68}', '{e11c0ce5-2e3e-4054-ae7b-8d30c9d6dc64}');";
		String str5 = insertDocTrans + "12, 14, '" + newObjTypeId + "', true, false, true, 1, 'APPROVE DELETE', '"
				+ menu + " Approve Delete', '{\"action\": \"delete\", \"delete\": \"" + apiDelete
				+ "\", \"service\": \"master\"}', '{}', 1, '" + createdBy + "', now(), '" + createdBy
				+ "', now(), true, true, 1, NULL, NULL, NULL, NULL, NULL, NULL, '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}', '{a5c24e32-882d-4996-a252-f20ac6432b67}', '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}');";
		String str6 = insertDocTrans + "1, 3, '" + newObjTypeId + "', true, false, false, 1, 'NEED APPROVAL', '" + menu
				+ " Need Approval', '{}', '{}', 1, '" + createdBy + "', now(), '" + createdBy
				+ "', now(), true, true, 1, NULL, NULL, NULL, NULL, NULL, NULL, '{a5c24e32-882d-4996-a252-f20ac6432b67}', '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}', '{e11c0ce5-2e3e-4054-ae7b-8d30c9d6dc64}');";
		String str7 = insertDocTrans + "7, 1, '" + newObjTypeId + "', true, false, true, 1, 'APPROVE', '" + menu
				+ " Approve step 2', '{\"action\": \"insert\", \"insert\": \"" + apiInsert + "\", \"getById\": \""
				+ apiGetById + "\", \"service\": \"master\"}', '{}', 1, '" + createdBy + "', now(), '" + createdBy
				+ "', now(), true, true, 1, NULL, NULL, NULL, NULL, NULL, NULL, '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}', '{a5c24e32-882d-4996-a252-f20ac6432b68}', '{e11c0ce5-2e3e-4054-ae7b-8d30c9d6dc64}');";
		String str8 = insertDocTrans + "3, 7, '" + newObjTypeId + "', true, false, false, 1, 'APPROVE', '" + menu
				+ " Approve step 1', '{}', '{}', 1, '" + createdBy + "', now(), '" + createdBy
				+ "', now(), true, true, 1, NULL, NULL, NULL, NULL, NULL, NULL, '{a5c24e32-882d-4996-a252-f20ac6432b68}', '{a5c24e32-882d-4996-a252-f20ac6432b67}', '{e11c0ce5-2e3e-4054-ae7b-8d30c9d6dc64}');";
		String str9 = insertDocTransSaveDraft + "1, 1, '" + newObjTypeId + "', true, true, false, 2, 'SAVE DRAFT', '"
				+ menu + " Save', '{}', '{}', 1, '" + createdBy + "', now(), '" + createdBy
				+ "', now(), true, true, 1, NULL, NULL, NULL, NULL, NULL, NULL, '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}', '{72598fd2-c9b6-4d18-b831-27a9aa1a47b9}', '{e11c0ce5-2e3e-4054-ae7b-8d30c9d6dc64}');";
		System.out.println(str + "\n" + str1 + "\n" + str2 + "\n" + str3 + "\n" + str4 + "\n" + str5 + "\n" + str6
				+ "\n" + str7 + "\n" + str8 + "\n" + str9 + "\n");
	}

}
