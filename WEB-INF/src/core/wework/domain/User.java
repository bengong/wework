package wework.domain;

import java.io.Serializable;
import java.util.List;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.json.JsonIgnore;

/**
 * 用戶。
 */
@Table("wework_sso_user")
public class User implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3806852640527359739L;

	@Name
	@ColDefine(type = ColType.VARCHAR, width = 20)
	public String username;
	
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 100)
	public String fullname;
	
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 100)
	public String email;
	
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 44)
	public String password;
		
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 24)
	public String salt;

	@Column
	@ColDefine(type = ColType.VARCHAR, width = 64)
	public String ticket;
	
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 100)
	public String description;
	
	@ManyMany(target = Role.class, relation = "wework_sso_user_role", from = "username", to = "role_id")
	private List<Role> roles;
	@Column
	@ColDefine(type = ColType.VARCHAR)	
	public String ts;
	
	@Column
	@ColDefine(type = ColType.INT, width = 1)
	public int dr = 0;

	/**
	 * 微信号
	 */
	@Column
	@ColDefine(type = ColType.VARCHAR, width = 64)
	public String wechat_code;
	
	@JsonIgnore
	public static SecureRandomNumberGenerator generator = new SecureRandomNumberGenerator();
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 撒盐。
	 * 
	 * @param password
	 */
	public void salt() {
		String salt = generator.nextBytes().toBase64();
		String hashedPasswordBase64 = new Sha256Hash(this.password, salt, 1024).toBase64();
		this.salt = (salt);
		this.password = hashedPasswordBase64;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * only for shiro 頁面中使用。
	 * 
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public String toString() {
		return username;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public int getDr() {
		return dr;
	}

	public void setDr(int dr) {
		this.dr = dr;
	}

	public String getWechat_code() {
		return wechat_code;
	}

	public void setWechat_code(String wechat_code) {
		this.wechat_code = wechat_code;
	}
}
