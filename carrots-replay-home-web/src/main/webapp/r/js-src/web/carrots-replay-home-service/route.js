'use strict';
function projectRouteConfig($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {
    var _lazyLoad = function(loaded) {
        return function($ocLazyLoad) {
            return $ocLazyLoad.load(loaded, {serie: true});
        }
    };

    $ocLazyLoadProvider.config({
        debug: false,
        events: true
    });


    $urlRouterProvider.otherwise('/dashboard');
    $stateProvider

        .state('field', {
            url: '',
            templateUrl: 'views/main.html',
            controller: 'MainController',
            controllerAs: 'vm',
            abstract: true, // true 表明此状态不能被显性激活，只能被子状态隐性激活
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/admin/mainController.js',
                    'js/directives/ptteng-sidebar/ptteng-sidebar-0.0.1.js',
                    'js/directives/ptteng-user/ptteng-user-0.0.1.js',
                    'js/directives/ptteng-paging/ptteng-page-0.0.1.js'
                ])
            }
        })
        .state('field.dashboard', {
            url: '/dashboard',
            templateUrl: 'views/dashboard.html'
        })
        
        
 

                
           //教材管理
        .state('field.companyTagList', {
            url: '/companyTagList',
            templateUrl: 'views/companyTagList.html',
            controller: 'CompanyTagListController',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/companyTag/companyTagListController.js'
                ])
            }
        })
        //教材编辑等管理
        .state('field.companyTagDetails', {
            url: '/companyTagDetails/:id',
            templateUrl: 'views/companyTagDetails.html',
            controller: 'CompanyTagDetailController',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/companyTag/companyTagDetailsController.js'
                ])
            }
        })      

                 
           //教材管理
        .state('field.companyTagList', {
            url: '/companyTagList',
            templateUrl: 'views/companyTagList.html',
            controller: 'CompanyTagListController',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/companyTag/companyTagListController.js'
                ])
            }
        })
        //教材编辑等管理
        .state('field.companyTagDetails', {
            url: '/companyTagDetails/:id',
            templateUrl: 'views/companyTagDetails.html',
            controller: 'CompanyTagDetailController',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/companyTag/companyTagDetailsController.js'
                ])
            }
        })      

                 
           //教材管理
        .state('field.companyTagList', {
            url: '/companyTagList',
            templateUrl: 'views/companyTagList.html',
            controller: 'CompanyTagListController',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/companyTag/companyTagListController.js'
                ])
            }
        })
        //教材编辑等管理
        .state('field.companyTagDetails', {
            url: '/companyTagDetails/:id',
            templateUrl: 'views/companyTagDetails.html',
            controller: 'CompanyTagDetailController',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/companyTag/companyTagDetailsController.js'
                ])
            }
        })

        //教材管理
        .state('field.articleList', {
            url: '/articleList',
            templateUrl: 'views/articleList.html',
            controller: 'ArticleListController',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/article/articleListController.js'
                ])
            }
        })
        //教材编辑等管理
        .state('field.articleDetails', {
            url: '/articleDetails/:id',
            templateUrl: 'views/articleDetails.html',
            controller: 'ArticleDetailController',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/article/articleDetailsController.js'
                ])
            }
        })










        // basic part
        .state('login', {
            url: '/login',
            templateUrl: 'views/admin/login.html',
            controller: 'LoginController',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad(
                    'js/controllers/admin/loginController.js')
            }
        })
        .state('field.manager', {
            url: '/manager/:page',
            templateUrl: 'views/admin/manager.html',
            controller:'ManagerCtrl',
            resolve: {
                loadMyFile: _lazyLoad('js/controllers/admin/ptteng-managerController-0.0.1.js')
            }
        })
        .state('field.managerDetail', {
            url: '/managerDetail/:id',
            templateUrl: 'views/admin/managerDetail.html',
            controller:'ManagerDetailCtrl',
            resolve: {
                loadMyFile: _lazyLoad('js/controllers/admin/ptteng-managerDetailController-0.0.1.js')
            }
        })
        .state('field.role', {
            url: '/role/:page',
            templateUrl: 'views/admin/role.html',
            controller:'RoleCtrl',
            resolve: {
                loadMyFile: _lazyLoad('js/controllers/admin/ptteng-roleController-0.0.1.js')
            }
        })
        .state('field.roleDetail', {
            url: '/roleDetail/:id',
            templateUrl: 'views/admin/roleDetail.html',
            controller:'RoleDetailCtrl',
            resolve: {
                loadMyFile: _lazyLoad('js/controllers/admin/ptteng-roleDetailController-0.0.1.js')
            }
        })
        .state('field.module', {
            url: '/module/:page',
            templateUrl: 'views/admin/module.html',
            controller:'ModuleCtrl',
            resolve: {
                loadMyFile: _lazyLoad('js/controllers/admin/ptteng-moduleController-0.0.1.js')
            }
        })
        .state('field.moduleDetail', {
            url: '/moduleDetail/:id',
            templateUrl: 'views/admin/moduleDetail.html',
            controller:'ModuleDetailCtrl',
            resolve: {
                loadMyFile: _lazyLoad('js/controllers/admin/ptteng-moduleDetailController-0.0.1.js')
            }
        })
        .state('field.pwd', {
            url: '/pwd',
            templateUrl: 'views/admin/pwd.html',
            controller:'PwdCtrl',
            resolve: {
                loadMyFile: _lazyLoad('js/controllers/admin/ptteng-pwdController-0.0.1.js')
            }
        })
        .state('field.article', {
            url: '/article/:page/:type/:status/:startAt/:endAt',
            templateUrl: 'views/admin/article.html',
            controller:'ArticleCtrl',
            resolve: {
                loadMyFile: _lazyLoad(['js/controllers/admin/ptteng-articleController-0.0.1.js'])
            }
        })
        .state('field.articleDetail', {
            url: '/articleDetail/:id',
            templateUrl: 'views/admin/articleDetail.html',
            controller:'ArticleDetailCtrl',
            resolve: {
                loadMyFile: _lazyLoad(['js/controllers/admin/ptteng-articleDetailController-0.0.1.js', 'summernote', 'angularFileUpload'])
            }
        })
        //新添操作记录
        .state('field.operatingRecord', {
            url: '/operatingRecord/:operateStart/:operateEnd/:managerName/:operate/:roleID',
            templateUrl: 'views/admin/operatingRecord.html',
            controller:'operatingRecordCtrl',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad('js/controllers/admin/operatingRecordCtrl.js')
            }
        })
        //操作记录详情
        .state('field.recordDetail', {
            url: '/recordDetail/:id',
            templateUrl: 'views/admin/recordDetail.html',
            controller:'recordDetailCtrl',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad('js/controllers/admin/recordDetailCtrl.js')
            }
        })

    ;





}

