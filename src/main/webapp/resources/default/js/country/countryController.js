/**
 * 
 */

'use strict';

countryApp.controller('CountryController',
		['$scope', 'CountryService',
		 function( $scope, CountryService) {
			var self = this;
			self.country={
					countryId: "11",
					countryName:"1",
					region: {regionId : "1"},

			};
			self.countryList=[];
			self.reset = function(){

			}
			self.findAll = function(){
				CountryService.findAll().then(
						function(d) {
							self.countryList = d.LIST;
						},
						function(errResponse){
							console.error('Error while fetching Currencies');
						}
				);
			};

			self.insert = function(country){
				CountryService.insert(country)
				.then(
						function(d) {
							self.findAll();
						},
						function(errResponse){
							console.error('Error while creating User.');
						} 
				);
			};	
			self.submit = function() {
				self.insert(self.country);
//				if(self.user.id==null){
//					console.log('Saving New User', self.user);    
//					self.createUser(self.user);
//				}else{
//					self.updateUser(self.user, self.user.id);
//					console.log('User updated with id ', self.user.id);
//				}
//				self.reset();
			};

		}]);