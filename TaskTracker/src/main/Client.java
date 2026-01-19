package main;

import java.util.Scanner;  

public class Client {
	private static int IDTask;
	
	public static void main(String[] args) {
		Message();
		String command = args[0];
		
	    switch(command) {
	    case "add":
	    	addTask(args);
	    	break;
	    case "update":
	    	updateTask(args);
	    	break;
	    case "delete":
	    	deleteTask(args);
	    	break;
	    case "mark-in-progress":
	    	markInProgressTask(args);
	    	break;
	    case "mark-done":
	    	markDoneTask(args);
	    	break;
	    case "list":
	    	listTask(args);
	    	break;
	    }	
	}
	
	private static void addTask(String[] answer) {
		
	}

	private static void updateTask(String[] answer) {
		// TODO Auto-generated method stub
		
	}

	private static void deleteTask(String[] answer) {
		// TODO Auto-generated method stub
		
	}

	private static void markInProgressTask(String[] answer) {
		// TODO Auto-generated method stub
		
	}

	private static void markDoneTask(String[] answer) {
		// TODO Auto-generated method stub
		
	}
	
	private static void listTask(String[] answer) {
		// TODO Auto-generated method stub
		
	}

	public static void Message() {
	    System.out.println("Welcome to the Task Trackern\n"
	    		+ "These are the valid commands to manage the task:\n"
	    		+ "add ´task-name-example´: to add a new task.\n"
	    		+ "update task-ID-example ´task-name-example´: to update a task\n"
	    		+ "delete task-ID-example: to delete a task\n"
	    		+ "mark-in-progress task-ID-example: to mark in progress a task\n"
	    		+ "mark-done task-ID-example: to mark a task already done\n"
	    		+ "list: will give you a lit of all the task\n"
	    		+ "list (done, todo, in-progress)");
	}
}
