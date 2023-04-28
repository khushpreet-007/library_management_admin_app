package com.example.admin;

public class user {

    String bookname;
    String authorname;

    public user(String bookname, String authorname) {
        this.bookname = bookname;
        this.authorname = authorname;
    }

    public String getName1() {
        return bookname;
    }

    public String getID1() {
        return authorname;
    }
}
