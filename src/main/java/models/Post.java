package models;

import lombok.Data;

@Data
public class Post {

    private int id;
    private String title;
    private String text;
    private int categoryId;
    private String image;
}
