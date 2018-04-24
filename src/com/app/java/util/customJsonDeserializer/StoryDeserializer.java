package com.app.java.util.customJsonDeserializer;

import com.app.java.model.json.*;
import com.google.gson.*;

import java.lang.reflect.Type;

public class StoryDeserializer implements JsonDeserializer<Story> {
    @Override
    public Story deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        JsonElement jsonId = jsonObject.get("id");
        int id = jsonId.getAsInt();

        int acceptanceTests_count = jsonObject.get("acceptanceTests_count").getAsInt();
        String acceptedDate = "";
        if (!jsonObject.get("acceptedDate").isJsonNull()) {
            acceptedDate = jsonObject.get("acceptedDate").getAsString();
        }
        int activities_count = jsonObject.get("activities_count").getAsInt();
        // The reason for this Deserializer
        // Icescrum returns a JsonArray of JsonObjects with 1 key:value instead of an Array of int
        // This prevents from using the simple parser
        JsonArray jsonActors_idsArray = jsonObject.get("actors_ids").getAsJsonArray();
        int[] actors_ids = new int[jsonActors_idsArray.size()];
        for (int i = 0; i < actors_ids.length; i++) {
            JsonObject jsonStories_id = jsonActors_idsArray.get(i).getAsJsonObject();
            actors_ids[i] = jsonStories_id.get("id").getAsInt();
        }
        String affectVersion = "";
        if (!jsonObject.get("affectVersion").isJsonNull()) {
            affectVersion = jsonObject.get("affectVersion").getAsString();
        }
        int attachments_count = jsonObject.get("attachments_count").getAsInt();
        // Delegate the deserialization to the context
        TimeBox backlog = context.deserialize(jsonObject.get("backlog"), TimeBox.class);
        int comments_count = jsonObject.get("comments_count").getAsInt();
        // Delegate the deserialization to the context
        User creator = context.deserialize(jsonObject.get("creator"), User.class);
        String dateCreated = jsonObject.get("dateCreated").getAsString();
        DependsOnStory dependsOn = null;
        if (!jsonObject.get("dependsOn").isJsonNull()) {
            // Delegate the deserialization to the context
            dependsOn = context.deserialize(jsonObject.get("dependsOn"), DependsOnStory.class);
        }
        String description = "";
        if (!jsonObject.get("description").isJsonNull()) {
            description = jsonObject.get("description").getAsString();
        }
        String doneDate = "";
        if (!jsonObject.get("doneDate").isJsonNull()) {
            doneDate = jsonObject.get("doneDate").getAsString();
        }
        float effort = 0.0f;
        if (!jsonObject.get("effort").isJsonNull()) {
            effort = jsonObject.get("effort").getAsFloat();
        }
        String estimatedDate = "";
        if (!jsonObject.get("estimatedDate").isJsonNull()) {
            estimatedDate = jsonObject.get("estimatedDate").getAsString();
        }
        // Delegate the deserialization to the context
        Feature feature = context.deserialize(jsonObject.get("feature"), Feature.class);
//        int followers_count = 0;
//        if (!jsonObject.get("followers_count").isJsonNull()) {
//            followers_count = jsonObject.get("followers_count").getAsInt();
//        }
        String inProgressDate = "";
        if (!jsonObject.get("inProgressDate").isJsonNull()) {
            inProgressDate = jsonObject.get("inProgressDate").getAsString();
        }
        String lastUpdated = jsonObject.get("lastUpdated").getAsString();
        String name = jsonObject.get("name").getAsString();
        String notes = "";
        if (!jsonObject.get("notes").isJsonNull()) {
            notes = jsonObject.get("notes").getAsString();
        }
        String origin = "";
        if (!jsonObject.get("origin").isJsonNull()) {
            origin = jsonObject.get("origin").getAsString();
        }
        // Delegate the deserialization to the context
        Sprint parentSprint = context.deserialize(jsonObject.get("parentSprint"), Sprint.class);
        String plannedDate = "";
        if (!jsonObject.get("plannedDate").isJsonNull()) {
            plannedDate = jsonObject.get("plannedDate").getAsString();
        }
        int rank = jsonObject.get("rank").getAsInt();
        int state = jsonObject.get("state").getAsInt();
        String suggestedDate = jsonObject.get("suggestedDate").getAsString();
        int tasks_count = jsonObject.get("tasks_count").getAsInt();
        String todoDate = jsonObject.get("todoDate").getAsString();
        int type = jsonObject.get("type").getAsInt();
        int uid = jsonObject.get("uid").getAsInt();
        int value = jsonObject.get("value").getAsInt();
//        int voters_count = jsonObject.get("voters_count").getAsInt();
        int testState = jsonObject.get("testState").getAsInt();
        JsonArray jsonTagsArray = jsonObject.get("tags").getAsJsonArray();
        String[] tags = new String[jsonTagsArray.size()];
        for (int i = 0; i < tags.length; i++) {
            JsonElement jsonTag = jsonTagsArray.get(i);
            tags[i] = jsonTag.getAsString();
        }
        JsonArray jsonDependencesArray = jsonObject.get("dependences").getAsJsonArray();
        Story[] dependences = new Story[jsonDependencesArray.size()];
        for (int i = 0; i < dependences.length; i++) {
            JsonElement jsonDependence = jsonDependencesArray.get(i);
            // Delegate the deserialization to the context
            dependences[i] = context.deserialize(jsonDependence, Story.class);
        }
//        boolean followed = jsonObject.get("followed").getAsBoolean();
        int countDoneTasks = jsonObject.get("countDoneTasks").getAsInt();
        int commits_count = jsonObject.get("commits_count").getAsInt();
        int builds_count = jsonObject.get("builds_count").getAsInt();
//        boolean hasVotedFor = jsonObject.get("hasVotedFor").getAsBoolean();
        String notes_html = jsonObject.get("notes_html").getAsString();

        Story story = new Story();
        story.setId(id);
        story.setAcceptanceTests_count(acceptanceTests_count);
        story.setAcceptedDate(acceptedDate);
        story.setActivities_count(activities_count);
        story.setActors_ids(actors_ids);
        story.setAffectVersion(affectVersion);
        story.setAttachments_count(attachments_count);
        story.setBacklog(backlog);
        story.setComments_count(comments_count);
        story.setCreator(creator);
        story.setDateCreated(dateCreated);
        story.setDependsOn(dependsOn);
        story.setDescription(description);
        story.setDoneDate(doneDate);
        story.setEffort(effort);
        story.setEstimatedDate(estimatedDate);
        story.setFeature(feature);
//        story.setFollowers_count(followers_count);
        story.setInProgressDate(inProgressDate);
        story.setLastUpdated(lastUpdated);
        story.setName(name);
        story.setNotes(notes);
        story.setOrigin(origin);
        story.setParentSprint(parentSprint);
        story.setPlannedDate(plannedDate);
        story.setRank(rank);
        story.setState(state);
        story.setSuggestedDate(suggestedDate);
        story.setTasks_count(tasks_count);
        story.setTodoDate(todoDate);
        story.setType(type);
        story.setUid(uid);
        story.setValue(value);
//        story.setVoters_count(voters_count);
        story.setTestState(testState);
        story.setTags(tags);
        story.setDependences(dependences);
//        story.setFollowed(followed);
        story.setCountDoneTasks(countDoneTasks);
        story.setCommits_count(commits_count);
        story.setBuilds_count(builds_count);
//        story.setHasVotedFor(hasVotedFor);
        story.setNotes_html(notes_html);

        return story;
    }
}
