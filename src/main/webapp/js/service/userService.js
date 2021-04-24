//服务层
app.service('userService',function($http){
	//增加 
	this.add=function(entity) {
		return $http.post('../user/add.do', entity);
	}
});