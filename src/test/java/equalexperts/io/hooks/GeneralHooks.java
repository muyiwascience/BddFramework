package equalexperts.io.hooks;



import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import equalexperts.io.browserconfig.BrowserFactory;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.HarEntry;

import java.util.List;


public class GeneralHooks {



    private BrowserFactory browserFactory;


    @Before
    public void testSetUp() {
        browserFactory = new BrowserFactory();
        browserFactory.initialiseBrowsers().cleanUpBrowsers();

    }


    @After
    public void testCleanUp(Scenario scenario){
        browserFactory.tearDownBrowsers();
    }

}
