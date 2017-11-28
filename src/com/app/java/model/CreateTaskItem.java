package com.app.java.model;

import com.app.java.model.enums.TaskColors;
import com.app.java.model.enums.TaskTypes;
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
    private String description = "";
    private float estimation;
    private String name = "";
    private int parentStoryId;
    private TaskTypes type;
    //Use commas for multiple tags
    private String tags = "";

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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEstimation(float estimation) {
        this.estimation = estimation;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

        if (!this.description.isEmpty()) {
            // description elements
            Element description = doc.createElement("description");
            description.appendChild(doc.createTextNode(this.description));
            rootElement.appendChild(description);
        }

        if (this.estimation != 0.0) {
            // estimation elements
            Element estimation = doc.createElement("estimation");
            estimation.appendChild(doc.createTextNode(Float.toString(this.estimation)));
            rootElement.appendChild(estimation);
        }

        if (!this.tags.isEmpty()) {
            // tags elements
            Element tags = doc.createElement("tags");
            tags.appendChild(doc.createTextNode(this.tags));
            rootElement.appendChild(tags);
        }

        // shorten way
        // staff.setAttribute("id", "1");

        DOMSource source = new DOMSource(doc);

        return source;
    }
}
