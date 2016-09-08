package org.seckill.listener;

import javax.servlet.*;
import java.io.IOException;

/**
 * User: xujiangjun
 * Date: 16/9/8 12:13
 */
public class ServletContextListenerImpl implements Filter, ServletContextListener {

    /**
     * Filter实现
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }

    /**
     * ServletContextListener接口实现
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
