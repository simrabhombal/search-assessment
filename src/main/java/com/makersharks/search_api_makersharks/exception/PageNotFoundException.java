package com.makersharks.search_api_makersharks.exception;
/* Created by Arjun Gautam */

public class PageNotFoundException extends RuntimeException{
    public PageNotFoundException(String string){
        super("Page Not Found "+ string);
    }
}
