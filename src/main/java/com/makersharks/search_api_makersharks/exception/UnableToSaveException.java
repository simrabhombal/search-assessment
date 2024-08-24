package com.makersharks.search_api_makersharks.exception;
/* Created by Arjun Gautam */

public class UnableToSaveException extends RuntimeException{
    public UnableToSaveException(String string){
        super("Page Not Found "+ string);
    }
}
