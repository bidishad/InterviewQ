var myApp = angular.module('myApp', []);

myApp.controller('TicketController', function($scope,$http) {
	var baseurl = $('#baseurl').val();
	
	$scope.getTickets = function()
	{
	$http({method: 'GET', url: baseurl+'tickets.json'}).
          success(function(data, status, headers, config) {
              $scope.tickets = data;
          }).
          error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
	};
	
	$scope.viewTicket = function ()
	{
		var ticketid = $('#ticketid').val();
		$http({method: 'GET', url: baseurl+'ticket/'+ticketid}).
        success(function(data, status, headers, config) {
            $scope.ticket = data;
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
        });
	};
	
	 $scope.isEditable = function(index)
     {
   	  var ticket = $scope.tickets[index];
   	  
   	  if(ticket.ticket_status.status_code==3)
   		  alert("You can't edit closed ticket.");
         else
       	  {
   	 		$('#ticketid').val(ticket.id);
				$('#edit-ticket').submit();
       	  }
     };
});