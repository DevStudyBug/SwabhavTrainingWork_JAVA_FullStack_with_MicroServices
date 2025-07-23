package com.aurionpro.OCP.Solution.learningManagementSystem.test;

import com.aurionpro.OCP.Solution.learningManagementSystem.model.ContentRenderer;
import com.aurionpro.OCP.Solution.learningManagementSystem.model.VideoContent;
import com.aurionpro.OCP.Solution.learningManagementSystem.model.articleContent;
import com.aurionpro.OCP.Solution.learningManagementSystem.model.quizContent;

public class ContentRendererTest {
public static void main(String[] args) {
	ContentRenderer c = new ContentRenderer();
	c.Contents(new VideoContent());
	c.Contents(new quizContent());
	c.Contents(new articleContent());
}
}
