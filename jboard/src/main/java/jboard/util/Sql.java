package jboard.util;

public class Sql {
	public final static String SELECT_TERMS = "select * from tb_terms where no=?";
	
	//user
	public static final String SELECT_COUNT = "SELECT COUNT(*) FROM tb_user ";
	public static final String WHERE_USID = "WHERE USID=?";
	public static final String WHERE_NICK = "WHERE NICK=?";
	public static final String WHERE_EMAIL = "WHERE EMAIL=?";
	public static final String WHERE_HP = "WHERE HP=?";
	
	public static final String SELECT_USER_BY_PASS = "SELECT * FROM TB_USER WHERE usid=? AND pass=STANDARD_HASH(?, 'SHA256')";
	
	public final static String INSERT_USER = "insert into tb_user (usid, pass, us_name, nick, email, hp, zip, addr1, addr2, reg_ip, reg_date) "
				+"values (?,STANDARD_HASH(?, 'SHA256'),?,?,?,?,?,?,?,?,SYSDATE)";
	
	// Article
	public final static String SELECT_COUNT_ARTICLE_TOTAL = "SELECT COUNT(*) FROM TB_ARTICLE";
	public final static String INSERT_ARTICLE = "INSERT INTO TB_ARTICLE (TITLE, CONTENT, FILE_CNT, WRITER, REG_IP, WDATE) VALUES (?,?,?,?,?,SYSDATE)";
	public final static String SELECT_MAX_ANO = "SELECT MAX(ano) FROM TB_ARTICLE";
	public final static String SELECT_ARTICLE_ALL = "SELECT a.*, tu.NICK  FROM TB_ARTICLE a "
			+ "JOIN TB_USER tu ON a.WRITER = tu.USID "
			+ "ORDER BY ANO DESC "
			+ "offset ? ROWS FETCH NEXT 10 ROWS only";
	
	public final static String INSERT_FILE = "INSERT INTO TB_FILE (ANO, ONAME, SNAME, RDATE) VALUES (?, ?, ?, SYSDATE)";
	

}



