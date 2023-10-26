package softStructure.twoCS;

import Java1.test.Str;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            System.out.print("请输入操作：");
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            // 发送请求给服务器
            writer.println(s);

            // 接收服务器返回的响应
            String response = reader.readLine();
            System.out.println("服务器响应：" + response);

            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
