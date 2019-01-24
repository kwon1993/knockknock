package com.knockknock.dto.event;

import java.sql.Date;
import lombok.Data;

<<<<<<< HEAD

=======
>>>>>>> efbb975837f57fe3d8cd73ab81b864860e86518d
@Data
public class EventReplyDTO {
	private int replyNumber;
	private int writingNumber;
	private int memberNumber;
	private String content;
	private Date writeDate;
	private Date writeTime;
	private int parentNumber;
}
