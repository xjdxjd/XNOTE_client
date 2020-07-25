
function showTextarea($this){

	var $commentss = $this.parent(".comment").siblings(".commentss");
	if($commentss.css('display') == 'none'){
		$commentss.slideDown('slow');
	}else{
		$commentss.slideUp('slow');
	}
}

function loadNotePageCut(pageCode){

}