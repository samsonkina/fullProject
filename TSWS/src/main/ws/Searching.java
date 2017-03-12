package main.ws;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Searching
{
    private String tmp = "";
    public String getTmp() {return this.tmp;}

    public void searchText(File file, String textToSearch)
    {
        if (file.isDirectory())
        {
            Thread _threadForDirectory = new Thread();
            _threadForDirectory = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    File[] files = file.listFiles();
                    // Returns null if this abstract pathname does not denote a directory, or if an I/O error occurs.
                    if (files != null)
                    {
                        for (File file : files)
                        {
                            searchText(file, textToSearch);
                        }
                    } else
                    {

                    }
                }
            });
            _threadForDirectory.start();

            try
            {
                _threadForDirectory.join();
            } catch (InterruptedException e)
            {

            }
        } else
        {
            try
            {
                Scanner scanner = new Scanner(file);
                String withinHorizon = scanner.findWithinHorizon(textToSearch, 0);
                if (withinHorizon != null)
                {
                    tmp += file.getAbsolutePath() + "\n";
                }
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
}