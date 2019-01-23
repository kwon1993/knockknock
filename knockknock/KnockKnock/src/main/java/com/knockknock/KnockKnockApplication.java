package com.knockknock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KnockKnockApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnockKnockApplication.class, args);
	}	
}

/* $(document).ready(function(){
var search = $("form[name=search]").serialize();
	
	$.ajax({
		type:'post',
		url:'/findingRoom',
		data:search,
		dataType:'json',
		success:function(json){
			alert(json);
		}
	});
}); */