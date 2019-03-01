package com.csi.sbs.gateway.constant;

import java.util.ArrayList;
import java.util.List;

public class SysConstant {

	
	   //权限校验地址
	   public static final String PERMISSION_URL = "http://SYSADMIN/sysadmin/permission/permissionValidate";
	   //不需要任何请求头,不需要登录的URL(Url 不带参数)
	   public static List<String> getNoNeedHeaderUrl(){
		   List<String> list = new ArrayList<String>();
		   list.add("/sysadmin/sysadmin/branch/getCountryCodes");
		   list.add("/sysadmin/sysadmin/branch/getClearingCodeByCountryCode");
		   list.add("/sysadmin/sysadmin/branch/getBrancoByCC");
		   list.add("/sysadmin/sysadmin/permission/userAuthorize");
		   
		   list.add("/deposit/deposit/account/accountNumberValidation");
		   
		   list.add("/creditcard/creditcard/creditCardNumberValidation");
		   
		   return list;
	   }
	   //客户登录的URL(Url 不带参数)
	   public static List<String> getLoginUrl(){
		   List<String> list = new ArrayList<String>();
		   list.add("/sysadmin/sysadmin/login/login");
		   
		   return list;
	   }
	   //需要请求头,不需要登录的URL(Url 不带参数)
	   public static List<String> getNOLoginUrlOne(){
		   List<String> list = new ArrayList<String>();
		   list.add("/sysadmin/sysadmin/currency/getCurrencys");
		   list.add("/sysadmin/sysadmin/queryApiList");
		   list.add("/sysadmin/sysadmin/testApiSend");
		   list.add("/sysadmin/sysadmin/getServiceInternalURL");
		   list.add("/sysadmin/sysadmin/addUser");
		   list.add("/sysadmin/sysadmin/currency/isSupportbyccy");
		   list.add("/sysadmin/sysadmin/currency/queryByCcyCode");
		   list.add("/sysadmin/sysadmin/currency/insertCurrency");
		   list.add("/sysadmin/sysadmin/currency/updateCurrency");
		   list.add("/sysadmin/sysadmin/currency/deleteCurrency");
		   list.add("/sysadmin/sysadmin/sysconfig/getSystemParameter");
		   list.add("/sysadmin/sysadmin/log/writeTransactionLog");
		   list.add("/sysadmin/sysadmin/trantype/addTranType");
		   list.add("/sysadmin/sysadmin/userbranch/addUserBranch");
		   list.add("/sysadmin/sysadmin/branch/addBranch");
		   
		   list.add("/deposit/deposit/rate/getAllTdRateList");
		   list.add("/deposit/deposit/rate/getPeirodList");
		   list.add("/deposit/deposit/rate/updateTdRate");
		   list.add("/deposit/deposit/rate/addTdRate");
		   list.add("/deposit/deposit/rate/deleteTdRate");
		   list.add("/deposit/deposit/rate/getTDRateDetails");
		   list.add("/deposit/deposit/rate/addTdPeriod");
		   list.add("/deposit/deposit/rate/addAmountRange");
		   list.add("/deposit/deposit/rate/upateAmountRange");
		   list.add("/deposit/deposit/rate/deleteAmountRange");
		   list.add("/deposit/deposit/rate/getAmountRangeInfoById");
		   list.add("/deposit/deposit/account/savingAccountOpening");
		   list.add("/deposit/deposit/account/currentAccountOpening");
		   list.add("/deposit/deposit/account/customerCreation");
		   
		   list.add("/creditcard/creditcard/openingCreditcardAccount");
		   list.add("/creditcard/creditcard/creditCardNumberCreation");
		   
		   return list;
	   }
	   //需要请求头,不需要登录的Url(Url 带参数)
	   public static List<String> getNOLoginUrlTwo(){
		   List<String> list = new ArrayList<String>();
		   list.add("/sysadmin/sysadmin/getApiInfo");
		   list.add("/sysadmin/sysadmin/trantype/queryTranType");
		   list.add("/sysadmin/sysadmin/getUserInfo");
		   list.add("/deposit/deposit/rate/getAllAmountRangeList");
		   
		   return list;
	   }
}
