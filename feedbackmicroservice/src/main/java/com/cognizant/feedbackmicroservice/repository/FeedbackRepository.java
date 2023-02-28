package com.cognizant.feedbackmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.feedbackmicroservice.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	@Query(value = "SELECT F FROM Feedback F WHERE F.productId = :id")
	List<Feedback> findByProductId(int id);
	
	@Query(value = "SELECT AVG(R.rating) FROM Feedback R WHERE R.productId = :productId")
	double calcualteAvgRating(int productId);
	
	@Query(value = "SELECT F FROM Feedback F WHERE F.userName = :userName")
	List<Feedback> findByUserName(String userName);

}
