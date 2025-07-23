package com.aurionpro.OCP.Solution.learningManagementSystem.model;

public interface contentTypes {
public void content();
}
/*In a learning management system, the ContentRenderer class uses if-else or switch blocks to render different content types (video, article, quiz). Adding a new type (e.g., podcast) requires modifying this class. 
 
 
Task: Refactor the system so it’s open for extension but closed for modification.*/