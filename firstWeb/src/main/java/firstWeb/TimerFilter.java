package firstWeb;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class TimerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if any
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long startTime = System.currentTimeMillis();

        // Call the next filter in the chain
        chain.doFilter(request, response);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Request processed in " + duration + " milliseconds.");

        // You can log the duration or perform any other actions as needed
        
        // Continue with the next filters in the chain, if any
    }

    @Override
    public void destroy() {
        // Cleanup code, if any
    }
}
