package com.js.productservice.dtos;

import com.js.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {


        //output
    //    {
    //        id:1,
    //        title:'...',
    //        price:'...',
    //        category:'...',
    //        description:'...',
    //        image:'...'
    //    }

    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    @Override
//    public String toString() {
//        return "FakeStoreProductDto{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", price=" + price +
//                ", category='" + category + '\'' +
//                ", description='" + description + '\'' +
//                ", image='" + image + '\'' +
//                '}';
//    }
}
