package util;

public class Sql {
	public final static String SELECT_CUSTOMER_BY_NO_AND_NAME = "SELECT * FROM BANK_CUSTOMER where c_no=? AND c_name=? AND deleted_yn='N'";
	
	public final static String SELECT_CUSTOMER_WITH_ACCOUNT_NO = "select c.*, a.a_no from bank_customer c "
			+ "join bank_account a on a.a_c_no=c.c_no "
			+ "where c_no = ? and deleted_yn='N'";
	
	public final static String INSERT_CUSTOMER = "INSERT INTO BANK_CUSTOMER VALUES (?,?,?,?,?,'N')";
	
	
	public final static String UPDATE_CUSTOMER = "UPDATE BANK_CUSTOMER SET c_name=?, c_phone=?, c_addr=? WHERE c_no=?";
	
	public final static String SELECT_ALL_ACCOUNT_WITH_NAME =  "select a.a_no, a.a_item_dist, a.a_item_name, a.a_c_no, a.a_balance, a.a_open_date, c.c_name " 
														+ "from bank_account a "
														+ "join bank_customer c on c.c_no = a.a_c_no "
														+ "where a.deleted_acc='N'";
	
	public final static String UPDATE_ACCOUNT_PLUS = "UPDATE BANK_ACCOUNT SET A_BALANCE = A_BALANCE + ? WHERE A_NO = ?";
	public final static String UPDATE_ACCOUNT_MINUS = "UPDATE BANK_ACCOUNT SET A_BALANCE = A_BALANCE - ? WHERE A_NO = ?";
	
	public final static String INSERT_ACCOUNT = "INSERT INTO BANK_ACCOUNT VALUES (?,?,?,?,?,SYSDATE,'N')";
	
	
	public final static String INSERT_TRANSACTION = "INSERT INTO BANK_TRANSACTION (T_A_NO, T__DIST, T_AMOUNT, T_DATETIME) VALUES (?,?,?,SYSDATE)";
}
