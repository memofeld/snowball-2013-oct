angular.module('geecon', [ 'conferenceService' ]).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/home', {
				templateUrl : 'partials/home.html',
				controller : ConferenceCtrl
			// Add a default route
			}).otherwise({
				redirectTo : '/home'
			});
		} ]);

angular.module('conferenceService', [ 'ngResource' ]).factory('ConferenceList',
		function($resource) {
			return $resource('../rest/conference/', {});
		});