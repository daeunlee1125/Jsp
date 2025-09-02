package jboard.util;

public class Sql {
	public final static String SELECT_TERMS = "select * from tb_terms where no=?";
	
	//user
	public static final String SELECT_COUNT = "SELECT COUNT(*) FROM tb_user ";
	public static final String WHERE_USID = "WHERE USID=?";
	public static final String WHERE_NICK = "WHERE NICK=?";
	public static final String WHERE_EMAIL = "WHERE EMAIL=?";
	public static final String WHERE_HP = "WHERE HP=?";
	
	public final static String INSERT_USER = "insert into tb_user (usid, pass, us_name, nick, email, hp, zip, addr1, addr2, reg_ip, reg_date) "
				+"values (?,STANDARD_HASH(?, 'SHA256'),?,?,?,?,?,?,?,?,SYSDATE)";
}



