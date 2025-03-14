var pagingUtil = {
	
	pagingView: function(currentPageNo, pageSize, totalCount, targetFunction){
		
		var pageNo = parseInt(currentPageNo); // 현재 페이지번
	 	var countPage = 5 ; 
		
		var finalPageNo = parseInt(totalCount / pageSize);
		var strPaging = "";
		var targetFunction = (targetFunction == null || targetFunction == "") ? "goPage" : targetFunction;
		
		if(totalCount % pageSize > 0){
			finalPageNo++;
		}
		if(finalPageNo < pageNo){
			pageNo = finalPageNo;
		}
		var startPage = Math.floor(((pageNo-1) / countPage)) * countPage + 1;
		var endPage = startPage + countPage -1 ;
		
		if(startPage <= 0){
			startPage = 1;
		}
		if(endPage > finalPageNo){
			endPage = finalPageNo;
		}
		if(pageNo > 1)
	}
}