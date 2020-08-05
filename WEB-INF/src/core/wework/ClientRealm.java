package wework;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import wework.domain.Permission;
import wework.domain.Role;
import wework.domain.User;
import wework.domain.UsernameTicketToken;

/**
 * SSO单点登录客户端验证。
 */
public class ClientRealm extends AuthorizingRealm {
		
	Log log = Logs.get();
	
	public ClientRealm() {
		setCredentialsMatcher(new SimpleCredentialsMatcher());
		this.setAuthenticationTokenClass(UsernameTicketToken.class);		
	}
	
	/**
	 * 认证回调函数,登录时调用.
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernameTicketToken token = (UsernameTicketToken) authcToken;
		User user = token.getUser();
		if (user != null) {
			// 通过ticket 进行匹配。
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, token.getCredentials(), getName());
			return info;
		}
		
		return null;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.addRoles(rolenames(user));
			for (Role role : user.getRoles()) {
				info.addStringPermissions(permissions(role));
			}
			return info;
		} else {
			return null;
		}
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
	
	private List<String> rolenames(User user) {
		List<String> roleNameList = new ArrayList<String>();
		for (Role role : user.getRoles()) {
			roleNameList.add(role.role_id);
		}
		return roleNameList;
	}
	
	private List<String> permissions(Role role) {
		List<String> permissionNameList = new ArrayList<String>();

		for (Permission permission : role.getPermissions()) {
			permissionNameList.add(permission.permission_id);
		}
		return permissionNameList;
	}
}