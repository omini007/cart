
var app = angular.module('cartApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/cart',
    USER_SERVICE_API : 'http://localhost:8080/cart/product/'
});



app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('views', {
                url: '/',
                templateUrl: 'views/aaa',
                controller:'productController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, productService) {
                        console.log('Data entry view');
                        var deferred = $q.defer();
                        UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);