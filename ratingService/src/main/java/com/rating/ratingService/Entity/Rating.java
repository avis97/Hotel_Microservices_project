package com.rating.ratingService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="rating_table")
public class Rating{

    @Id
    @Column(name="rating_id")
    private String ratingId;
    @Column(name="user_id")
    private String userId;
    @Column(name="hotel_id")
    private String hotelId;
    @Column(name="rating")
    private int rating;
    @Column(name="Customer_FeedBack")
    private String feedback;
}
