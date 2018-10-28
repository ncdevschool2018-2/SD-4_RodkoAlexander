package com.netcracker.sd4alexanderrodko.sd4parent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "group_to_lesson", schema = "backend", catalog = "")
public class GroupToLesson {
    private int entryId;

    @Id
    @Column(name = "entry_id", nullable = false)
    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupToLesson that = (GroupToLesson) o;
        return entryId == that.entryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryId);
    }
}
