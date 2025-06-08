package com.data.book;

import com.data.book.Book;

public class TestBook {
    public static void main(String[] args) {
        Book bk = new Book();
        bk.setPrice(25.5);
        System.out.println(bk.getPrice());
    }
}
