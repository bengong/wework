package wework.service;

import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import wework.domain.Role;
import wework.domain.User;
import wework.util.EntityServiceImpl;
import wework.util.Result;

@IocBean(args = { "refer:dao" })
public class UserService extends EntityServiceImpl<User> {
	
	public UserService(Dao dao) {
		super(dao);
	}

	/**
	 * 通過用戶名或密碼，獲取用戶。
	 * 
	 * @param name
	 * @return
	 */
	public User fetchByNameOrEmail(String name) {
		return fetch(Cnd.where("username", "=", name).or("email", "=", name));
	}

	public List<String> getRoleNameList(User user) {
		dao().fetchLinks(user, "roles");
		List<String> roleNameList = new ArrayList<String>();
		for (Role role : user.getRoles()) {
			roleNameList.add(role.role_id);
		}
		return roleNameList;
	}

	public Result add(String username, String role_id) {
		try {
			dao().insert("wework_sso_user_role", Chain.make("username", username).add("role_id", role_id)); 
			return Result.success("添加角色成功");
		} catch (Exception e) {
			return Result.error(e.getMessage());
		}
	}

	public Result remove(String username, String role_id) {		
		try {
			int result = dao().clear("wework_sso_user_role", Cnd.where("username", "=", username).and("role_id", "=", role_id));
			return result > 0 ? Result.success("刪除角色成功") : Result.error("數據已發生變化，刪除角色失敗");
		} catch (Exception e) {
			return Result.error(e.getMessage());
		}
	}
	
	/**
	 * 更新ticket。
	 * 
	 * @param username
	 * @param ticket
	 * @return
	 */
	public Result updateTicket(String username, String ticket) {		
		try {
			int result = dao().update("wework_sso_user", Chain.make("ticket", ticket), Cnd.where("username", "=", username));
			return result > 0 ? Result.success("更新ticket成功").setData(ticket): Result.error("數據已發生變化，刪除角色失敗").setData(ticket);
		} catch (Exception e) {
			return Result.error(e.getMessage());
		}
	}
	
	public User fetchByTicket(String ticket) {		
		return fetch(Cnd.where("ticket", "=", ticket));
	}
}
