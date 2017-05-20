package entity.list;

import javax.persistence.*;

@Entity
@Table(name = "tblist_elm")
public class ListElement {

    @Id
    @Column(name = "elm_id")
    private Integer elmId;

    @Column(name = "list_id")
    private Integer listId;

    @Column(name = "reference_id")
    private String reference;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public Integer getElmId() {
        return elmId;
    }

    public void setElmId(Integer elmId) {
        this.elmId = elmId;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
