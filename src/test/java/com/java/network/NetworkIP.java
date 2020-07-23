package com.java.network;

import org.junit.Test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 网卡地址获取
 */
public class NetworkIP {
    @Test
    public void getIP() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                if (inetAddress.isLoopbackAddress()) {//回路地址，如127.0.0.1
                    System.out.println("loop addr:" + inetAddress);
                } else if (inetAddress.isLinkLocalAddress()) {//169.254.x.x
                    System.out.println("link addr:" + inetAddress);
                } else {
                    //非链接和回路真实ip
                    System.out.println("ip:" + inetAddress);
                }
            }
        }
    }
}
