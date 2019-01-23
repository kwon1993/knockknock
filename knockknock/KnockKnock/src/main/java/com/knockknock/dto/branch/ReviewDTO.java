package com.knockknock.dto.branch;

import java.sql.Date;
import lombok.Data;

<<<<<<< HEAD
=======
import lombok.Data;

>>>>>>> a26fd36b2e4ad7887e95e867c2311f30ec9020db
@Data
public class ReviewDTO {
	
	private int writingNumber;
	private int memberNumber;
	private int branchNumber;
	private String content;
	private Date writeTime;
	private String image;
}
