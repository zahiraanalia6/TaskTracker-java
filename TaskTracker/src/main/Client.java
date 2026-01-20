package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Client {
	private static int IDTask;
	
	public static void main(String[] args){
		getTasksArray();
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
	
	private static JSONArray getTasksArray() {
	    File file = new File("Task.json");

	    try {
	        if (!file.exists()) {
	            FileWriter writer = new FileWriter(file);
	            writer.write("[]");
	            writer.close();
	        }

	        FileReader reader = new FileReader(file);
	        Object obj = JSONValue.parse(reader);
	        reader.close();

	        return (JSONArray) obj;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return new JSONArray();
	    }
	}
	
	private static void addTask(String[] args) {
	    JSONArray tasks = getTasksArray();
	    int newId = getNextID(tasks);

	    JSONObject task = new JSONObject();
	    task.put("ID", newId);
	    task.put("Description", args[1]);
	    task.put("Status", "todo");
	    task.put("CreatedAt", Date());
	    task.put("UpdateAt", Date());

	    tasks.add(task);

	    try (FileWriter file = new FileWriter("Task.json")) {
	        file.write("[\n");
	        for (int i = 0; i < tasks.size(); i++) {
	            file.write("  " + tasks.get(i).toString());
	            if (i < tasks.size() - 1) {
	                file.write(",");
	            }
	            file.write("\n");
	        }
	        file.write("]");
	        file.flush();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    System.out.println("Task added successfully (ID: " + newId + ")");
	}


	private static int getNextID(JSONArray tasks) {
		int maxId = 0;

	    for (Object t : tasks) {
	        JSONObject task = (JSONObject) t;
	        long id = (long) task.get("ID");
	        if (id > maxId) {
	            maxId = (int) id;
	        }
	    }

	    return maxId + 1;
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

	public static String Date() {
		LocalDateTime myDate = LocalDateTime.now();
	    DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String now = myDate.format(myFormat);
		return now;
		
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
