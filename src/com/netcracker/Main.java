package com.netcracker;

import com.netcracker.config.SpringConfig;
import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import com.netcracker.model.Store;
import com.netcracker.service.bookService.IBookService;
import com.netcracker.service.customerService.ICustomerService;
import com.netcracker.service.purchaseService.IPurchaseService;
import com.netcracker.service.storeService.IStoreService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        IBookService bookService = (IBookService) context.getBean("bookService");
        IStoreService storeService = (IStoreService) context.getBean("storeService");
        IPurchaseService purchaseService = (IPurchaseService) context.getBean("purchaseService");
        ICustomerService customerService = (ICustomerService) context.getBean("customerService");


        List<Book> bookList = bookService.showAllBooks();
        System.out.println(storeService.rowCount());

        List<Purchase> pList = purchaseService.showAllPurchases();

        bookList.forEach(System.out::println);
        pList.forEach(System.out::println);



        SQLQueriesDAO sqlDAO = (SQLQueriesDAO) context.getBean("sqlDAO");
        sqlDAO.getUniqueBooks();
        //sqlDAO.getUniqueDistricts();
        sqlDAO.getUniquePurchaseMonths();
        //sqlDAO.getCustomersFromNizhegorodskyDistrict();
        //sqlDAO.getSormovoStores();
        sqlDAO.getWindowsBooks();
        //sqlDAO.getShortPurchaseInfo();
        //sqlDAO.getFullPurchaseInfo();
        sqlDAO.getPurchaseInfoOver60000();
        //sqlDAO.getPurchasesInCustomersLivingDistrict();
        sqlDAO.getNotAvtozavodStores();
        sqlDAO.getPurchaseBooksInfoInStockOver10();
    }
}
