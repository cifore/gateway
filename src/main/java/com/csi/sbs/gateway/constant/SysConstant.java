package com.csi.sbs.gateway.constant;

import java.util.ArrayList;
import java.util.List;

public class SysConstant {

	
	   //权限校验地址
	   public static final String PERMISSION_URL = "http://SYSADMIN/sysadmin/permission/permissionValidate";
	   //查询客户地址
	   public static final String GET_CUSTOMER_URL = "http://DEPOSIT/deposit/account/getCustomer";
	   //不需要登录的URL(Url 不带参数)
	   public static List<String> getNoNeedLoginOne(){
		   List<String> list = new ArrayList<String>();
		   list.add("/sysadmin/sysadmin/branch/getCountryCodes");
		   list.add("/sysadmin/sysadmin/branch/getClearingCodeByCountryCode");
		   list.add("/sysadmin/sysadmin/branch/getBrancoByCC");
		   list.add("/sysadmin/sysadmin/permission/developerAuthorization");
		   list.add("/sysadmin/sysadmin/login/loginIn");
		   list.add("/sysadmin/sysadmin/login/userCreation");
		   list.add("/sysadmin/sysadmin/sandbox/getSandBoxTableInfo");
		   list.add("/sysadmin/sysadmin/sandbox/getSandBoxTable");
		   list.add("/sysadmin/sysadmin/permission/getSandBox");
		   list.add("/sysadmin/sysadmin/permission/appDockerForDeveloper");
		   list.add("/sysadmin/sysadmin/branchdata/getBranchCodeTable");
		   list.add("/sysadmin/sysadmin/branchdata/getBranchCodeTableInfo");
		   
		   list.add("/sysadmin/sysadmin/module/queryModuleList");
		   list.add("/sysadmin/sysadmin/module/selectById");
		   list.add("/sysadmin/sysadmin/module/insert");
		   list.add("/sysadmin/sysadmin/module/update");
		   list.add("/sysadmin/sysadmin/module/delete");
		   list.add("/sysadmin/sysadmin/initHoliday");
		   
		   
		   list.add("/sysadmin/sysadmin/currency/currencyRetrieval");
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
		   
		   list.add("/deposit/deposit/account/accountNumberValidation");
		   
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
		   list.add("/deposit/deposit/account/sandboxSearch");
		   list.add("/deposit/deposit/account/customerCreation");
		   list.add("/deposit/deposit/validate/curAccountType");
		   list.add("/deposit/deposit/validate/fexAccountType");
		   list.add("/deposit/deposit/validate/fundAccountType");
		   list.add("/deposit/deposit/validate/metAccountType");
		   list.add("/deposit/deposit/validate/savOrCurType");
		   list.add("/deposit/deposit/validate/stockAccountType");
		   list.add("/deposit/deposit/validate/tdAccountType");
		   list.add("/deposit/deposit/validate/emailFormat");
		   
		   
		   list.add("/deposit/deposit/validate/AmountFormat");
		   list.add("/deposit/deposit/validate/dateRange");
		   list.add("/creditcard/validate/merchantCategory");
		   
		   
		   
		   list.add("/investment/investment/datehandle/sandboxSearch");
		   
		   list.add("/loan/mortgage/loanCalculater");
		   list.add("/loan/mortgage/resetContractDueInfo");
		   
		   
		   list.add("/creditcard/creditcard/creditCardNumberCreation");
		   list.add("/creditcard/creditcard/sandboxSearch");
		   list.add("/creditcard/creditcard/numberValidation");
		   list.add("/creditcard/creditcard/resetData");
		   list.add("/creditcard/merchant/historyQuery");
		   list.add("/creditcard/merchant/getMerchants");
		   list.add("/creditcard/merchant/queryMerchantById");
		   list.add("/creditcard/merchant/insertMerchant");
		   list.add("/creditcard/merchant/updateMerchant");
		   list.add("/creditcard/merchant/deleteMerchant");
		   

		   list.add("/creditcard/point/productEnquiry");
		   list.add("/creditcard/validate/validateMerchantCategory");
		   list.add("/creditcard/validate/number");
		   
//		   list.add("/deposit/swagger-ui.html");
//		   list.add("/creditcard/swagger-ui.html");
//		   list.add("swagger.json");
		   
		   return list;
	   }
	   //不需要登录的URL(URL带参数)
	   public static List<String> getNoNeedLoginTwo(){
		   List<String> list = new ArrayList<String>();
		   list.add("/sysadmin/sysadmin/getApiInfo");
		   list.add("/sysadmin/sysadmin/trantype/queryTranType");
		   list.add("/sysadmin/sysadmin/getUserInfo");
		   list.add("/sysadmin/sysadmin/login/authorize");
		   list.add("/sysadmin/sysadmin/isHoliday");
		   
		   list.add("/deposit/deposit/rate/getAllAmountRangeList");
		   list.add("/deposit/deposit/validate/currency");
		   list.add("/deposit/deposit/validate/idFormat");
		   list.add("/deposit/deposit/validate/phoneNumberFormat");
		   list.add("/deposit/deposit/validate/contractPeriod");
		   list.add("/deposit/deposit/validate/dateFormat");
		   list.add("/deposit/deposit/validate/timeFormat");
		   list.add("/deposit/deposit/validate/transType");
		   
		   list.add("/investment/investment/fund/fundQuotation");
		   list.add("/investment/investment/stock/stockQuotation");
		   
		   list.add("/creditcard/merchant/merchantEnquiry");
		   list.add("/creditcard/merchant/merchantPayment");
		   
		   
		   return list;
	   }
	   
	   
	   /**
        * 错误码
        */
       public static final int ERROR_CODE403001 = 403001;//token 异常
       public static final int ERROR_CODE403002 = 403002;//没有权限
       public static final int ERROR_CODE403003 = 403003;//没有登录
}
