package main.endpoint;

import javax.xml.ws.Endpoint;
import main.ws.SearcherImpl;

/**
 * Класс запуска сервера с сервисами
 */
public class SearcherLauncher
{
    public static void main(String... args)
    {
        Endpoint.publish("http://localhost:8888/text", new SearcherImpl());
    }
}

