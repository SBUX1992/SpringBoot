package kr.co.ch09.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User2VO {
	private String uid;
	private String pass;
	private String name;
	private String hp;
	private int age;
	private String rdate;
}