package main.client;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import main.ws.Searcher;

public class client
{
    public static void main(String[] args) throws MalformedURLException
    {
        // создаем ссылку на wsdl описание
        URL url = new URL("http://localhost:8888/text?wsdl");
        QName qname = new QName("http://ws.main/", "SearcherImplService");
        Service service = Service.create(url, qname);

        // получаем ссылку на удаленный ws
        Searcher searcher = service.getPort(Searcher.class);

        //вводим данные
        System.out.println("Техт для поиска:");
        Scanner scanner = new Scanner(System.in);
        String textToSearch = scanner.nextLine();
        System.out.println("Где искать:");
        String filePath = scanner.nextLine();

        //получаем результат выполнения функции поиска от сервиса
        String s = searcher.letsSearch(textToSearch, filePath);
        System.out.println(s + "\nПоиск завершен");
    }
}