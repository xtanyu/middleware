package com.example.shirodemo.shiro;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.shirodemo.mapper.UserMapper;
import com.example.shirodemo.util.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * 自定义Realm
 * @author lenovo
 *
 */
public class Realm extends AuthorizingRealm{
	@Resource
	private UserMapper userMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("执行授权逻辑");
		//给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();
		LambdaQueryWrapper<User> userLambdaQueryWrapper=new LambdaQueryWrapper<>();
		userLambdaQueryWrapper.eq(User::getName,user.getName());
		User dbUser = userMapper.selectOne(userLambdaQueryWrapper);
		System.out.println("用户权限："+dbUser.getPermissions());
		info.addStringPermission(dbUser.getPermissions());
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
		queryWrapper.eq(User::getName,usernamePasswordToken.getUsername());
		User user=userMapper.selectOne(queryWrapper);
		System.out.println("用户信息："+user.toString());
		if (user==null){
			return null;
		}
		return new SimpleAuthenticationInfo(user,user.getPassword(),"");
	}
}
