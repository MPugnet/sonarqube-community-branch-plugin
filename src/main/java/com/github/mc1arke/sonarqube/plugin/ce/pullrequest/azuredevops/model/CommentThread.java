package com.github.mc1arke.sonarqube.plugin.ce.pullrequest.azuredevops.model;

import com.github.mc1arke.sonarqube.plugin.ce.pullrequest.azuredevops.model.enums.CommentThreadStatus;
import org.sonar.db.protobuf.DbIssues;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a comment thread of a pull request. A thread contains meta data about the file
 * it was left on along with one or more comments (an initial comment and the subsequent replies).
 */
public class CommentThread implements Serializable {

    private CommentThreadStatus status;
    private List<Comment> comments;
    private CommentThreadContext threadContext;
    public CommentThread(){};

    public CommentThread(String filePath, DbIssues.Locations locations, String message){
        comments = Arrays.asList(
                new Comment(message)
        );
        status = CommentThreadStatus.active; //CommentThreadStatusMapper.toCommentThreadStatus(issue.status());
        threadContext = new CommentThreadContext(
                filePath,
                locations
        );

    }
    /**
     * A list of the comments.
     */
    public List<Comment> getComments(){
        return this.comments;
    };
    /**
     * A list of the comments.
     */
    public void setComments(List<Comment> value){
        this.comments = value;
    };
    /**
     * The status of the comment thread.
     */
    public CommentThreadStatus getStatus(){
        return this.status;
    };
    /**
     * The status of the comment thread.
     */
    public void setStatus(CommentThreadStatus value){
        this.status = value;
    };
    /**
     * Specify thread context such as position in left/right file.
     */
    public CommentThreadContext getThreadContext() {
        return this.threadContext;
    };
    /**
     * Specify thread context such as position in left/right file.
     */
    public void setThreadContext(CommentThreadContext value) {
        this.threadContext = value;
    };

    /**
     * The comment thread id.
     */
    public int id;
    /**
     * The time this thread was published.
     */
    public Date publishedDate;
    /**
     * The time this thread was last updated.
     */
    public Date lastUpdatedDate;
    /**
     * Optional properties associated with the thread as a collection of key-value
     */
    private PropertiesCollection properties;
    /**
     * Set of identities related to this thread
     */
    public HashMap<String, IdentityRef> identities;
    /**
     * Specify if the thread is deleted which happens when all comments are deleted.
     */
    public Boolean isDeleted;
    /**
     * Links to other related objects.
     */
    public ReferenceLinks _links;
}
