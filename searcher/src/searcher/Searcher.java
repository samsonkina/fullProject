package searcher;

import java.io.File;

public class Searcher
{
    public static void main(String[] args)
    {
        File file;
        String textToSearch = "";

//        if (args.length == 0 || args[0].isEmpty() || args[1].isEmpty())
//        {
//            throw new IllegalArgumentException();
//        }
//
//        textToSearch = args[0].toString();
//        file = new File(args[1].toString());

        textToSearch = "альпака228";
        file = new File("D:\\Отчеты");

//создаем объект класса для запуска функции поиска
        Searching searching = new Searching();
        String finalTextToSearch = textToSearch;
        //выделяем нить
        Thread _t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                searching.searchText(file, finalTextToSearch);
            }
        });
        _t.start();
        try
        {
            _t.join();
        } catch (InterruptedException e)
        {

        }
        System.out.println("Поиск завершен");
    }
}




