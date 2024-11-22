/*package Proxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import org.testng.annotations.BeforeTest;

public class ProxyConnection  {



@BeforeTest

public static void ProxySett() throws IOException{


Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.1.125.155", 80));

HttpURLConnection conn = (HttpURLConnection) new URL("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1").openConnection(proxy);


System.out.println("connection established");

conn.connect();

System.out.println("Established");

BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

StringBuilder response = new StringBuilder();

String inputLine;

while ((inputLine = in.readLine()) != null) 

response.append(inputLine);


System.out.println(response);

File file = new File("srinu.txt");

FileWriter fileWriter = new FileWriter(file);

fileWriter.write(response.toString());

fileWriter.flush();

fileWriter.close();

}


}

*/