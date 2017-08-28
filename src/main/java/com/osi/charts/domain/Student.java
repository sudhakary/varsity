package com.osi.charts.domain;

import java.util.List;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Student")
@Component
public class Student {

@Id
 String id;
 String name;
 @NotEmpty
 Integer rollNumber;
 List<Integer> marks;
 @NotEmpty
 String campus;
 
}
