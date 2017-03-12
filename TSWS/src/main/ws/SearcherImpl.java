package main.ws;

import javax.jws.WebService;
import java.io.File;

@WebService(endpointInterface = "main.ws.Searcher")
public class SearcherImpl implements Searcher
{
    @Override
    public String letsSearch(String textToSearch, String filePath)
    {
        File file = new File(filePath);
        Searching searching = new Searching();
        Thread _t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                searching.searchText(file, textToSearch);
            }
        });
        _t.start();
        String tmp = "";
        try
        {
            _t.join();
            tmp = searching.getTmp();
        } catch (InterruptedException e)
        {

        }

        System.out.println("Поиск завершен");
        return tmp;
    }
}

