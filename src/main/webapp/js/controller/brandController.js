app.controller('brandController',function ($scope,brandService) {

    //读取列表数据绑定到表单中
    $scope.findAll=function(){
        brandService.findAll().success(
            function(response){
                $scope.BList=response;
            }
        );
    }

})