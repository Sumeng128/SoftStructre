package example;


import example.queryNum.MobileCodeWS;
import example.queryNum.MobileCodeWSSoap;

import java.util.Scanner;

public class PhoneWsClient {

    public static void main(String[] args){
        //创建一个MobileCodeWS工厂
        MobileCodeWS factory = new MobileCodeWS();
        //根据工厂创建一个MobileCodeWSSoap对象
        MobileCodeWSSoap mobileCodeWSSoap = factory.getMobileCodeWSSoap();
        //调用WebService提供的getMobileCodeInfo方法查询手机号码的归属地
        System.out.println("********欢迎使用SUMENG电话号码归属地查询********");
        System.out.print("请输入你的电话号码：");
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        String searchResult = mobileCodeWSSoap.getMobileCodeInfo(num, null);
        System.out.println(searchResult);

    }
}
