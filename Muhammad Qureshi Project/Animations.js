function slide(division){
	division = '#'+division;
	$(division).animate({top: '0%', opacity:'1.0'}, 1000,function () {slideMenu('Menu')});
	}
function slideMenu(division){
	division = '#'+division;
	$(division).animate({top:'55%', opacity:'1.0'}, 1000);
	}

function openDiv(Division){
		Division = '#'+Division;
		$(Division).slideToggle();
}
function closeDivs(Div1,Div2,Div3,Div4,Div5,Div6,Div7,Div8,Div9,Div10,Div11,Div12,Div13 ){
	var divs = [Div1,Div2,Div3,Div4,Div5,Div6,Div7,Div8,Div9,Div10,Div11,Div12,Div13];
	for (i=0; i<divs.length; i++){
		$(divs[i]).slideUp();
	}
}