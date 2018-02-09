package com.app.java.util.customJsonDeserializer;

import com.app.java.model.json.Release;
import com.app.java.model.json.Sprint;
import com.google.gson.*;

import java.lang.reflect.Type;

public class SprintDeserializer implements JsonDeserializer<Sprint> {
    @Override
    public Sprint deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        JsonElement jsonId = jsonObject.get("id");
        int id = jsonId.getAsInt();

        int activities_count = jsonObject.get("activities_count").getAsInt();
        int attachments_count = jsonObject.get("attachments_count").getAsInt();
        float capacity = jsonObject.get("capacity").getAsFloat();
        float dailyWorkTime = jsonObject.get("dailyWorkTime").getAsFloat();
        String dateCreated = jsonObject.get("dateCreated").getAsString();
        String deliveredVersion = "";
        if (!jsonObject.get("deliveredVersion").isJsonNull()) {
            deliveredVersion = jsonObject.get("deliveredVersion").getAsString();
        }
        String description = "";
        if (!jsonObject.get("description").isJsonNull()) {
            description = jsonObject.get("description").getAsString();
        }
        String doneDate = "";
        if (!jsonObject.get("doneDate").isJsonNull()) {
            doneDate = jsonObject.get("doneDate").getAsString();
        }
        String doneDefinition = "";
        if (!jsonObject.get("doneDefinition").isJsonNull()) {
            doneDefinition = jsonObject.get("doneDefinition").getAsString();
        }
        String endDate = jsonObject.get("endDate").getAsString();
        String goal = "";
        if (!jsonObject.get("goal").isJsonNull()) {
            goal = jsonObject.get("goal").getAsString();
        }
        String inProgressDate = "";
        if (!jsonObject.get("inProgressDate").isJsonNull()) {
            inProgressDate = jsonObject.get("inProgressDate").getAsString();
        }
        float initialRemainingTime = 0.0f;
        if (!jsonObject.get("initialRemainingTime").isJsonNull()) {
            initialRemainingTime = jsonObject.get("initialRemainingTime").getAsFloat();
        }
        String lastUpdated = jsonObject.get("lastUpdated").getAsString();
        int orderNumber = jsonObject.get("orderNumber").getAsInt();
        // Delegate the deserialization to the context
        Release parentRelease = context.deserialize(jsonObject.get("parentRelease"), Release.class);
        String retrospective = "";
        if (!jsonObject.get("retrospective").isJsonNull()) {
            retrospective = jsonObject.get("retrospective").getAsString();
        }
        String startDate = jsonObject.get("startDate").getAsString();
        int state = jsonObject.get("state").getAsInt();
        // The reason for this Deserializer
        // Icescrum returns a JsonArray of JsonObjects with 1 key:value instead of an Array of int
        // This prevents from using the simple parser
        JsonArray jsonStories_idsArray = jsonObject.get("stories_ids").getAsJsonArray();
        int[] stories_ids = new int[jsonStories_idsArray.size()];
        for (int i = 0; i < stories_ids.length; i++) {
            JsonObject jsonStories_id = jsonStories_idsArray.get(i).getAsJsonObject();
            stories_ids[i] = jsonStories_id.get("id").getAsInt();
        }
        int tasks_count = jsonObject.get("tasks_count").getAsInt();
        String todoDate = jsonObject.get("todoDate").getAsString();
        float velocity = jsonObject.get("velocity").getAsFloat();
        boolean activable = jsonObject.get("activable").getAsBoolean();
        float totalRemaining = jsonObject.get("totalRemaining").getAsFloat();
        int duration = jsonObject.get("duration").getAsInt();
        int index = jsonObject.get("index").getAsInt();
        int expectedAvailability = jsonObject.get("expectedAvailability").getAsInt();
        int actualAvailability = jsonObject.get("actualAvailability").getAsInt();
        String retrospective_html = jsonObject.get("retrospective_html").getAsString();
        String doneDefinition_html = jsonObject.get("doneDefinition_html").getAsString();

        Sprint sprint = new Sprint();
        sprint.setId(id);
        sprint.setActivities_count(activities_count);
        sprint.setAttachments_count(attachments_count);
        sprint.setCapacity(capacity);
        sprint.setDailyWorkTime(dailyWorkTime);
        sprint.setDateCreated(dateCreated);
        sprint.setDeliveredVersion(deliveredVersion);
        sprint.setDescription(description);
        sprint.setDoneDate(doneDate);
        sprint.setDoneDefinition(doneDefinition);
        sprint.setEndDate(endDate);
        sprint.setGoal(goal);
        sprint.setInProgressDate(inProgressDate);
        sprint.setInitialRemainingTime(initialRemainingTime);
        sprint.setLastUpdated(lastUpdated);
        sprint.setOrderNumber(orderNumber);
        sprint.setParentRelease(parentRelease);
        sprint.setRetrospective(retrospective);
        sprint.setStartDate(startDate);
        sprint.setState(state);
        sprint.setStories_ids(stories_ids);
        sprint.setTasks_count(tasks_count);
        sprint.setTodoDate(todoDate);
        sprint.setVelocity(velocity);
        sprint.setActivable(activable);
        sprint.setTotalRemaining(totalRemaining);
        sprint.setDuration(duration);
        sprint.setIndex(index);
        sprint.setExpectedAvailability(expectedAvailability);
        sprint.setActualAvailability(actualAvailability);
        sprint.setRetrospective_html(retrospective_html);
        sprint.setDoneDefinition_html(doneDefinition_html);

        return sprint;
    }
}
