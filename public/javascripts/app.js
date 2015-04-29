var app = angular.module('app', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
  
  $urlRouterProvider.otherwise("/");
  
    $stateProvider
    .state('home',{
        url: '/',
        abstract: true,
        views:{
          'nav' :{
            templateUrl : 'views/leftnav.html'
          }
        }
    })
    .state('home.products', {
        url: 'store/:catid',
        views: {
          'container@': {
              templateUrl: 'views/category.html',
              controller: 'productsCtrl'
          }
        }
    })
    .state('home.product', {
        url: 'store/:catid/:pid',
        views: {
          'container@': {
              templateUrl : 'views/single-product.html',
              controller : 'oneProdCtrl'
          }
        }
    });
});


app.run(function ($rootScope, $state, $stateParams, $http) {
  console.log('app run')
  $http.get('/products/prods/all/cats').success(function(data){
    $rootScope.categories = data;
    console.log(data);
    $state.transitionTo('home.products', {catid: data[0]});
  });
});

app.controller('productsCtrl', function($scope, $http, $stateParams){
  $scope.catID = $stateParams.catid;
  $http.get('/products/cat/'+$stateParams.catid).success(function(data){
    $scope.products = data;
    $scope.isProductAvailable = function(){

          var time = ((new Date).getTime()/1000);
          if($scope.product.Start_Date < time && time< $scope.product.End_Date){
              console.log('true');
              return true;
          }

          else{
            
            return false;
          
          }
        };
  });
});


app.controller('oneProdCtrl', function($scope, $http, $stateParams){
  var pid = $stateParams.pid;
  $http.get('/products/'+pid).success(function(data){
    $scope.product = data;
    console.log(data);
    $scope.isProductAvailable = function(){

          var time = ((new Date).getTime()/1000);
          console.log(time);
          if($scope.product.Start_Date < time && time < $scope.product.End_Date){
              console.log('true');
              return true;
          }

          else{
            console.log('true');
            return false;
          
          }
        };
    });
});































/*
var app = angular.module('app', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
	
	$urlRouterProvider.otherwise("/");
	
    $stateProvider
    .state('home',{
      	url: '/',
      	abstract: true,
      	views:{
          'nav' :{
            templateUrl : 'views/leftnav.html'
          }
        }
    })
    .state('home.products', {
      	url: 'store/:catid',
      	views: {
        	'container@': {
          		templateUrl: 'views/category.html',
          		controller: 'productsCtrl'
        	}
      	}
    })
    .state('home.product', {
      	url: 'store/:catid/:pid',
      	views: {
        	'container@': {
          		templateUrl : 'views/single-product.html',
          		controller : 'oneProdCtrl'
        	}
      	}
    });
});


app.run(function ($rootScope, $state, $stateParams, $http) {
  console.log('app run')
	$http.get('/products/prods/all/cats').success(function(data){
		$rootScope.categories = data;
    console.log(data);
		$state.transitionTo('home.products', {catid: data[0]});
	});
});

app.controller('productsCtrl', function($scope, $http, $stateParams){
	$scope.catID = $stateParams.catid;
	$http.get('/products/cat/'+$stateParams.catid).success(function(data){
		$scope.products = data;
	});
});


app.controller('oneProdCtrl', function($scope, $http, $stateParams){
	var pid = $stateParams.pid;
	$http.get('/products/'+pid).success(function(data){
		$scope.product = data;
		console.log(data);
    $scope.isProdAvailable = function(){
          var time = ((new Date).getTime()/1000);
          if($scope.product.Start_Date < time < $scope.product.End_Date){
              return true;
          }
          else{
            return false;
            }
        };
    });
});
*/









