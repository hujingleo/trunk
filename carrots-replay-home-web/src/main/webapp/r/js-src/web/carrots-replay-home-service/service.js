// 'use strict';
// angular.module('carrots_replay')
//
//     .factory('pathProject', function (commonUtil) {
//         return {
//                 	     companyTag: function (id) {
//                 if (!id) {
//                     return "ajax/u/companyTag";
//                 } else {
//                     return "ajax/u/companyTag/" + id;
//                 }
//             },
//           companyTag_list: "ajax/u/companyTag/search"
//
//                                    ,
//
//
//
//          	     companyTag: function (id) {
//                 if (!id) {
//                     return "ajax/u/companyTag";
//                 } else {
//                     return "ajax/u/companyTag/" + id;
//                 }
//             },
//           companyTag_list: "ajax/u/companyTag/search"
//
//                                    ,
//
//
//
//          	     companyTag: function (id) {
//                 if (!id) {
//                     return "ajax/u/companyTag";
//                 } else {
//                     return "ajax/u/companyTag/" + id;
//                 }
//             },
//           companyTag_list: "ajax/u/companyTag/search"
//
//
//
//
//
//         }
//     })
//
//
// 	    .factory('companyService', function ($http, pathProject) {
//         return {
//             add: function (params) {
//                 return $http.post(pathProject.company(), params);
//             },
//             update: function (id, params) {
//
//                 return $http.put(pathProject.company(id), params);
//             },
//             getList: function (params) {
//                 return $http.get(pathProject.company_list, {params: params});
//             },
//             get: function (id) {
//                 return $http.get(pathProject.company(id));
//             },
//             del: function (id) {
//
//                 return $http.delete(pathProject.company(id));
//             }
//
//         }
//     })
//
// 	    .factory('professionService', function ($http, pathProject) {
//         return {
//             add: function (params) {
//                 return $http.post(pathProject.profession(), params);
//             },
//             update: function (id, params) {
//
//                 return $http.put(pathProject.profession(id), params);
//             },
//             getList: function (params) {
//                 return $http.get(pathProject.profession_list, {params: params});
//             },
//             get: function (id) {
//                 return $http.get(pathProject.profession(id));
//             },
//             del: function (id) {
//
//                 return $http.delete(pathProject.profession(id));
//             }
//
//         }
//     })
//
// 	    .factory('companyTagService', function ($http, pathProject) {
//         return {
//             add: function (params) {
//                 return $http.post(pathProject.companyTag(), params);
//             },
//             update: function (id, params) {
//
//                 return $http.put(pathProject.companyTag(id), params);
//             },
//             getList: function (params) {
//                 return $http.get(pathProject.companyTag_list, {params: params});
//             },
//             get: function (id) {
//                 return $http.get(pathProject.companyTag(id));
//             },
//             del: function (id) {
//
//                 return $http.delete(pathProject.companyTag(id));
//             }
//
//         }
//     })
//
//
//     ;
//
//
//
//
//
//
