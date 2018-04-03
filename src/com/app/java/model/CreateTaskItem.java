package com.app.java.model;

import com.app.java.model.enums.TaskColors;
import com.app.java.model.enums.TaskTypes;
import com.app.java.model.json.*;
import com.google.gson.Gson;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;

/**
 * Created by elamoureux on 1/16/2017.
 */
public class CreateTaskItem {
    private int sprintId;
    private TaskColors color;
    private float estimation;
    private String name = "";
    private int parentStoryId;
    private TaskTypes type;
    //Use commas for multiple tags

    public CreateTaskItem(int sprintId, int parentStoryId, String name) {
        this.sprintId = sprintId;
        this.parentStoryId = parentStoryId;
        this.name = name;
    }

    public CreateTaskItem(int sprintId, TaskTypes taskTypes, String name) {
        this.sprintId = sprintId;
        this.type = taskTypes;
        this.name = name;
    }

    public void setColor(TaskColors color) {
        this.color = color;
    }

    public void setEstimation(float estimation) {
        this.estimation = estimation;
    }

    public DOMSource createDOMSource() {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("task");
        doc.appendChild(rootElement);

        if (parentStoryId != 0) {
            // parentStory elements
            Element parentStory = doc.createElement("parentStory");
            rootElement.appendChild(parentStory);

            // set attribute to parentStory element
            Attr parentStoryAttr = doc.createAttribute("id");
            parentStoryAttr.setValue(Integer.toString(parentStoryId));
            parentStory.setAttributeNode(parentStoryAttr);
        } else {
            // type elements
            Element type = doc.createElement("type");
            type.appendChild(doc.createTextNode(this.type.getName()));
            rootElement.appendChild(type);
        }

        // icescrumSprint elements
        Element sprint = doc.createElement("icescrumSprint");
        rootElement.appendChild(sprint);

        // set attribute to icescrumSprint element
        Attr sprintAttr = doc.createAttribute("id");
        sprintAttr.setValue(Integer.toString(sprintId));
        sprint.setAttributeNode(sprintAttr);

        // name elements
        Element name = doc.createElement("name");
        name.appendChild(doc.createTextNode(this.name));
        rootElement.appendChild(name);

        if (this.color != null) {
            // color elements
            Element color = doc.createElement("color");
            color.appendChild(doc.createTextNode(this.color.getIdentifier()));
            rootElement.appendChild(color);
        }

        if (this.estimation != 0.0) {
            // estimation elements
            Element estimation = doc.createElement("estimation");
            estimation.appendChild(doc.createTextNode(Float.toString(this.estimation)));
            rootElement.appendChild(estimation);
        }

        // shorten way
        // staff.setAttribute("id", "1");

        DOMSource source = new DOMSource(doc);

        return source;
    }

    public String createJSONSource() {
        if (parentStoryId != 0) {
            NewStoryTaskItem taskItem = new NewStoryTaskItem();
            StoryTaskItem storyTaskItem = new StoryTaskItem();
            StoryTaskItemStory parentStory = new StoryTaskItemStory();
            parentStory.setId(parentStoryId);
            storyTaskItem.setParentStory(parentStory);

            storyTaskItem.setName(name);
            storyTaskItem.setColor(color.getIdentifier());
            storyTaskItem.setEstimation(estimation);

            taskItem.setTask(storyTaskItem);

            Gson gson = new Gson();
            String json = gson.toJson(taskItem);
            return json;
        } else {
            NewSprintTaskItem taskItem = new NewSprintTaskItem();
            SprintTaskItem sprintTaskItem = new SprintTaskItem();
            SprintTaskItemTimeBox timeBox = new SprintTaskItemTimeBox();
            timeBox.setId(sprintId);
            sprintTaskItem.setBacklog(timeBox);
            sprintTaskItem.setType(type.getIdentifier());

            sprintTaskItem.setName(name);
            sprintTaskItem.setColor(color.getIdentifier());
            sprintTaskItem.setEstimation(estimation);

            taskItem.setTask(sprintTaskItem);

            Gson gson = new Gson();
            String json = gson.toJson(taskItem);
            return json;
        }
    }
}
