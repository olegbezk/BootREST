angular.module('app', [])

.controller('controller', function($scope, $http) {

    function showData() {
        $http.get('http://localhost:8080/data/all/')
            .then(function(res){
                $scope.results = res.data;
            });
    }

    var data = {
        title: "",
        number: ""
    };

    $scope.submitData = function() {

         data = $scope.formData

         if (data.number == 0) {
             return;
         }

         if(!isFinite(data.number)) {
             alert("Insert a number in the number field, please!")
         }

         $http.post(
                'http://localhost:8080/data/add/',
                JSON.stringify(data),
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
            ).success(function (response) {
                $scope.postResult = response;
            }).error(function (response) {

            });

            showData();

            data.title = "";
            data.number = "";
    }

});



