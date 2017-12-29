import java.net.*;
import java.io.*;
import java.util.*;

public class Server{

	int port;				//端口号
	List<Socket> clients;	//客户端列表，包含所有连接到该客户端的信息
	ServerSocket server;	//服务器


	public static void main(String[] args){
		new Server();
	}	//main函数，创建服务器

    //服务器实现源码
	public Server(){
		try{
			port=6666;      //定义具体端口号端口
			clients = new ArrayList<Socket>();
			server = new ServerSocket(port);
			while(true){
				Socket socket=server.accept();
				clients.add(socket);
				Mythread mythread=new Mythread(socket);
				mythread.start();
			}
		}catch(Exception ex){}
	}

	class Mythread extends Thread{
		Socket ssocket;
		private BufferedReader br; 
		private PrintWriter pw; 
		public String msg; 
		public Mythread(Socket s){
			ssocket=s;
		}
		public void run(){
			try{
				br = new BufferedReader(new InputStreamReader(ssocket.getInputStream())); 
				msg = "欢迎【" + ssocket.getInetAddress() + "】进入聊天室！当前聊天室有【" + clients.size() + "】人"; 
	
				sendMsg();
	
				while ((msg = br.readLine()) != null) { 
	
					msg = "【" + ssocket.getInetAddress() + "】说：" + msg; 
					sendMsg(); 
				} 
			}
			catch(Exception ex){
			}    
		}
		public void sendMsg(){
			try{
				System.out.println(msg);
				for(int i = clients.size() - 1; i >= 0; i--){
					pw=new PrintWriter(clients.get(i).getOutputStream(),true);
					pw.println(msg);
					pw.flush();
				}
			}
			catch(Exception ex){}
		}    
	}
}