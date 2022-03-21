package io.github.minxiangnan.utils.log;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;

@Slf4j
public class IpConvert extends ClassicConverter {
    private  String localIp = "127.0.0.1";
    @Override
    public String convert(ILoggingEvent event) {
        if (localIp == null) {
            synchronized (IpConvert.class) {
                try {
                    InetAddress addr = InetAddress.getLocalHost();
                    return addr.getHostAddress();
                    //String hostname = addr.getHostName();
                } catch (Exception e) {
                    log.info("获取本机IP失败",e);
                }
            }
        }
        return localIp;
    }
}