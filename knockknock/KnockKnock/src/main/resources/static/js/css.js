$(document).ready(function(){
    $("#menu ul li").on('click',function(){
    	alert("hi");
        $(".active").removeClass("active");
        $(this).attr('class','active');
    });
});
