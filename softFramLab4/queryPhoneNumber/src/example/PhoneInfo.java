package example;

import example.queryNum.ArrayOfString;
import example.queryNum.MobileCodeWS;
import example.queryNum.MobileCodeWSSoap;
import java.util.List;

/**
 * 获得国内手机号码归属地数据库信息
 * */
public class PhoneInfo {
    public static void main(String[] args){
        //创建一个MobileCodeWS工厂
        MobileCodeWS factory = new MobileCodeWS();
        //根据工厂创建一个MobileCodeWSSoap对象
        MobileCodeWSSoap mobileCodeWSSoap = factory.getMobileCodeWSSoap();
        //调用WebService提供的getMobileCodeInfo方法查询手机号码的归属地
//        String searchResult = mobileCodeWSSoap.getMobileCodeInfo("17338977993", null);
//        System.out.println(searchResult);
        ArrayOfString phoneArray =  mobileCodeWSSoap.getDatabaseInfo();
        List<String> phoneList = phoneArray.getString();
        for(Object o : phoneList){
            System.out.println(o);
        }
    }
}
