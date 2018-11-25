package com.tcp;

import com.tcp.service.TcpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

@Component
public class ClientTcp {

    Logger log = LoggerFactory.getLogger(getClass());

    @Value("${sky.tcplink.host}") String host;
    @Value("${sky.tcplink.port}") int port;

    @Autowired
    private TcpService service;

    public void runClientTcp() {
        try {

            log.info("Connecting to host " + host + " on port " + port + ".");

            Socket echoSocket = null;
            BufferedReader in = null;

            try {
                echoSocket = new Socket(host, port);
                in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                while (true) {
                    service.save(in.readLine());
                }
            } catch (UnknownHostException e) {
                log.error("Unknown host: " + host);
                System.exit(1);
            } catch (IOException e) {
                log.error("Unable to get streams from server");
                System.exit(1);
            } finally {
                assert echoSocket != null;
                echoSocket.close();
            }

            in.close();
            echoSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
