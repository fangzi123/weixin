
function getActivityDetail(gender){
	$("input[name='gender']").val(gender);
	$("#shiliheIndex").submit();
}

$(document).ready(function() {
	if ($("input[name='moveTo']").val()) {
		var target = $("input[name='moveTo']").val();
		window.location=target;
	} else {
	    if($.browser.msie && $.browser.version < 10){
	        $('body').addClass('ltie10');
	    }
	    $.fn.fullpage({
	        verticalCentered: false,
	        anchors: ['page1', 'page2', 'page3', 'page4', 'page5', 'page6', 'page7', 'page8', 'page9', 'page10'],
	        navigation: true,
	    });
	}
});
