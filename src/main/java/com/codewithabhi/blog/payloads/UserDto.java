package com.codewithabhi.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.codewithabhi.blog.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    
    @NotEmpty
    @Size(min=4,message="Username must be min of 4 character")
	private String name;
    
    @Email(message="Email Addrss is not valid")
	private String email;
    
//  @Pattern(Resgex)
    @NotEmpty
    @Size(min=3,max=10,message="Password must be min 3 character and max 10 character ")
	private String password;
    
    @NotEmpty
	private String About; 
    
    private Set<RoleDto> roles=new HashSet<>();

}
