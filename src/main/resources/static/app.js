var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http){
     $http.get("http://localhost:8080/booking/all").then(function (response) {
           $scope.bookings = response.data;
                 });

                 $scope.confirmDelete = function(id) {
                         var isConfirmDelete = confirm('Are you sure you want this record?');
                         if (isConfirmDelete) {
                             $http({
                                 method: 'DELETE',
                                 url:'http://localhost:8080/booking/' + id
                             }).
                                     success(function(data) {
                                         console.log(data);
                                         location.reload();
                                     }).
                                     error(function(data) {
                                         console.log(data);
                                         alert('Unable to delete');
                                     });
                         } else {
                             return false;
                         }
                     }
});