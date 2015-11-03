/**
 * 
 */

'use strict';

countryApp.service('CountryService', ['$http', '$q', function($http, $q){
	var url= 'http://localhost:8083/TestServer/country/';
	return {
		findAll: function() {
			return $http.get(url).then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while fetching users');
						return $q.reject(errResponse);
					}
			);
		},
		insert: function(country){
			return $http.post(url, country)
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
		update: function(country){
			return $http.put(url, country)
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

	};

}]);