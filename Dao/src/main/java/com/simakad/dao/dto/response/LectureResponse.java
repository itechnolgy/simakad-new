package com.simakad.dao.dto.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRIN on 12/15/2016.
 */
public class LectureResponse {

    public List<Lecture> lectureList = new ArrayList<>();

    public void addLecture(Lecture lecture){
        lectureList.add(lecture);
    }

    public static class Lecture{
        private String name;
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
