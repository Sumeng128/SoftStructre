package softStructure.twoCS;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("服务器已启动，等待客户端连接...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端已连接：" + clientSocket.getInetAddress());

                // 创建一个新的线程处理客户端请求
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String request = reader.readLine();
            String response = processRequest(request);
            writer.println(response);

            reader.close();
            writer.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processRequest(String request) {
        // 在这里进行联系人信息的处理，根据请求的类型进行相应的操作
        // 例如，可以使用数据库进行联系人信息的增删改查操作

        // 这里只是一个简单的示例，直接返回请求内容作为响应
        return  request + "已完成";
    }
}
