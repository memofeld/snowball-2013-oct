function ConferenceCtrl($scope, $http, ConferenceList) {

    // Define a refresh function, that updates the data from the REST service
    $scope.refresh = function() {
        $scope.conferenceList = ConferenceList.query();
    };

    // Define a reset function, that clears the prototype newConference object, and
    // consequently, the form
    $scope.reset = function() {
        // clear input fields
        $scope.newConference = {};
    };

    // Define a creation function, which adds the conference using the REST service,
    // and displays any error messages
    $scope.creation = function() {
        $scope.successMessages = '';
        $scope.errorMessages = '';
        $scope.errors = {};

        ConferenceList.save($scope.newConference, function(data) {

            // mark success on the registration form
            $scope.successMessages = [ 'Conference Registered' ];

            // Update the list of members
            $scope.refresh();

            // Clear the form
            $scope.reset();
        }, function(result) {
            if ((result.status == 409) || (result.status == 400)) {
                $scope.errors = result.data;
            } else {
                $scope.errorMessages = [ 'Unknown  server error' ];
            }
            $scope.$apply();
        });

    };

    // Call the refresh() function, to populate the list of conferences
    $scope.refresh();

    // Initialize newConference here to prevent Angular from sending a request
    // without a proper Content-Type.
    $scope.reset();

    // Set the default orderBy to the name property
    $scope.orderBy = 'name';
}