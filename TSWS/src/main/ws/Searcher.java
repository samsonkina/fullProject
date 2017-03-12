package main.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
//сервис используется для вызова метода letsSearch
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Searcher
{
    @WebMethod
    public String letsSearch(String textToSearch, String filePath);
}