package com.csi.sbs.gateway.constant;

import java.util.ArrayList;
import java.util.List;

public class SysConstant {

	
	   //权限校验地址
	   public static final String PERMISSION_URL = "http://SYSADMIN/sysadmin/permission/permissionValidate";
	   //不需要请求头的URL
	   public static List<String> getNoNeedHeaderUrl(){
		   List<String> list = new ArrayList<String>();
		   list.add("/sysadmin/sysadmin/branch/getCountryCodes");
		   list.add("/sysadmin/sysadmin/branch/getClearingCodeByCountryCode");
		   list.add("/sysadmin/sysadmin/branch/getBrancoByCC");
		   list.add("/sysadmin/sysadmin/permission/userAuthorize");
		   
		   return list;
	   }
	   //客户登录的URL
	   public static List<String> getLoginUrl(){
		   List<String> list = new ArrayList<String>();
		   list.add("/sysadmin/sysadmin/login/login");
		   
		   return list;
	   }
}
