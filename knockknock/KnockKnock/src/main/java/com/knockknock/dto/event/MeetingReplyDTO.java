<<<<<<< HEAD
package com.knockknock.dto.event;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeetingReplyDTO {
	private int replyNumber;
	private int writingNumber;
	private int memberNumber;
	private String content;
	private Date writeTime;
	private int parentNumber;
}
=======
package com.knockknock.dto.event;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MeetingReplyDTO {
	private int replyNumber;
	private int writingNumber;
	private int memberNumber;
	private String content;
	private Date writeDate;
	private int parentNumber;
}
>>>>>>> ash
