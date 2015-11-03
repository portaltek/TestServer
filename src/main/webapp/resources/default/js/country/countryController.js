/**
 * 
 */

'use strict';

countryApp.controller('CountryController',
		['$scope', 'CountryService',
		 function( $scope, CountryService) {
		    $scope.showModal = true;
		    $scope.toggleModal = function(){
		        $scope.showModal = !$scope.showModal;
		    };
			
			
			var self = this;
			self.country={
					countryId: "",
					countryName:"",
					region: {regionId : ""},

			};
			self.countryList=[];
			self.showBtnInsert = false;
			self.showBtnUpdate = false;
			self.showBtnDelete = false;
			
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
			self.submit = function() {
			};
			self.insert = function(){
				CountryService.insert(self.country)
				.then(
						function(d) {
							self.findAll();
						},
						function(errResponse){
							console.error('Error while creating User.');
						} 
				);
			};	
			self.update = function(){
				CountryService.update(self.country)
				.then(
						function(d) {
							self.findAll();
						},
						function(errResponse){
							console.error('Error while creating User.');
						} 
				);
			};			

			
			self.showInsertForm = function(){
				toggleModal();
				self.showBtnInsert = true;
				self.showBtnUpdate = false;				
				self.showBtnDelete = false;				
			}				
			self.showUpdateForm = function(id){
				$scope.toggleModal();
				self.showBtnInsert = false;
				self.showBtnUpdate = true;
				self.showBtnDelete = false;
				self.country = self.find(id);
			}
			
			self.showDeleteForm = function(id){
				$scope.toggleModal();
				self.showBtnInsert = false;
				self.showBtnUpdate = false;
				self.showBtnDelete = true;
				self.country = self.find(id);

			}			

			self.find = function(id){
				for(var i = 0; i < self.countryList.length; i++){
					console.log('id: ', self.countryList[i].countryId);
					if(self.countryList[i].countryId == id) {
						return angular.copy(self.countryList[i]);
//						break;
					}
				}
			}		

		}]);

countryApp.directive('modal', function () {
    return {
      template: 
    	  '<div class="modal fade">' + 
          '<div class="modal-dialog">' + 
            '<div class="modal-content">' + 
              '<div class="modal-header">' + 
                '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' + 
                '<h4 class="modal-title">{{ title }}</h4>' + 
              '</div>' + 
              '<div class="modal-body" ng-transclude></div>' + 
            '</div>' + 
          '</div>' + 
        '</div>',
      restrict: 'E',
      transclude: true,
      replace:true,
      scope:true,
      link: function postLink(scope, element, attrs) {
        scope.title = attrs.title;

        scope.$watch(attrs.visible, function(value){
          if(value == true)
            $(element).modal('show');
          else
            $(element).modal('hide');
        });

        $(element).on('shown.bs.modal', function(){
          scope.$apply(function(){
            scope.$parent[attrs.visible] = true;
          });
        });

        $(element).on('hidden.bs.modal', function(){
          scope.$apply(function(){
            scope.$parent[attrs.visible] = false;
          });
        });
      }
    };
  });