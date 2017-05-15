'use strict';
angular.module('carrots_replay')
    .controller('companyCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, companyService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     province: $state.params.province
	                	     city: $state.params.city
	                	     county: $state.params.county
	                	     finacing: $state.params.finacing
	                	     approved: $state.params.approved
	                	     freezed: $state.params.freezed
	                	     logo: $state.params.logo
	                	     slogan: $state.params.slogan
	                	     totalNum: $state.params.totalNum
	                	     summary: $state.params.summary
	                	     industry: $state.params.industry
	                	     phone: $state.params.phone
	                	     address: $state.params.address
	                	     map: $state.params.map
	                	     status: $state.params.status
	                	     mail: $state.params.mail
	                	     professionCount: $state.params.professionCount
	                	     productName: $state.params.productName
	                	     productLogo: $state.params.productLogo
	                	     productSolgan: $state.params.productSolgan
	                	     productSummary: $state.params.productSummary
	                	     approvedAt: $state.params.approvedAt
	                	     releaseAt: $state.params.releaseAt
	                	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                	     createAt: $state.params.createAt
	                	     updateAt: $state.params.updateAt
	                         };


    companyService.getList(vm.params).then(function(res) {
        if (res.data.code === 0) {
            vm.list = res.data.data;
            vm.page = {
                next: res.data.next || 0,
                size: res.data.size || 0,
                page: res.data.page || 0,
                total: res.data.total || 0
            };
        } else {
            $rootScope.alert(res.data.message);
        }
    });
  

    vm.search = function() {
        
        $state.go("field.companyList", vm.params,{reload:true});
    };
    });
