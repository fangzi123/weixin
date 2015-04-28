$(document).ready(function() {
	//each
	$(".main_image").each(function(index){
		var $this = $(this);
		
		var $dragBln = false;
		
		$this.touchSlider({
			flexible : true,
			speed : 200,
			btn_prev : $("#btn_prev"+ index),
			btn_next : $("#btn_next"+ + index),
			paging : $this.siblings(".flicking_con").find(".flicking_inner a"),//$(".flicking_con a"),
			counter : function (e) {
				$this.siblings(".flicking_con").find(".flicking_inner a").removeClass("on").eq(e.current-1).addClass("on");
			}
		});
		
		$this.bind("mousedown", function() {
			$dragBln = false;
		})
		$this.bind("dragstart", function(event) {
			$dragBln = true;
		})
		$this.find("a").click(function() {
			if($dragBln) {
				return false;
			}
		})
		
		/*timer = setInterval(function() { $("#btn_next"+index).click();}, 5000);
		$(".main_visual").hover(function() {
			clearInterval(timer);
		}, function() {
			timer = setInterval(function() { $("#btn_next"+index).click();}, 5000);
		})
		$(".main_image").bind("touchstart", function() {
			clearInterval(timer);
		}).bind("touchend", function() {
			timer = setInterval(function() { $("#btn_next"+index).click();}, 5000);
		})*/
	})
})