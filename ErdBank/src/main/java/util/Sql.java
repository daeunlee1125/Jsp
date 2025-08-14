package util;

public class Sql {
	public final static String SELECT_CUSTOMER_BY_NO_AND_NAME = "SELECT * FROM BANK_CUSTOMER where c_no=? AND c_name=?";
	
	public final static String SELECT_CUSTOMER_WITH_ACCOUNT_NO = "select c.*, a.a_no from bank_customer c "
			+ "join bank_account a on a.a_c_no=c.c_no "
			+ "where c_no = ?";
	
	
	public final static String SELECT_ALL_ACCOUNT_WITH_NAME =  "select a.*, c.c_name " 
														+ "from bank_account a "
														+ "join bank_customer c on c.c_no = a.a_c_no";
	
	public final static String UPDATE_ACCOUNT_PLUS = "UPDATE BANK_ACCOUNT SET A_BALANCE = A_BALANCE + ? WHERE A_NO = ?";
	public final static String UPDATE_ACCOUNT_MINUS = "UPDATE BANK_ACCOUNT SET A_BALANCE = A_BALANCE - ? WHERE A_NO = ?";
	
	
	
	
	public final static String INSERT_TRANSACTION = "INSERT INTO BANK_TRANSACTION (T_A_NO, T__DIST, T_AMOUNT, T_DATETIME) VALUES (?,?,?,SYSDATE)";
}
