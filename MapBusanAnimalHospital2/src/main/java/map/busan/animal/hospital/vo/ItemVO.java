package map.busan.animal.hospital.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemVO {
	
	private String gugin;
	private String animal_hospital;	// 병원이름
	private String approval;
	private String road_address;
	private String tel;
	private String lat;				// 위도
	private String lon;				// 경도
	private String basic_date;

}
