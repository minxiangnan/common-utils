package com.github.monite.utils.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OnlyConsoleStartLogFilter extends Filter<ILoggingEvent> {
    private static FilterReply filterReply = FilterReply.ACCEPT;

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (filterReply == FilterReply.DENY) {
            return FilterReply.DENY;
        }
        if (event.getMessage().contains("JVM running")) {
            filterReply = FilterReply.DENY;
            log.info("应用已启动成功>>>>>>>>>>>>>>>>>>控制台日志已经停止输出!!!");
        }
        return FilterReply.ACCEPT;
    }
}
