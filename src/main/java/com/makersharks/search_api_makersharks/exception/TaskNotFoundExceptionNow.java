package com.makersharks.search_api_makersharks.exception;
/* Created by Arjun Gautam */

public class TaskNotFoundExceptionNow extends RuntimeException{
    public TaskNotFoundExceptionNow(String string){
        super("Could not found the Task with id "+ string);
    }
}
