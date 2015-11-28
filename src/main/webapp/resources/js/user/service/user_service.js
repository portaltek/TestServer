/**
 * 
 */

'use strict';

App.service('UserService', ['$http', '$q', function($http, $q){
	var url= 'http://localhost:8083/TestServer/user/';
	return {
//		url: 'http://localhost:8083/TestServer/user/',
		fetchAllUsers: function() {
//			alert("UserService");
			return $http.get(url)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while fetching users');
						return $q.reject(errResponse);
					}
			);
		},

		createUser: function(user){
			return $http.post(url, user)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while creating user');
						return $q.reject(errResponse);
					}
			);
		},

		updateUser: function(user, id){
			return $http.put(url+id, user)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while updating user');
						return $q.reject(errResponse);
					}
			);
		},

		deleteUser: function(id){
			return $http['delete'](url+id)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while deleting user');
						return $q.reject(errResponse);
					}
			);
		}

	};

}]);