package com.mycompany.test.command;

import javax.servlet.http.HttpServletRequest;
import com.mycompany.test.manager.ConfigurationManager;

public class ExitCommand  implements Command{

    @Override
    public String execute(HttpServletRequest request)
    {
        String page = ConfigurationManager.getProperty("path.page.index");
        
        request.getSession().invalidate();        
        
        return page;
    }
}
