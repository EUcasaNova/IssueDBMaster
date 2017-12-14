/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package issuedb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Miles
 */
@Entity
@Table(name = "issue", catalog = "IssueDB", schema = "")
@NamedQueries({
    @NamedQuery(name = "Issue.findAll", query = "SELECT i FROM Issue i")
    , @NamedQuery(name = "Issue.findByPriority", query = "SELECT i FROM Issue i WHERE i.priority = :priority")
    , @NamedQuery(name = "Issue.findByStatus", query = "SELECT i FROM Issue i WHERE i.status = :status")
    , @NamedQuery(name = "Issue.findById", query = "SELECT i FROM Issue i WHERE i.id = :id")
    , @NamedQuery(name = "Issue.findByOpenedBy", query = "SELECT i FROM Issue i WHERE i.openedBy = :openedBy")
    , @NamedQuery(name = "Issue.findByAssignedTo", query = "SELECT i FROM Issue i WHERE i.assignedTo = :assignedTo")})
public class Issue implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Lob
    @Column(name = "Comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "Priority")
    private int priority;
    @Basic(optional = false)
    @Column(name = "Status")
    private String status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "OpenedBy")
    private String openedBy;
    @Basic(optional = false)
    @Column(name = "AssignedTo")
    private String assignedTo;

    public Issue() {
    }

    public Issue(Integer id) {
        this.id = id;
    }

    public Issue(Integer id, String comment, int priority, String status, String openedBy, String assignedTo) {
        this.id = id;
        this.comment = comment;
        this.priority = priority;
        this.status = status;
        this.openedBy = openedBy;
        this.assignedTo = assignedTo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        String oldComment = this.comment;
        this.comment = comment;
        changeSupport.firePropertyChange("comment", oldComment, comment);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        int oldPriority = this.priority;
        this.priority = priority;
        changeSupport.firePropertyChange("priority", oldPriority, priority);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getOpenedBy() {
        return openedBy;
    }

    public void setOpenedBy(String openedBy) {
        String oldOpenedBy = this.openedBy;
        this.openedBy = openedBy;
        changeSupport.firePropertyChange("openedBy", oldOpenedBy, openedBy);
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        String oldAssignedTo = this.assignedTo;
        this.assignedTo = assignedTo;
        changeSupport.firePropertyChange("assignedTo", oldAssignedTo, assignedTo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Issue)) {
            return false;
        }
        Issue other = (Issue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "issuedb.Issue[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
