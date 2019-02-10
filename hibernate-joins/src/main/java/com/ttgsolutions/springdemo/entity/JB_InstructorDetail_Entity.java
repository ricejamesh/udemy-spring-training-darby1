package com.ttgsolutions.springdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail", schema = "public", catalog = "hb_student_tracker")
public class JB_InstructorDetail_Entity {
    private int id;
    private String youtubeChannel;
    private String hobby;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "youtube_channel", nullable = true, length = -1)
    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    @Basic
    @Column(name = "hobby", nullable = true, length = -1)
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JB_InstructorDetail_Entity that = (JB_InstructorDetail_Entity) o;

        if (id != that.id) return false;
        if (youtubeChannel != null ? !youtubeChannel.equals(that.youtubeChannel) : that.youtubeChannel != null)
            return false;
        if (hobby != null ? !hobby.equals(that.hobby) : that.hobby != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (youtubeChannel != null ? youtubeChannel.hashCode() : 0);
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        return result;
    }
}
