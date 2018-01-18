package br.ufs.dcomp.revyou.common.message;

import java.util.HashMap;
import java.util.Map;

import br.ufs.dcomp.revyou.enums.MessageEnum;

public class ErrorMessage extends Message {

	private Map<Integer, String> messageMap = new HashMap<Integer, String>();

	public ErrorMessage(Integer code, String description) {
		super(MessageEnum.ERROR, code, description);
		messageMap.put(code, description); // TODO For validity in tests.
	}

	/* start-system-messages */

	private static final Integer OPERATION_NOT_RESPONDING_CODE = 999;
	private static final String OPERATION_NOT_RESPONDING_DESCRIPTION = "This operation is not responding properly. The administrator has been notified.";
	public static final ErrorMessage OPERATION_NOT_RESPONDING = new ErrorMessage(OPERATION_NOT_RESPONDING_CODE,
			OPERATION_NOT_RESPONDING_DESCRIPTION);

	/* end-system-messages */

	private static final Integer RESEARCHER_NOT_FOUND_CODE = 2000;
	private static final String RESEARCHER_NOT_FOUND_DESCRIPTION = "Researcher not found.";
	public static final ErrorMessage RESEARCHER_NOT_FOUND = new ErrorMessage(RESEARCHER_NOT_FOUND_CODE,
			RESEARCHER_NOT_FOUND_DESCRIPTION);
	
	private static final Integer RESEARCHER_NOT_FOUND_PASS_CODE = 2000;
	private static final String RESEARCHER_NOT_FOUND_PASS_DESCRIPTION = "Researcher not found, probably email to new password is invalid now.";
	public static final ErrorMessage RESEARCHER_NOT_FOUND_PASS = new ErrorMessage(RESEARCHER_NOT_FOUND_PASS_CODE,
			RESEARCHER_NOT_FOUND_PASS_DESCRIPTION);

	private static final Integer EMAIL_ALREADY_IN_USE_CODE = 2001;
	private static final String EMAIL_ALREADY_IN_USE_DESCRIPTION = "Email already in use.";
	public static final ErrorMessage EMAIL_ALREADY_IN_USE = new ErrorMessage(EMAIL_ALREADY_IN_USE_CODE,
			EMAIL_ALREADY_IN_USE_DESCRIPTION);

	private static final Integer LOGIN_INVALID_CODE = 2002;
	private static final String LOGIN_INVALID_DESCRIPTION = "Login invalid.";
	public static final ErrorMessage LOGIN_INVALID = new ErrorMessage(LOGIN_INVALID_CODE, LOGIN_INVALID_DESCRIPTION);
	

	private static final Integer PASSWORD_INVALID_CODE = 2003;
	private static final String PASSWORD_INVALID_DESCRIPTION = "Password invalid.";
	public static final ErrorMessage PASSWORD_INVALID = new ErrorMessage(PASSWORD_INVALID_CODE,
			PASSWORD_INVALID_DESCRIPTION);

	private static final Integer USERNAME_ALREADY_IN_USE_CODE = 2004;
	private static final String USERNAME_ALREADY_IN_USE_DESCRIPTION = "Username already in use.";
	public static final ErrorMessage USERNAME_ALREADY_IN_USE = new ErrorMessage(USERNAME_ALREADY_IN_USE_CODE,
			USERNAME_ALREADY_IN_USE_DESCRIPTION);

	private static final Integer KEY_ALREADY_IN_USE_CODE = 2005;
	private static final String KEY_ALREADY_IN_USE_DESCRIPTION = "Project Key already in use.";
	public static final ErrorMessage KEY_ALREADY_IN_USE = new ErrorMessage(KEY_ALREADY_IN_USE_CODE,
			KEY_ALREADY_IN_USE_DESCRIPTION);

	private static final Integer INSTITUTION_NOT_DELETED_CODE = 2006;
	private static final String INSTITUTION_NOT_DELETED_DESCRIPTION = "Institution not deleted, the project must have at least one associated institution.";
	public static final ErrorMessage INSTITUTION_NOT_DELETED = new ErrorMessage(INSTITUTION_NOT_DELETED_CODE,
			INSTITUTION_NOT_DELETED_DESCRIPTION);

	private static final Integer ACCOUNT_ALREADY_CONFIRMED_CODE = 2007;
	private static final String ACCOUNT_ALREADY_CONFIRMED_DESCRIPTION = "This email account has already been confirmed.";
	public static final ErrorMessage ACCOUNT_ALREADY_CONFIRMED = new ErrorMessage(ACCOUNT_ALREADY_CONFIRMED_CODE,
			ACCOUNT_ALREADY_CONFIRMED_DESCRIPTION);

	private static final Integer NO_PROJECT_OPEN_CODE = 2008;
	private static final String NO_PROJECT_OPEN_DESCRIPTION = "Open a project before view, add institution, or invite member to a project";
	public static final ErrorMessage NO_PROJECT_OPEN = new ErrorMessage(NO_PROJECT_OPEN_CODE,
			NO_PROJECT_OPEN_DESCRIPTION);

	private static final Integer MEMBER_NOT_FOUND_CODE = 2009;
	private static final String MEMBER_NOT_FOUND_DESCRIPTION = "Researcher not found, a email has been sent.";
	public static final ErrorMessage MEMBER_NOT_FOUND = new ErrorMessage(MEMBER_NOT_FOUND_CODE,
			MEMBER_NOT_FOUND_DESCRIPTION);

	private static final Integer MEMBER_INACTIVE_CODE = 2009;
	private static final String MEMBER_INACTIVE_DESCRIPTION = "This member is inactive.";
	public static final ErrorMessage MEMBER_INACTIVE = new ErrorMessage(MEMBER_INACTIVE_CODE,
			MEMBER_INACTIVE_DESCRIPTION);

	private static final Integer ALREADY_MEMBER_CODE = 2010;
	private static final String ALREADY_MEMBER_DESCRIPTION = "Already a member.";
	public static final ErrorMessage ALREADY_MEMBER = new ErrorMessage(ALREADY_MEMBER_CODE, ALREADY_MEMBER_DESCRIPTION);

	private static final Integer CITEKEY_IN_USE_CODE = 2010;
	private static final String CITEKEY_IN_USE_DESCRIPTION = "Cite key already in use. Hint: add key project at the end of cite key of studies";
	public static final ErrorMessage CITEKEY_IN_USE = new ErrorMessage(CITEKEY_IN_USE_CODE, CITEKEY_IN_USE_DESCRIPTION);

	private static final Integer NO_STANDARD_QUERY_CODE = 2010;
	private static final String NO_STANDARD_QUERY_DESCRIPTION = "Before save study you need save a standard query in a protocol project.";
	public static final ErrorMessage NO_STANDARD_QUERY = new ErrorMessage(NO_STANDARD_QUERY_CODE,
			NO_STANDARD_QUERY_DESCRIPTION);

	private static final Integer STUDY_IN_REVIEW_CODE = 2011;
	private static final String STUDY_IN_REVIEW_DESCRIPTION = "This study already in review.";
	public static final ErrorMessage STUDY_IN_REVIEW = new ErrorMessage(STUDY_IN_REVIEW_CODE,
			STUDY_IN_REVIEW_DESCRIPTION);

	private static final Integer STUDY_ALREADY_ASSIGNED_CODE = 2012;
	private static final String STUDY_ALREADY_ASSIGNED_DESCRIPTION = "At least one of the studies was already assigned to the researcher. If remains studies, assigned successfully.";
	public static final ErrorMessage STUDY_ALREADY_ASSIGNED = new ErrorMessage(STUDY_ALREADY_ASSIGNED_CODE,
			STUDY_ALREADY_ASSIGNED_DESCRIPTION);

	private static final Integer STUDY_AUTO_ALREADY_ASSIGNED_CODE = 2012;
	private static final String STUDY_AUTO_ALREADY_ASSIGNED_DESCRIPTION = "All studies undesignated are assigned to researcher now.";
	public static final ErrorMessage STUDY_AUTO_ALREADY_ASSIGNED = new ErrorMessage(STUDY_AUTO_ALREADY_ASSIGNED_CODE,
			STUDY_AUTO_ALREADY_ASSIGNED_DESCRIPTION);
	
	private static final Integer ACCOUNT_NOT_CONFIRMED_CODE = 2013;
	private static final String ACCOUNT_NOT_CONFIRMED_DESCRIPTION = "Account not confirmed, check your email.";
	public static final ErrorMessage ACCOUNT_NOT_CONFIRMED = new ErrorMessage(ACCOUNT_NOT_CONFIRMED_CODE, ACCOUNT_NOT_CONFIRMED_DESCRIPTION);

	private static final Integer ALREADY_INVITED_CODE = 2014;
	private static final String ALREADY_INVITED_DESCRIPTION = "This member has a pendent invite to this project.";
	public static final ErrorMessage ALREADY_INVITED= new ErrorMessage(ALREADY_INVITED_CODE, ALREADY_INVITED_DESCRIPTION);
}
