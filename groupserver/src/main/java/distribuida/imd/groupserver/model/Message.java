package distribuida.imd.groupserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {	
	private String text;
	private String date;
	private Member member;
}
