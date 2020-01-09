package com.training.mysites.domain;

import org.hibernate.engine.internal.Cascade;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="contenttype")
public class ContentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @Column(length = 50, unique = true)
    @NotNull
    private String name;

    private Integer weight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pid")
    @Nullable
    private ContentType parent;

    @OneToMany(mappedBy = "parent", cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<ContentType> sublists;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Nullable
    public ContentType getParent() {
        return parent;
    }

    public void setParent(@Nullable ContentType parent) {
        this.parent = parent;
    }

    public List<ContentType> getSublists() {
        return sublists;
    }

    public void setSublists(List<ContentType> sublists) {
        this.sublists = sublists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentType that = (ContentType) o;
        return Objects.equals(tid, that.tid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, name, weight);
    }
}
