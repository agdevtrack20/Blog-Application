package com.codewithabhi.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	
	@NotBlank
	@Size(min=4,message="Category title size min 4 character ")
	private String categoryTitle;
	@NotBlank
	@Size(min=10,message="Category title size min 10 character ")
	private String  categoryDescription;

}
