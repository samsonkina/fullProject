package searcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Класс с функцией поиска
 */
class Searching
{
    /**
     * Поиск текста в файле
     * @param file директория для поиска
     * @param textToSearch искомая подстрока
     */
    public void searchText(File file, String textToSearch)
    {
        //если переданный параметр file является директорией
        if (file.isDirectory())
        {
            //выделяем нить под директорию
            Thread _threadForDirectory = new Thread();
            _threadForDirectory = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    //получаем список файлов в диреткории
                    File[] files = file.listFiles();
                    //Returns null if this abstract pathname does not denote a directory, or if an I/O error occurs.
                    if (files != null)
                    {
                        //для каждого файла/папки из списка полученных выполняем поиск
                        for (File file : files)
                        {
                            searchText(file, textToSearch);
                        }
                    }
                    else
                    {
                        System.err.println("[run.Line(" + Thread.currentThread().getStackTrace()[1].getLineNumber() +
                                ")]: null on list files for " + file.getAbsolutePath());
                    }
                }
            });
            _threadForDirectory.start();
            //ждем завершения выолнения
            try
            {
                _threadForDirectory.join();
            } catch (InterruptedException e)
            {
            }
        }
        //если file вляется файлом
        else
        {
            try
            {
                //считываем содержимое файла и проверяем наличие в нем искомой подстроки
                Scanner scanner = new Scanner(file);
                String withinHorizon = scanner.findWithinHorizon(textToSearch, 0);
                //если подстрока найдена - выводим
                if (withinHorizon != null)
                {
                    System.out.println(file.getAbsolutePath());
                }
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
}
